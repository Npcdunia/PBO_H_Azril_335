package com.praktikum.users;
import com.praktikum.Error.LoginException;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

import java.util.Iterator;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String nama, String nim) {

        super(nama,nim);
    }

    @Override
    public void login(String inputNama, String inputNim) {
        boolean found = false;
        for(User u : LoginSystem.userList){
            if(u instanceof Mahasiswa mahasiswa){
                if (mahasiswa.getNama().equals(inputNama) && mahasiswa.getNim().equals(inputNim)){
                    throw new LoginException("Login mahasiswa gagal : nama/nim salah");
                }
            }
        }
    }


    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang.");
            System.out.println("2. Lihat Daftar Laporan.");
            System.out.println("0. Log out.");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        ReportItem();
                        break;
                    case 2:
                        viewReportItems();
                        break;
                    case 0:
                        System.out.println("Keluar dari menu.\n");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.\n");
            }
        }
    }


    @Override
    public void ReportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Barang : ");
        String namabarang = scanner.nextLine();

        System.out.print("Deskripsi Barang : ");
        String Deskripsibarang = scanner.nextLine();

        System.out.print("Lokasi di temukan : ");
        String Lokasibarang = scanner.nextLine();

        Item item = new Item(namabarang,Deskripsibarang,Lokasibarang);
        LoginSystem.itemList.add(item);

        System.out.println("Terima kasih telah melapor!");
    }

    @Override
    public void viewReportItems() {
        Iterator<Item> iterator = LoginSystem.itemList.iterator();
        int index = 1;
        boolean ditemukan = false;

        while (iterator.hasNext()) {
            Item barang = iterator.next();
            if ("Reported".equalsIgnoreCase(barang.getStatus())) {
                // Tampilkan header hanya sekali saat ditemukan pertama
                if (!ditemukan) {
                    System.out.printf("\n%-5s %-25s %-40s %-30s\n", "NO", "NAMA", "DESKRIPSI", "LOKASI");
                    ditemukan = true;
                }

                System.out.printf("%-5d %-25s %-40s %-30s\n",
                        index++,
                        barang.getItemnama(),
                        barang.getDeskripsi(),
                        barang.getLocation()
                );
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada barang berstatus 'Reported'...");
        }
    }


    @Override
    public void displayInfo() {
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
