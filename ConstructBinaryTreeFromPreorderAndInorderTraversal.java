package cn.edu.sjtu.zzang;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal cb = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int[] preorder = {1,2,4,3};
		int[] inorder = {2,4,1,3};
		TreeNode root = cb.buildTree(preorder, inorder);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.val);
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        root = builder(preorder, inorder, 0, preorder.length, 0, inorder.length);
        return root;
    }
    
    private TreeNode builder(int[] preorder, int[] inorder, int plo, int phi, int ilo, int ihi) {
    	if (phi - plo == 0 && ihi - ilo == 0)
    		return null;
    	int rv = preorder[plo];
    	int i = ilo;
    	for (; i < ihi; i++) {
    		if (inorder[i] == preorder[plo])
    			break;
    	}
    	TreeNode parent = new TreeNode(rv);
    	parent.left = builder(preorder, inorder, plo + 1, plo + i - ilo + 1, ilo, i);
    	parent.right = builder(preorder, inorder, plo + i - ilo + 1, phi, i + 1, ihi);
    	return parent;
    }
}
