// Jai Ganesh
class Solution {

    void solve(int target, List<Integer> currentElements, int[] candidates, List<List<Integer>> ans, int index) {
        // while target is > 0 at every recursion step we have choice to include any element and move on

        if(target == 0) {
            ans.add(new ArrayList<>(currentElements));
            return;
        }

        for(int ind = index; ind < candidates.length; ind++) {
            if(target > 0 && target >= candidates[ind]) {
                int updatedTarget = target - candidates[ind];
                currentElements.add(candidates[ind]);
                solve(updatedTarget, currentElements, candidates, ans, ind);
                currentElements.removeLast();
            }
            else if(target < candidates[ind]) {
                break;
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