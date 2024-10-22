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
 
 /* 2583 - Kth Largest Sum in a Binary tree
    basically traverse the tree in bfs order and for each level we will calculate sum
    keep the sum in a priority queue and maintain a size of k
    the answer is the top most element
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        //dequeue since we have first and last both operations
        Deque<TreeNode> q1=new LinkedList<TreeNode>();
        //to maintain the kth largest element
        PriorityQueue<Long> pq=new PriorityQueue<>();
        //the sum on each level
        long sum=0;
        //populate the queue with its first element
        q1.add(root);
        while(!q1.isEmpty()){
            sum=0;
            //we fix the sum since we dont want it to dynamically change while we add a node's children
            int levelSize = q1.size();
            for (int i=0;i<levelSize;i++){
                //pop the current
                TreeNode curr=q1.pollFirst();
                //add it to the sum
                sum+=curr.val;
                //if it has left right, add them
                if(curr.left!=null){
                    q1.addLast(curr.left);
                }
                if(curr.right!=null){
                    q1.addLast(curr.right);
                }
            }
            //populate the queue
            pq.add(sum);
            //if the priority queue has more then k elements , remove them
            if(pq.size()>k){
                pq.poll();
            }
        }
        //if the priority queue has less then k levels that means its the tree has less than k levels
        return pq.size()<k?-1:pq.poll();
    }
}
