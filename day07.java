//2696 - Minimum String Length After Removing Substrings
//Approach 1 Stack Data Structure
class Solution {
    public int minLength(String s) {
      //Create a stack of char type
        Stack<Character> stk= new Stack<Character>();
      //constraint says even a string of length 1 is also there
        if(s.length()==1) return 1;
        for(int i=0;i<s.length();i++){
          //if the stack has A and next char in string is B just pop the A 
            if(!stk.isEmpty() && stk.peek()=='A' && s.charAt(i)=='B'){
                stk.pop();
              //continue to ignore the char in string
                continue;
            }
            if(!stk.isEmpty() && stk.peek()=='C' && s.charAt(i)=='D'){
                stk.pop();
                continue;
            }
          //lastly fill the stack
            stk.push(s.charAt(i));
        }
      //the number of stack elements is the answer
        return stk.size();
    }
}
