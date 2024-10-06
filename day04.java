//2491 Divide into teams of equal skill
// the approach was pretty simple as it can be done using greedy
class Solution {
    public long dividePlayers(int[] skill) {
      //nlogn sort
        Arrays.sort(skill);
      //the lower player gets matched with higher
        int target=skill[0]+skill[skill.length-1];
        int start=0,end=skill.length-1;
        long result=0;
      //same as above
        while(start<end){
            if(!(skill[start]+skill[end]==target))
            {
                return -1;
            }
            else{
                result+= skill[start]*skill[end];
            }
            start++;
            end--;
        }
        return result;
    }
}
