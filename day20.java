//1106 - parsing a boolean expression
/*i was able to come up with an approach but it was hard to implement
so i had to watch videos on this question , it may be simple but it cleared my recurion */
//Approach 1
class Solution {
    boolean helper(int[] arr,String s){
        //we took the first character which is the operator or t f
        char c=s.charAt(arr[0]);
        //we increment by 1 because we already took the operator
        arr[0]++;
        //the base case if t return true
        if (c=='t'){
            return true;
        }
        //if f return false
        if(c=='f'){
            return false;
        }
        //if the operator is not then 
        if(c=='!'){
            //out pointer was at an opening bracket so we skipped it first
            arr[0]++;
            //then from current index calculate again as it may be nested
            // not the answer
            boolean ans= ! helper(arr,s);
            //skip the closing bracket
            arr[0]++;
            return ans;
        }
        //if we encounter & or |
        //we know the characters to be evaluated is comma separated
        //we will create a list and store the answer of childs
        List<Boolean> l1= new ArrayList<Boolean>();
        //increment to skip the opening bracket
        arr[0]++;
        //while its not closing
        while(s.charAt(arr[0])!=')'){
            //if its not a comma evaluate it and add it to the list
            if(s.charAt(arr[0])!=','){
                l1.add(helper(arr,s));
            }else{
                //if a comma then skip
                arr[0]++;
            }
        }
        //skip the closing brackets
        arr[0]++;
        //we cant take random values, we will take the first value 
        //the logic is :- "a or a = a" 
        //      similarly "a and a = a" 
        boolean ans=l1.get(0);
        if(c=='&'){
            for(boolean i:l1){
                ans &=i;
            }
        }
        if(c=='|'){
            for(boolean i:l1){
                ans |=i;
            }
        }
        return ans;
    }
    public boolean parseBoolExpr(String expression) {
        //we want the count to persist so we will make an array of size 1 and keep incrementing it
        //this way the index value will persist among the recursive calls
        int arr[]= new int[1];
        return helper(arr,expression);
    }
}
