// Jai Ganesh
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;

        int expected = (nums.length * (nums.length + 1)) / 2;

        for(int ind = 0; ind < nums.length; ind++) {
            sum += nums[ind];
        }

        return expected - sum;
    }
}
