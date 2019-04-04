package main.java.lista1;

import static java.lang.System.*;

public class Main {

  private static WierszTrojkataPascala wierszTrojkataPascala;

  public static void main(String[] args) {
    if(args.length < 1) {
      out.println("Za malo argumentow. ");
      exit(1);
    }
    int n = 0;
    try { n = Integer.parseInt(args[0]); }
    catch(NumberFormatException e) {
      out.println(args[0] + " - zly argument. Pierwszy argument musi byc klasy Integer. ");
      exit(2);
    }
    if(n < 0) {
      out.println(args[0] + " - zly argument. Numer wierwsza nie moze byc liczba ujemna. ");
      exit(3);
    }
    if(n > 20) {
      out.println(args[0] + " - zly argument. Numer wiersza musi byc nie wiekszy niz 20.  ");
      exit(4);
    }
    wierszTrojkataPascala = new WierszTrojkataPascala(n);
    int k = 0;
    for(int i = 1; i < args.length; i++) {
      try { k = Integer.parseInt(args[i]); } catch (NumberFormatException e) {
        out.println(args[i] + " - nieprawidlowa dana. ");
      }
      try { out.println(args[i] + " - " + wierszTrojkataPascala.wspolczynnik(k)); } catch (Exception e) {
        out.println(args[i] + " - " + e.getMessage());
      }
    }
  }
}