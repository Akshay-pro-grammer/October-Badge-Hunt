//962 - Maximum Width Ramp
class Solution {
    public int maxWidthRamp(int[] nums) {
        // preprocessing data
        // Decreasing monotonic stack
        //max[] array stores the maximum values encountered from right to left in the nums[] array
        int max[] = new int[nums.length];
        int maxi = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > maxi) {
                maxi = nums[i];
            }
            max[i] = maxi;
        }
        // System.out.println(Arrays.toString(max));
        //this is a variable sliding window approach
        //this is out result , max value of width to be stored here
        int rampWidth = 0;
        //left pointer ,this will only increase if the next maximum vaue is lesser then the left pointer
        //because if the left value is lesser than the right max , it will defy the given condition
        
        //so until we have greater or equal then the left pointer , we will count it
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while(nums[left]>max[right]){
            //skip to the next element as this was the max possible length of the ramp with the current left pointer
            //because of the max monotonic array , we were able to say 
            // that if there is exist a value lesser then left pointer
            //then all the elemnts on the right of max array are lesser then the left pointer
            //because of decreasing monotonic array 
                left++;
            }
            //check if the previous ramp width is greater then the current
            rampWidth = Math.max(rampWidth, right - left);
        }
        return rampWidth;
    }

}
