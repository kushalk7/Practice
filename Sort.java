import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		Sort sort = new Sort();
		int[] set = {23,5,64,66,36,69,6,62,21,67,56,27,87,35,77};
//		sort.SelectionSort(set);
		sort.bubbleSort(set);
//		sort.insertionSort(set);
		System.out.println("Sorted: "+Arrays.toString(set));
	}
	
	public void SelectionSort(int[] a) {
		int min = 0;
		int i;
		for (int j = 0;j<a.length-1;j++) {
			min = j;
			for(i=j+1;i<a.length;i++) {
				if (a[min]> a[i])
					min = i;
			}
			int t = a[min];
			a[min] = a[j];
			a[j] = t;
		}
	}
	
	public void bubbleSort (int[] a) {
		boolean swapped = true;
		for (int i = a.length-1;i>0 && swapped;i--) { // if array gets sorted no swapping will happen so we can stop
			swapped = false;
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					swapped = true;
				}				
			}
		}
	}
	
	public void insertionSort (int[] a) {
		for(int i=1;i<a.length;i++) {
			int j=i; int t = a[i];
			while(j>0 && a[j-1]> t) { // remember a[j-1] > t and not a[j] coz a[j] is overwritten in next line
				a[j] = a[j-1];
				j--;
			}
			a[j] = t;
		}
	}
	
	private static void quicksort(final int[] values) {
	    if (values.length == 0) {
	        return;
	    }
	    quicksort(values, 0, values.length - 1);
	}

	private static void quicksort(final int[] values, final int low, final int high) {
	    int i = low, j = high;
	    int pivot = values[low + (high - low) / 2];
	    while (i <= j) {
	        while (values[i] < pivot) {
	            i++;
	        }
	        while (values[j] > pivot) {
	            j--;
	        }
	        if (i <= j) {
	            swap(values, i, j);
	            i++;
	            j--;
	        }
	    }
	    if (low < j) {
	        quicksort(values, low, j);
	    }
	    if (i < high) {
	        quicksort(values, i, high);
	    }
	}

	private static void swap(final int[] values, final int i, final int j) {
	    final int temp = values[i];
	    values[i] = values[j];
	    values[j] = temp;
	}
}
