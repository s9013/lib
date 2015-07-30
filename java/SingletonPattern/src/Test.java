/**
 * 单列模式
 * @author 	Jay
 * @time 	2015年7月30日
 */
public class Test {
	public static void main(String[] args) {
		// 方法一
		Singleton s1 =  Singleton.getInstance();
		Singleton s2 =  Singleton.getInstance();
		System.out.println(s1==s2);
		
		// 方法二
		Singleton2 s3 =  Singleton2.getInstance();
		Singleton2 s4 =  Singleton2.getInstance();
		System.out.println(s3==s4);
	}
}
