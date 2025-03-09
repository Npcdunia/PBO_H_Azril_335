import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nama,gender;
        char kelamin;
        int tahun;
        Scanner objInput = new Scanner(System.in);

        System.out.print("Masukkan Nama : ");
        nama = objInput.nextLine();

        System.out.print("Masukkan Jenis Kelamin (P/L) : ");
        kelamin = objInput.next().charAt(0);

        System.out.print("Masukkan tahun lahir : ");
        tahun = objInput.nextInt();

        int year = LocalDate.now().getYear();
        int umur = year - tahun;

        if (kelamin == 'L' || kelamin == 'l'){
            gender = "Laki - Laki";
        }else if (kelamin == 'P' || kelamin == 'p'){
            gender = "Perempuan";
        }else{
            gender = "Kelamin tidak valid";
        }


        System.out.println("Data Diri :");
        System.out.println("Nama\t\t\t: " + nama);
        System.out.println("Jenis Kelamin\t: " + gender);
        System.out.println("Umur\t\t\t: " + umur + " Tahun");
        }
    }


