//1962 Minimum number of swaps to make the string balanced

//the logic here is simple , we will count the number of brackets which are not balanced 
//and also ignore the brackets which are balanced since it has asked minimum number of swaps 
//approach 1
class Solution {
    public int minSwaps(String s) {
      //initialize the variable to store the unbalanced
        int hasOpen=0;
        for(int i=0;i<s.length();i++){
          //simulation like stack to ignore the balanced 
            if(s.charAt(i)=='['){
                //check if we have open brackets
                hasOpen++;
            }else if(hasOpen>0){
                //if we have the counter half that is the closing bracket that means it must be balancing the previous open bracket present
              //thats why we remove it
                hasOpen--;
            }
        }
      //now we are left with the unbalanced open brackets
      //now whenver we swap the bracket not only we make it balance it we also cancel 1 more open bracket
      //example ]]][[[[] here if we swap
      //that means at one swap we fix two open brackets 
        //so we will have n/2 swaps but the number is odd so we have to make it even or use Math.ceil()
        return (hasOpen+1)/2;
    }
}
//approach 2
//the opposite of above approach
//we count the max number of closing brackets at a point and the rest is same
class Solution {
    public int minSwaps(String s) {
        int isClosed=0,max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                isClosed++;
                max=Math.max(max,isClosed);
            }else{
                isClosed--;
            }
        }
        return (max+1)/2;
    }
}
