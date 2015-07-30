/**
 * @author       Jay
 * @time         2015��7��30��
 */
public class Singleton {

	//1.�����췽��˽�л����ⲿ���ܴ���ʵ��
	private Singleton(){
	}
	
	//2.�������Ψһʵ��
	private static Singleton instance = new Singleton();
	
	
	//3.�ṩһ�����ڻ�ȡʵ���ķ���
	public static Singleton getInstance(){
		return instance;
	}
}
