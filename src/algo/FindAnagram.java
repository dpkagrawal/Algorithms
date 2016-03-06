package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindAnagram {
	String[] list = { "sad", "das", "sda", "mad", "amd" };
	Map<String, ArrayList<String>> m = null;

	public String getSortedString(String s) {
		char[] arr = s.toLowerCase().toCharArray();
		Arrays.sort(arr);
		return (new String(arr));
	}

	public void calAnagram() {
		m = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < list.length; i++) {
			String t = getSortedString(list[i]);
			if (!m.containsKey(t)) {
				ArrayList<String> a = new ArrayList<String>();
				a.add(list[i]);
				m.put(t, a);
			} else {
				ArrayList<String> a = (ArrayList<String>) m.get(t);
				a.add(list[i]);
			}
		}
	}

	public void display() {
		System.out.println("Anagrams are: ");
		Set<String> s = m.keySet();
		for (Object key : m.keySet()) {
			ArrayList<String> t = (ArrayList<String>) m.get(key);
			for (int i = 0; i < t.size(); i++)
				System.out.print(t.get(i) + "\t");
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		FindAnagram a = new FindAnagram();
		a.calAnagram();
		a.display();
	}
}
