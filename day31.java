//2463 Minimum Total Distance Traveled
//read from editorial because unable to understand
//Another dp hard memoization problem
//we will solev this using sorting and memoization
//the though process is that we have two choices either we assign the robot to current factory
//or we move to the next factory 
class Solution {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        // Flatten factory positions according to their capacities
        //this was done to simplfiy 
        //the number of times the factory can repair it will be present that meany times
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }

        int robotCount = robot.size();
        int factoryCount = factoryPositions.size();
        //our memoization table initially filled with -1
        long[][] memo = new long[robotCount][factoryCount];
        for (long[] row : memo)
            Arrays.fill(row, -1);

        // Recursively calculate minimum total distance with memoization
        return calculateMinDistance(0, 0, robot, factoryPositions, memo);
    }

    private long calculateMinDistance(int robotIdx,int factoryIdx,
            List<Integer> robot,List<Integer> factoryPositions,long[][] memo) {
        // All robots assigned
        if (robotIdx == robot.size())
            return 0;
        // No factories left to assign
        if (factoryIdx == factoryPositions.size())
            return (long) 1e12;
        // Check memo
        if (memo[robotIdx][factoryIdx] != -1)
            return memo[robotIdx][factoryIdx];

        // Option 1: Assign current robot to current factory
        long assign = Math.abs(robot.get(robotIdx) - factoryPositions.get(factoryIdx)) +
                calculateMinDistance(
                        robotIdx + 1,
                        factoryIdx + 1,
                        robot,
                        factoryPositions,
                        memo);

        // Option 2: Skip current factory for the current robot
        long skip = calculateMinDistance(
                robotIdx,
                factoryIdx + 1,
                robot,
                factoryPositions,
                memo);

        // Take the minimum and store in memo
        memo[robotIdx][factoryIdx] = Math.min(assign, skip);
        return memo[robotIdx][factoryIdx];
    }
}
