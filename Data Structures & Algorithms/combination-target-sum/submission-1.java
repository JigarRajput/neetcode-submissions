// Jai Ganesh
class Solution {

    void solve(int target, List<Integer> currentElements, int[] candidates, List<List<Integer>> ans, Set<List<Integer>> seen, int index) {
        // while target is > 0 at every recursion step we have choice to include any element and move on

        if(target == 0) {
            if(!seen.contains(currentElements)) {
                ans.add(currentElements);
                seen.add(currentElements);
            }
        }

        for(int ind = index; ind < candidates.length; ind++) {
            if(target > 0) {
                int updatedTarget = target - candidates[ind];
                List<Integer> elements = new ArrayList<>();
                elements.addAll(currentElements);
                elements.add(candidates[ind]);
                solve(updatedTarget, elements, candidates, ans, seen, ind);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentElements = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        Arrays.sort(candidates);

        solve(target, currentElements, candidates, ans, seen, 0);

        return ans;
    }
}