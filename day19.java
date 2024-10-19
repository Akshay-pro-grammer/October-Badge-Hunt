//1545 Find kth bit in Nth Binary String
//This is a recursive approach
//we know that every string will have a 1 in the middle 
//the left side is built but the right side is built using the left so we dont actually need to calculate right
//instead we can map left to right and build the answer
//its like modified simulated binary search
class Solution {
    public char findKthBit(int n, int k) {
        // Base case: When n = 1, the binary string is "0"
        if (n == 1) return '0';
        
        // Find the length of the current string Sn, which is 2^n - 1
        int length = (1 << n) - 1;
        
        // Find the middle position
        int mid = length / 2 + 1;
        
        // If k is the middle position, return '1'
        if (k == mid) return '1';
        
        // If k is in the first half, find the bit in Sn-1
        if (k < mid) return findKthBit(n - 1, k);
        
        // If k is in the second half, find the bit in Sn-1 and invert it
        return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0';
    }
}
//BruteForce approach
class Solution {
    public static String invert(String s1)
    {
        StringBuilder s=new StringBuilder(s1);
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                s.setCharAt(i,'0');
            }
            else{
                s.setCharAt(i,'1');
            }
        }
        return s.toString();
    }
    public static String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }
    public char findKthBit(int n, int k) {
        String s="0";
        for(int i=0;i<=n;i++)
        {
            s=s+'1'+reverse(invert(s));
        }
        return s.charAt(k-1);
    }
}
