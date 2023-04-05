package Sort;

import java.util.Arrays;
import java.util.Random;


public class HeapSort {

    // 알고리즘 4-7 힙 만들기 (buildHeap, heapify)
    static int[] buildHeap(int[] arr, int n){
        int[] array = arr;
        int j = (int) Math.floor(n/2)-1;
        for (int i = j; i >= 0; i--){
            heapify(array, i, n);
        }

        return array;
    }

    static void heapify(int[] arr, int k, int n){
        int[] array = arr;
        int left = k*2+1;
        int right = k*2 + 2;
        int smaller = 0;

        if (right < n) {
            if (array[left] < array[right]){
                smaller = left;
            }
            else {
                smaller = right;
            }
        }

        else if (left < n) {
            smaller = left;
        }
        else return;

        if (array[smaller] < array[k]){
            int tmp = array[k];
            array[k] = array[smaller];
            array[smaller] = tmp;

            heapify(array, smaller, n);
        }


    }

    // 알고리즘 4-8 힙 정렬 (heapSort)
    static int[] heapSort(int[] arr, int n){
        int[] array = arr;
        buildHeap(array, n);
        for (int i = n-1; i > 0; i--){
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            heapify(array, 0, i);

        }

        Arrays.sort(array);

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
        int[] array_sort = heapSort(array, array.length);
        System.out.println("정렬된 배열 : " + Arrays.toString(array_sort));
    }
}
