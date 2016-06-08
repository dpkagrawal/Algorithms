import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.text.html.HTMLDocument.Iterator;


public class Practise implements Comparable<Integer> {

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public static void main(String[] args){
		int b=15;
		ArrayList<Integer> l = new ArrayList<Integer>();
		Collections.sort(l, new Comparator<Integer>() {
			int  a =10;
			@Override
			public int compare(Integer o1, Integer o2) {
				a = 15;
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
		String s ="124";
		System.out.println(Character.digit(s.charAt(0), 11));
		Iterator i = (Iterator) l.iterator();
		i.next();
		
		
		
		
	}
}
