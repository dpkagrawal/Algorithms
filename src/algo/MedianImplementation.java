package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
The median of M numbers is defined as the middle number after sorting them in order,
if M is odd or the average number of the middle 2 numbers (again after sorting) if M is even. 
You have an empty number list at first. Then you can add or remove some number from the list.
For each add or remove operation, output the median of numbers in the list.
Example : For a set of m = 5 numbers, { 9, 2, 8, 4, 1 }
 the median is the third number in sorted set { 1, 2, 4, 8, 9 } which is 4.
Similarly for set of m = 4, { 5, 2, 10, 4 }, the median is the average of second
and the third element in the sorted set { 2, 4, 5, 10 } which is (4+5)/2 = 4.5

Input:
The first line is an integer n indicates the number of operations.
Each of the next n lines is either "a x" or "r x" which indicates the operation is add or remove.
Output:
For each operation: If the operation is add output the median after adding x in a single line.
If the operation is remove and the number x is not in the list, output "Wrong!" in a single line.
If the operation is remove and the number x is in the list, output the median after deleting x in a single line. 
(if the result is an integer DO NOT output decimal point. And if the result is a double number , DO NOT output trailing 0s.)
Constraints:
0 < n <= 100,000
for each "a x" or "r x" , x will fit in 32-bit integer.
Sample Input:
7
r 1
a 1
a 2
a 1
r 1
r 2
r 1
Sample Output:
Wrong!
1
1.5
1
1.5
1
Wrong!
Note: As evident from the last line of the input, if after remove operation the list becomes empty you have to print "Wrong!" ( quotes are for clarity ). 
 */


public class MedianImplementation {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int N;

		line = br.readLine();
		N = Integer.parseInt(line);
		
		Median m = new Median(N);

		for (int i = 0; i < N; i++){
			line = br.readLine();
			String[] tokens = line.split(" ");

			if (tokens[0].equals("a")){
				m.add(Integer.parseInt(tokens[1]));
				print(m.getMedian());
			}
			else if (tokens[0].equals("r")){
				boolean flag = m.remove(Integer.parseInt(tokens[1]));
				if (!flag)
					System.out.println("Wrong!");
				else
					if (!m.isEmpty())
						print(m.getMedian());
					else System.out.println("Wrong!");
			}


		}
	}

	private static void print(double median) {
		
		if (Math.ceil(median) != median){
			System.out.format("%.1f%n", median);
		}
		else {
			System.out.println((int)median);
		}
		
	}

	public static class Median {

		PriorityQueue<Integer> minHeap;
		PriorityQueue<Integer> maxHeap;
		double median;

		public Median(int N) {
			minHeap = new PriorityQueue<Integer>(N/2);
			maxHeap = new PriorityQueue<Integer>(N/2, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
		}
		
		public void add (Integer number){
			
			if (number <= median){
				maxHeap.add(number);
			}
			else {
				minHeap.add(number);
			}
			balanceHeaps();
		}
		
		private void balanceHeaps() {
			
			int difference = maxHeap.size() - minHeap.size();
			
			if (Math.abs(difference) <= 1)
				return;
			else if (difference < -1){
				maxHeap.offer(minHeap.poll());
			}
			else if (difference > 1){
				minHeap.offer(maxHeap.poll());
			}
			
		}

		public boolean remove (Integer number) {
			boolean isRemoved;
			if (number == median){
				isRemoved = maxHeap.remove(number);
				if (!isRemoved)
					isRemoved = minHeap.remove(number);
				else return true;
			}
			if (number < median){
				isRemoved = maxHeap.remove(number);
			}
			else {
				isRemoved = minHeap.remove(number);
			}
			if (isRemoved)
				balanceHeaps();
			
			return isRemoved;
		}
		
		public boolean isEmpty(){
			return maxHeap.isEmpty() && minHeap.isEmpty();
		}
		
		public double getMedian (){
			
			if (maxHeap.size() == minHeap.size())
				median = (double)(maxHeap.peek() + minHeap.peek()) / 2;
			else if (maxHeap.size() < minHeap.size())
				median = minHeap.peek();
			else median = maxHeap.peek();
			
			return median;
		}

	}
}