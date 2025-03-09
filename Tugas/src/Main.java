//tugas 1

import java.util.Scanner;

public class Main{
    //validasi input admin
    private static void Admin(Scanner scanner){
        String usernameAdmin = "Admin335";
        String passwordAdmin = "Password335";

        System.out.print("Masukkan Username : ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password : ");
        String password = scanner.nextLine();

        if(username.equals(usernameAdmin) && password.equals(passwordAdmin)){
            System.out.println("Login Admin Berhasil!");
        }else{
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    //validasi input mahasiswa
    private static void Mahasiswa(Scanner scanner){
        String namaMahasiswa = "MOCH SYAIFUL AZRIL";
        String nimMahasiswa = "202410370110335";

        System.out.print("Masukkan Nama : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM : ");
        String nim = scanner.nextLine();

        if(nama.equals(namaMahasiswa) && nim.equals(nimMahasiswa)){
            System.out.println("Login Mahasiswa Berhasil!");
            System.out.println("Nama : " + nama);
            System.out.println("NIM : " + nim);
        }else{
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    //program utama memilih pilihan
    public static void main(String[] args) {
        int pilih;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih login : ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        pilih = scanner.nextInt();
        scanner.nextLine();

        if(pilih == 1){
            Admin(scanner);
        }else if(pilih == 2){
            Mahasiswa(scanner);
        }else{
            System.out.print("Pilihan tidak valid.");
        }
        scanner.close();
    }
}