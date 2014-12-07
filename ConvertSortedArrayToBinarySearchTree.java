package cn.edu.sjtu.zzang;

public class ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree cs = new ConvertSortedArrayToBinarySearchTree();
		int[] num = {1,2,3,4,5,6};
		TreeNode root = cs.sortedArrayToBST(num);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.val);
		System.out.println(root.right.left.val);
	}
    public TreeNode sortedArrayToBST(int[] num) {
        TreeNode root = null;
        root = builder(num, 0, num.length - 1);
        return root;
    }
    
    private TreeNode builder(int[] num, int lo, int hi) {
    	if (hi < lo)
    		return null;
    	int mid = (lo + hi) >> 1;
    	TreeNode parent = new TreeNode(num[mid]);
    	parent.left = builder(num, lo, mid - 1);
    	parent.right = builder(num, mid + 1, hi);
    	return parent;
    }
}
