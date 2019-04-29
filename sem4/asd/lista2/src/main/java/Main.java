package main.java;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

  public static void main(String[] args) {
    if(args[0].equals("1"))
      procedure1(args);
    if(args[0].equals("2"))
      procedure2(args);
  }

  private static void procedure2(String[] args) {
  }

  private static void procedure1(String[] args) {
    String type = args[1];
    String order = args[2];
    Scanner s = new Scanner(in);
    out.println("Size: ");
    int size = s.nextInt();
    int[] array = new int[size];
    for(int i = 0; i < size; i++)
      array[i] = s.nextInt();
    Sort sort = new Sort(array, type, order);
    out.println("Swaps: " + sort.getSwaps());
    out.println("Comps: " + sort.getComps());
    out.println("Time: nanos=" + sort.getNanos() + ", micros=" + sort.getMicros() + ", milis=" + sort.getMilis());
    out.print("Sorted? ");
    out.println(sort.isSorted() ? "Yes" : "No");
    out.println("Size: " + sort.getSize());
    int[] sorted = Arrays.copyOf(sort.getArray(), sort.getSize());
    out.print("Sorted array: ");
    for(int i = 0; i < sorted.length; i++) {
      out.print(sorted[i]);
      if(i < sorted.length-1)
        out.print(", ");
    }
    out.println();
  }

}
