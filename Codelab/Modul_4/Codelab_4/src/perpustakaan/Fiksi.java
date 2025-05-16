package perpustakaan;

public class Fiksi extends Buku {
    public Fiksi(String Judul, String Penulis, String Genre){
        super(Judul, Penulis, Genre);
    }

    @Override
    public void displayinfo(){
        System.out.println("Buku fiksi : " + Judul + " oleh " + Penulis + " " + Genre + ".");
    }
}
