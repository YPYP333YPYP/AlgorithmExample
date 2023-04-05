package Sort;

import java.util.Arrays;
import java.util.Random;

// 알고리즘 4-3 삽입 정렬
public class InsertionSort {
    static int[] insertionSort(int[] arr, int n){

        int[] array = arr;

        for (int i = 1; i < n; i++){
            int loc = i-1 ;
            System.out.println("정렬되어져 있는 인덱스 범위 : " + loc);
            int newItem = array[i];

            while(loc >= 0 && newItem < array[loc]){
                array[loc+1] = array[loc];
                loc--;
            }
            array[loc+1] = newItem;

            System.out.println("배열의 상태 : " + Arrays.toString(array));

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

        int[] array_sort = insertionSort(array,array.length);
        System.out.println("정렬된 배열 : " + Arrays.toString(array_sort));


    }
}
