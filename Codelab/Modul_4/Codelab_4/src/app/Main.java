package app;
import perpustakaan.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Buku bukufiksi = new Fiksi("Bumi","Tere Liye", "(Fantasy)");
        Buku bukunonfiksi = new NonFiksi("Manusia dan Langit", "Rogbi Adam", "(Astrofotografi)");
        Anggota Anggota1 = new Anggota("Syaiful Azril","H335");
        Anggota Anggota2 = new Anggota("Ramanda", "H380");

        Scanner scanner = new Scanner(System.in);

        bukufiksi.displayinfo();
        bukunonfiksi.displayinfo();

        System.out.print("Masukkan nama : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ID : ");
        String IdAnggota = scanner.nextLine();
        
        Anggota anggotaAktif = null;
        if (Anggota1.autentikasi(nama, IdAnggota)) {
            anggotaAktif = Anggota1;
            Anggota1.displayinfo();
            Anggota1.PinjamBuku("Bumi");
            Anggota1.KembalikanBuku("Bumi");
        } else if (Anggota2.autentikasi(nama, IdAnggota)) {
            anggotaAktif = Anggota2;
            Anggota2.displayinfo();
            Anggota2.PinjamBuku("Manusia dan Langit", 7);
            Anggota2.KembalikanBuku("Manusia dan Langit", 7);
        } else {
            System.out.println("Autentikasi gagal. Nama atau ID salah.");
            return;
        }
    }
}