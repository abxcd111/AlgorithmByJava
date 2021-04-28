package SwordToOffer;

public class Que14_CutRopeRope {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;

        while(n!=0){
            n &= n-1;
            res++ ;
        }
        return res;
    }
    // n & n-1 ：可以消去n最左边的二进制位1
    // 原理：
    //二进制位数-1的话主要就两种情况：
    //(1)最右边为1: n = ……1, n-1 = ……0;与完之后就是……0；
    //(2)最右边不为1：n= ……1……0, n-1 = ……0(0……0)1;与完之后是……0(0……0)1;
    // 只要左边省略号部分还有1，结果就不为0，结果不为0， res+1；
    public static void main(String[] args) {
        Que14_CutRopeRope s = new Que14_CutRopeRope();
        int res = s.hammingWeight(2135);
        System.out.println(res);
    }
}
