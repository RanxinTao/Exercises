package DFS_base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsII {
	public List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] charArray = set.toCharArray();
		Arrays.sort(charArray);
		helper(charArray, 0, res, new StringBuilder());
		return res;
	}

	private void helper(char[] set, int index, List<String> res, StringBuilder curSb) {
		if (index == set.length) {
			res.add(curSb.toString());
			return;
		} else {
			curSb.append(set[index]);
			helper(set, index + 1, res, curSb);
			curSb.deleteCharAt(curSb.length() - 1);
			// skip all the consecutive and duplicate elements.
			while (index + 1 < set.length && set[index] == set[index + 1]) {
				index++;
			}
			helper(set, index + 1, res, curSb);	
		}
	}
}
