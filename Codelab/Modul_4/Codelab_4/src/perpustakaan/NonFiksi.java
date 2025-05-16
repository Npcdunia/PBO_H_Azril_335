package perpustakaan;

public class NonFiksi extends Buku{
    public NonFiksi(String Judul, String Penulis, String Genre){
        super(Judul, Penulis, Genre);
    }

    @Override
    public void displayinfo(){
        System.out.println("Buku Non Fiksi :" + Judul + " oleh " + Penulis + " " + Genre + ".");
    }
}
