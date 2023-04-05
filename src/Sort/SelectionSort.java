package Sort;

import java.util.Arrays;
import java.util.Random;

// 알고리즘 4-1 선택정렬
public class SelectionSort {

    public static int theLargest(int[] arr, int last){
        int max = 1;
        int idx = 0;

        for(int i = 0; i <= last; i++){
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    public static int[] selectionSort(int[] arr, int n){
        int[] array = arr;
        int last = n-1;
        for (int i = last+1; i > 2; i--){
            int maxIdx = theLargest(array, last);
            System.out.println("배열 중 가장 큰 수 : " + array[maxIdx]);
            int tmp = array[last];
            array[last] = array[maxIdx];
            array[maxIdx] = tmp;
            last = last -1;
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

        int[] array_sort = selectionSort(array,array.length);
        System.out.println("정렬된 배열 : " + Arrays.toString(array_sort));
    }
}

