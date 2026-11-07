// Subclass pengisian Pertamax yang mengimplementasikan interface CetakStruk
public class PengisianPertamax extends LayananSPBU implements CetakStruk {

    public PengisianPertamax(String kodeTransaksi, double jumlahLiter) {
        // Pemanggilan konstruktor superclass
        super(kodeTransaksi, "Pertamax", 12100.0, jumlahLiter);
    }

    // Implementasi method abstrak untuk memproses pengisian
    @Override
    public void prosesPengisian(double liter) {
        if (liter > 0) {
            setJumlahLiter(liter);
            setStatusProses(true);
            System.out.println("Pengisian Pertamax sebesar " + liter + " Liter berhasil.");
        } else {
            setStatusProses(false);
            System.out.println("Pengisian Pertamax gagal!");
        }
    }

    // Overriding method hitungSubtotal dari superclass
    @Override
    public double hitungSubtotal() {
        return super.hitungSubtotal();
    }

    // Method untuk menampilkan struk transaksi Pertamax
    @Override
    public void cetakStruk() {
        System.out.println("\n========== " + NAMA_SPBU + " ==========");
        System.out.println("Kode Transaksi : " + getKodeTransaksi());
        System.out.println("Jenis BBM      : " + getJenisBBM());
        System.out.println("Harga/Liter    : Rp " + getHargaPerLiter());
        System.out.println("Jumlah Liter   : " + getJumlahLiter() + " L");
        System.out.println("----------------------------------------");
        System.out.println("Total Bayar    : Rp " + hitungSubtotal());
        System.out.println("Status         : " + (isStatusProses() ? "SUKSES" : "GAGAL"));
        System.out.println("========================================\n");
    }
}