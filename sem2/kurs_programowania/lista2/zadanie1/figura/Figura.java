package main.java.lista2.figura;



public abstract class Figura implements MaPoleIObwod {

  public static Czworokat wezCzworokat(double bok1, double bok2, double bok3, double bok4, double kat) {
    if(Czworokat.czyRomb(bok1, bok2, bok3, bok4, kat))
      return new Romb(bok1, bok2, bok3, bok4, kat);
    if(Czworokat.czyProstokat(bok1, bok2, bok3, bok4, kat))
      return new Prostokat(bok1, bok2, bok3, bok4, kat);
    if(Czworokat.czyKwadrat(bok1, bok2, bok3, bok4, kat))
      return new Kwadrat(bok1, bok2, bok3, bok4, kat);
    return null;
  }

  public static Kolo wezOkrag(double promien) {
    if (promien <= 0) return null;
    return new Kolo(promien);
  }

  public static Pieciokat wezPieciokat(double bok) {
    if (bok <= 0) return null;
    return new Pieciokat(bok);
  }

  public static Szesciokat wezSzesciokat(double bok) {
    if (bok <= 0) return null;
    return new Szesciokat(bok);
  }
}
