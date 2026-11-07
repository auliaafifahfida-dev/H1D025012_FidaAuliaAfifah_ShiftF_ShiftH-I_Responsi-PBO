/**
 * Superclass abstract untuk semua layanan pengisian bahan bakar.
 */
public abstract class LayananSPBU {

    // konstanta global
    public static final String NAMA_SPBU = "SPBU FIDAAAA";
    public static final double HARGA_DEFAULT = 10000;

    // atribut (semua private)
    private final String kodeTransaksi; // kekal, tidak bisa diubah
    private String namaPelanggan;
    private double jumlahLiter;
    private double hargaPerLiter;
    private String status;

    // konstruktor pertama: harga memakai nilai default
    public LayananSPBU(String kodeTransaksi, String namaPelanggan, double jumlahLiter) {
        this(kodeTransaksi, namaPelanggan, jumlahLiter, HARGA_DEFAULT);
    }

    // konstruktor kedua (overloading): harga ditentukan sendiri
    public LayananSPBU(String kodeTransaksi, String namaPelanggan,
                       double jumlahLiter, double hargaPerLiter) {
        this.kodeTransaksi = kodeTransaksi;
        this.namaPelanggan = namaPelanggan;
        this.jumlahLiter = jumlahLiter;
        this.hargaPerLiter = hargaPerLiter;
        this.status = "BELUM DIPROSES";
    }

    // getter dan setter
    public String getKodeTransaksi() {
        return this.kodeTransaksi;
    }

    public String getNamaPelanggan() {
        return this.namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public double getJumlahLiter() {
        return this.jumlahLiter;
    }

    public void setJumlahLiter(double jumlahLiter) {
        this.jumlahLiter = jumlahLiter;
    }

    public double getHargaPerLiter() {
        return this.hargaPerLiter;
    }

    public void setHargaPerLiter(double hargaPerLiter) {
        this.hargaPerLiter = hargaPerLiter;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // method fungsi (mengembalikan nilai)
    public double hitungTotal() {
        return this.jumlahLiter * this.hargaPerLiter;
    }

    public boolean isBerhasil() {
        return this.status.equals("BERHASIL");
    }

    // method prosedur (void)
    public void tampilkanDetail() {
        System.out.println("Kode transaksi : " + this.kodeTransaksi);
        System.out.println("Nama pelanggan : " + this.namaPelanggan);
        System.out.printf("Jumlah liter   : %.1f%n", this.jumlahLiter);
        System.out.printf("Harga/liter    : Rp%.0f%n", this.hargaPerLiter);
        System.out.println("Status         : " + this.status);
    }

    // dipakai subclass untuk mengubah status transaksi
    protected void tandaiBerhasil(String jenis) {
        this.status = "BERHASIL";
        System.out.println("Pengisian " + jenis + " berhasil diproses.");
    }

    protected void tandaiGagal(String alasan) {
        this.status = "GAGAL - " + alasan;
        System.out.println("Transaksi gagal: " + alasan + ".");
    }

    // isi struk yang sama untuk semua jenis BBM
    protected void cetakStrukDasar(String jenis, double diskon) {
        System.out.println("\n========== STRUK " + jenis.toUpperCase() + " ==========");
        System.out.println("Kode transaksi : " + this.kodeTransaksi);
        System.out.println("Nama pelanggan : " + this.namaPelanggan);
        if (isBerhasil()) {
            System.out.printf("Jumlah liter   : %.1f%n", this.jumlahLiter);
            System.out.printf("Harga per liter: Rp%.0f%n", this.hargaPerLiter);
            System.out.printf("Total          : Rp%.0f%n", hitungTotal());
            System.out.printf("Diskon         : Rp%.0f%n", diskon);
            System.out.printf("Total dibayar  : Rp%.0f%n", hitungTotal() - diskon);
        }
        System.out.println("Status         : " + this.status);
        System.out.println("=====================================");
    }

    // setiap jenis BBM punya aturan transaksi sendiri
    public abstract void prosesTransaksi();
}