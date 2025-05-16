package com.praktikum.users;
import com.praktikum.actions.MahasiswaActions;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa() {

        super("MOCH SYAIFUL AZRIL", "202410370110335");
    }

    @Override
    public void login(String inputNama, String inputNim) {
        if (inputNama.equalsIgnoreCase(getNama()) && inputNim.equals(getNim())) {
            System.out.println("Login Mahasiswa berhasil!");
            displayInfo();
            tampilkanWaktuLogin();
            displayAppMenu();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.\n");
        }
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\n===Menu Mahasiswa===");
            System.out.println("1. Laporkan Barang Temuan/Hilang.");
            System.out.println("2. Lihat Daftar Laporan.");
            System.out.println("0. Log out.");
            System.out.print("pilih menu :");
            int pilihan = scanner.nextInt();

            switch (pilihan){
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
                    System.out.println("pilihan tidak valid.\n");
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

        System.out.println("Terima kasih telah melapor!");
    }

    @Override
    public void viewReportItems() {
        System.out.println("Fitur lihat laporan belum tersedia.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama : " + getNama());
        System.out.println("NIM  : " + getNim());
    }

    @Override
    void tampilkanWaktuLogin() {
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Waktu login : " + waktu.format(format));
    }
}
