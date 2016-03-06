package sort;

public class MergeSort{


	public void sort(int[] values) {
		
		if(values == null) System.out.println("Input values is null");
		
		mergeSort(values, 0, values.length-1);
	}
	
	private void mergeSort(int[] input, int low, int high){
		if(low < high){
			int mid = (low + high)/2;
			mergeSort(input, low, mid);
			mergeSort(input, mid+1, high);
			merge(input, low, mid, high);
		}
	}
	
	private void merge(int[] input, int low, int mid, int high){
		
		int [] leftSubArray = new int[mid-low+1];
		int [] rightSubArray = new int[high-mid];

		for(int i=low,j=0; i <= mid; i++,j++){
			leftSubArray[j] = input[i];
		}

		for(int i= mid+1,j=0;i <= high; i++,j++){
			rightSubArray[j] = input[i];
		}

		int i=0,j=0, k=low;
		while( i < leftSubArray.length && j < rightSubArray.length){
			if(leftSubArray[i] < rightSubArray[j]){
				input[k] = leftSubArray[i];
				i++;
			}
			else{
				input[k] = rightSubArray[j];
				j++;
			}
			k++;
		}

		while(i< leftSubArray.length){
			input[k] = leftSubArray[i];
			i++;
			k++;
		}

		while(j< rightSubArray.length){
			input[k] = rightSubArray[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args){
		int[] values = new int[]{2,2,1};
		MergeSort ms = new MergeSort();
		ms.sort(values);
		System.out.println("SORTED ARRAY: ");
		for(int i=0;i< values.length;i++){
			
			System.out.println(values[i]);
		}
	}
}
