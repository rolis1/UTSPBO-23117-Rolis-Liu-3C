
package ReservasiHotel;
import Kamar.*;

/**
 *
 * @author rolis
 */
public class Reservasi {
    private final String namaCustomer;
    private final Kamar kamar;
    private final int jumlahMalam;

    public Reservasi(String namaCustomer, Kamar kamar, int jumlahMalam) {
        this.namaCustomer = namaCustomer;
        this.kamar = kamar;
        this.jumlahMalam = jumlahMalam;
        kamar.setTersedia(false); // Set kamar menjadi tidak tersedia(false) saat dipesan
    }

    public String getDetailReservasi() {
        return "Nama Customer: " + namaCustomer + "\n" +
               "Nomor Kamar: " + kamar.getNomorKamar() + "\n" +
               "Tipe Kamar: " + kamar.getTipeKamar() + "\n" +
               "Jumlah Malam: " + jumlahMalam + "\n" +
               "Total Harga: " + kamar.getHargaPerMalam() * jumlahMalam;
    }

    public void batalkanReservasi() { // Membatalkan/menghapuis reservasi customer
        kamar.setTersedia(true);
        System.out.println("Reservasi telah dibatalkan.");
    }
}
