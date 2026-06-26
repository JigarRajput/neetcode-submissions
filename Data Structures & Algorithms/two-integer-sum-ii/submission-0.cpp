// Jai Ganesh
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int len = numbers.size();
        int low = 0;
        int high = len - 1;

        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) return {numbers[low], numbers[high]};

            else if(sum > target) {
                sum -= numbers[high];
                high--;
            }
            else {
                sum -= numbers[low];
                low++;
            }
        }

        return {-1, -1}; 
    }
};
