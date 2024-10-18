//2044 Count Number of Maximum Bitwise-OR subsets
//APPROACH 1
// we will use backtracking here bruteforce
//WHY DID BRUTEFOCE WORKED? The constraint says the array length is 16 and backtracking solution is 2powerN
//the concept is to go through each subset 
// when we reach the leaf node we will know have successfully reached the subset
//if its value is equal to max or, just count it
//but since java has no refrencing so we will pass an aray of size 1
//the value will persist through the calls
class Solution {
    //index for traversing and curr is current or
    //max or is the thing we calculated earlier its fixed
    //res is the answer array , we need this to persist
    //nums is the array we will traverse through , fixed
    void dfs(int index,int curr,int max,int[] res,int []nums){
        //if we reached the leaf node we know the subset is complete
        if(index == nums.length){
            //if the value is equal to the max then we count it
            if(curr== max){
                res[0]++;
            }
            return;
        }
        //when we take subsets we know that we will either skip the current or not skip
        //skip
        dfs(index+1,curr,max,res,nums);
        //not skip
        dfs(index+1,curr | nums[index],max,res,nums);
    }
    public int countMaxOrSubsets(int[] nums) {
        //calculate the max or
        int max_or=0;
        for(int i:nums){
            max_or |=i;
        }
        //answer array
        int res[]={0};
        //function call
        dfs(0,0,max_or,res,nums);
        //return the answer
        return res[0];
    }
}
