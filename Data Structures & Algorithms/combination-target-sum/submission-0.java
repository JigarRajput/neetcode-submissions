// Jai Ganesh
class Solution {

    void solve(int target, List<Integer> currentElements, int[] candidates, List<List<Integer>> ans, Set<List<Integer>> seen) {
        // while target is > 0 at every recursion step we have choice to include any element and move on

        if(target == 0) {
            Collections.sort(currentElements);
            if(!seen.contains(currentElements)) {
                ans.add(currentElements);
                seen.add(currentElements);
            }
        }

        for(int index = 0; index < candidates.length; index++) {
            if(target > 0) {
                int updatedTarget = target - candidates[index];
                List<Integer> elements = new ArrayList<>();
                elements.addAll(currentElements);
                elements.add(candidates[index]);
                solve(updatedTarget, elements, candidates, ans, seen);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentElements = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();

        solve(target, currentElements, candidates, ans, seen);

        return ans;
    }
}