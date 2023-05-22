public class heap {
    private static void heapSort(int[] arr, String order) {
        int n = arr.length;

        // membuat max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // memindahkan elemen satu per satu dari heap
        for (int i = n - 1; i >= 0; i--) {
            // Memindahkan akar saat ini ke akhir
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Memanggil fungsi max heapify pada heap yang dikurangi
            heapify(arr, i, 0);
        }

        // jika descending
        if (order.equals("descending")) {
            for (int i = 0; i < n / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[n - i - 1];
                arr[n - i - 1] = temp;
            }
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Inisialisasi largest sebagai root
        int l = 2 * i + 1; // kiri = 2*i + 1
        int r = 2 * i + 2; // kanan = 2*i + 2

        // Jika left child lebih besar dari root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Jika right child lebih besar dari largest sejauh ini
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Jika largest bukan root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Memanggil heapify rekursif pada subtree yang terpengaruh
            heapify(arr, n, largest);
        }
    }

    // Fungsi untuk mengurutkan array secara ascending
    public static void ascending(int[] arr) {
        heapSort(arr, "ascending");
        System.out.print("Array setelah diurutkan ascending:");
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    // Fungsi untuk mengurutkan array secara descending
    public static void descending(int[] arr) {
        heapSort(arr, "descending");
        System.out.print("Array setelah diurutkan descending:");

        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    // Contoh penggunaan
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("HEAP SORT");
        System.out.print("Array sebelum diurutkan:");
        for (int item : arr) {
            System.out.print(item + " ");
        }

        System.out.println();
        ascending(arr);

        System.out.println();
        descending(arr);
    }
}