package main.java.lista2.figura;

public abstract class Czworokat extends Figura {
  protected double bok1;
  protected double bok2;
  protected double bok3;
  protected double bok4;
  protected double kat;

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("c[");
    s.append(bok1);
    s.append(", ");
    s.append(bok2);
    s.append(", ");
    s.append(bok3);
    s.append(", ");
    s.append(bok4);
    s.append(", ");
    s.append(kat);
    s.append("]");
    return s.toString();
  }

  protected void init(double bok1, double bok2, double bok3, double bok4, double kat) {
    this.bok1 = bok1;
    this.bok2 = bok2;
    this.bok3 = bok3;
    this.bok4 = bok4;
    this.kat = kat;
  }
  static boolean czyKwadrat(double bok1, double bok2, double bok3, double bok4, double kat) {
    if((czyRomb(bok1, bok2, bok3, bok4, kat)) && kat == 90)
      return true;
    return false;
  }

  static boolean czyProstokat(double bok1, double bok2, double bok3, double bok4, double kat) {
    if((czyRownoleglobok(bok1, bok2, bok3, bok4, kat)) && kat == 90)
      return true;
    return false;
  }

  static boolean czyRomb(double bok1, double bok2, double bok3, double bok4, double kat) {
    if((bok1 == bok2 && bok2 == bok3 && bok3 == bok4) && czyRownoleglobok(bok1, bok2, bok3, bok4, kat))
      return true;
    return false;
  }
  static private boolean czyRownoleglobok(double bok1, double bok2, double bok3, double bok4, double kat) {
    if(bok1 <= 0 || bok2 <= 0 || bok3 <= 0 || bok4 <= 0) return false;
    if(kat <= 0 || kat >= 180) return false;
    if(bok1 == bok2 && bok3 == bok4) return true;
    if(bok1 == bok3 && bok2 == bok4) return true;
    if(bok1 == bok4 && bok2 == bok3) return true;
    return false;
  }
}
