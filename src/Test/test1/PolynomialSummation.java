package Test.test1;
//多项式求和
//计算1-1/2+1/3-1/4+...+1/99-1/100
public class PolynomialSummation {
    public static void main(String[] args) {
        double sum = getSum(100);
        System.out.println(sum);
    }
    public static double getSum(int k ) {
        double sum=0;
        for(int i=1;i<k;i++){
            if(i%2!=0){
                sum+=1/((double)i);
            }else{
                sum-=1/((double)i);
            }
        }
       return sum;
    }
}
