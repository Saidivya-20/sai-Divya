import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Main {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }

    // Print tree in level order including nulls
    public void printLevelOrderWithNulls(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add("null");
            }
        }

        // Remove trailing "null" for cleaner output (optional)
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Main sol = new Main();

        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = sol.sortedArrayToBST(nums1);
        System.out.print("BST1: ");
        sol.printLevelOrderWithNulls(root1);
        // Output example: [0, -10, 5, null, -3, null, 9]

        int[] nums2 = {1, 3};
        TreeNode root2 = sol.sortedArrayToBST(nums2);
        System.out.print("BST2: ");
        sol.printLevelOrderWithNulls(root2);
        // Output example: [3, 1]
    }
}