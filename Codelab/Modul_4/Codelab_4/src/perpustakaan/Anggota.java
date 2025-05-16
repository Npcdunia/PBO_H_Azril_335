package perpustakaan;

public class Anggota implements Peminjaman{
    String nama;
    String IdAnggota;

    public Anggota (String nama, String IdAnggota){
        this.nama = nama;
        this.IdAnggota = IdAnggota;
    }

    public void displayinfo(){
        System.out.println(nama + IdAnggota);
    }

    @Override
    public void PinjamBuku(String Judul) {
        System.out.println(nama + " meminjam buku berjudul : " + Judul);
    }

    public void PinjamBuku(String Judul, int Durasi){
        System.out.println(nama + " meminjam buku berjudul : " + Judul + " selama " + Durasi + " hari.");
    }

    @Override
    public void KembalikanBuku(String Judul) {
        System.out.println(nama + " mengembalikan buku berjudul : " + Judul );
    }

    public void KembalikanBuku(String Judul, int Durasi){
        System.out.println(nama + " mengembalikan buku berjudul : " + Judul + " " + Durasi + " hari yang lalu.");
    }

    public boolean autentikasi(String inputNama, String inputId) {
        return this.nama.equalsIgnoreCase(inputNama) && this.IdAnggota.equalsIgnoreCase(inputId);
    }
}
