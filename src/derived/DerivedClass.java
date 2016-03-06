package derived;

import base.BaseClass;


public class DerivedClass extends BaseClass{
	
	public int val = 10;
	
	public void passByValue(DerivedClass dc){
		System.out.println(dc);
		dc.val = 20;
		System.out.println("Inside Pass by Value" + dc.val);
	}
	public static void main(String[] args){
		DerivedClass d = new DerivedClass();
		DerivedClass dc = new DerivedClass();
		d.passByValue(dc);
		System.out.println(dc);
		System.out.println("Inside Main" +  dc.val);
		
		
	}
}
