import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {

            int parentVal = d[0];
            int childVal = d[1];
            int isLeft = d[2];

            TreeNode parent = map.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = map.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            map.put(parentVal, parent);
            map.put(childVal, child);

            children.add(childVal);
        }

        // root is the one who is never a child
        TreeNode root = null;

        for (int key : map.keySet()) {
            if (!children.contains(key)) {
                root = map.get(key);
                break;
            }
        }

        return root;
    }
}
