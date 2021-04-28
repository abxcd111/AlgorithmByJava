package SwordToOffer;

import static java.lang.Math.pow;

public class Que17_printNumbers {
    public int[] printNumbers(int n) {
        int upperBound = (int)Math.pow(10,n);
        int[] res = new int[upperBound-1];
        for(int i = 1; i < upperBound; i++){
            res[i-1] = i;
        }
        return res;

    }
}
