/**
 * @author       Jay
 * @time         2015��7��30��
 */
public class Singleton2 {
	
	//1.�����췽��˽�л����ⲿ���ܴ���ʵ��
	private Singleton2(){
	}
	
	// 2.�������Ψһʵ��
	private static Singleton2 instance;
	
	// 3.�ṩһ�����ڻ�ȡʵ���ķ���
	public static Singleton2 getInstance(){
		if(null == instance){
			instance = new Singleton2();
		}
		return instance;
	}
	
}
