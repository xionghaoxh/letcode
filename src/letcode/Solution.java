package letcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //应用桶排序，

//    给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//    示例 1:
//    输入: nums = [1,1,1,2,2,3], k = 2
//    输出: [1,2]
//    示例 2:
//    输入: nums = [1], k = 1
//    输出: [1]

//    提示：
//    你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//    你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
//    题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
//    你可以按任意顺序返回答案。
    public static void main(String[] args) {
        int []arr =new int[]{1,1,1,2,2,3,4,4,5};
        int k=2;
        List<Integer> list = topKFrequent(arr, k);
        System.out.println(list);
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        //重复判断
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        System.out.println(map);
        //建多少个桶；
        List<Integer> [] buchet = new List[nums.length+1];
        //装桶
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            Integer value = e.getValue();
            System.out.println(value);
            //如果为空，就建立一个list
            if(buchet[value]==null){
                buchet[value]=new ArrayList<>();
            }
            System.out.println(buchet[value]);
            System.out.println(e.getKey());
            //一个值的key都装在 buchet[value]这个list 里面；
            buchet[value].add(e.getKey());
            System.out.println( buchet[value]);
            System.out.println("----------");

            //System.out.println( buchet[value]+"几号桶已经装了"+e.getKey());
        }

        //得到前k值频率高的的list
        System.out.println(buchet.length);
        List<Integer>  fristList = new ArrayList<>();
        System.out.println("------"+fristList.size());
        for(int j=buchet.length-1;j>-1&&fristList.size()<k;j--){
            if(buchet[j]!=null){
                fristList.addAll(buchet[j]);
            }
        }
        System.out.println(fristList);
       return fristList;
    }
}
