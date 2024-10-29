//2684 - Maximum number of moves in a grid
//i understood this problem after reading it a couple of times
//the concept of memorization is used here
class Solution {
    //class variables to use them
    //i used it like this because i didnt want to carry them in my dfs and make it bigger 
    //i learnd this new trick to make them class variables instead
    int m;
    int n;
    //these are the diretion of rows 
    //in column , we are always doing a +1 but in rows we are first doing -1 then 0 then 1
    // so for each element we will do this 
    static int directions[]={-1,0,1};
    public int dfs(int r,int c,int [][]grid,int [][]memoize){
        //if you already have calculated the answer just return
        if(memoize[r][c]!=0){
            return memoize[r][c];
        }
        //moves for this element
        int moves=0;
        for (int i:directions){
            //new rows and cols
            int newRows=r+i;
            int newCols=c+1;
            //this is the validation part , the indices must be within range and 
            //the stritcly greater then validation
            if(newRows>=0 && newRows<m && newCols>=0 && newCols<n && grid[newRows][newCols]>grid[r][c]){
                //if you got a moves greater then current update and return
                moves=Math.max(moves,1+dfs(newRows,newCols,grid,memoize));
            }
        }
        //store and return
        return memoize[r][c]=moves;
    }
    public int maxMoves(int[][] grid) {
        //row length and col length
        m=grid.length;
        n=grid[0].length;
        int result=0;
        //the memorization
        int memoize[][]=new int[m][n];
        //in the first column vertical
        for(int i=0;i<m;i++){
            //find the answer and update if the value obtained is greater than max
            result=Math.max(result,dfs(i,0,grid,memoize));
        }
        //return the result
        return result;
    }
}
