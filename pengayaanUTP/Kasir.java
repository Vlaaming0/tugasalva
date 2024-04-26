package pengayaanUTP;

import java.util.Scanner;

public class Kasir {
    private Meja[] daftarMeja;
    private Menu[] daftarMenu;

    public Kasir() {
        daftarMeja = new Meja[10];
        for (int i = 0; i < 10; i++) {
            daftarMeja[i] = new Meja(i + 1);
        }

        daftarMenu = new Menu[5];
        daftarMenu[0] = new Menu("Nasi Goreng", 15000);
        daftarMenu[1] = new Menu("Mi Goreng", 15000);
        daftarMenu[2] = new Menu("Capcay", 20000);
        daftarMenu[3] = new Menu("Bihun Goreng", 17000);
        daftarMenu[4] = new Menu("Ayam Koloke", 25000);
    }

    public void tampilkanDaftarMeja() {
        System.out.println("Daftar Meja:");
        for (int i = 0; i < daftarMeja.length; i++) {
            if (daftarMeja[i].isKosong()) {
                System.out.println("Meja " + (i + 1) + " tersedia");
            } else {
                System.out.println("Meja " + (i + 1) + " telah diisi oleh pelanggan " + daftarMeja[i].getPelanggan().getNama());
            }
        }
    }

    public void tambahPelanggan(int nomorMeja, Pelanggan pelanggan) {
        if (nomorMeja >= 1 && nomorMeja <= daftarMeja.length) {
            if (daftarMeja[nomorMeja - 1].isKosong()) {
                daftarMeja[nomorMeja - 1].setPelanggan(pelanggan);
                System.out.println("Pelanggan telah ditambahkan ke meja nomor " + nomorMeja);
            } else {
                System.out.println("Meja nomor " + nomorMeja + " sudah terisi");
            }
        } else {
            System.out.println("Meja tidak valid");
        }
    }

    public void tambahPesanan(int nomorMeja, Menu menu) {
        if (nomorMeja >= 1 && nomorMeja <= daftarMeja.length) {
            if (!daftarMeja[nomorMeja - 1].isKosong()) {
                daftarMeja[nomorMeja - 1].tambahMenu(menu);
            } else {
                System.out.println("Meja kosong");
            }
        } else {
            System.out.println("Meja tidak valid");
        }
    }

    public void hapusPelanggan(int nomorMeja) {
        if (nomorMeja >= 1 && nomorMeja <= daftarMeja.length) {
            daftarMeja[nomorMeja - 1].hapusPelanggan();
            System.out.println("Pelanggan pada meja nomor " + nomorMeja + " telah dihapus");
        } else {
            System.out.println("Meja tidak valid");
        }
    }

    public int hitungHargaPesanan(int nomorMeja) {
        int totalHarga = 0;
        Meja meja = daftarMeja[nomorMeja - 1];
        Pelanggan pelanggan = meja.getPelanggan();
        Menu[] menu = meja.getMenu();
        if (pelanggan != null && menu != null && menu.length > 0) {
            for (int i = 0; i < menu.length; i++) {
                if (menu[i] != null) {
                    totalHarga += menu[i].getHarga();
                }
            }
        }
        return totalHarga;
    }

    public void tampilkanPesanan(int nomorMeja) {
        Meja meja = daftarMeja[nomorMeja - 1];
        Pelanggan pelanggan = meja.getPelanggan();
        Menu[] menu = meja.getMenu();
        if (pelanggan != null && menu != null && menu.length > 0) {
            System.out.println("Pesanan pada Meja " + nomorMeja + " :");
            for (int i = 0; i < menu.length; i++) {
                if (menu[i] != null) {
                    System.out.println("Meja " + nomorMeja + " - " + pelanggan.getNama() + " memesan " + menu[i].getNama() + " seharga Rp" + menu[i].getHarga());
                }
            }
        } else {
            System.out.println("Meja " + nomorMeja + " tidak memiliki pesanan");
        }
    }

    public void tampilkanDaftarMenu() {
        System.out.println("Daftar Menu:");
        for (int i = 0; i < daftarMenu.length; i++) {
            System.out.println((i + 1) + ". " + daftarMenu[i].getNama() + " - Rp" + daftarMenu[i].getHarga());
        }
        System.out.println((daftarMenu.length + 1) + ". Simpan");
    }

    public void tampilkanDaftarFitur() {
        System.out.println("1. Tampilkan daftar meja");
        System.out.println("2. Tambah pelanggan");
        System.out.println("3. Tambah pesanan");
        System.out.println("4. Hapus pelanggan");
        System.out.println("5. Hitung harga pesanan");
        System.out.println("6. Tampilkan pesanan di meja");
        System.out.println("0. Keluar");
    }

    public void jalankan() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = -1;
        while (pilihan != 0) {
            tampilkanDaftarFitur();
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    tampilkanDaftarMeja();
                    break;
                case 2:
                    System.out.print("Masukkan nomor meja: ");
                    int nomorMejaPelanggan = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama pelanggan: ");
                    String namaPelanggan = scanner.nextLine();
                    tambahPelanggan(nomorMejaPelanggan, new Pelanggan(namaPelanggan));
                    break;
                case 3:
                    boolean stopLoop = false;
                System.out.print("Masukkan nomor meja: ");
                int nomorMejaPesan = scanner.nextInt();
                Boolean meja = daftarMeja[nomorMejaPesan - 1].isKosong();
                scanner.nextLine();  
                if (!meja) {
                    tampilkanDaftarMenu();
                    while (!stopLoop) {
                        System.out.print("Masukkan nomor menu: ");
                        int nomorMenuPesan = scanner.nextInt();
                        scanner.nextLine();  
                        switch (nomorMenuPesan) {
                            case 1:
                                tambahPesanan(nomorMejaPesan, daftarMenu[0]);
                                break;
                            case 2:
                                tambahPesanan(nomorMejaPesan, daftarMenu[1]);
                                break;
                            case 3:
                                tambahPesanan(nomorMejaPesan, daftarMenu[2]);
                                break;
                            case 4:
                                tambahPesanan(nomorMejaPesan, daftarMenu[3]);
                                break;
                            case 5:
                                tambahPesanan(nomorMejaPesan, daftarMenu[4]);
                                break;
                            case 6:
                                stopLoop = true;
                                break;
                            default:
                                System.out.println("Nomor menu tidak valid");
                                break;
                        }
                    }
                }
                else {
                    System.out.println("Meja belum terisi oleh pelanggan");
                }
                break;
                case 4:
                    System.out.print("Masukkan nomor meja: ");
                    int nomorMejaHapus = scanner.nextInt();
                    scanner.nextLine();
                    hapusPelanggan(nomorMejaHapus);
                    break;
                case 5:
                    System.out.print("Masukkan nomor meja: ");
                    int nomorMejaHarga = scanner.nextInt();
                    scanner.nextLine();
                    int totalHarga = hitungHargaPesanan(nomorMejaHarga);
                    if (totalHarga > 0) {
                    System.out.println("Total tagihan pada meja nomor " + nomorMejaHarga + " adalah Rp" + totalHarga);
                    } else {
                    System.out.println("Meja nomor " + nomorMejaHarga + " tidak memiliki pesanan");
                    }
                    break;
                case 6:
                    System.out.print("Masukkan nomor meja: ");
                    int nomorMejaTampilkan = scanner.nextInt();
                    scanner.nextLine();
                    tampilkanPesanan(nomorMejaTampilkan);
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi kasir restoran!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Kasir kasir = new Kasir();
        kasir.jalankan();
    }
}

class Meja {
    private int nomorMeja;
    private Pelanggan pelanggan;
    private Menu[] menu;

    public Meja(int nomorMeja) {
        this.nomorMeja = nomorMeja;
        this.pelanggan = null;
        this.menu = new Menu[10];
    }

    public boolean isKosong() {
        return pelanggan == null;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void tambahMenu(Menu menu) {
        for (int i = 0; i < this.menu.length; i++) {
            if (this.menu[i] == null) {
                this.menu[i] = menu;
                break;
            }
        }
    }

    public Menu[] getMenu() {
        return menu;
    }

    public void hapusPelanggan() {
        pelanggan = null;
        menu = new Menu[10]; 
    }
}

class Menu {
    private String nama;
    private int harga;

    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
}

class Pelanggan {
    private String nama;

    public Pelanggan(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}
