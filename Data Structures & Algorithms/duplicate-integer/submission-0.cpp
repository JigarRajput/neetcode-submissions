// Jai Ganesh
class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        int len = nums.size();
        unordered_map<int, int> existing;

        for(int index = 0; index < len; index++) {
            if(existing[nums[index]]) return true;
            existing[nums[index]] = 1; 
        }

        return false;
     }
};
