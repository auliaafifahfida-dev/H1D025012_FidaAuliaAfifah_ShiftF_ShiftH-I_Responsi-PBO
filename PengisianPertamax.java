public class PengisianPertamax extends LayananSPBU implements Diskon, CetakStruk {

    public static final double HARGA_PERTAMAX = 12500;
    public static final double BATAS_LITER = 100;

    public PengisianPertamax(String kodeTransaksi, String namaPelanggan, double jumlahLiter) {
        super(kodeTransaksi, namaPelanggan, jumlahLiter, HARGA_PERTAMAX);
    }

    @Override
    public void prosesTransaksi() {
        if (getJumlahLiter() <= 0) {
            tandaiGagal("jumlah liter harus lebih dari 0");
        } else if (getJumlahLiter() > BATAS_LITER) {
            tandaiGagal("maksimal " + (int) BATAS_LITER + " liter per transaksi");
        } else {
            tandaiBerhasil("Pertamax");
        }
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Jenis BBM      : Pertamax");
    }

    // diskon 10% untuk pembelian minimal Rp200.000
    @Override
    public double hitungDiskon(double total) {
        if (total >= 200000) {
            return total * 0.10;
        } else {
            return 0;
        }
    }

    @Override
    public void cetakStruk() {
        cetakStrukDasar("Pertamax", hitungDiskon(hitungTotal()));
    }
}
