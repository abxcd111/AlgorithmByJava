package SwordToOffer;

public class Que04_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        int col = 0;

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;


        while ((row < matrix.length) && (col > -1)){
            if(target > matrix[row][col]){
                row++;
            }
            else if(target < matrix[row][col]){
                col--;
            }else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int matrix[][]= {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};


    }
}
