package DFS_base;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
	public List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		helper(set, 0, res, new StringBuilder());
		return res;
	}

	private void helper(String set, int index, List<String> res, StringBuilder cur) {
		if (index == set.length()) {
			res.add(cur.toString());
			return;
		} else {
			cur.append(set.charAt(index));
			helper(set, index + 1, res, cur);
			cur.deleteCharAt(cur.length() - 1);
			helper(set, index + 1, res, cur);
		}
	}
}
