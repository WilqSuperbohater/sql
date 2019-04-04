package main.java.lista2;

import main.java.lista2.figura.Figura;

public class Main {
  private static Figura[] f;

  public static void main(String[] args) {
    try { sprawdzArgumenty(args); } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(1); }
    przygotujTablice(args);
    wypiszPolaIObwody();
  }

  private static void sprawdzArgumenty(String[] args) throws Exception {
    if(args.length < 2 )
      throw new Exception("Za malo argumentow. ");
    int suma = 0;
    for (Character c : args[0].toCharArray())
      switch(c) {
        case 'c':
          suma += 5;
          break;
        case 'o':
          suma += 1;
          break;
        case 'p':
          suma += 1;
          break;
        case 's':
          suma += 1;
          break;
        default:
          throw new Exception("Niepoprawny pierwszy argument. ");
      }
    if (suma < (args.length - 1))
      throw new Exception("Za duzo argumentow. ");
    if (suma > (args.length - 1))
      throw new Exception("Za malo argumentow. ");
    double argumentKontrolny;
    for (int i = 1; i < args.length; i++) {
      try { argumentKontrolny = Double.parseDouble(args[i]); } catch (NumberFormatException e) {
        throw new Exception("Wszystkie argumenty poza pierwszym powinny byc klasy Double.");
      }
      if ( argumentKontrolny <= 0)
        throw new Exception("Wartosci miary kata i dlugosci boku figury musza byc wieksze od 0. ");
    }
  }

  private static void przygotujTablice(String[] args) {
    f = new Figura[args[0].length()];
    double[] d = new double[args.length - 1];
    int it1 = 0;
    int it2 = 0;
    for (int i = 1; i < args.length; i++)   d[i-1] = Double.parseDouble(args[i]);
    for (Character c : args[0].toCharArray())
      switch(c) {
        case 'c':
          f[it1] = Figura.wezCzworokat(d[it2], d[it2+1], d[it2+2], d[it2+3], d[it2+4]);
          it1++;
          it2 += 5;
          break;
        case 'o':
          f[it1] = Figura.wezOkrag(d[it2]);
          it1++;
          it2++;
          break;
        case 'p':
          f[it1] = Figura.wezPieciokat(d[it2]);
          it1++;
          it2++;
          break;
        case 's':
          f[it1] = Figura.wezSzesciokat(d[it2]);
          it1++;
          it2++;
          break;
        default:
          System.exit(2);
    }
  }

  private static void wypiszPolaIObwody() {
    for (int i = 0; i < f.length; i++)
      if(f[i] != null)
        System.out.println(f[i].toString() + ": pole = " + f[i].wezPole() + ", obwod = " + f[i].wezObwod());
  }
}
