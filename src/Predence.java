import java.util.ArrayList;
import java.util.stream.Collectors;

public class Predence {

	static String findWord(String[] s) {
		ArrayList<String> l = new ArrayList<>();
		for (String v : s) {
			String r[] = v.split(">");
			if (l.contains(r[0]) && l.contains(r[1])) {
				if (Math.abs(l.indexOf(r[0]) - l.indexOf(r[1])) == 1) {
					continue;
				} else {
					
				}
			} else if (l.contains(r[0])) {
				l.add(l.indexOf(r[0]) + 1, r[1]);
			} else if (l.contains(r[1])) {
				l.add(l.indexOf(r[1]) - 1 < 0 ? 0 : l.indexOf(r[1]) - 1, r[0]);
			} else {
				l.add(r[0]);
				l.add(r[1]);
			}
		}
//		System.out.println(l);
		return l.stream().collect(Collectors.joining(""));
	}

	// r,t,g,a,l,p,o
	public static void main(String[] args) {
		System.out.println(findWord(new String[] { "P>E", "E>R", "R>U" }));
		System.out.println(findWord(new String[] { "I>N", "A>I", "P>A", "S>P" }));
		System.out.println(findWord(new String[] { "U>N", "G>A", "R>Y", "H>U", "N>G", "A>R" }));
		System.out.println(findWord(new String[] { "I>F", "W>I", "S>W", "F>T" }));
		System.out.println(findWord(new String[] { "R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G" }));
		System.out.println(
				findWord(new String[] { "W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T" }));
	}

}
