import javax.swing.tree.TreeNode;

class Solution{
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if(root==null && subRoot==null) {
			return true;
		}
		i()
	}
	
	public boolean sameSubtree(TreeNode root, TreeNode subRoot) {
		if(sameSubtree(root.left,subRoot.left) && sameSubtree(root.right,subRoot.right)) {
			return true;
		}
	}
}






import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNodesWithZeroAndOneParents {
    public static List<List<Integer>> findNodesWithZeroAndOneParents(List<int[]> pairs) {
        Map<Integer, List<Integer>> parents = new HashMap<>();
        Map<Integer, List<Integer>> children = new HashMap<>();

        // Populate the dictionaries from the input data
        for (int[] pair : pairs) {
            int parent = pair[0];
            int child = pair[1];

            // Update children
            children.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);

            // Update parents
            parents.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
        }

        List<Integer> individualsWithZeroParents = new ArrayList<>();
        List<Integer> individualsWithOneParent = new ArrayList<>();

        // Find individuals with zero parents
        for (int i = 1; i <= pairs.size(); i++) {
            if (!parents.containsKey(i)) {
                individualsWithZeroParents.add(i);
            }
        }

        // Find individuals with exactly one parent
        for (int i = 1; i <= pairs.size(); i++) {
            if (parents.containsKey(i) && parents.get(i).size() == 1) {
                individualsWithOneParent.add(i);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(individualsWithZeroParents);
        result.add(individualsWithOneParent);

        return result;
    }

    public static void main(String[] args) {
        List<int[]> pairs = List.of(
                new int[]{5, 6}, new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 6}, new int[]{15, 12},
                new int[]{5, 7}, new int[]{4, 5}, new int[]{4, 9}, new int[]{9, 12}, new int[]{30, 16}
        );

        List<List<Integer>> result = findNodesWithZeroAndOneParents(pairs);
        System.out.println(result);
    }
}
