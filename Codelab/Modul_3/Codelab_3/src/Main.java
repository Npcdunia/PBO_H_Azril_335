import java.util.Scanner;

//Superclass
class KarakterGame {
    private String nama; //Mendeklarasikan atribut nama untuk menyimpan nama karakter
    private int kesehatan; //Untuk menyimpan nilai kesehatan karakter

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama; //nilai nama dan kesehatan akan disimpan ke variabel nama dan kesehatan pada class ini
        this.kesehatan = kesehatan;
    }

    public String getNama() { //untuk mengambil nilai nama diluar class
        return nama;
    }

    public void setNama(String nama) { //untuk mengubah nilai nama diluar class
        this.nama = nama;
    }

    public int getKesehatan() { // untuk mengambil nilai kesehatan dilar class
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) { //untuk mengubah nilai kesehatan diluar class
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target, String senjata) {
        // Method akan di-override oleh subclass
    }
}

// Subclass Pahlawan dari class karakter game
class Pahlawan extends KarakterGame {

    public Pahlawan(String nama, int kesehatan) { //constructor dari pahlawan
        super(nama, kesehatan);
    }

    public void serang(KarakterGame target, String senjata) { //method serang() dari karakter game di pahlawan
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan " + senjata + "!");
        target.setKesehatan(target.getKesehatan() - 20);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

// Subclass Musuh dari class karakter game
class Musuh extends KarakterGame {

    public Musuh(String nama, int kesehatan) { //constructor dari musuh
        super(nama, kesehatan);
    }

    public void serang(KarakterGame target, String senjata) { //Method serang() dari karakter game di musuh
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan " + senjata + "!");
        target.setKesehatan(target.getKesehatan() - 15);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

// Kelas utama
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama Pahlawan: ");
        String namaPahlawan = input.nextLine();

        System.out.print("Masukkan senjata atau skill Pahlawan: ");
        String senjataPahlawan = input.nextLine();

        System.out.print("Masukkan nama Musuh: ");
        String namaMusuh = input.nextLine();

        System.out.print("Masukkan senjata atau skill Musuh: ");
        String senjataMusuh = input.nextLine();

        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan pahlawan = new Pahlawan(namaPahlawan, 150);
        Musuh musuh = new Musuh(namaMusuh, 200);

        // Menampilkan status awal
        System.out.println("\nStatus Awal:");
        System.out.println(pahlawan.getNama() + " memiliki kesehatan: " + pahlawan.getKesehatan());
        System.out.println(musuh.getNama() + " memiliki kesehatan: " + musuh.getKesehatan());

        // Simulasi pertarungan
        System.out.println("\nPertarungan Dimulai:");
        pahlawan.serang(musuh, senjataPahlawan);
        musuh.serang(pahlawan, senjataMusuh);

        input.close();
    }
}
