import java.text.DecimalFormat;
import java.util.Scanner;

class Pegawai {
    private String nama;
    private String noKTP;

    public Pegawai(String nama, String noKTP) {
        this.nama = nama;
        this.noKTP = noKTP;
    }

    public String getNama() {
        return nama;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public String toString() {
        return "Nama            : " + nama + "\nNo. KTP         : " + noKTP;
    }
    
    public double gaji() {
        return 0;
    }
}

class PegawaiTetap extends Pegawai {
    private double upah;

    public PegawaiTetap(String nama, String noKTP, double upah) {
        super(nama, noKTP);
        this.upah = upah;
    }

    public void setUpah(double upah) {
        this.upah = upah;
    }

    public double getUpah() {
        return upah;
    }

    public double gaji() {
        return upah;
    }
}

class PegawaiHarian extends Pegawai {
    private double upahPerJam;
    private int totalJam;

    public PegawaiHarian(String nama, String noKTP, double upahPerJam, int totalJam) {
        super(nama, noKTP);
        this.upahPerJam = upahPerJam;
        this.totalJam = totalJam;
    }

    public double getUpahPerJam() {
        return upahPerJam;
    }

    public int getTotalJam() {
        return totalJam;
    }

    public void setUpahPerJam(double upahPerJam) {
        this.upahPerJam = upahPerJam;
    }

    public void setTotalJam(int totalJam) {
        this.totalJam = totalJam;
    }

    public double gaji() {
        if (totalJam <= 40) {
            return upahPerJam * totalJam;
        } else {
            int jamNormal = 40;
            double gajiNormal = upahPerJam * jamNormal;
            int jamLembur = totalJam - jamNormal;
            return gajiNormal + (jamLembur * upahPerJam * 1.5);
        }
    }
}

class Sales extends Pegawai {
    private int penjualan;
    private double komisi;

    public Sales(String nama, String noKTP, int penjualan, double komisi) {
        super(nama, noKTP);
        this.penjualan = penjualan;
        this.komisi = komisi;
    }

    public int getPenjualan() {
        return penjualan;
    }

    public double getKomisi() {
        return komisi;
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }

    public void setKomisi(double komisi) {
        this.komisi = komisi;
    }

    public double gaji() {
        return penjualan * komisi;
    }
}

public class obob {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pegawai[] dataPT = new Pegawai[100];
        Pegawai[] dataPH = new Pegawai[100];
        Pegawai[] dataS = new Pegawai[100];
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        DecimalFormat currencyFormat = new DecimalFormat("Rp #,##0");

        boolean rill = true;
        while(rill){
            System.out.println("Pilih kategori karyawan");
            System.out.println("=======================");
            System.out.println("1. Pegawai Tetap");
            System.out.println("2. Pegawai Harian");
            System.out.println("3. Sales");
            System.out.println("=======================");
            int milih = input.nextInt();
            input.nextLine();
            

            switch (milih) {
                case 1:
                System.out.println("Masukkan data pegawai tetap");
                System.out.print("Nama            : ");
                String namaTetap = input.nextLine();
                System.out.print("No. KTP         : ");
                String noKTPtetap = input.nextLine();
                System.out.print("Upah            : ");
                double upahTetap = input.nextDouble();
                input.nextLine();
                dataPT[count1] = new PegawaiTetap(namaTetap, noKTPtetap, upahTetap);
                count1++;
                System.out.println("===========================");
                break;
            
                case 2:
                System.out.println("Masukkan data pegawai harian");
                System.out.print("Nama            : ");
                String namaHarian = input.nextLine();
                System.out.print("No. KTP         : ");
                String noKTPharian = input.nextLine();
                System.out.print("Upah/jam        : ");
                double upahPerJam = input.nextDouble();
                System.out.print("Total jam kerja : ");
                int totalJam = input.nextInt();
                input.nextLine();
                dataPH[count2] = new PegawaiHarian(namaHarian, noKTPharian, upahPerJam, totalJam);
                count2++;
                System.out.println("============================");
                break;

                case 3:
                System.out.println("Masukkan data sales");
                System.out.print("Nama            : ");
                String namaSales = input.nextLine();
                System.out.print("No. KTP         : ");
                String noKTPsales = input.nextLine();
                System.out.print("Total Penjualan : ");
                int penjualan = input.nextInt();
                System.out.print("Besaran Komisi  : ");
                double komisi = input.nextDouble();
                input.nextLine();
                dataS[count3] = new Sales(namaSales, noKTPsales, penjualan, komisi);
                count3++;
                System.out.println("===================");
                break;

                default:
                System.out.println("Invalid");
                    break;
            }

            System.out.println("Tambah data karyawan lagi?");
            System.out.println("==========================");
            System.out.print("Ya / Tidak : ");
            String pilih = input.nextLine();

            if(pilih.equalsIgnoreCase("ya")){
                rill = pilih.equalsIgnoreCase("ya");
            } else if(pilih.equalsIgnoreCase("tidak")){
                rill = false;
            }
        }

        System.out.println("Data Pegawai");
        System.out.println("============");
        for(int i = 0; i < count1; i++){
            System.out.println("\nKaryawan Tetap");
            Pegawai karyawan = dataPT[i];
            System.out.println(karyawan);
            PegawaiTetap pegawaiTetap = (PegawaiTetap) karyawan;
            System.out.println("Upah            : " + currencyFormat.format(pegawaiTetap.getUpah()));
            System.out.println("Pendapatan      : " + currencyFormat.format(pegawaiTetap.gaji()));
        }

        for(int i = 0; i < count2; i++){
            System.out.println("\nKaryawan Harian");
            Pegawai karyawan = dataPH[i];
            System.out.println(karyawan);
            PegawaiHarian pegawaiHarian = (PegawaiHarian) karyawan;
            System.out.println("Total jam kerja : " + pegawaiHarian.getTotalJam());
            System.out.println("Upah/jam        : " + currencyFormat.format(pegawaiHarian.getUpahPerJam()));
            System.out.println("Pendapatan      : " + currencyFormat.format(pegawaiHarian.gaji()));
        }

        for(int i = 0; i < count3; i++){
            System.out.println("\nSales");
            Pegawai karyawan = dataS[i];
            System.out.println(karyawan);
            Sales sales = (Sales) karyawan;
            System.out.println("Total Penjualan : " + sales.getPenjualan());
            System.out.println("Besaran Komisi  : " + currencyFormat.format(sales.getKomisi()));
            System.out.println("Pendapatan      : " + currencyFormat.format(sales.gaji()));
        }

        input.close();
    }
}
