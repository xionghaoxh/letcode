package letcode;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class findContinuousSequence {
    //譬如说如果有两个连续的数之和等于target，那么相差为1，
    // (target - 1) % 2 == 0， 且数组一定是从 (target - 1) / 2开始的，数组的元素就是2个；
    // 如果是3个连续的数组，那么三个数之间相差为1、2，(target - 1 - 2) % 3 == 0，
    // 且数组一定是从 (target - 1 - 2) / 3开始的，
    // 数组元素是3个，依次类推，但是注意target必须是大于0的数，且res需要倒序。
    public static void main(String[] args) {
        List<int[]> continuousSequence = findContinuousSequence_01(15);
        System.out.println(continuousSequence.size());
        for (int[] a : continuousSequence) {
            System.out.println("");
            for (int n : a) {
                System.out.print(n);
            }
        }
    }

    public static List<int[]> findContinuousSequence_01(int target) {
        List<int[]> list = new ArrayList<>();
        int i = 1;
        while (target > 0) {
            target -= i++;
            if (target > 0 && target % i == 0) {
                int[] temp = new int[i];
                for (int j = 0; j < i; j++) {
                    temp[j] = target / i + j;
                }
                list.add(temp);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
