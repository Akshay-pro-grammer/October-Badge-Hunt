/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//951 - Flip Equivalent Binary Trees
/*
we will use recursion 
we are allowed to do any number of flips
so we have four cases:-
    a)left == left
    b)right== right
    c)left == right
    d)right== left
    now the first two cases seems like the werent flipped int eh first place
    4 recusion calls and only one is valid in each true return
*/
class Solution {
    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
        //if the root1 is null the root2 should be mandotarily null
        if(r1==null && r2==null){
            return true;
        }
        //if any one of them is null we return false
        //if both are null it will be already handled by above case
        if(r1==null || r2==null){
            return false;
        }
        //they must be equal 
        if(r1.val==r2.val){
            //the without flip case
            boolean without=flipEquiv(r1.left, r2.left) && flipEquiv(r1.right,r2.right);
            //if they were flipped case
            boolean with=flipEquiv(r1.left, r2.right) && flipEquiv(r1.right,r2.left);
            //return if any of the four case are true or false
            return without || with;
        }
        //if not equal return false directly
        return false;
    }
}
