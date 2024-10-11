// 1942 - The Number of the Smallest Unoccupied Chair
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        //beacuse constraints says we have distinct arrival times so no need to use hashmap
        int friendArrival=times[targetFriend][0];
        //now custom sort the array order by arrival time
        Arrays.sort(times,(a,b)->Integer.compare(a[0],b[0]));
        //to get the minimum seats present 
        PriorityQueue<Integer> seats= new PriorityQueue<Integer>();
        //we know we only need max seats == number of people
        for(int i=0;i<times.length;i++){
            seats.add(i);
        }
        //format - gone time , seat alloted
        PriorityQueue<int[]> occupied= new PriorityQueue<int[]>((a,b)->Integer.compare(a[0],b[0]));
        //for each person coming
        for(int[] time:times){
            int arrival=time[0];
            int leaving=time[1];
            //if seats are occupied and and if people have left or about to go from the party
            //we remove them first
            while(!occupied.isEmpty() && occupied.peek()[0]<=arrival){
                int free[]=occupied.poll();
                seats.add(free[1]);
            }
            //did the friend arrive?
            if(arrival==friendArrival){
                return seats.poll();
            }
            //add the person who came
            occupied.add(new int[]{leaving, seats.poll()});
        }
        //this is unreachable case
        return -1;
    }
}
