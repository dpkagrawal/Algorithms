package string;

public class StringReverse{

public String Reverse(String s){
	
	if(s.length()==1)
		return s;

	else
	{
		String t = s.substring(s.length()-1);
		String t1 = Reverse(s.substring(0,s.length()-1));
		return (t + t1);
	

	}
}

public static void main(String[] args)
{
	StringReverse s = new StringReverse();
	System.out.println(s.Reverse("deep"));
}







}
