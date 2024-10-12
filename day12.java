// 2406 - Divide Intervals Into Minimum Number of Groups
// Approach 1
class Solution {
    public int minGroups(int[][] intervals) {
        //we will solve using the linesweep algorithm
        //first take all the intervals and match them with start time with 1 and end time with -1
        int events[][]= new int[intervals.length*2][2];
        //this is just an index
        int index=0;
        for(int i[]:intervals){
            events[index][0]=i[0];
            events[index][1]=1;
            index++;
            //this was done to avoid the overlapping problem
            //if we +1 to all the end points we will avoid any overlap 
            events[index][0]=i[1]+1;
            events[index][1]=-1;
            index++;
        }
        //now sort according to times but if the time is same sort according to the -1 1 values
        Arrays.sort(events,(a,b)->a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int max=1,prev=0;
        for(int event[]:events){
            prev+=event[1];
            //the max intersection at a point is the answer as per hint 2
            max=Math.max(max,prev);
        }
        return max;
    }
}
//Approach 2 using min heap
class Solution {
    public int minGroups(int[][] intervals) {
        // Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to store the end times of the groups
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            // If the earliest ending group is free (current interval starts after or when it ends)
            if (!heap.isEmpty() && heap.peek() < interval[0]) {
                heap.poll();  // Remove the group that has ended
            }
            // Assign this interval to a group (either reuse or new group)
            heap.add(interval[1]);  // Add the current interval's end time
        }

        // The size of the heap represents the minimum number of groups needed
        return heap.size();
    }
}
