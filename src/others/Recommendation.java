package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Recommendation {

	public static List getRecommendations(int currentUserId) {
		List<Integer> recommendations = new ArrayList<Integer>();

		ArrayList<Integer> currentUserPurchases = getPurchasesForUser(currentUserId);

	   // nlogn to sort the array
		Collections.sort(currentUserPurchases);


		Map<Integer, Integer> productCount = new HashMap<Integer, Integer>();
		ArrayList<Integer> friends = getFriendsListForUser(currentUserId);
		//n*n*logn
		for (Integer friendsUserId : friends) {

			for (Integer productId : getPurchasesForUser(friendsUserId)) {

				if (Collections.binarySearch(currentUserPurchases, productId) < 0) {
					if (productCount.containsKey(productId)) {
						productCount.put(productId, productCount.get(productId) + 1);
					} else {
						productCount.put(productId, 1);
					}
				}
			}
		}
		
		// n
		List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(productCount.entrySet());
	    
		//nlogn
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return (-1)*o1.getValue().compareTo(o2.getValue());
            }
        });


        // n
        for(Map.Entry<Integer, Integer> entry: entries){
        	recommendations.add(entry.getKey());
        }

		return recommendations;
	}

	static HashMap<Integer, ArrayList<Integer>> purchasesForUser = new HashMap<Integer, ArrayList<Integer>>();
	static {
		purchasesForUser.put(1, new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		purchasesForUser.put(2, new ArrayList<Integer>(Arrays.asList(3, 4, 4)));
		purchasesForUser.put(3, new ArrayList<Integer>(Arrays.asList(5, 3, 2)));
		purchasesForUser.put(4, new ArrayList<Integer>(Arrays.asList(2)));
	}

	public static ArrayList<Integer> getFriendsListForUser(int id) {
		return new ArrayList<Integer>(Arrays.asList(1, 2, 3));
	}

	public static ArrayList<Integer> getPurchasesForUser(int id) {
		return purchasesForUser.get(id);
	}

	public static void main(String args[]) {
		System.out.println(Recommendation.getRecommendations(0));
	}

}
