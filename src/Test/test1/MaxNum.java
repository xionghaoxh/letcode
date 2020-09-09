package Test.test1;

/**
 * 给定一串非负数的数 ，组合成最大的整数；
 */
public class MaxNum {
    public static void main(String[] args) {
     int [] nums = new int[]{6,4,2,3,67};
        int maxNum = getMaxNum(nums);
        System.out.println(maxNum);
    }
    //得到两个数比较的大小 然后组合
    public static boolean getMergeAndMax(int x,int y) {
          StringBuffer sb1 = new StringBuffer();
          StringBuffer sb2 = new StringBuffer();
          //a,b  就是两个数不同组合
          sb1.append(x).append(y);
          sb2.append(y).append(x);
          //组合后又转化为 整数
          int m1 = Integer.parseInt(String.valueOf(sb1));
          int m2 = Integer.parseInt(String.valueOf(sb2));
          if(m1<m2){
              return true;
          }else {
              return false;
          }
    }

    public static int getMaxNum (int num[]){
        int temp;
        int length = num.length;
        while(length!=0){
            for(int i=1;i<length;i++){
                if(getMergeAndMax(num[i-1],num[i])){
                    temp=num[i-1];
                    num[i-1]=num[i];
                    num[i]=temp;
                }
            }
            length--;
        }
        //打印排序过后的顺序（检测）
      for(int i=0;i<num.length;i++){
          System.out.println(num[i]);
      }
      //拼接
        StringBuffer sb= new StringBuffer();
        for(int i=0;i<num.length;i++){
            sb.append(num[i]);
        }
        System.out.println(sb);
        //转化为数字
        int max = Integer.parseInt(String.valueOf(sb));
        return max;
    }

}
