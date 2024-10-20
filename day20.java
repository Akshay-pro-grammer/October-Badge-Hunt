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
//Approach 2
//using stack non recursive
class Solution {
    public boolean parseBoolExpr(String expression) {
        //we will create a stack of characters
        Stack<Character> s1=new Stack<>();
        //convert the string to a character array
        char array[]=expression.toCharArray();
        //for each characters in array
        for(char ch:array){
            //if we encounter a comma or an opening parenthesis we skip it
            if(ch==',' || ch=='('){
                continue;
            }
            //push the stack if tf&|! is the current char
            if(ch=='t' || ch=='f' || ch=='&' || ch=='|' || ch=='!'){
                s1.push(ch);
            }
            //if we encounter a closing bracket we know we have to know check the stacak and empty it until an operator shows up
            else if(ch==')'){
                //we will keep a check if the sequence popping out from stack has false or true
                boolean hastrue=false,hasfalse=false;
                //until the operetor comes
                while(s1.peek()!='!' && s1.peek()!='&' && s1.peek()!='|'){
                    //get the top and update the variables
                    char top=s1.pop();
                    if(top=='t') hastrue=true;
                    if(top=='f') hasfalse=true;
                }
                //now the stack top has operator
                //we will check it and act accordingly to the operator
                char operator=s1.pop();
                // logic :- if we have even one true or one false , we can determine the answers of logical or and not
                //if we have and as operator and we have a false , the whole answer will be false
                //similarly if we have a or and we encounter one true then whole equation becomes true
                // not is unary and it requries only to check if it has true or not
                if(operator =='!'){
                    s1.push(hastrue?'f':'t');
                }else if(operator=='&'){
                    s1.push(hasfalse?'f':'t');
                }else if (operator=='|'){
                    s1.push(hastrue?'t':'f');
                }
            }
        }
        // the answer remains at the top
        return s1.peek()=='f'?false:true;
    }
}
