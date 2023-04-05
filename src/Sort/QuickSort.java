package Sort;

import java.util.Arrays;
import java.util.Random;

// 알고리즘 4-5 퀵 정렬
public class QuickSort {

    static int[] quickSort(int[] arr, int p, int r){

        int[] array = arr;

        if (p < r){
            int q = partition(array, p, r);
            quickSort(array, p,q-1);
            quickSort(array, q+1, r);
        }

        return array;
    }

    // 알고리즘 4-6 분할
    static int partition(int[] arr, int p , int r){
        int[] array = arr;

        int x = array[r];
        int i = p;

        for(int j = p; j < r; j++){

            if(array[j] <= x) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;

                i++;
            }

        }

        int tmp = array[i];
        array[i] = array[r];
        array[r] = tmp;

        return i;
    }

    // 난수 생성 함수
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
        int[] array_sort = quickSort(array,0, array.length-1);
        System.out.println("정렬된 배열 : " + Arrays.toString(array_sort));
    }
}
