// 1590- Make sum divisible by p
class Solution {
    public int minSubarray(int[] nums, int p) {
      //a hashmap to stor the previous sum
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
      //for a two pointer approach 
        map.put(0,-1);
        int sum=0;
      //add all the numbers into sum but upto the remainder limit so that the sum does not becomes a big amount
        for(int i=0;i<nums.length;i++){
            sum=(sum+nums[i])%p;
        }

        int target=sum%p;
      //if the target is zero that means the sum is divisible by p
        if (target == 0) {
            return 0;
        }
        int length=nums.length;
        int curr=0;
      //cumulative sum starts
        for(int j=0;j<nums.length;j++){
          //find the current sum and modulo together
            curr=(curr+nums[j])%p;
          //find remainder  again modulo and negative check
            int rem=(curr-target+p)%p;
          //was this sum found anywhere? if yes find the length
            if(map.containsKey(rem)){
                length=Math.min(length,j-map.get(rem));
            }
          //update the map with the current sum and index
            map.put(curr,j);
        }
        return length==nums.length?-1:length;
    }
}
