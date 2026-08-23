// Jai Ganesh
// Jai Ganesh
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a)-> a[1])
                                         .thenComparingInt(a -> a[0]));
        int lastInd = 0;
        int minCount = 0;
        
        for(int ind = 1; ind < intervals.length; ind++) {
            if(intervals[ind][0] < intervals[lastInd][1]) {
                minCount++;
            }
            else {
                lastInd = ind;
            }
        }

        return minCount;
    
    }
}