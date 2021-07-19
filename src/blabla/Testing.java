package blabla;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Testing {

	int uniqueElement(List<StudentMarks> ls) {
		Set<Integer> st = new HashSet<>();
		for (int i = 0; i < ls.size(); i++) {
			if (st.contains(ls.get(i).rollno)) {
				st.remove(ls.get(i).rollno);
			} else {
				st.add(ls.get(i).rollno);
			}
		}
		return st.iterator().next();
	}

	int missingRollno(List<StudentMarks> ls) {
		Map<String, Set<Integer>> subjectRollnomap = new HashMap<>();
		
		for (StudentMarks sm : ls) {
			Set<Integer> rollnos = subjectRollnomap.getOrDefault(sm.subjectName, new HashSet<Integer>());
			rollnos.add(sm.rollno);
			subjectRollnomap.put(sm.subjectName, rollnos);
		}
		
		Set<Set<Integer>> st = (Set<Set<Integer>>) subjectRollnomap.values();
		Iterator<Set<Integer>> sItr = st.iterator();
		
		Set<Integer> r1 = sItr.next();
		Set<Integer> r2 = sItr.next();
		
		for (Integer v : r1) {
			if (!r2.contains(v)) {
				return v;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {

	}

	static class StudentMarks {
		int rollno;
		String subjectName;
		int marks;
	}

}
