//1671 Minimum Number of Removals to Make Mountain Array
//this problem is really hard and to come up with a solution is also very hard
//the problem can be divided into sub problems 
//Longest Common Subsequence
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        //find the longest common subsequence 
        //bruteforce wont work as its 2^N and 2^1000 will take your whole next birth
        //dynamic programming approach using cache
        int lis[]=new int[nums.length];
        //fill with one since the sequence is of length 1 in each
        Arrays.fill(lis,1);
        //start for each element
        for(int i=0;i<nums.length;i++){
            //for each element before the main element
            for(int j=0;j<i;j++){
                //if the main element is greater than the previous then 
                if(nums[i]>nums[j]){
                    //update the cache with max value
                    //now it not only checks its previous element only but all the elements before it
                    //so its n^2
                    lis[i]=Math.max(lis[i],1+lis[j]);
                }
            }
        }
        //same for the longest decreasing sequence
        //dp approach
        int lds[]=new int[nums.length];
        Arrays.fill(lds,1);
        //start from the back and find the longest increasing 
        for(int i=nums.length-1;i>=0;i--){
            //check after main element to the last
            for(int j=i+1;j<nums.length;j++){
                // if the main element is bigger then the rest after it
                //update the array
                if(nums[i]>nums[j]){
                    lds[i]=Math.max(lds[i],1+lds[j]);
                }
            }
        }
        //the res cannot be more than this
        int res=nums.length;
        //to find the array we will use the arrays lds and lis
        for(int i=1;i<nums.length-1;i++){
            //do anything only if there is lis and lds has greater than 1
            if(lis[i]>1 && lds[i]>1)
                //lis will give us the left maximum array we can have in a pivot
                //lds will give us the right maximum array we can have from a pivot 
                //but in both of them we counted the pivot 2 times so will subtract one
                //now this is the max array we can have
                //but we have to return the removals which is length - max array
                //also that to be minimized
                res=Math.min(res,nums.length - (lis[i] + lds[i] - 1));
        }
        return res;
    }
}
