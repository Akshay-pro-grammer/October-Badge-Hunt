//2938 Separate Black and White Balls
class Solution {
    public long minimumSteps(String s) {
        // we have to return long sum of swaps
        long sum = 0;
        // the approach is to count the number of zeros  and when we find a 1
        //we know thats the minimum number of swaps we have to make for that 1 
        //so we will add it to the sum and we will keep the sum same because 
        //the next 1 also neeeds to be swapped this much and more
        //O(N) time with O(1) space
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                sum += count;
            }
        }
        return sum;
    }
}
