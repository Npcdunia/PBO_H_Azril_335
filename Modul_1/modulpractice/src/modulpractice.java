import java.util.Scanner;

public class modulpractice {
    public static void main(String[]args){
        String firstname;
        int age;
        Scanner objInput = new Scanner(System.in);

        System.out.print("Masukkan nama anda : ");
        firstname = objInput.nextLine();
        System.out.print("Masukkan Umur anda : ");
        age = objInput.nextInt();
    }

}
