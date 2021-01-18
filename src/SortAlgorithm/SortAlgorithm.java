package SortAlgorithm;

public class SortAlgorithm {
    public void BubbleSort(int[] array){//Sort from small to large
        int temp = 0 ;

        for (int i = array.length; i > 1; i--){
            for (int j = 0; j < i-1; j++){// notice the bound j<i-1
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public void InsertSort(int[] array){
        int temp = 0;
        int current = 0;

        for (int i = 1; i < array.length; i++){// notice the situation when two elements are equal in comparison
            if (array[i] >= array[i-1])continue;

            for (int j = 0; j < i; j++){
                if (array[i] <= array[j]){
                    current = j;
                    break;
                }
            }
            temp = array[i];
            for (int j = i  ; j > current; j--){
                array[j] = array[j-1];
            }
            array[current] = temp;
        }
    }

    //归并排序
    public void MergeSort(int[] array){
        MergeSort_t(array, 0, array.length - 1);
    }
    public void MergeSort_t(int[] array, int start, int end){
        if(start == end)return;

        int middle = (start + end)/2;

        MergeSort_t(array, start, middle);
        MergeSort_t(array, middle+1, end);
        Merge(array, start, middle, end);
    }
    public void Merge(int[] array, int start, int middle, int end){
        int length = end - start + 1;
        int[] tempArray = new int[length];
        int left = start, right = middle + 1;

        for (int i = 0; i < length; i++){
            if (left > middle){
                for (int j = i; j < length; j++){
                    tempArray[j] = array[right];
                    right++;
                }
                break;
            }
            if (right > end){
                for (int j = i; j < length; j++){
                    tempArray[j] = array[left];
                    left++;
                }
                break;
            }

            if (array[left] <= array[right]){
                tempArray[i] = array[left];
                left++;
            }else {
                tempArray[i] = array[right];
                right++;
            }
        }

        for (int i = 0; i < length; i++){
            array[start+i] = tempArray[i];
        }
    }

    //快速排序
    public void QuickSort(int[] array){
        QuickSort_t(array, 0, array.length-1);
    }
    public void QuickSort_t(int[] array, int start, int end){//pivot denotes the subscript of partition node
        if (start >= end)return;

        int pivot = Partition(array, start, end);
        QuickSort_t(array, start, pivot - 1 );
        QuickSort_t(array, pivot + 1, end);
    }
    public int Partition(int[] array, int start, int end){
        int i = start;
        int temp = 0;

        for (int j = start; j < end ; j++){
            if(array[j] < array[end]){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i ;
    }


    public void SortTest(){
        int[] array = new int[] {4,7,3,7,3,6,3,7,4,6,6,8,2,3,4,5,8,9,4,6,3,7,8,1};
//        int[] array = new int[] {3,11,6,7,8,7};
//        BubbleSort(array);
//        InsertSort(array);
//        MergeSort(array);
        QuickSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(" " + array[i]);
        }
    }
}
