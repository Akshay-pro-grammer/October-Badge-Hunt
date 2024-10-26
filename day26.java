//2458 - Height of Binary Tree After Subtree Removal Queries
/*
This problem is a good example of why we should read constraints
a thought process say that we will just for each query do a dfs and calculate the answer but 
if we have a unbalanced tree the time complexity will be O(MN) which will be !0^5 * 10^4 = 10^9 TLE
so in this problem we will preprocess data and try to solve it in linear time O(N)
for that we will be needing some preprocessed data which can be served in O(1) time
-the height for each level, a map or array
-the level of each node, a map or array
-the top height , in this porblem 2 are enough why? beacuse at a time we are removing only 1 element
 and it can be either greater than the max hiehgt or less than , so we only need a 2d array
now alll these can be used to get a height in linear time
the formula is 
    height at a query=level of query top + height from below - 1 ( 2 reasons : we need a zero based height 
    and the hieght from below and the level from top counts a common node which needs to be removed )
*/
class Solution {
    public int findheight(TreeNode curr,int level,int[]node_level,int[]node_height,int[][] top_2){
        //if current is null we return 0
        if(curr==null){
            return 0;
        }
        //find for left of the tree
        int left=findheight(curr.left,level+1,node_level,node_height,top_2);
        //find for right of the tree
        int right=findheight(curr.right,level+1,node_level,node_height,top_2);
        //we just came from 1 height so plus 1 
        int height=1+Math.max(left,right);
        //update the data
        node_level[curr.val]=level;
        node_height[curr.val]=height;
        //priority queue simulation of pair
        if(height > top_2[level][0]){
            top_2[level][1]=top_2[level][0];
            top_2[level][0]=height;
        }else if(height> top_2[level][1]){
            top_2[level][1]=height;
        }
        //return the height
        return height;
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        //this is the maximum possible nodes in the tree given in the constraints
        int n=100001;
        //every node is unique as per the constraints
        //the level of each node
        int node_level[]=new int[n];
        Arrays.fill(node_level,-1);
        //the height of each node from bottom
        int node_height[]=new int[n];
        //the top 2 heights at a given level
        int top_2[][]=new int[n][2];
        //the preprocessing of data to find the above three
        findheight(root,0,node_level,node_height,top_2);
        //this is the reusltant array
        int res[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            //the query
            int query=queries[i];
            //the level of the query in the tree
            int level=node_level[query];
            //the height of the query in the tree
            int height=node_height[query];
            // the maxheight calculated from the top two
            int maxheight= (top_2[level][0] == height) ? top_2[level][1] : top_2[level][0];
            //update res
            res[i]=(maxheight+level-1);
        }
        return res;
    }
}
