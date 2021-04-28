package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

public class Que07_BuildTree {
    private  Map<Integer, Integer> index;

    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }


    }

    public  TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0 ){
            return null;
        }

        index = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            index.put(inorder[i], i);
        }

        return recurseBuildTree(preorder, inorder, 0, preorder.length - 1,
                0, inorder.length - 1);


    }

    public TreeNode recurseBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight,
                                     int inorderLeft, int inorderRight){
        if (preorderLeft > preorderRight){
            return null;
        }

        int preorderRoot = preorder[preorderLeft];
        TreeNode res = new TreeNode(preorderRoot);

        int rootIndexInorder = (int) index.get(preorderRoot);
        int lengthOfLeftTree =  rootIndexInorder - inorderLeft;


        res.left = recurseBuildTree(preorder, inorder, preorderLeft+1,
                preorderLeft+lengthOfLeftTree, inorderLeft,
                rootIndexInorder-1);
        res.right = recurseBuildTree(preorder, inorder, preorderLeft+lengthOfLeftTree+1,
                preorderRight, rootIndexInorder+1, inorderRight);

        return res;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,2,1,7}, inorder = {9,3,1,2,7};
        Que07_BuildTree s = new Que07_BuildTree();

        TreeNode tree = s.buildTree(preorder, inorder);
        System.out.println();
    }
}
