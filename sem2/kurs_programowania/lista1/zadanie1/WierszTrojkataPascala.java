package main.java.lista1;

public class WierszTrojkataPascala {

  private int[] wiersz;
  private int n;

  WierszTrojkataPascala(int n) { init(n); }

  public int wspolczynnik(int m) throws Exception {
    if(m < 0 || m > n) throw new Exception("liczba spoza zakresu");
    return wiersz[m];
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    for(int i = 0; i < wiersz.length-1; i++) {
      s.append(wiersz[i]);
      s.append(" ");
    }
    s.append(wiersz[wiersz.length-1]);
    return s.toString();
  }

  private void init(int n) {
    this.n = n;
    wiersz  = new int[n+1];
    for(int k = 0; k <= n; k++)
      wiersz[k] = symbolNewtona(n, k);
  }

  private int symbolNewtona(int n, int k) { return dolnaSilnia(n, k) / dolnaSilnia(k, k); }

  private int dolnaSilnia(int n, int k) {
    if(k == 0) return 1;
    int dolna_silnia = 1;
    for(int i = 0; i < k; i++)
      dolna_silnia *= (n-k+i+1);
    return dolna_silnia;
  }
}
