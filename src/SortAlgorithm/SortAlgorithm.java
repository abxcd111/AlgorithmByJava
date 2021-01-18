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

    public void SelectSort(int[] array){

    }

    public void SortTest(){
        int[] array = new int[] {4,7,3,7,3,6,3,7,4,6,6,8,2,3,4,5,8,9,4,6,3,7,8,1};
//        BubbleSort(array);
        InsertSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(" " + array[i]);
        }
    }
}
