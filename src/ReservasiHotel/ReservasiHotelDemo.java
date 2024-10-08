
package ReservasiHotel;
import Kamar.*;
import Users.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author rolis
 */
public class ReservasiHotelDemo {
    private static final ArrayList<Kamar> daftarKamar = new ArrayList<>();
    private static final ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        daftarKamar.add(new KamarKing("01", true));
        daftarKamar.add(new KamarKing("02", true));
        daftarKamar.add(new KamarQueen("03", true));
        daftarKamar.add(new KamarQueen("04", true));
        daftarKamar.add(new KamarQueen("05", true));

        User user = null;
        boolean lanjutAplikasi = true;

        while (lanjutAplikasi) {
            System.out.println("Selamat datang di sistem reservasi hotel.");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Keluar");
            System.out.println("Masukkan pilihan akses:");
            int pilAkses = input.nextInt();
            input.nextLine();
            
            switch (pilAkses) {
                case 1:
                    System.out.println("Masukkan nama Admin:");
                    String namaAdmin = input.nextLine();
                    user = new Admin(namaAdmin);
                    break;
                case 2:
                    System.out.println("Masukkan nama Customer:");
                    String namaCustomer = input.nextLine();
                    user = new Customer(namaCustomer);
                    break;
                case 3:
                    lanjutAplikasi = false;
                    continue;
                default:
                    System.out.println("Pilihan tidak valid.");
                    continue;
            }

            boolean lanjutMenu = true;
            while (lanjutMenu) {
                user.aksesMenu();
                int pilihan = input.nextInt();

                switch (pilihan) {
                    case 1:
                        if (user instanceof Admin) {
                            cekKetersediaanKamar();
                        } else {
                            tampilkanKamarTersedia();
                            pesanKamar(input);
                        }
                        break;
                    case 2:
                        lihatDetailPesanan();
                        break;
                    case 3:
                        batalkanPesanan(input);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }

                System.out.println("Ingin kembali ke menu? (y/n)");
                lanjutMenu = input.next().equalsIgnoreCase("y");
            }
        }

        System.out.println("Terima kasih telah menggunakan sistem reservasi hotel ini!");
        input.close();
    }

    
    public static void cekKetersediaanKamar() { // Cek ketersediaan kamar di user Admin
        for (Kamar kamar : daftarKamar) {
            System.out.println(kamar.getNomorKamar() + "-" + kamar.getTipeKamar() + " Status: " + kamar.getStatusKetersediaan());
        }
    }

    // Menampilkan hanya kamar yang tersedia untuk Customer
    public static void tampilkanKamarTersedia() {
        System.out.println("Kamar yang tersedia:");
        for (Kamar kamar : daftarKamar) {
            if (kamar.isTersedia()) {
                System.out.println(kamar.getNomorKamar() + " - " + kamar.getTipeKamar() + " - Harga per malam: " + kamar.getHargaPerMalam());
            }
        }
    }

    // Pesan kamar untuk Customer
    public static void pesanKamar(Scanner input) {
        System.out.println("Masukkan nomor kamar yang ingin dipesan:");
        String nomorKamar = input.next();

        for (Kamar kamar : daftarKamar) {
            if (kamar.getNomorKamar().equals(nomorKamar)) {
                if (kamar.isTersedia()) {
                    System.out.println("Berapa malam?: ");
                    int malam = input.nextInt();
                    System.out.println("Reservasi atas nama: ");
                    String namaCustomer = input.next();
                    Reservasi reservasi = new Reservasi(namaCustomer, kamar, malam);
                    daftarReservasi.add(reservasi);
                    kamar.setTersedia(false);
                    System.out.println("Kamar berhasil dipesan.");
                } else {
                    System.out.println("Kamar tidak tersedia.");
                }
                return;
            }
        }
        System.out.println("Nomor kamar tidak ditemukan.");
    }

    // Lihat detail pesanan untuk Admin dan Customer
    public static void lihatDetailPesanan() {
        if (daftarReservasi.isEmpty()) {
            System.out.println("Belum ada reservasi.");
        } else {
            for (Reservasi reservasi : daftarReservasi) {
                System.out.println(reservasi.getDetailReservasi());
            }
        }
    }

    // Batalkan pesanan
    public static void batalkanPesanan(Scanner input) {
        System.out.println("Masukkan nomor kamar yang ingin dibatalkan:");
        String nomorKamar = input.next();

        for (Reservasi reservasi : daftarReservasi) {
            if (reservasi.getDetailReservasi().contains(nomorKamar)) {
                reservasi.batalkanReservasi();
                daftarReservasi.remove(reservasi);
                for (Kamar kamar : daftarKamar) {
                    if (kamar.getNomorKamar().equals(nomorKamar)) {
                        kamar.setTersedia(true);
                        break;
                    }
                }
                
                return;
            }
        }
        System.out.println("Reservasi tidak ditemukan.");
    }
    
}
