//567 - permutation in string
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
      //sort the first string lexicographically
        char[] charArray = s1.toCharArray();
        Arrays.sort(charArray); 
      //its not possible if the string to be permuted is longer then the second
        if(n>m){
            return false;
        }
      //take the substring of length equal as of sorted string
        for(int i=0;i<=m-n;i++){
            String sub=s2.substring(i,i+n);

            char[] sorted=sub.toCharArray();
          //sort the substring
            Arrays.sort(sorted);
          //check if they are equal
            if(Arrays.equals(sorted,charArray)) return true;
        }
        return false;
    }
}
