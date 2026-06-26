// Jai Ganesh
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int len = nums.size();
        unordered_map<int, int> lastSeen;
        for(int index = 0; index < len; index++) {
            if(lastSeen.find(target - nums[index]) != lastSeen.end()) {
                return {lastSeen[target - nums[index]], index};
            }
            lastSeen[nums[index]] = index;
        }

        return {-1,-1};
    }
};
