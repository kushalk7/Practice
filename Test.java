
public class Test {
	
	
	public static void main (String[] args) {
		char[] s = {'m','a','d','a','m'};
		Test t = new Test();
		t.palindrome(s);
//		char[] s = {'W','o','r','l','d'};
//		int j= s.length-1;
//		for(int i=0;i<j;i++,j--) {
//			char t = s[i];
//			s[i] = s[j];
//			s[j] = t;
//		}
//		System.out.println(s);
	}
	
	public void palindrome(char[] s) {
		int j=s.length-1;
		boolean f = false;
		for (int i=0;i<j;i++,j--) {
			if(s[i] == s[j])
				f = true;
			else
				f = false;
		}
		if (f == true)
			System.out.print(s);
			System.out.println(" is Palindrome");
	}
	
}
