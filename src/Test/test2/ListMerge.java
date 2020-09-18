package Test.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * List合并函数
 * 这里标注所在部门+姓名
 *
 * @author qdy
 */
public class ListMerge {

    public static void main(String[] args) {

        List<BillsNums> list1 = new ArrayList<BillsNums>();

        BillsNums nums = new BillsNums();
        nums.setClothingid("1001");
        nums.setName("苹果");
        nums.setNums(2);
        nums.setSums(100);
        list1.add(nums);

        BillsNums nums1 = new BillsNums();
        nums1.setClothingid("1001");
        nums1.setName("苹果111");
        nums1.setNums(5);
        nums1.setSums(102);
        //list1.add(nums);//你是想坑我吗  ，都加同一个
        list1.add(nums1);
        List<BillsNums> list2 = merge(list1);

        for (BillsNums nums2 : list2) {
            System.out.println(nums2.getClothingid());
            System.out.println(nums2.getName());
            System.out.println(nums2.getNums());
            System.out.println(nums2.getSums());

        }
    }

    /**
     * 按clothingid进行合并
     * nums，sums相加
     * 返回合并后的集合
     *
     * @param list
     * @return
     */
    public static List<BillsNums> merge(List<BillsNums> list) {
        //TODO 在这里实现代码：将 list 中 clothingid 相等的对象进行合并，name任意取，nums相加；sums相加
        List<BillsNums> newList = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getClothingid().equals(list.get(i + 1).getClothingid())) {
                BillsNums billsNums = mergeNBillsNum(list.get(i), list.get(i + 1));
                newList.add(billsNums);
            }
        }
        return newList;
    }

    public static BillsNums mergeNBillsNum(BillsNums nums, BillsNums nums2) {
        int i = 1;
        BillsNums billsNums = new BillsNums();
        billsNums.setClothingid(nums.getClothingid());
        billsNums.setName("A" + i);
        billsNums.setNums(nums.getNums() + nums2.getNums());
        billsNums.setSums(nums.getSums() + nums2.getSums());
        i++;
        return billsNums;
    }

}
