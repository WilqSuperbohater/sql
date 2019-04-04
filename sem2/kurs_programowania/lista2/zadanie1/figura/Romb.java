package main.java.lista2.figura;

import static java.lang.Math.PI;

public class Romb extends Czworokat {

  Romb (double bok1, double bok2, double bok3, double bok4, double kat) { init(bok1, bok2, bok3, bok4, kat); }

  @Override
  public double wezPole() { return bok1 * bok1 * Math.sin((kat * (PI/180))); }

  @Override
  public double wezObwod() {
    return 4 * bok1;
  }
}
