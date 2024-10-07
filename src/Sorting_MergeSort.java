public class Sorting_MergeSort {
    public static void mergeSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);

    }

    private static void merge(int[] a, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if(left[i]<right[j]){
                a[k]=left[i];
                i++;
                k++;
            }else{
                a[k]=right[j];
                j++;
                k++;
            }
        }
        while (i < left.length) {
            a[k]=left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            a[k]=right[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] array= {9,8,7,6,5,4,3,2,1,0};

        mergeSort(array);
        System.out.print("{");
        for(int i=0; i<array.length; i++){
            if(i<array.length-1){
                System.out.print(array[i]+",");
            }else{
                System.out.print(array[i]);
            }
        }
        System.out.print("}");
    }


}
