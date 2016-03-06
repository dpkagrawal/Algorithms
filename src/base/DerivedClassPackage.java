package base;

public class DerivedClassPackage extends BaseClass{

	
	public static void main(String[] args){
		DerivedClassPackage d = new DerivedClassPackage();
		 DerivedClassPackage.staticVariable = 2;
		System.out.println("value" + BaseClass.staticVariable);
	}
}
