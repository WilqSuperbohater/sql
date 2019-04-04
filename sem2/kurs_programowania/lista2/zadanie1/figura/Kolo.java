package main.java.lista2.figura;

import static java.lang.Math.PI;

public class Kolo extends Figura {

  private double promien;

  Kolo(double promien) { this.promien = promien; }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("o[");
    s.append(promien);
    s.append("]");
    return s.toString();
  }

  @Override
  public double wezPole() { return promien * promien * PI; }

  @Override
  public double wezObwod() { return 2 * promien * PI; }
}
