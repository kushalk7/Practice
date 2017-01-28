import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class WordCount {
	public static void main(String[] args) {
		String str = "This is a test is of the game where the game is a test";
		HashMap<String,Integer> map = new HashMap<>();
		Scanner s = new Scanner(str);
		String t;
		while(s.hasNext()) {
			t = s.next();
			if(map.containsKey(t)){
				map.put(t, map.get(t)+1);
			}else {
				map.put(t,1);
			}
		}
		
		System.out.println(Arrays.toString(map.entrySet().toArray()));
	}
}
