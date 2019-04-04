package main.java.lista0;

public class GD {
    public static void main(String[] args) { 
        int n = 0;
        for(int i = 0; i < args.length; i++) {
            try { n = Integer.parseInt(args[i]); }
            catch(NumberFormatException e) {
                System.out.println(args[i] + " nie jest liczba calkowita.");
                continue;
            }
            try { System.out.println(args[i]  + ": " + div(n)); }
            catch(Exception e) {
                System.out.println(args[i] + " nie jest liczba naturalna.");
            }
        }
    }
    
    public static int div(int n) throws Exception {
        if(n < 1) throw new Exception();
        int i = 1, gd = 1;
        while(i <= n/2) {
            if(n%i == 0)    gd = i;
            i++;
        }
        return gd;
    }
}
