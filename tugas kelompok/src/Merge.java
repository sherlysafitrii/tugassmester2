public class Merge {
    private static void printarray(int[] arr){
        System.out.println("MERGE SORT");
        System.out.println("SEBELUM");
        for(int val:arr){
            System.out.print(val + " ");
        }
        //memanggil fungsi mergeSort dengan parameter array
        mergeSort(arr,"asc");
        System.out.println("\nHasil Ascending");
        for(int valu:arr){
                System.out.print(valu+" ");
        }


        mergeSort(arr,"des");
        System.out.println("\nHasil Descending");
        for(int valu:arr){
                System.out.print(valu+" ");
        }
    }

    private static void mergeSort(int[] arr,String asc) {

        // untuk cek apakah data sudah satuan 
        if (arr == null || arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right;

        // cek apakah panjang array genap atau ganjil untuk menentukan panjang array sisi kanan
        if(arr.length % 2 == 0){
            right = new int[mid];
        }
        else{
            right = new int[mid + 1];
        }

        // memisahkan nilai pada array
        int i = 0;
        int j = 0;
        for(;i < arr.length;i++){
            // mengisi sisi kanan
            if(i < mid){
                left[i] = arr[i];
            }
            //mengisi sisi kiri
            else{
                right[j] = arr[i];
                j++;
            }
        }

        //fungsi recursive sisi kiri dan sisi kanan sampai terpecah menjadi 1 / 1
        mergeSort(left,asc);
        mergeSort(right,asc);

        merge(left, right, arr,asc);

    }

    private static void merge(int[] left, int[] right, int[] arr,String asc) {
        int i = 0, j = 0, k = 0;

        if(asc.equals("asc")){
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
        }else{
            while (i < left.length && j < right.length) {
                if (left[i] >= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        //mengisi array bagian kanan
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }


    }

    public static void main(String[] args) {
        int[] arr = {
            38,43,63,24,15,86,37,65
        };
        // memanggil fungsi printarray dengan parameter array
        printarray(arr);
    }

}