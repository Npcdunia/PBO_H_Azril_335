class hewan{
    String Nama;
    String Jenis;
    String Suara;

    void tampilkaninfo(){
        System.out.println("Nama = " + Nama);
        System.out.println("Jenis = " + Jenis);
        System.out.println("Suara = " + Suara);
    }
}

public class Main {
    public static void main(String[] args) {
        hewan hewan1 = new hewan();
        hewan hewan2 = new hewan();

        hewan1.Nama = "Kucing";
        hewan1.Jenis = "Mamalia";
        hewan1.Suara = "Nyann~~";

        hewan2.Nama = "Anjing";
        hewan2.Jenis = "Mamalia";
        hewan2.Suara = "Woof-Woof";

        hewan1.tampilkaninfo();
        System.out.println();
        hewan2.tampilkaninfo();
    }
}