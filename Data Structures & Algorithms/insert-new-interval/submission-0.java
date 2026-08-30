// Jai Ganesh

class Solution {
    static boolean isOverlapping(int s1, int e1, int s2, int e2) {
        if((s1 >= s2 && s1 <= e2) || 
           (e1 >= s2 && e1 <= e2) || 
           (s2 >= s1 && s2 <= e1) ||
           (e2 >= s1 && e2 <= e1)) {
            return true;
        }

        return false;
    }

    static ArrayList<Integer> getMergedInterval(int s1, int e1, int s2, int e2) {
        return new ArrayList<>(List.of(Math.min(s1, s2), Math.max(e1, e2)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean isMerged = false;

        for(int ind = 0; ind < intervals.length; ind++) {

            if(!isMerged) {
                // is overlapping
                if(!isOverlapping(intervals[ind][0], intervals[ind][1], newInterval[0], newInterval[1])) {
                    if(newInterval[0] > intervals[ind][1]) {
                        list.add(new ArrayList<>(List.of(intervals[ind][0], intervals[ind][1])));
                    }
                    else {
                        isMerged = true;
                        list.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));
                        list.add(new ArrayList<>(List.of(intervals[ind][0], intervals[ind][1])));
                    }
                }
                else {
                    ArrayList<Integer> mergedIntervals = getMergedInterval(intervals[ind][0], intervals[ind][1], newInterval[0], newInterval[1]);
                    
                    isMerged = true;
                    list.add(mergedIntervals);
                }
            }
            else {
                // is overlapping
                if(!isOverlapping(intervals[ind][0], 
                    intervals[ind][1], 
                    list.get(list.size()-1).get(0), 
                    list.get(list.size()-1).get(1))
                ) {
                    list.add(new ArrayList<>(List.of(intervals[ind][0], intervals[ind][1])));
                }
                else {
                    ArrayList<Integer> mergedIntervals = getMergedInterval(intervals[ind][0], 
                    intervals[ind][1], 
                    list.get(list.size()-1).get(0), 
                    list.get(list.size()-1).get(1)
                    );

                    list.set((list.size()-1), mergedIntervals);
                }
            }
        }

        if(!isMerged) {
            list.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));
        }

        int[][] merged = new int[list.size()][2];

        for(int ind = 0; ind < list.size(); ind++) {
            merged[ind][0] = list.get(ind).get(0);
            merged[ind][1] = list.get(ind).get(1);
        }

        return merged;
    }
}