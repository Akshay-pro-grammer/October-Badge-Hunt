//1405 - Longest Happy String
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        //Max heap with a array which stores in the format
        //format := countof character and the character
        PriorityQueue<int[]> pq= new PriorityQueue<int[]>((p,q)->Integer.compare(q[0],p[0]));
        //if the count is > 0 then only add the pair
        if(a>0){
            pq.add(new int[]{a,'a'});
        }
        if(b>0){
            pq.add(new int[]{b,'b'});
        }
        if(c>0){
            pq.add(new int[]{c,'c'});
        }
        //StringBuffer to make the answer
        StringBuffer s1= new StringBuffer();
        //if pq is empty we break
        while(!pq.isEmpty()){
            //get the max frequency character
            int curr[]=pq.poll();
            int count=curr[0];
            char ch=(char)curr[1];
            int len=s1.length();
            //if we have same character in the previos 2 indices we will not put the same again
            //instead we will go for next max
            if(len>=2 && s1.charAt(len-1)==ch && s1.charAt(len-2)==ch){
                if (pq.isEmpty()) {
                    break; // No valid character to use
                }
                //next max
                int next[]=pq.poll();
                int count2=next[0];
                char ch2=(char)next[1];
                //update the answer
                s1.append(ch2);
                //reduce the count
                count2--;
                ///we wont add it back if its count is zero
                if (count2 > 0) {
                    pq.add(new int[]{count2, ch2});
                }
                // add the original back to heap
                pq.add(curr);
            }else {
                //else we use the current character
                s1.append(ch);
                //reduce the count again
                count--;
                //if only count remains we add
                if (count > 0) {
                    pq.add(new int[]{count, ch});
                }
            }
        }
        return s1.toString();
    }
}
