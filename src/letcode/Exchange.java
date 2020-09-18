package letcode;


public class Exchange {
    public static void main(String[] args) {
        int []xh = new int[]{1,2,4,5,7,8};
        int[] exchange = exchange(xh);
        for(int num: exchange){
            System.out.print(num);
        }
    }
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     */
    public static int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            while(nums[left]%2!=0){
                left++;
            }
            while(nums[right]%2==0){
                right--;
            }
            if(left<right){
               int temp =nums [left];
               nums[left]=nums[right];
               nums[right]=temp;
            }
        }
        return nums;
    }
}
