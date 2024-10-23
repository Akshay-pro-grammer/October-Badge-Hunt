 //2641 - Cousins in Binary Tree II
//Approach 1
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
/*
we will use bfs two times , O(n) time complexity 
The approach is to first calculate the level sum and store them accordng to their level index
now we have the level sum at each level , now to get the sum of all cousin value in the nodes
we already know that the levelsum(total) = sibling sum(same parent) + cousin sum(different parent)
to get the cousin sum we subtract sibling sum from levelsum
current node val = level sum of that level - sibling sum of that level
thats how we calculate the current node value
*/

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        //first we declare a queue to for bfs
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        //this is the level sum list
        ArrayList<Integer> levelsum=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            //we dont want size to increase dynamically so we stored it
            int size=q.size();
            //the current level sum
            int levelSum=0;
            for(int i=0;i<size;i++){
                //the logic to get the level sum of the bfs
                TreeNode node=q.poll();
                levelSum+=node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            //append the level sum to the list
            levelsum.add(levelSum);
        }
        //bfs 2
        //this time with list of object
        // why? - because we want to store different data types in a list
        Queue<List<Object>> q2= new LinkedList<>();
        //this is the first member of the of the list
        List<Object> l1= new LinkedList<Object>();
        //add the members
        l1.add(root);
        l1.add(root.val);
        q2.add(l1);
        //the level to substract from
        int level=0;
        while(!q2.isEmpty()){
            //same size logic
            int size=q2.size();
            //traverse again level wise
            for(int i=0;i<size;i++){
                //get the element from the queue
                List<Object> l2=q2.poll();
                //the objects  first need to be converted back to their respective datatypes
                TreeNode node=(TreeNode)l2.get(0);
                Integer siblingSum=(Integer)l2.get(1);
                //we update the value using the formula
                node.val=levelsum.get(level)-siblingSum;
                //now , to update the queue we will first calculate the child sum if they exist
                int childSiblingSum= (node.left!=null?node.left.val:0) + (node.right!=null?node.right.val:0);
                //the childSiblingSum in the formula it is called sibling sum
                //this value later will be subtracted to level sum
                if(node.left!=null){
                    List<Object> l3= new LinkedList<Object>();
                    l3.add(node.left);
                    l3.add(childSiblingSum);
                    q2.add(l3);
                }
                if(node.right!=null){
                    List<Object> l4= new LinkedList<Object>();
                    l4.add(node.right);
                    l4.add(childSiblingSum);
                    q2.add(l4);
                }
            }
            //increase the level
            level++;
        }
        //we updated the tree itself , so we return the root
        return root;
    }
}
//approach 2
//2641 - Cousins in Binary Tree II
/*
we will use bfs two times , O(n) time complexity 
The approach is to first calculate the level sum and store them accordng to their level index
now we have the level sum at each level , now to get the sum of all cousin value in the nodes
we already know that the levelsum(total) = sibling sum(same parent) + cousin sum(different parent)
to get the cousin sum we subtract sibling sum from levelsum
current node val = level sum of that level - sibling sum of that level
thats how we calculate the current node value
*/

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        //first we declare a queue to for bfs
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        //this is the level sum list
        ArrayList<Integer> levelsum=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            //we dont want size to increase dynamically so we stored it
            int size=q.size();
            //the current level sum
            int levelSum=0;
            for(int i=0;i<size;i++){
                //the logic to get the level sum of the bfs
                TreeNode node=q.poll();
                levelSum+=node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            //append the level sum to the list
            levelsum.add(levelSum);
        }
        //bfs 2
        //same queue assigned with new queue
        q= new LinkedList<>();
        //this is the first member of the queue
        q.add(root);
        //the root will always be 0
        root.val=0;
        //the level to substract from
        int level=0;
        while(!q.isEmpty()){
            //same size logic
            int size=q.size();
            //traverse again level wise
            for(int i=0;i<size;i++){
                //get the element from the queue
                TreeNode node=q.poll();
                //now , to update the queue we will first calculate the child sibling sum if they exist
                int childSiblingSum= (node.left!=null?node.left.val:0) + (node.right!=null?node.right.val:0);
                //the childSiblingSum in the formula it is called sibling sum
                if(node.left!=null){
                    //we update the value using the formula
                    //value will be subtracted to level sum
                    //we are at the parent level but we have childsibling sum so we need to update the index
                    node.left.val=levelsum.get(level+1)-childSiblingSum;
                    q.add(node.left);
                }
                if(node.right!=null){
                    node.right.val=levelsum.get(level+1)-childSiblingSum;
                    q.add(node.right);
                }
            }
            //increase the level
            level++;
        }
        //we updated the tree itself , so we return the root
        return root;
    }
}
