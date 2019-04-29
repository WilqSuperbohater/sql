package main.java;

import java.util.Arrays;

class Sort {

  private static int[] array;
  private String type;
  private String order;
  private static int size;

  private static int swaps = 0;
  private static int comps = 0;

  private long start, stop;

  Sort(int[] array, String type, String order) {
    init(array, type, order);
    start = System.nanoTime();
    sort();
    stop = System.nanoTime();
  }

  private void sort() {
    if(type.equalsIgnoreCase("select") && order.equalsIgnoreCase("asc"))
      Type.SELECT.sortAsc();
    if(type.equalsIgnoreCase("select") && order.equalsIgnoreCase("dsc"))
      Type.SELECT.sortDsc();
    if(type.equalsIgnoreCase("insert") && order.equalsIgnoreCase("asc"))
      Type.INSERT.sortAsc();
    if(type.equalsIgnoreCase("insert") && order.equalsIgnoreCase("dsc"))
      Type.INSERT.sortDsc();
    if(type.equalsIgnoreCase("heap") && order.equalsIgnoreCase("asc"))
      Type.HEAP.sortAsc();
    if(type.equalsIgnoreCase("heap") && order.equalsIgnoreCase("dsc"))
      Type.HEAP.sortDsc();
    if(type.equalsIgnoreCase("quick") && order.equalsIgnoreCase("asc"))
      Type.QUICK.sortAsc();
    if(type.equalsIgnoreCase("quick") && order.equalsIgnoreCase("dsc"))
      Type.QUICK.sortDsc();
  }

  private void init(int[] array, String type, String order) {
    this.array = Arrays.copyOf(array, array.length);
    this.type = type;
    this.order = order;
    size = this.array.length;
  }

  private static void swap(int pos1, int pos2) {
    System.out.println("array[" + pos1 + "]=" + array[pos1] + ", array[" + pos2 + "]=" + array[pos2] + " - swap");
    int tmp =  array[pos1];
    array[pos1] = array[pos2];
    array[pos2] = tmp;
    swaps += 2;
  }

  private static void move(int pos1, int pos2) {
    System.out.println("array[" + pos2 + "]=" + array[pos2] + ", move to array[" + pos1 + "]");
    array[pos1] = array[pos2];
    swaps++;
  }
  private static void moveWithKey(int pos, int key) {
    System.out.println(key + " move to array[" + pos + "]");
    array[pos] = key;
    swaps++;
  }

  private static int compare(int pos1, int pos2) {
    System.out.println("array[" + pos1 + "]=" + array[pos1] + ", array[" + pos2 + "]=" + array[pos2] + " - compare");
    comps++;
    return array[pos1] - array[pos2];
  }

  private static int compareWithKey(int pos, int key) {
    System.out.println("array[" + pos + "]=" + array[pos] + ", key=" + key + " - compare");
    comps++;
    return array[pos] - key;
  }
  private static void select(int ord) {
    for (int i = 0; i < size - 1; i++) {
      int min = i;
      for (int j = i + 1; j < size; j++)
        if (compare(min, j) * ord > 0)
          min = j;
      if (compare(min, i) != 0)
        swap(min, i);
    }
  }

  private static void insert(int ord) {
    for (int i = 1; i < size; i++) {
      int key = array[i];
      int j = i - 1;
      while (j >= 0 && compareWithKey(j, key) * ord > 0) {
        move(j + 1, j);
        j--;
      }
      moveWithKey(j + 1, key);
    }
  }

  private static void insert2(int ord, int begin, int end) {

  }


  private static void heap(int n, int i, int ord) {
    int max = i;
    int l = 2*i + 1;
    int r = 2*i + 2;
    if(l < n && compare(l, max) * ord > 0)
      max = l;
    if(r < n && compare(r, max) * ord > 0)
      max = r;
    if(max != i) {
      swap(i, max);
      heap(n, max, ord);
    }
  }

  private static void quick(int begin, int end, int ord) {
    if (begin < end) {
      int partitionIndex = partition(begin, end, ord);
      quick(begin, partitionIndex-1, ord);
      quick(partitionIndex+1, end, ord);
    }
  }

  private static int partition(int begin, int end, int ord) {
    int pivot = array[end];
    int i = (begin-1);

    for (int j = begin; j < end; j++)
      if (compareWithKey(j, pivot) * ord < 0) {
        i++;
        swap(i,j);
      }
    swap(i+1,end);
    return i+1;
  }

  private static void mQuick(int begin, int end, int ord) {
    if (begin < end) {
      if(end  - begin >= 16) {
        int partitionIndex = partition(begin, end, ord);
        mQuick(begin, partitionIndex - 1, ord);
        mQuick(partitionIndex + 1, end, ord);
      }
      else {
        insert2(ord, begin, end);
      }
    }
  }

  int[] getArray() { return array; }

  int getSize() { return size; }

  int getSwaps() { return swaps; }

  int getComps() { return comps; }

  boolean isSorted() {
    int el0 =  array[0];
    switch (order) {
      case "asc":
        for (int i1 : array)
          if (i1 < el0)
            return false;
        break;
      case "dsc":
        for (int i1 : array)
          if (i1 > el0)
            return false;
        break;
      default:
        System.exit(1);
    }
    return true;
  }

  long getNanos() { return stop - start; }
  long getMicros() { return (stop - start) / 1000; }
  long getMilis() { return (stop - start) / 1000000; }

  private enum Type {
    SELECT {
      @Override
      void sortAsc() { select(1); }

      @Override
      void sortDsc() { select(-1); }
    },
    INSERT {
      @Override
      void sortAsc() { insert(1); }

      @Override
      void sortDsc() { insert(-1); }
    },
    HEAP {
      @Override
      void sortAsc() {
        for (int i = size / 2 - 1; i >= 0; i--)
          heap(size, i,1);
        for (int i = size-1; i >= 0; i--)
        {
          swap(0, i);
          heap(i, 0, 1);
        }
      }

      @Override
      void sortDsc() {
        for (int i = size / 2 - 1; i >= 0; i--)
          heap(size, i, -1);
        for (int i = size-1; i >= 0; i--)
        {
          swap(0, i);
          heap(i, 0, -1);
        }
      }
    },
    QUICK {
      @Override
      void sortAsc() { quick(0, size-1, 1);}

      @Override
      void sortDsc() { quick(0, size-1, -1); }
    };

    abstract void sortAsc();
    abstract void sortDsc();
  }

}
