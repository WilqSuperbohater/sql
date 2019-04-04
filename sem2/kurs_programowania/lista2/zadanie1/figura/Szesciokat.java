package main.java.lista2.figura;

public class Szesciokat extends Figura {

  private double bok;

  Szesciokat(double bok)  { this.bok = bok; }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("s[");
    s.append(bok);
    s.append("]");
    return s.toString();
  }

  @Override
  public double wezPole() {
    return (3/2) * bok * bok  * (Math.cos(30)/Math.sin(30));
  }

  @Override
  public double wezObwod() {
    return 5 * bok;
  }
}
