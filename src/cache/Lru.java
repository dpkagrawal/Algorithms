package cache;

import java.util.LinkedHashMap;

/*
 *  Least Recent Used Cache implemented using LinkedHashMap
 *  
 *  LinkedHashMap maintains the order of the insertion. And re=inserting does not affect the order
 *  https://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html
 *  
 */
public class Lru extends LinkedHashMap<Object, Object>{
	private static final long serialVersionUID = 1L;

	int sizeOfCache;
	Lru(int capacity, float loadFactor){
		super(capacity, loadFactor, true);
		this.sizeOfCache=capacity;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<Object,Object> eldest) {
		return size() > this.sizeOfCache;
	};

	public static void main(String args[]){
		Lru lru = new Lru(3, 0.75f);
		lru.put(1, "1");
		lru.put(2, "2");
		lru.put(3, "3");
		lru.get(1); // 1 is recently accessed
		System.out.println(lru);
		lru.put(4, "4"); // 2 will be removed
		System.out.println(lru);
	}
	
}
