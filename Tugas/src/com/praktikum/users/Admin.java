package com.praktikum.users;
import com.praktikum.actions.AdminActions;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Admin extends User implements AdminActions {
    String username = "Admin335";
    String password = "Password335";

    public Admin() {
        super("Admin335", "00335");
    }

    @Override
    public void login(String user, String pass) {
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Admin berhasil!");
            displayInfo();
            tampilkanWaktuLogin();
            displayAppMenu();
        } else {
            System.out.println("Login gagal! Username atau password salah.\n");
        }
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n===Menu Admin===");
            System.out.println("1. Kelola laporan barang.");
            System.out.println("2. Kelola Data Mahasiswa.");
            System.out.println("0. Log out.");
            System.out.print("pilih menu :");
            int pilihan = scanner.nextInt();

            switch(pilihan){
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
                    System.out.println("pilihantidak valid.\n");
            }
        }
    }

    @Override
    public void manageItems() {
        System.out.println("Fitur kelola barnag belum tersedia.\n");
    }

    @Override
    public void manageUsers() {
        System.out.println("Fitur kelola mahasiswa belum tersedia\n.");
    }

    @Override
    void displayInfo() {
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