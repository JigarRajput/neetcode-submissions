// Jai Ganesh
class Solution {

    void solve(int target, List<Integer> currentElements, int[] candidates, List<List<Integer>> ans, int index) {
        // while target is > 0 at every recursion step we have choice to include any element and move on

        if(target == 0) {
            ans.add(currentElements);
        }

        for(int ind = index; ind < candidates.length; ind++) {
            if(target > 0) {
                int updatedTarget = target - candidates[ind];
                List<Integer> elements = new ArrayList<>();
                elements.addAll(currentElements);
                elements.add(candidates[ind]);
                solve(updatedTarget, elements, candidates, ans, ind);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentElements = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        solve(target, currentElements, candidates, ans, 0);

        return ans;
    }
}