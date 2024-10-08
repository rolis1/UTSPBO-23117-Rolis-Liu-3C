
package Kamar;

/**
 *
 * @author rolis
 */
public class KamarQueen extends Kamar {
    public KamarQueen(String nomorKamar, boolean tersedia) {
        super(nomorKamar, 500000.0, "Queen Bed", tersedia);
    }

    @Override
    public String getDeskripsiKamar() {
        return "Harga Kamar Queen Bed per malam: " + hargaPerMalam;
    }
}
