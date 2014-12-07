package cn.edu.sjtu.zzang;

public class ConstructBinaryTreeFromInorderAndPostorder {
	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorder cb = new ConstructBinaryTreeFromInorderAndPostorder();
		int[] inorder = {2,4,1,3};
		int[] postorder = {4,2,3,1};
		TreeNode root = cb.buildTree(inorder, postorder);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.val);
	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        root = builder(inorder, postorder, 0, inorder.length, 0, postorder.length);
        return root;
    }
    
    private TreeNode builder(int[] inorder, int[] postorder, int ilo, int ihi, int plo, int phi) {
    	if (ihi - ilo == 0 && phi - plo == 0)
    		return null;
    	int rv = postorder[phi - 1];
    	int i = ihi - 1;
    	for (; i >= ilo; i--) {
    		if (inorder[i] == rv)
    			break;
    	}
    	TreeNode parent = new TreeNode(rv);
    	parent.left = builder(inorder, postorder, ilo, i, plo, plo + i - ilo);
    	parent.right = builder(inorder, postorder, i + 1, ihi, plo + i - ilo, phi - 1);
    	return parent;
    }
}
