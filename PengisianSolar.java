public class PengisianSolar extends LayananSPBU implements CetakStruk {

    public static final double HARGA_SOLAR = 6800;
    public static final double BATAS_LITER = 200;

    public PengisianSolar(String kodeTransaksi, String namaPelanggan, double jumlahLiter) {
        super(kodeTransaksi, namaPelanggan, jumlahLiter, HARGA_SOLAR);
    }

    @Override
    public void prosesTransaksi() {
        if (getJumlahLiter() <= 0) {
            tandaiGagal("jumlah liter harus lebih dari 0");
        } else if (getJumlahLiter() > BATAS_LITER) {
            tandaiGagal("maksimal " + (int) BATAS_LITER + " liter per transaksi");
        } else {
            tandaiBerhasil("Solar");
        }
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Jenis BBM      : Solar");
    }

    @Override
    public void cetakStruk() {
        cetakStrukDasar("Solar", 0);
    }
}
