//2501 Longest Square Streak in an Array
//very easy problem just keep on searching for the answer 
class Solution {
    public int longestSquareStreak(int[] nums) {
        //we create a Hashset, this removes the duplicate element 
        //+ we can now check if an element is present or not in O(1) time
        Set<Integer> st = new HashSet<>();
        //for each element
        for (int num : nums) {
            st.add(num);
        }
        //for max length found
        int maxStreak = 0;

        for (int num : nums) {
            //the current length
            int streak = 0;
            //get the number as long
            long curr = num;
            //run while the square is present
            while (st.contains((int) curr)) {

                streak++;
                //break if the number square goes out of constraint
                if (curr * curr > 1e5) {
                    break;
                }

                curr = curr * curr; // square
            }
            //get the max
            maxStreak = Math.max(maxStreak, streak);
        }
        //if less than 2 return -1
        return maxStreak < 2 ? -1 : maxStreak;
    }
}
