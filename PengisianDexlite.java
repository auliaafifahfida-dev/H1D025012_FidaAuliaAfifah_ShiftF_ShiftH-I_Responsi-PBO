public class PengisianDexlite extends LayananSPBU implements CetakStruk {

    public static final double HARGA_DEXLITE = 13000;
    public static final double BATAS_LITER = 100;

    public PengisianDexlite(String kodeTransaksi, String namaPelanggan, double jumlahLiter) {
        super(kodeTransaksi, namaPelanggan, jumlahLiter, HARGA_DEXLITE);
    }

    @Override
    public void prosesTransaksi() {
        if (getJumlahLiter() <= 0) {
            tandaiGagal("jumlah liter harus lebih dari 0");
        } else if (getJumlahLiter() > BATAS_LITER) {
            tandaiGagal("maksimal " + (int) BATAS_LITER + " liter per transaksi");
        } else {
            tandaiBerhasil("Dexlite");
        }
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Jenis BBM      : Dexlite");
    }

    @Override
    public void cetakStruk() {
        cetakStrukDasar("Dexlite", 0);
    }
}
