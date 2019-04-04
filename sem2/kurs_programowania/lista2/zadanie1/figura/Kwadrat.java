package main.java.lista2.figura;

public class Kwadrat extends Czworokat {

  Kwadrat(double bok1, double bok2, double bok3, double bok4, double kat) { init(bok1, bok2, bok3, bok4, kat); }

  @Override
  public double wezPole() { return bok1 * bok1; }

  @Override
  public double wezObwod() { return 4 * bok1; }
}
