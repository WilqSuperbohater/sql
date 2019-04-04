package main.java.lista2.figura;

public class Pieciokat extends Figura {
  private double bok;

  Pieciokat(double bok) { this.bok = bok; }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("p[");
    s.append(bok);
    s.append("]");
    return s.toString();
  }

  @Override
  public double wezPole() {
    return (5/4) * bok * bok  * (Math.cos(36)/Math.sin(36));
  }

  @Override
  public double wezObwod() {
    return 5 * bok;
  }
}
