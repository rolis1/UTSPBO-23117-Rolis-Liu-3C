package Users;

/**
 *
 * @author rolis
 */
public class Admin implements User {
    private final String namaAdmin;

    public Admin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }

    @Override
    public void aksesMenu() {
        System.out.println("Admin: " + namaAdmin);
        System.out.println("1. Cek Ketersediaan Kamar");
        System.out.println("2. Lihat Detail Pesanan");
        System.out.println("3. Batalkan Pesanan");
        System.out.println("Masukkan Pilihan: ");
    }
}
