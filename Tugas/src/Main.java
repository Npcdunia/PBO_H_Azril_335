import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class User {
    private String nama;
    private String nim;

    public User(String nama,String nim){
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void login(String inputNama, String inputNim) {

    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
    }

    void tampilkanWaktuLogin() {
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Waktu login: " + waktu.format(format));
    }
}

class Admin extends User {
    String username = "Admin335";
    String password = "Password335";

    public  Admin (){
        super("Admin335","00335" );
    }

    public void login(String user, String pass) {
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Admin berhasil!");
            displayInfo();
            tampilkanWaktuLogin();
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    public void displayInfo() {
        System.out.println("Nama : " + getNama());
        System.out.println("NIM  : " + getNim());
    }

    public void tampilkanWaktuLogin() {
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Waktu login : " + waktu.format(format));
    }
}

class Mahasiswa extends User {

    public Mahasiswa (){
        super("MOCH SYAIFUL AZRIL","202410370110335");
    }

    public void login(String inputNama, String inputNim) {
        if (inputNama.equalsIgnoreCase(getNama()) && inputNim.equals(getNim())) {
            System.out.println("Login Mahasiswa berhasil!");
            displayInfo();
            tampilkanWaktuLogin();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

   public void displayInfo() {
        System.out.println("Nama : " + getNama());
        System.out.println("NIM  : " + getNim());
    }

    public void tampilkanWaktuLogin() {
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Waktu login : " + waktu.format(format));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("Pilih login:");
        System.out.println("1. Admin\n2. Mahasiswa");
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
        }
        scanner.close();
    }
}
