// Jai Ganesh
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int left = 0, right = 0, len = nums.size();
        map<int, int> freq;
        int windowMax = nums[0];
        vector<int> ans;
        freq[windowMax]++;

        while(right < len) {
            if(right - left + 1 < k) {
                freq[nums[right]]++;
                windowMax = max(windowMax, nums[right]);
                right++;
            }
            else {
                ans.push_back(prev(freq.end())->first);
                if(left < len) {
                    freq[nums[left]]--;
                    if(freq[nums[left]] <= 0) {
                        freq.erase(nums[left]);
                    }
                    left++;
                }
                right++;
                if(right < len) {
                    freq[nums[right]]++;
                }
            }
        }

        return ans;
    }
};
