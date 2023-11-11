/**
 * Kelas yang menyediakan metode untuk mengurutkan array menggunakan algoritma Selection Sort.
 */
public class SelectionSort {

    /**
     * Metode untuk mengurutkan array integer dalam urutan menurun menggunakan algoritma Selection Sort.
     *
     * @param array Array of integers yang akan diurutkan.
     * @return Array yang sudah diurutkan dalam urutan menurun.
     */
    public static int[] selectionSort(int[] array) {
        int ukuran = array.length; // Mendapatkan ukuran array

        // Melakukan iterasi selama masih ada elemen yang belum diurutkan
        while (ukuran > 0) {
            int max = 0; // Mengasumsikan elemen pertama (index 0) adalah yang terbesar

            // Mencari elemen terbesar dalam subarray yang belum diurutkan
            for (int i = 1; i < ukuran; i++) {
                if (array[max] < array[i]) {
                    max = i; // Menemukan elemen baru yang lebih besar
                }
            }

            // Menukar elemen terbesar dengan elemen di akhir subarray yang belum diurutkan
            int temp = array[max];
            array[max] = array[ukuran - 1];
            array[ukuran - 1] = temp;

            // Mengurangi ukuran subarray yang belum diurutkan karena elemen terbesar sudah di tempat yang tepat
            ukuran--;
        }
        return array; // Mengembalikan array yang sudah diurutkan
    }

    /**
     * Metode utama yang menjalankan program.
     */
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90}; // Array yang akan diurutkan
        int[] sortedArray = selectionSort(array); // Memanggil metode selec untuk mengurutkan array

        // Mencetak array yang sudah diurutkan dalam urutan menurun
        System.out.println("Sorted array in descending order:");
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}
