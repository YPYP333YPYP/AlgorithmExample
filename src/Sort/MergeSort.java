package Sort;

import java.util.Arrays;
import java.util.Random;


// 알고리즘 4-4 병합 정렬
public class MergeSort {

    static int[] mergeSort(int[] arr, int p, int r){
        int [] array = arr;

        if (p < r) {
            int q = (p+r) / 2;
            mergeSort(array,p,q);
            mergeSort(array,q+1,r);
            merge(array, p,q,r);
        }

        return array;
    }

    static int[] merge(int[] arr, int p, int q, int r){

        int[] tmp = new int[arr.length+1];
        int[] array = arr;

        int i = p; int j= q+1; int t = 1;

        while(i <= q && j <= r){
            if(array[i] <= array[j]){
                tmp[t] = array[i];
                t++; i++;
            }
            else{
                tmp[t] = array[j];
                t++; j++;
            }
        }

        while(i<= q){
            tmp[t] = array[i];
            t++; i++;
        }

        while(j<=r){
            tmp[t] = array[j];
            t++; j++;
        }

        i = p; t=1;
        while(i <= r){
            array[i] = tmp[t];
            i++; t++;
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
        int[] array_sort = mergeSort(array,0, array.length-1);
        System.out.println("정렬된 배열 : " + Arrays.toString(array_sort));



    }
}
