public class Main {
    public static void main(String[] args) {
        System.out.println("=== PENGUJIAN SISTEM TRANSAKSI SPBU ===\n");

        // 1. Pengujian Pengisian Pertalite Valid & Dapat Diskon
        System.out.println("--- Transaksi 1: Pengisian Pertalite (Valid & Diskon) ---");
        PengisianPertalite pertalite = new PengisianPertalite("TRX-001", 12.0);
        pertalite.prosesPengisian(12.0); // Total 12 Liter = Rp 120.000 (Dapat Diskon)
        
        // Polimorfisme interface: Pemanggilan method via variabel bertipe CetakStruk
        CetakStruk transaksiPertalite = pertalite;
        transaksiPertalite.cetakStruk();

        // 2. Pengujian Pengisian Pertamax Valid Tanpa Diskon
        System.out.println("--- Transaksi 2: Pengisian Pertamax (Valid) ---");
        PengisianPertamax pertamax = new PengisianPertamax("TRX-002", 5.0);
        pertamax.prosesPengisian(5.0); // Total 5 Liter = Rp 60.500 (Tanpa Diskon)
        
        // Polimorfisme interface
        CetakStruk transaksiPertamax = pertamax;
        transaksiPertamax.cetakStruk();

        // 3. Pengujian Logika If/Else Transaksi Gagal (Liter Tidak Valid)
        System.out.println("--- Transaksi 3: Pengisian Tidak Valid (Uji Logika If/Else Gagal) ---");
        PengisianPertalite pertaliteGagal = new PengisianPertalite("TRX-003", 0.0);
        pertaliteGagal.prosesPengisian(-2.0); // Pengisian negatif memicu kondisi else (State GAGAL)
        
        // Polimorfisme interface
        CetakStruk transaksiGagal = pertaliteGagal;
        transaksiGagal.cetakStruk();
    }
}