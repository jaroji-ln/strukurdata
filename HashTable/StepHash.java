/**
 * Kelas StepHash
 * <p>
 * Implementasi sederhana dari struktur data hash table menggunakan array.
 * Teknik "step hashing" digunakan untuk menangani kolisi.
 * </p>
 */
public class StepHash {
    
    /**
     * Array untuk menyimpan data.
     */
    private int[] table;

    /**
     * Langkah atau interval untuk menangani kolisi.
     */
    private int step = 1;

    /**
     * Konstruktor StepHash
     * @param size Ukuran dari array hash table
     */
    public StepHash(int size) {
        table = new int[size];
    }

    /**
     * Metode untuk menyisipkan nilai ke dalam hash table.
     * @param value Nilai yang akan disisipkan
     */
    public void insert(int value) {
        int index = value % table.length; // Hitung indeks awal
        // Cari slot kosong jika terjadi kolisi
        while (table[index] != 0) {
            System.out.println("Terjadi collition pada key: "+ index);
            index = (index + step) % table.length; // Gunakan langkah untuk mencari slot kosong
            System.out.println("Index di geser ke: "+index);
        }
        table[index] = value; // Sisipkan nilai
        System.out.println("Data dimasukan ke dalam index : "+index);
    }

    /**
     * Metode untuk mencari nilai dalam hash table.
     * @param value Nilai yang akan dicari
     * @return Indeks dari nilai yang dicari, atau -1 jika tidak ditemukan
     */
    public int search(int value) {
        int index = value % table.length; // Hitung indeks awal
        // Cari nilai yang sesuai
        while (table[index] != 0) {
            if (table[index] == value) {
                return index; // Kembalikan indeks jika ditemukan
            }
            index = (index + step) % table.length; // Gunakan langkah untuk mencari lebih lanjut
        }
        return -1; // Tidak ditemukan
    }

    /**
     * Metode main untuk demonstrasi.
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        // Inisialisasi Step Hash dengan ukuran array 10
        StepHash stepHash = new StepHash(10);

        // Menyisipkan beberapa nilai
        stepHash.insert(9);
        stepHash.insert(9);
        stepHash.insert(8);
        stepHash.insert(50);

        // Mencari nilai
        System.out.println("Hasil pencarian nilai 9 di Index: " + stepHash.search(9));  // Harusnya mengembalikan 9
        System.out.println("Hasil pencarian nilai 50 di Index: " + stepHash.search(50));  // Harusnya mengembalikan 50
        System.out.println("Hasil pencarian nilai 8 di Index: " + stepHash.search(8));  // Harusnya mengembalikan 100

        // Mencari nilai yang tidak ada
        System.out.println("Hasil pencarian nilai 200 di Index: " + stepHash.search(200));  // Harusnya mengembalikan -1 (tidak ditemukan)
    }
}
