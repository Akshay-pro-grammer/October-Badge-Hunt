//1497 - Check if Array pairs are divisible by k
class Solution {
    public boolean canArrange(int[] arr, int k) {
      //frequency array
        int[] mp = new int[k];  
      //we find all the remainders and store them in a new arrays
        for (int num : arr) {
          //extra modulo to handle negative values
            int rem = (num % k + k) % k;  
            mp[rem]++;
        }

        if (mp[0] % 2 != 0) {
          //the number of zeroes need to be even because they pair up with each other
            return false;
        }

      //we know the remainders will be from 0 to k-1, we handled the zero case 
      //k/2 because the first half of k pairs with the second half of k
        for (int rem = 1; rem <= k / 2; rem++) {
            int counterHalf = k - rem;
          //they must have same frequency
            if (mp[counterHalf] != mp[rem]) {
                return false;
            }
        }

        return true;
    }
}
