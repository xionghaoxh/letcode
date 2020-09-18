package letcode;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    public static void main(String[] args) {
       int []a = new int []{1,1,1,1,2,2,2,56,7,8,9};
        System.out.println(findRepeatNumber_01(a));
        System.out.println(findRepeatNumber_02(a));
    }
    public static int findRepeatNumber_01(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
       for(int num :nums){
           if(set.contains(num)){
             return num;
           }
           set.add(num);

       }
        return -1;
    }
    public static int findRepeatNumber_02(int[] nums) {
        int start = 0;
        while ( start == nums[start] ) {
            start++;
        }

        int slow = start;
        int fast = start;

        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                return nums[slow];
            }
        }
    }
}
