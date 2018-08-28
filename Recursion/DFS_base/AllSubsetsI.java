package DFS_base;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
	public List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		helper(set.toCharArray(), 0, res, new StringBuilder());
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
			helper(set, index + 1, res, curSb);
		}
	}
}
