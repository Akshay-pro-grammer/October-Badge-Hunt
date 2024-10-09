//921 - Minimum Add to make parenthesis valid
class Solution {
    public int minAddToMakeValid(String s) {
        int open=0,close=0;
        for(int i =0;i<s.length();i++){
            //count the opening
            if(s.charAt(i)=='('){
                open++;
                //if it has a balanced counterhalf then pop
            }else if(open>0 && s.charAt(i)==')') {
                open--;
            }
                //if it is standalone closing then count
            else{
                close++;
            }
        }
        //return tthe leftover sum
        return open+close;
    }
}
