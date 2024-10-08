
package Kamar;

/**
 *
 * @author rolis
 */
public abstract class Kamar {
    protected String nomorKamar;
    protected double hargaPerMalam;
    protected String tipeKamar;
    protected boolean tersedia;
    String status;

    public Kamar(String nomorKamar, double hargaPerMalam, String tipeKamar, boolean tersedia) {
        this.nomorKamar = nomorKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.tipeKamar = tipeKamar;
        this.tersedia = tersedia;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
    
    public String getStatusKetersediaan() {
        return tersedia ? "Tersedia" : "Tidak Tersedia"; // Ternary untuk menampilkan status kesediaan kamar
    }

    public abstract String getDeskripsiKamar();
}