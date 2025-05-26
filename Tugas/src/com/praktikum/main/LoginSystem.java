package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> itemList = new ArrayList<>();

    public static void main(String[] args) {
        userList.add(new Admin("Admin335", "Password335"));
        userList.add(new Mahasiswa("MOCH SYAIFUL AZRIL", "202410370110335"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Login ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            String pilihan = scanner.nextLine();

            if (pilihan.equals("1")) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                boolean berhasilLogin = false;
                for (User u : userList) {
                    if (u instanceof Admin admin) {
                        if (admin.getNama().equals(username) && admin.getNim().equals(password)) {
                            admin.tampilkanWaktuLogin();
                            admin.displayAppMenu();
                            berhasilLogin = true;
                            break;
                        }
                    }
                }

                if (!berhasilLogin) {
                    System.out.println("Login Admin gagal. Username atau password salah.");
                }

            } else if (pilihan.equals("2")) {
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                boolean berhasilLogin = false;
                for (User u : userList) {
                    if (u instanceof Mahasiswa mhs) {
                        if (mhs.getNama().equals(nama) && mhs.getNim().equals(nim)) {
                            mhs.tampilkanWaktuLogin();
                            mhs.displayAppMenu();
                            berhasilLogin = true;
                            break;
                        }
                    }
                }

                if (!berhasilLogin) {
                    System.out.println("Login Mahasiswa gagal. Nama atau NIM salah.");
                }

            } else if (pilihan.equals("0")) {
                System.out.println("Keluar dari program.");
                break;
            } else {
                System.out.println("Pilihan tidak valid.\n");
            }
        }

        scanner.close();
    }
}
