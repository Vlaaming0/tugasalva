public class mobil {
    private String noplat;
    private String warna;
    private String manufactur;
    private int kecepatan;

    public void setnoplat(String s){
        noplat = s;
    }

    public void setwarna(String s){
        warna = s;
    }

    public void setmanufactur(String s){
        manufactur = s;
    }

    public void setkecepatan(int i){
        kecepatan = i;
    }

    public void displaymessage() {
        System.out.println("Mobil anda adalah bermerek " + manufactur);
        System.out.println("Mempunyai nomer plat " + noplat);
        System.out.println("Serta memiliki warna " + warna);
        System.out.println("Dan mampu menempuh kecepatan " + kecepatan);
    }
}
