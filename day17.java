//670 Maximum swap
// this question was very hard 
//the lack of example test cases was also adding up to it
//this approach is a one pass solution 
//The appraoach is we will traverse from  right to left
//we will find the max from the last and store its index if we find a max
// if we do not find a max then we will update the swap i with current i and swap j and max index because these are currently to be swapped
//but since there might be a better place to swap the max we will check ahead
// the indices of max and curr are stored in swapi and swapj
//at last we will swap them and return the integer value
//if there is no swap possible then swap will not happen just directly return the value  
class Solution {
    public int maximumSwap(int num) {
        //to string for O(1) swap
        String nums= String.valueOf(num);
        //char array as its efficient from spliting to string (i tried string way also)
        char arr[]=nums.toCharArray();
        //the requires variables
        //max
        int max=0;
        //max index
        int max_i=-1;
        //the swaping index storage
        int swap_i=-1;
        int swap_j=-1;
        for(int i =arr.length-1;i>=0;i--){
            //ascii value of 0 is 48 so we gotta bring it back to range
            int cur=arr[i]-'0';
            //if max found update the max
            if(cur>max){
                max=cur;
                max_i=i;
            //if max not found update the swapping indices
            }if(cur<max){
                swap_i=i;
                swap_j=max_i;
            }
        }
        //swap them only if swapi is not -1 that means no swap
        if (swap_i != -1) {
            char temp=arr[swap_i];
            arr[swap_i]=arr[swap_j];
            arr[swap_j]=temp;
        }
        //char to string in O(1) and string to int in O(1)
        return Integer.parseInt(new String(arr));

    }
}
