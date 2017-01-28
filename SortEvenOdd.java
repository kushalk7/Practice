import java.util.Arrays;
import java.util.Comparator;

public class SortEvenOdd {
	public static void main(String[] args) {
		Integer[] array = {23,4,5,1,15,26,34,62,32,6,76,84,36,78};
		Arrays.sort(array,new Comparator<Integer>() {
			public int compare(Integer a,Integer b) {
				if(((a+b)&1) == 0){	// Both a & b are even or odd	
						return a.compareTo(b);
				}else {
					if((a&1) == 0) { // a = even
						return -1;
					}else
						return 1;
				}
			}
		});
		
		System.out.println(Arrays.toString(array));
	}
	
}
