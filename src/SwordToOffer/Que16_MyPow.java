package SwordToOffer;

public class Que16_MyPow {
    public double myPow(double x, int n) {
        double remain = 1;
        long  pow = (long) n;
        int flag = 1;

        if(pow < 0){
            pow = -pow;
            flag = -1;
        }
        if(pow == 0) return 1;
        while(pow > 0) {
            if (pow == 1) break;
            if ((pow & 1)  == 0) {
                pow = pow >> 1;
                x *= x;
            }else {
                pow = pow >> 1;
                remain = remain * x;
                x = x * x;
            }
        }

        if(flag == 1){
            return remain*x;
        } else {
            return 1/(remain*x);
        }
    }

    public static void main(String[] args){
        Que16_MyPow s = new Que16_MyPow();
        double res = s.myPow(2.0000, -2147483648);
        System.out.println(res);
    }
}
