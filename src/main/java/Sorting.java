import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {

        int[] arr = {3, 1, 5, 2, 9, 7};

        System.out.println(Arrays.toString(bublSort(arr)));
        System.out.println(Arrays.toString(selectSort(arr)));

    }

    public static int[] bublSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {

                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }

            }
        }
        return arr;
    }

    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int max_index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    max_index = j;
                }
            }
            if (max_index != i) {
                int temp = arr[i];
                arr[i] = arr[max_index];
                arr[max_index] = temp;
            }
        }
        return arr;
    }

}
