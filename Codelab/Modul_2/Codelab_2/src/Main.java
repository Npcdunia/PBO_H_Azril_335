import java.util.Scanner;
//class rekeningbank yang berisi dari atribut dan method untuk mengelola saldo bank
class Rekeningbank{
    String NomorRekening;
    String NamaPemilik;
    double Saldo;

    void tampilkaninfo(){
        System.out.println("Nomor Rekening = " + NomorRekening);
        System.out.println("Nma Pemilik = " + NamaPemilik);
        System.out.println("Saldo = " + Saldo);
    }
    void setoruang(double Setor){
        Saldo += Setor;
        System.out.println(NamaPemilik + " menyetor Rp" + Setor + ". Saldo sekarang : " + Saldo);
    }
    void tarikuang(double Tarik){
        if(Saldo < Tarik) {
            System.out.println(NamaPemilik + " menarik Rp" + Tarik + " (Gagal,saldo tidak mencukupi)." + ". saldo saat ini : " + Saldo);
        }else{
            Saldo -= Tarik;
            System.out.println(NamaPemilik + " menarik Rp" + Tarik + " (Berhasil)" + ". saldo saat ini : " + Saldo);
        }
    }
}

//class main berfungsi untuk menjalankan program utama
public Main {
    public static void main(String[] args) {
        //atribut dari class main
        //rekening1 dan rekening2 merupakan objek rekening dari awal saldo yang dibut dari class rekeningbank
        Rekeningbank rekening1 = new Rekeningbank();
        Rekeningbank rekening2 = new Rekeningbank();
        //atribut ini berfungsi untuk mengambil inputan dari user
        Scanner scanner = new Scanner(System.in);

        //Nilai dari rekening 1
        rekening1.NomorRekening = "202410370110335";
        rekening1.NamaPemilik = "Azril";
        rekening1.Saldo = 600000;

        //Nilai dari rekening 2
        rekening2.NomorRekening = "202410370110361";
        rekening2.NamaPemilik = "Athallah";
        rekening2.Saldo = 700000;

        //perulangan while(true) akan terus berjalan sampai user memasukkan input 4 yaitu pilihan untuk keluar
        while (true) {
            System.out.println("\n==Menu==");
            System.out.println("1. Lihat Saldo.");
            System.out.println("2. Setor Uang.");
            System.out.println("3. Tarik Uang.");
            System.out.println("4. Keluar");
            System.out.print("Pilih (1-4) : ");
            int pilihan = scanner.nextInt();

            if (pilihan == 4){
                System.out.println("Terima kasih telah menggunakan layanan kami.");
                break;
            }

            //switch case berfungsi untuk pemilihan menu sesuai dengan input yang dimasukkan oleh user pengguna
            switch (pilihan){
                case 1 :
                    rekening1.tampilkaninfo();
                    System.out.println();
                    rekening2.tampilkaninfo();
                    break;
                case 2:
                    rekening1.setoruang(200000);
                    rekening2.setoruang(300000);
                    System.out.println();
                    rekening1.tampilkaninfo();
                    System.out.println();
                    rekening2.tampilkaninfo();
                    break;
                case 3:
                    rekening1.tarikuang(100000);
                    rekening2.tarikuang(500000);
                    System.out.println();
                    rekening1.tampilkaninfo();
                    System.out.println();
                    rekening2.tampilkaninfo();
                    break;
                default :
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();    //berfungsi untuk menutup Scanner setelah mebaca Input1

    }
}