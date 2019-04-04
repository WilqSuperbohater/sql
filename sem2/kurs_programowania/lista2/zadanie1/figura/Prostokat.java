package main.java.lista2.figura;

public class Prostokat extends Czworokat {

  Prostokat (double bok1, double bok2, double bok3, double bok4, double kat) { init(bok1, bok2, bok3, bok4, kat); }

  @Override
  public double wezPole() {
    if(bok1 == bok2)
      return bok1 * bok3;
    else
      return bok1 * bok2;
  }

  @Override
  public double wezObwod() { return bok1 + bok2 + bok3 + bok4; }
}
