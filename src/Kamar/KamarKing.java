
package Kamar;

/**
 *
 * @author rolis
 */
public class KamarKing extends Kamar {
    public KamarKing(String nomorKamar, boolean tersedia) {
        super(nomorKamar, 750000.0, "King Bed", tersedia);
    }

    @Override
    public String getDeskripsiKamar() {
        return "Harga Kamar Queen Bed per malam: " + hargaPerMalam;
    }
}
