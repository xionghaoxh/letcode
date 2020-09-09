package Test.test2;

import java.io.UnsupportedEncodingException;

/**
 * 字符串比较单元
 * 这里标注所在部门+姓名
 * @author qdy
 *
 */
public class StrCompare {

	public static void main(String[] args) throws Exception {
		String str1="a";
		String str2="b";
		boolean sure=compare(str1,str2);
		
		String str3="a";
		String str4="a";
		boolean sure1=compare(str3,str4);
		
		String str5="a";
		String str6="A";
		boolean sure2=compare(str5,str6);
		
//		String str7=null;
//		String str8="A";
//		boolean sure3=compare(str7,str8);

//		String str9=null;
//		String str10=null;
//		boolean sure4=compare(str9,str10);
			
        System.out.println("字符串比较:"+str1+"/"+str2+":"+sure);
		System.out.println("字符串比较:"+str1+"/"+str2+":"+sure1);
		System.out.println("字符串比较:"+str1+"/"+str2+":"+sure2);
		//System.out.println("字符串比较:"+str1+"/"+str2+":"+sure3);

	}

	/**
	 * 字符串比较函数
	 * 如果stri1等于str2，返回true;不相等返回false;
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @return
	 */
	public static boolean compare(String str1,String str2) throws Exception {
		//TODO 在这里实际字段串的比较
		//比较的时候，要统一编码
		if(str1==null||str2==null){
			throw new Exception("传入的字符串为空：不可以比较哦");
		}
		str1 = new String(str1.getBytes("ISO-8859-1"),"UTF-8");
		str2 = new String(str2.getBytes("ISO-8859-1"),"UTF-8");
		return str1.equals(str2);
	}
}
