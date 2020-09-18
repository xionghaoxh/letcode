package letcode;

import java.lang.management.MonitorInfo;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 */
public class TwoSum {
    public static void main(String[] args) {
        int []xh = new int[]{1,3,5,7,9};
        int []xh1= new int[]{1,5,3,7,9};
        int[] ints = twoSum(xh, 6);
        int[] ints1 = twoSum_1(xh1, 6);
        for(int num: ints){
            System.out.println(num);
       }
        for(int num: ints1){
            System.out.println(num);
        }
    }
    //有序  ，先使用二分法查找target的位置，然后 再用双指针。
    public static int[] twoSum(int[] nums, int target) {//双指针+二分
        int left=0;
        int right=getMiddle(nums,target);
        while(left<=right){
            if(nums[left]+nums[right]<target){
                left++;
            }else if(nums[left]+nums[right]>target){
                right--;
            }else{
                return new int[]{nums[left],nums[right]};
            }
        }
       return new int[0];
    }
    public static int getMiddle(int[] nums, int target){//二分查找
        int left =0;//左边位置
        int  right=nums.length-1;//右边位置
        int middle = 0;			//定义middle中间位置
        while(left<=right){
            middle = (left + right) / 2;
            if(nums[middle]>target){
                right=middle-1;
            }else if(nums[middle]<target){
                left=middle+1;
            }else{
                return middle;
            }

        }
       return middle;
    }
    //无序，找出数组中的两个数，并等于给定值；
    public static int[] twoSum_1(int[] nums, int target){
        int index=0;
        HashMap<Integer,Integer> map = new HashMap();
        //储存结果
        int [] xh = new int[2];
        for(int num:nums){
            map.put(num,index++);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
             int value=entry.getKey();//我们在上面把值当为key存储了
             if(map.containsKey(target-value)){
                xh[0]=value;
                xh[1]=target-value;
             }
        }
        return xh;
    }
}
