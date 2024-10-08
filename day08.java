//1962 Minimum number of swaps to make the string balanced

//the logic here is simple , we will count the number of brackets which are not balanced 
//and also ignore the brackets which are balanced since it has asked minimum number of swaps 
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
        return (hasOpen+1)/2;
    }
}
