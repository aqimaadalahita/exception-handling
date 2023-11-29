import java.util.Scanner;

// Interface untuk menghitung total barang
interface HitungTotal {
    double hitungTotal();
}

// Kelas utama Faktur
class Faktur {
    private String noFaktur;
    private String namaPelanggan;

    public Faktur(String noFaktur, String namaPelanggan) {
        this.noFaktur = noFaktur;
        this.namaPelanggan = namaPelanggan;
    }

    public String getNoFaktur() {
        return noFaktur;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }
}

// Kelas Barang dengan inheritance dari Faktur
class Barang extends Faktur implements HitungTotal {
    private String namaBarang;
    private double hargaBarang;
    private int jumlahBarang;

    public Barang(String noFaktur, String namaPelanggan, String namaBarang, double hargaBarang, int jumlahBarang) {
        super(noFaktur, namaPelanggan);
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBarang = jumlahBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    @Override
    public double hitungTotal() {
        return hargaBarang * jumlahBarang;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan nomor faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan nama pelanggan: ");
            String namaPelanggan = scanner.nextLine();

            System.out.print("Masukkan nama barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan harga barang: ");
            double hargaBarang = scanner.nextDouble();

            System.out.print("Masukkan jumlah barang: ");
            int jumlahBarang = scanner.nextInt();

            // Membuat objek Barang
            Barang barang = new Barang(noFaktur, namaPelanggan, namaBarang, hargaBarang, jumlahBarang);

            // Menampilkan informasi faktur dan total barang
            System.out.println("------------------------------");
            System.out.println("Nomor Faktur: " + barang.getNoFaktur());
            System.out.println("Nama Pelanggan: " + barang.getNamaPelanggan());
            System.out.println("Nama Barang: " + barang.getNamaBarang());
            System.out.println("Harga Barang: " + barang.getHargaBarang());
            System.out.println("Jumlah Barang: " + barang.getJumlahBarang());
            System.out.println("Total Barang: " + barang.hitungTotal());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
