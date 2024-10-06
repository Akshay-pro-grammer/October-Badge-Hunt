//1331 - Rank Transform
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //create a copy of array since we dont want to mess up the order of orignal
        int copy[]=Arrays.copyOf(arr, arr.length);
      //sort the copy
        Arrays.sort(copy);
      //a hashmap to store the rank
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count=1;
        for(int i=0;i<copy.length;i++){
          //if the rank is assigned then no need to assign
            if(map.containsKey(copy[i])){
                continue;
            }
                map.put(copy[i],count++);
        }
      //put the rank in original array to save space
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}
