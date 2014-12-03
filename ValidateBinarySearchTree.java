package cn.edu.sjtu.zzang;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		ValidateBinarySearchTree vbs = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(1);
		root.left = left;
		System.out.println(vbs.isValidBST(root));
	}

    public boolean isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    
    public boolean isBST(TreeNode node, int min, int max){
        if(node == null){
            return true;
        }
        if(min < node.val && node.val < max){
            return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
        }
        else
            return false;
    }
}
