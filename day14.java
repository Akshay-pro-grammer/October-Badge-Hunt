//2530-Maximal Score After applying K operations
class Solution {
    public long maxKelements(int[] nums, int k) {
        //The reason i have taken everything as long is because i dont want data loss
        // we want a max heap
        //we want to min heap to max using comparator
        PriorityQueue<Long> pq= new PriorityQueue<Long>((a,b)->Long.compare(b,a));
        //add the elements into the max heap
        for(int i:nums){
            pq.add((long)i);
        }
        //iterations
        int i=0;
        //the final score asked in the question
        long sum=0;
        while(i<k){
            //remove the max element
            long el=pq.poll();
            // add it to the score before doing the operation
            sum+=el;
            //add it back to the heap , applying the operation
            //here integer/integer gives an integer value we need to convert it to double first
            //then we will apply the ceil 
            //and then add it to the heap
            pq.add((long)Math.ceil((double)el / 3));
            i++;
        }
        //return sum
        return sum;
    }
}
