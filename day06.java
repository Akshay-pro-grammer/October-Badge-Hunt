//1813 String Similarity III
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1,s2;
      //conditions to make s1 be of lower length
        if(sentence2.length()<sentence1.length()){
            s2=sentence1.split(" ");
            s1=sentence2.split(" ");
        }else{
            s1=sentence1.split(" ");
            s2=sentence2.split(" ");
        }
        //prefix check
        int left1=0;
        while(left1<s1.length && s1[left1].equals(s2[left1])){
            left1++;
        }
        //suffix check
        int right1=s1.length-1,right2=s2.length-1;
        while(right1>=0 && right2>=0 && s1[right1].equals(s2[right2])){
            right1--;
            right2--;
        }
        //if prefix passed suffix then true, checks for all three cases
        return left1>right1;

    }
}
