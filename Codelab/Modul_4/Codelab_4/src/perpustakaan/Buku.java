package perpustakaan;

public abstract class Buku {
    protected String Judul;
    protected String Penulis;
    protected String Genre;

    public Buku(String Judul, String Penulis, String Genre){
        this.Judul = Judul;
        this.Penulis = Penulis;
        this.Genre = Genre;
    }

    public abstract void displayinfo();
}
