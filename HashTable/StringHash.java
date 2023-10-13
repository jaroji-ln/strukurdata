import java.util.LinkedList;

/**
 * Kelas StringHash
 * <p>
 * Implementasi sederhana dari struktur data hash table untuk menyimpan string.
 * Teknik "Separate Chaining" digunakan untuk menangani kolisi.
 * </p>
 */
public class StringHash {
    
    /**
     * Array dari LinkedList untuk menyimpan data.
     */
    private LinkedList<String>[] table;

    /**
     * Konstruktor StringHash
     * @param size Ukuran dari array hash table
     * <p>
     * Menginisialisasi array dan LinkedList di setiap indeks array.
     * </p>
     */
    public StringHash(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    /**
     * Fungsi hash untuk menghitung indeks dari string.
     * @param key String yang akan dihitung indeksnya
     * @return Indeks yang dihasilkan dari fungsi hash
     */
    public int hashFunction(String key) {
        return key.charAt(0) % table.length;
    }

    /**
     * Metode untuk menyisipkan string ke dalam hash table.
     * @param value String yang akan disisipkan
     */
    public void insert(String value) {
        int index = hashFunction(value); // Hitung indeks
        table[index].add(value); // Tambahkan ke LinkedList di indeks tersebut
        System.out.println("Data "+value+" ditambahkan di index: "+index);
    }

    /**
     * Metode untuk mencari string dalam hash table.
     * @param value String yang akan dicari
     * @return Indeks dari LinkedList di mana string tersebut berada
     */
    public int search(String value) {
        int index = hashFunction(value); // Hitung indeks
        return index; // Cek apakah nilai ada di LinkedList di indeks tersebut
    }

    /**
     * Metode main untuk demonstrasi.
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        // String Hash with Separate Chaining
        StringHash stringHash = new StringHash(26); // Membuat objek dengan ukuran 26 (A-Z)
        stringHash.insert("Kucing"); // Menyisipkan string "Kucing"
        stringHash.insert("Ayam"); // Menyisipkan string "Ayam"
        stringHash.insert("Kelinci");// Menyisipkan string "Kelinci"
        System.out.println("String Kelinci ditemukan di index: " + stringHash.search("Kelinci")); // Mencari string "Kelinci"
    }
}
