
public class PrimeNumbers {
	public static void main(String[] args) {
		int n = 100;
		for(int i=3;i<n;i++){
			int count = 0;
			for(int k=2;k*k<=i;k++){
				if(i%k == 0)
					count++;
			}
			if(count == 0)
				System.out.print(i+" ");
				
		}
	}
}
