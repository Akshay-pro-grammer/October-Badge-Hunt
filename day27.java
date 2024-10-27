//1277 Count square submatrices with all ones
//this porblem we will solve through recursion with memoization
//approach 1 not very efficient
class Solution {
    public int dfs(int r,int c,int rows,int col,int [][]matrix,HashMap<String,Integer> map){
        //if we reach to the end of the matrix or we encouter a zero we skip
        if(r==rows || c==col || matrix[r][c]!=1){
            return 0;
        }
        //we create the unique key since it can be the same
        String key = r + "," + c;
        //if we already have the value , we return
        if (map.containsKey(key)) {
            return map.get(key);
        }
        //else we put the minimum associated with the key
        //1+ because the element of the matrix itself is a box because its not zero
        //the reason we are taking the minimum is beacuse 
        //if we want to know if the matrix forms a box we should know if it can for sub boxes
        //the subboxes itself are entity , and sub sub boxes can be found
        //what i mean is a 3x3 matrix can have 4 2x2 matrix and a 2x2 matrix can have 4 1x1 matrix
        //so we will just take the 1x1 traverse it through the right down and daigonal , like hay
        //if you have any zero then minimum of them is 0 so you dont form a 2x2
        //if the minimum is 1 you form a 2x2
        //now this 2x2 will ask the same hey do you form a 2x2 in the right down and daigonal then you forma  3x3
        //else you dont
        //this approach is hard to come up with 
        map.put(key,1+Math.min(
            //check the down
                dfs(r+1,c,rows,col,matrix,map),
                Math.min(
                    //check the right
                    dfs(r,c+1,rows,col,matrix,map),
                    //check the diagonal
                    dfs(r+1,c+1,rows,col,matrix,map))
                ));
                //return the cached value
        return map.get(key);
    }
    public int countSquares(int[][] matrix) {
        //get the rows and columns 
        int rows=matrix.length;
        int col=matrix[0].length;
        //a map to store the rows so we dont have to do the extra work
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        //this is the answer we will return
        int res=0;
        //for each row
        for(int i=0;i<rows;i++){
            //for each element in col
            for(int j=0;j<col;j++){
                //call the recursion and add it to the answer
                res+=dfs(i,j,rows,col,matrix,map);
            }
        }
        return res;
    }
}
//approach 2 using dynamic proggraming bottom up approach
// we will keep the first row and column same as the original
// we already have the count of 1x1 boxes in the original array we just need to sum it
// we need to find the rest
// so to find it we will start from row 1 and col 1 instead of 0 
//we will take an element an ask him like hey
// what is the minimum value you have up, left and daigonal up , if its 0 then you dont form a 2x2
//else you form a 2x2 and we wil update the value to 2
// we will keep doing this until the element is surroundedd by 2s then it will become a 3x3
// then we will add all the elements
//this approach makes more sense
class Solution {
    public int countSquares(int[][] matrix) {
        int rowSize  = matrix.length;
        int colSize = matrix[0].length;

        for(int i = 1; i < rowSize; i++)
        {
            for(int j = 1; j < colSize; j++)
            {
                //if its 1 then check and add up
                if(matrix[i][j] == 1)
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]));
            }
        }

        int total = 0;
        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                //the answer is the total
                total += matrix[i][j];
            }
        }

        return total;
    }
}
