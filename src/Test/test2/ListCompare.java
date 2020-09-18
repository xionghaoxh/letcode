package Test.test2;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.ArrayList;
import java.util.List;

/**
 * List比较函数
 * 这里标注所在部门+姓名
 *
 * @author qdy
 */
public class ListCompare {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("苹果手机");
        list1.add("华为手机");
        list1.add("电脑");
        list1.add("苹果");

        List<String> list2 = new ArrayList<String>();
        list2.add("苹果手机");
        list2.add("华为手机");
        list2.add("电脑1");
        list2.add("苹果1");


        boolean sure = find(list1, "苹果");
        System.out.println("sure:" + sure);
        List<String> list = differenceList(list1, list2);
        List<String> list3 = equalList(list1, list2);
        System.out.println(list);
        System.out.println(list3);
    }


    public static boolean find(List<String> list, String str) {
        //TODO 在这里实现:在list查找str是否存在，存在返回true,不存在返回false
        return list.contains(str);
    }

    /**
     * 返回集合差异部分
     * 比较两个集合，把差异部分返回
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List<String> differenceList(List<String> list1, List<String> list2) {
        //TODO 在这里实现代码：返回两个集合差异部分
        //不同部分就是去重，把两个list加到一个新的 lsit ,然后去重
        List<String> list = new ArrayList<>();
        //先把 lsit1 装入list
        for (int i = 0; i < list1.size(); i++) {
            list.add(list1.get(i));
        }
        //在list2 装入list的时候 去重
        for (int i = 0; i < list2.size(); i++) {
            if (!list.contains(list2.get(i))) {
                list.add(list2.get(i));
            } else {
                list.remove(list2.get(i));
            }
        }
        return list;
    }

    /**
     * 返回集合相同部分
     * 比较两个集合，返回相同部分
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List<String> equalList(List<String> list1, List<String> list2) {
        //TODO 在这里实现代码：返回两个集合返回相同部分
        List<String> list = new ArrayList<>();
        //比较两个list的长度
        int length = list1.size() < list2.size() ? list1.size() : list2.size();
        for (int i = 0; i < length; i++) {
            if (list1.get(i) == list2.get(i)) {
                list.add(list1.get(i));
            }
        }
        return list;
    }
}
