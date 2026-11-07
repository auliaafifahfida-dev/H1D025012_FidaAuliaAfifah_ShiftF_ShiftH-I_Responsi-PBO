public class PengisianPertalite extends LayananSPBU implements Diskon, CetakStruk {

    public static final double HARGA_PERTALITE = 10000;
    public static final double BATAS_LITER = 60;

    public PengisianPertalite(String kodeTransaksi, String namaPelanggan, double jumlahLiter) {
        super(kodeTransaksi, namaPelanggan, jumlahLiter, HARGA_PERTALITE);
    }

    // overloading: tanpa nama pelanggan, otomatis "Umum"
    public PengisianPertalite(String kodeTransaksi, double jumlahLiter) {
        this(kodeTransaksi, "Umum", jumlahLiter);
    }

    @Override
    public void prosesTransaksi() {
        if (getJumlahLiter() <= 0) {
            tandaiGagal("jumlah liter harus lebih dari 0");
        } else if (getJumlahLiter() > BATAS_LITER) {
            tandaiGagal("maksimal " + (int) BATAS_LITER + " liter per transaksi");
        } else {
            tandaiBerhasil("Pertalite");
        }
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Jenis BBM      : Pertalite");
    }

    // diskon 5% untuk pembelian minimal Rp100.000
    @Override
    public double hitungDiskon(double total) {
        if (total >= 100000) {
            return total * 0.05;
        } else {
            return 0;
        }
    }

    @Override
    public void cetakStruk() {
        cetakStrukDasar("Pertalite", hitungDiskon(hitungTotal()));
    }
}