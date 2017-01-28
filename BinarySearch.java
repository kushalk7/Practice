import java.util.Arrays;

//import java.lang.reflect.Array;

public class BinarySearch {
	  public static void main(String[] args) {
		int[] set = {3,2,5,43,6,3,44,267,24,66,35,67,22};
		
		Arrays.sort(set);
//		System.out.println(new BinarySearch().binarySearchRecursive(set, 0, set.length, 43));
		System.out.println(new BinarySearch().binarySearch(set, 35));
	  }
	  
	  public int binarySearch(int[] a, int s) {
		  int l = 0;
		  int r = a.length-1;
//		  Arrays.sort(a);
		  System.out.println(Arrays.toString(a));
		  while(l<r) {
			  int mid = (l+r)/2;
			  if (s == a[mid])
				  return mid;
			  else if(s < a[mid]) {
				  r = mid - 1;
			  }else if (s > a[mid/2]) {
				  l = mid + 1;
			  }
		  }
		  
		  return -1;
	  }
	  
	  public int binarySearchRecursive(int[] a,int start,int end,int s) {
		  int mid = start+(end - start) / 2;
		  if(a[mid] == s)
			  return mid;
		  else if (s < a[mid]) {
			  return binarySearchRecursive(a, start, mid-1, s);
		  }
		  else {
			  return binarySearchRecursive(a, mid+1, end, s);
		  }
//		  return -1;
	  }
}
