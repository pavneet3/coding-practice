package prc.j8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class J8Test {

	public static void main(String[] args) {
		List<String> s = new ArrayList<>();
		s.add("a");
		s.add("b");
		s.add("d");
		s.add("c");
		s.add("a");

//		Map<String, Set<String>> sa = s.stream().collect(Collectors.groupingBy(Function.identity()),
//				Collectors.mapping(Function.identity(), Collectors.toSet()));
//		System.out.println(sa);

	}

}
