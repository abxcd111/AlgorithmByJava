package SwordToOffer;

public class Que13_RobotsRangeOfMotion {
    int count = 0;

    public int movingCount(int m, int n, int k) {
        int[][] array = new int[m][n];
        int i = 0, j = 0;

        dfs(array, i, j, k);
        return count;
    }

    void dfs(int[][] array, int i, int j, int k){
        //判断机器人是否越界，或当前格子是否已经被计数过
        if(i < 0 || j < 0 || i >= array.length || j >= array[0].length || array[i][j] == 1
            || array[i][j] == -1)
            return ;
        //判断是否小于k
        if((countSum(i) + countSum(j)) <= k){
            count++;
            array[i][j] = 1;
            System.out.println(i + ' ' + j + '\n');
        }else{
            array[i][j] = -1;
            return;
        }

        dfs(array, i+1, j,    k);
        dfs(array, i,   j+1,  k);
        dfs(array, i-1, j,    k);
        dfs(array, i,   j-1,  k);
    }

    int countSum(int num){
        int res = 0;
        while(num != 0){
            res += num%10;
            num /= 10;
        }

        return res;
    }

    public static void main(String[] args) {

        Que13_RobotsRangeOfMotion s = new Que13_RobotsRangeOfMotion();
        int count = s.movingCount(16,8,4);

        System.out.println(count);
    }

}
