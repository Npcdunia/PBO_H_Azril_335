import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ManajemenBarang {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        daftarBarang.add(new Barang("Pensil", 0));
        daftarBarang.add(new Barang("Buku", 0));
        daftarBarang.add(new Barang("Pulpen", 0));

        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("=== Menu Manajemen Stok ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan nama barang: ");
                        String nama = scanner.nextLine();

                        System.out.print("Masukkan stok awal: ");
                        try {
                            int stok = scanner.nextInt();
                            scanner.nextLine();
                            Barang barangBaru = new Barang(nama, stok);
                            daftarBarang.add(barangBaru);
                            System.out.println("Barang berhasil ditambahkan.");
                        } catch (InputMismatchException e) {
                            System.out.println("Input stok harus berupa angka!");
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong.");
                        } else {
                            System.out.println("\nDaftar Barang:");
                            for (int i = 0; i < daftarBarang.size(); i++) {
                                Barang b = daftarBarang.get(i);
                                System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                            }
                        }
                        break;

                    case 3:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Tidak ada barang untuk dikurangi stoknya.");
                            break;
                        }

                        System.out.println("\nPilih barang yang ingin dikurangi stoknya:");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                        }

                        try {
                            System.out.print("Masukkan nomor indeks barang: ");
                            int indeks = scanner.nextInt();
                            Barang barangDipilih = daftarBarang.get(indeks);

                            System.out.print("Masukkan jumlah yang ingin diambil: ");
                            int jumlahDiambil = scanner.nextInt();
                            scanner.nextLine();

                            if (jumlahDiambil > barangDipilih.getStok()) {
                                throw new StokTidakCukupException("Stok untuk " + barangDipilih.getNama()
                                        + " hanya tersisa " + barangDipilih.getStok());
                            }

                            barangDipilih.setStok(barangDipilih.getStok() - jumlahDiambil);
                            System.out.println("Stok berhasil dikurangi. Sisa stok: " + barangDipilih.getStok());
                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka!");
                            scanner.nextLine();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Indeks barang tidak valid.");
                        } catch (StokTidakCukupException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Terima kasih!");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}