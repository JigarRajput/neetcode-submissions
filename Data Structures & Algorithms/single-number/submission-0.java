// Jai Ganesh
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        
        for(int ind = 0; ind < nums.length; ind++) {
            ans ^= nums[ind];
        }

        return ans;
    }
}
