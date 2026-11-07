// Subclass pengisian Pertalite yang mengimplementasikan interface Diskon dan CetakStruk
public class PengisianPertalite extends LayananSPBU implements Diskon, CetakStruk {

    public PengisianPertalite(String kodeTransaksi, double jumlahLiter) {
        // Pemanggilan konstruktor superclass
        super(kodeTransaksi, "Pertalite", 10000.0, jumlahLiter);
    }

    // Implementasi method abstrak untuk memproses pengisian dan mengubah state
    @Override
    public void prosesPengisian(double liter) {
        if (liter > 0) {
            setJumlahLiter(liter);
            setStatusProses(true);
            System.out.println("Pengisian Pertalite sebesar " + liter + " Liter berhasil.");
        } else {
            setStatusProses(false);
            System.out.println("Jumlah liter tidak valid!");
        }
    }

    // Perhitungan diskon 5% untuk minimal transaksi Rp 100.000
    @Override
    public double hitungDiskon(double total) {
        if (total >= 100000) {
            return total * 0.05;
        }
        return 0;
    }

    // Method untuk menampilkan struk transaksi Pertalite
    @Override
    public void cetakStruk() {
        double subtotal = hitungSubtotal();
        double diskon = hitungDiskon(subtotal);
        double totalBayar = subtotal - diskon;

        System.out.println("\n========== " + NAMA_SPBU + " ==========");
        System.out.println("Kode Transaksi : " + getKodeTransaksi());
        System.out.println("Jenis BBM      : " + getJenisBBM());
        System.out.println("Harga/Liter    : Rp " + getHargaPerLiter());
        System.out.println("Jumlah Liter   : " + getJumlahLiter() + " L");
        System.out.println("Subtotal       : Rp " + subtotal);
        System.out.println("Diskon         : Rp " + diskon);
        System.out.println("----------------------------------------");
        System.out.println("Total Bayar    : Rp " + totalBayar);
        System.out.println("Status         : " + (isStatusProses() ? "SUKSES" : "GAGAL"));
        System.out.println("========================================\n");
    }
}