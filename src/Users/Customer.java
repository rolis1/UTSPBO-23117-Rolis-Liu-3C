
package Users;

/**
 *
 * @author rolis
 */
public class Customer implements User {
    private String namaCustomer;

    public Customer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    @Override
    public void aksesMenu() {
        System.out.println("Customer: " + namaCustomer);
        System.out.println("1. Reservasi Kamar");
        System.out.println("2. Lihat Detail Pesanan");
        System.out.println("3. Batalkan Pesanan");
        System.out.println("Masukkan Pilihan");
    }
}
