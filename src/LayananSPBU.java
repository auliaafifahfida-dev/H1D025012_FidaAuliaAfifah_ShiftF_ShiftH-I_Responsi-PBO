public abstract class LayananSPBU {
    // Konstanta dan variabel final (Immutability)
    public static final String NAMA_SPBU = "SPBU PERTAMINA FIDA AFIFAH";
    private final String kodeTransaksi;

    // Atribut privat (Enkapsulasi)
    private String jenisBBM;
    private double hargaPerLiter;
    private double jumlahLiter;
    private boolean statusProses;

    // Konstruktor 1 (Inisialisasi tanpa jumlah liter awal)
    public LayananSPBU(String kodeTransaksi, String jenisBBM, double hargaPerLiter) {
        this.kodeTransaksi = kodeTransaksi;
        this.jenisBBM = jenisBBM;
        this.hargaPerLiter = hargaPerLiter;
        this.jumlahLiter = 0.0;
        this.statusProses = false;
    }

    // Konstruktor 2 (Inisialisasi langsung dengan jumlah liter)
    public LayananSPBU(String kodeTransaksi, String jenisBBM, double hargaPerLiter, double jumlahLiter) {
        this.kodeTransaksi = kodeTransaksi;
        this.jenisBBM = jenisBBM;
        this.hargaPerLiter = hargaPerLiter;
        this.jumlahLiter = jumlahLiter;
        this.statusProses = false;
    }

    // Method abstrak untuk memproses pengisian BBM
    public abstract void prosesPengisian(double liter);

    // Prosedur untuk mereset status transaksi
    public void resetStatus() {
        this.statusProses = false;
    }

    // Fungsi untuk menghitung subtotal transaksi
    public double hitungSubtotal() {
        return hargaPerLiter * jumlahLiter;
    }

    // Getter dan Setter
    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public String getJenisBBM() {
        return jenisBBM;
    }

    public double getHargaPerLiter() {
        return hargaPerLiter;
    }

    public double getJumlahLiter() {
        return jumlahLiter;
    }

    public void setJumlahLiter(double jumlahLiter) {
        this.jumlahLiter = jumlahLiter;
    }

    public boolean isStatusProses() {
        return statusProses;
    }

    public void setStatusProses(boolean statusProses) {
        this.statusProses = statusProses;
    }
}