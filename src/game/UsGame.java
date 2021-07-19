package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UsGame {

	static HashMap<String, List<String>> actionMap = new HashMap<>();
	static HashMap<String, List<String>> bpMap = new HashMap<>();

	static {
		List<String> aAction = Arrays.asList(new String[] { "kiss", "wild", "tickle", "bite", "lick" });
		List<String> pAction = Arrays.asList(new String[] { "kiss", "wild", "tickle", "bite", "lick" });
		actionMap.put("a", aAction);
		actionMap.put("p", pAction);
		List<String> aBP = Arrays
				.asList(new String[] { "neck", "v-shape", "back", "ear", "fingers" });
		List<String> pBP = Arrays.asList(new String[] { "neck", "balls", "ear", "fingers" });
		bpMap.put("a", aBP);
		bpMap.put("p", pBP);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter name");
			String s = sc.next();
			if (s.equals("e")) {
				System.out.println("Thanks for playing");
				break;
			}
			Random r = new Random();
			System.out.print(actionMap.get(s).get(r.nextInt(actionMap.get(s).size() - 1)));
			System.out.print(" On ");
			System.out.print(bpMap.get(s).get(r.nextInt(bpMap.get(s).size() - 1)));
			System.out.println();
		}

	}

}
