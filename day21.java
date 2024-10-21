//1593 - Split a string into the max number of unique substrings
//we will solve this using backtracking 
//because the constraints are only 16 and 2^16 is 65536 which is ok
//in this approach we will take a part of string and put the rest into the recursion
class Solution {
    int helper(HashSet<String> store,String s,int index){
        //if we reach the last index , return 0 as we were not able to make a string
        if(index==s.length()){
            return 0;
        }
        //this is the result
        int res=0;
        // from index 1 to length of string
        //the reason we start from 1 is because we dont want empty strings in our set
        //substring(0,0) will give us empty string , which is invalid
        for(int i=index+1;i<=s.length();i++){
            //make a substrinf from the index we passed in recursion to the index of the loop
            String sub=s.substring(index,i);
            //if it is already present in set skip it
            if(store.contains(sub)){
                continue;
            }
            //backtracking
            store.add(sub);
            //we send the remaining string to recusion through index
            //maximize the result
            res=Math.max(res,1+helper(store,s,i));
            store.remove(sub);
        }
    return res;
    }
    public int maxUniqueSplit(String s) {
        //create a hashset for O(1) removal and retrival
        HashSet<String> store=new HashSet<>();
        return helper(store,s,0);
    }
}
