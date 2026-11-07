public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("       SISTEM TRANSAKSI SPBU");
        System.out.println("          " + LayananSPBU.NAMA_SPBU);
        System.out.println("====================================");

        // TRANSAKSI PERTALITE
        System.out.println("\n========== TRANSAKSI PERTALITE ==========");

        PengisianPertalite pertalite =
            new PengisianPertalite("TRX-001", "Andi", 12);

        pertalite.prosesTransaksi();
        pertalite.tampilkanDetail();

        Diskon diskonPertalite = pertalite;
        double potonganPertalite =
            diskonPertalite.hitungDiskon(pertalite.hitungTotal());

        System.out.printf("Diskon melalui interface: Rp%.0f%n",
                          potonganPertalite);

        CetakStruk strukPertalite = pertalite;
        strukPertalite.cetakStruk();


        // TRANSAKSI PERTAMAX
        System.out.println("\n========== TRANSAKSI PERTAMAX ==========");

        PengisianPertamax pertamax =
            new PengisianPertamax("TRX-002", "Rina", 25);

        pertamax.prosesTransaksi();
        pertamax.tampilkanDetail();

        CetakStruk strukPertamax = pertamax;
        strukPertamax.cetakStruk();


        // TRANSAKSI SOLAR
        System.out.println("\n========== TRANSAKSI SOLAR ==========");

        PengisianSolar solar =
            new PengisianSolar("TRX-003", "Budi", 15);

        solar.prosesTransaksi();
        solar.tampilkanDetail();

        CetakStruk strukSolar = solar;
        strukSolar.cetakStruk();


        // TRANSAKSI DEXLITE
        System.out.println("\n========== TRANSAKSI DEXLITE ==========");

        PengisianDexlite dexlite =
            new PengisianDexlite("TRX-004", "Dewi", 20);

        dexlite.prosesTransaksi();
        dexlite.tampilkanDetail();

        CetakStruk strukDexlite = dexlite;
        strukDexlite.cetakStruk();


        // PENGUJIAN TRANSAKSI GAGAL
        System.out.println("\n========== TRANSAKSI GAGAL ==========");

        PengisianPertalite gagal =
            new PengisianPertalite("TRX-005", "Citra", 80);

        gagal.prosesTransaksi();
        gagal.tampilkanDetail();

        System.out.println("\nPengujian program selesai.");
    }
}