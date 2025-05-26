package com.praktikum.users;
import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;
import java.util.Iterator;
import com.praktikum.Error.LoginException;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Admin extends User implements AdminActions {
    String username = "Admin335";
    String password = "Password335";

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String username, String password) {
        boolean found = false;
        for(User u : LoginSystem.userList){
            if(u instanceof Mahasiswa mahasiswa){
                if (mahasiswa.getNama().equals(username) && mahasiswa.getNim().equals(password)){
                    throw new LoginException("Login Admin gagal : username/password salah");
                }
            }
        }
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola laporan barang.");
            System.out.println("2. Kelola Data Mahasiswa.");
            System.out.println("0. Log out.");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        manageItems();
                        break;
                    case 2:
                        manageUsers();
                        break;
                    case 0:
                        System.out.println("Keluar dari menu.\n");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harus berupa angka.");
            }
        }
    }



    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Kelola Laporan Barang ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        if (LoginSystem.itemList.isEmpty()) {
                            System.out.println("Belum ada laporan barang.");
                        } else {
                            System.out.printf("\n%-5s %-25s %-40s %-30s %-10s\n", "NO", "NAMA", "DESKRIPSI", "LOKASI", "STATUS");
                            int no = 1;
                            for (var item : LoginSystem.itemList) {
                                System.out.printf("\n%-5d %-25s %-40s %-30s %-10s\n",
                                        no++,
                                        item.getItemnama(),
                                        item.getDeskripsi(),
                                        item.getLocation(),
                                        item.getStatus());
                            }
                        }
                        break;

                    case 2:
                        boolean ada = false;
                        for (int i = 0; i < LoginSystem.itemList.size(); i++) {
                            var item = LoginSystem.itemList.get(i);
                            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                                if (!ada) {
                                    System.out.println("\nLaporan Barang (Status: Reported):");
                                    ada = true;
                                }
                                System.out.printf("[%d] %s - %s\n", i, item.getItemnama(), item.getLocation());
                            }
                        }

                        if (!ada) {
                            System.out.println("Tidak ada barang berstatus 'Reported'.");
                            break;
                        }

                        System.out.print("\nMasukkan indeks barang yang ingin ditandai sebagai 'Claimed': ");
                        try {
                            int index = Integer.parseInt(scanner.nextLine());
                            if (index >= 0 && index < LoginSystem.itemList.size()) {
                                var item = LoginSystem.itemList.get(index);
                                if ("Reported".equalsIgnoreCase(item.getStatus())) {
                                    item.setStatus("Claimed");
                                    System.out.println("Barang berhasil ditandai sebagai 'Claimed'.");
                                } else {
                                    System.out.println("Barang sudah dalam status 'Claimed'.");
                                }
                            } else {
                                System.out.println("Indeks tidak valid.");
                            }
                        } catch (NumberFormatException | IndexOutOfBoundsException e) {
                            System.out.println("Input tidak valid. Silakan coba lagi.");
                        }
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
            }
        }
    }


    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Kelola Data Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Nama Mahasiswa: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan NIM Mahasiswa: ");
                        String nim = scanner.nextLine();

                        Mahasiswa mhsBaru = new Mahasiswa(nama, nim);
                        LoginSystem.userList.add(mhsBaru);
                        System.out.println("Mahasiswa berhasil ditambahkan.");
                        break;

                    case 2:
                        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                        String nimHapus = scanner.nextLine();

                        boolean ditemukan = false;
                        Iterator<User> iterator = LoginSystem.userList.iterator();
                        while (iterator.hasNext()) {
                            User u = iterator.next();
                            if (u instanceof Mahasiswa m && m.getNim().equals(nimHapus)) {
                                iterator.remove();
                                ditemukan = true;
                                System.out.println("Mahasiswa dengan NIM " + nimHapus + " berhasil dihapus.");
                                break;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                        }
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
            }
        }
    }


    @Override
    void displayInfo() {
        System.out.println("Nama : " + getNama());
        System.out.println("NIM  : " + getNim());
    }

    @Override
    public void tampilkanWaktuLogin() {
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Waktu login : " + waktu.format(format));
    }
}