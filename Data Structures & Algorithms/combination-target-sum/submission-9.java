// Jai Ganesh
class Solution {

    void solve(int target, List<Integer> currentElements, int[] candidates, List<List<Integer>> ans, int index) {
        // while target is > 0 at every recursion step we have choice to include any element and move on

        if(target == 0) {
            ans.add(new ArrayList<>(currentElements));
            return;
        }

        if(index < candidates.length && target >= candidates[index]) {
            currentElements.add(candidates[index]);
            solve(target - candidates[index], currentElements, candidates, ans, index);
            currentElements.removeLast();
        }
        if(index < candidates.length){
            solve(target, currentElements, candidates, ans, index+1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentElements = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(target, currentElements, candidates, ans, 0);

        return ans;
    }
}