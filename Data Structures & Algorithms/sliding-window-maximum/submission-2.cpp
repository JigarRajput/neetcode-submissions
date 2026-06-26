// Jai Ganesh
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int left = 0, right = 0, len = nums.size();
        map<int, int> freq;
        vector<int> ans;
        freq[nums[0]]++;

        while(right < len) {
            if((right - left + 1) < k) {
                right++;
                if(right < len) {
                    freq[nums[right]]++;
                }
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
