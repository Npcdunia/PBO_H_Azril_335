package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();
        while(true) {
            System.out.println("Pilih login:");
            System.out.println("1. Admin\n2. Mahasiswa\n0. Keluar");
            System.out.print("Masukkan pilihan: ");
            String pilihan = scanner.nextLine();

            if (pilihan.equals("1")) {
                System.out.print("Masukkan username: ");
                String user = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String pass = scanner.nextLine();
                admin.login(user, pass);
            } else if (pilihan.equals("2")) {
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                mahasiswa.login(nama, nim);
            } else if (pilihan.equals("0")) {
                System.out.println("Keluar dari program\n");
                break;
            }
        }
        scanner.close();
    }
}
