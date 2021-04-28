package SwordToOffer;

public class Que03_FindRepeatNumbers {
    public int findRepeatNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == nums[nums[i]])
                return nums[i];

            temp = nums[i];
            nums[i] = nums[nums[i]];
            nums[nums[i]] = temp;
        }
        return 0;
    }

}
