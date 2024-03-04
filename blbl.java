import java.util.Scanner;

public class blbl {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih segitiga atau persegi?");
        String pilih = input.next();

        if (pilih.equalsIgnoreCase("SEGITIGA")){
            System.out.println("Masukkan alas dan tinggi:");
            int alas = input.nextInt();
            int tinggi = input.nextInt();
            int luasSG = luassegitiga(alas,tinggi);
            System.out.println("Luas segitiga sebesar: " + luasSG);
            double kelilingSG = kelilingsegitiga(alas, tinggi);
            int kelsg2 = (int) kelilingSG;
            System.out.println("Keliling segitiga sebesar: " + kelsg2);
        } else if (pilih.equalsIgnoreCase("PERSEGI")){
            System.out.println("Masukkan panjang dan lebar");
            int panjang = input.nextInt();
            int lebar = input.nextInt();
            int luasP = hitungluas(panjang,lebar);
            System.out.println("Luas persegi sebesar: " + luasP);
            int kelP = hitungkeliling( panjang,  lebar);
            System.out.println("Keliling persegi sebesar: " + kelP);
        }
    } public static int hitungluas(int panjang, int lebar){
        int luas = panjang * lebar;
        return luas;
    } 
    
    public static int hitungkeliling(int panjang, int lebar){
        int keliling = panjang * 2 + lebar * 2;
        return keliling;
    } 
    
    public static int luassegitiga(int alas, int tinggi){
        int luasS = alas * tinggi / 2;
        return luasS;
    } 
    
    public static double kelilingsegitiga(double alas, double tinggi){
        double sisi = Math.pow(alas, 2) + Math.pow(tinggi, 2);
        double sisi2 = Math.sqrt(sisi) * 3;
        return sisi2;
    }
}
