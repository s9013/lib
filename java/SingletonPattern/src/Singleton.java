/**
 * @author       Jay
 * @time         2015年7月30日
 */
public class Singleton {

	//1.将构造方法私有化，外部不能创建实例
	private Singleton(){
	}
	
	//2.创建类的唯一实例
	private static Singleton instance = new Singleton();
	
	
	//3.提供一个用于获取实例的方法
	public static Singleton getInstance(){
		return instance;
	}
}
