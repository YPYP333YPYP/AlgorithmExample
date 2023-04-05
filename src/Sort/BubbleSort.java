package Sort;

import java.util.Arrays;
import java.util.Random;

// 알고리즘 4-2 버블 정렬
public class BubbleSort {

    public static int[] bubbleSort(int[] arr, int n){
        int[] array = arr;
        int last = n - 1;


        for (int i = last; i > 2; i--){

            for ( int j = 0; j <= last -1; j++){
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;

                }
            }
            System.out.println("배열의 상태 : " + Arrays.toString(array));
        }

        return array;

    }

    public static int[] bubbleSort_opt(int[] arr, int n) {
        int[] array = arr;
        int last = n - 1;


        for (int i = last; i > 2; i--) {
            boolean sorted = true;
            for (int j = 0; j <= last - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    sorted = false;
                }
            }
            if (sorted == true) {
                return array;
            }
        }
        return array;
    }

    public static int[] makeArray(int count){
        int arr[] = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++){
            arr[i] = random.nextInt(50) + 1;
            for (int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    i--;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args){
        int[] array = makeArray(20);
        System.out.println("정렬전 배열 : " + Arrays.toString(array));

        int[] array_sort = bubbleSort(array,array.length);
        int[] array_sort_opt = bubbleSort_opt(array,array.length);

        System.out.println("정렬된 배열 : " + Arrays.toString(array_sort));


    }
}
