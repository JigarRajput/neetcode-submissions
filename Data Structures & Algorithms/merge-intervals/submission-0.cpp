// Jai Ganesh
class Solution {
private:        
   static bool comp(const vector<int>& a, const vector<int>& b) {
        return a[0] < b[0];  // Strict inequality for correct sorting
    }

public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;

        sort(intervals.begin(), intervals.end(), comp);

        ans.push_back({intervals[0][0], intervals[0][1]});

        for(int index = 1; index<intervals.size(); index++) {
            vector<int> prev = ans.back();

            int prevStart = prev[0];
            int prevEnd = prev[1];

            int currentStart = intervals[index][0];
            int currentEnd = intervals[index][1];

            if(currentStart >= prevStart && currentStart <= prevEnd) {

                int newStart = min(currentStart, prevStart);
                int newEnd = max(currentEnd, prevEnd);
                // we have overLap
                ans.pop_back();

                ans.push_back({newStart, newEnd});
            }
            else {
                ans.push_back({currentStart, currentEnd});
            }
        }

        return ans;
    }
};
