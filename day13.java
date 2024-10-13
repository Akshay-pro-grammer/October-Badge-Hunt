//632 Smallest Range Covering Elements from K lists
//this was the first hard of this month and i got a headache trying to understand the solution
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        //We gotta know whats the k first ,which will be the number of the lists inside the lists
        int k=nums.size();
        //initialize left and right to be the first element we will change it later
        int left=nums.get(0).get(0);
        int right=nums.get(0).get(0);
        //The complex part, initialize a priority queue of array
        //the array has three things:-The Element,List number,index of element in the list
        //a comparator was passed to maintain priority queue order by the 0th index of the array
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->Integer.compare(a[0],b[0]));
        // we need to find the initial values of left and right 
        //this can be done by looping through the elements at index 0 , as all pointers will start from index 0
        for(int i=0;i<k;i++){
            List<Integer> list= nums.get(i);
            int startNum=list.get(0);
            pq.add(new int[]{startNum, i , 0 });
            //updating the left and right
            left=Math.min(left,startNum);
            right=Math.max(right,startNum);
        }
        //this is the result we want to return initially set to left , right
        int res[]=new int[]{left,right};
        while(true){
            //poll out the minimum 
            int min[]=pq.poll();
            //get the details back from priority queue
            int currListElement=min[0];
            int listnum=min[1];
            int index=min[2];
            //get to the next element
            index++;
            //if the index goes out of bound,break
            if(index==nums.get(listnum).size()){
                break;
            }
            ///now we need to add the next value , which is next index to the current value
            int next_value=nums.get(listnum).get(index);
            //add it to the priority queue
            pq.add(new int[]{next_value,listnum,index});
            //update right , the max can change here , we may get a new big value so we check
            right=Math.max(right,next_value);
            //left will be the smallest in the priority queue
            left=pq.peek()[0];
            //we update the result array if we found a smaller range
            if(right-left<res[1]-res[0] ){
                res[0] = left;
                res[1] = right;
            }
        }
        return res;
    }
}
