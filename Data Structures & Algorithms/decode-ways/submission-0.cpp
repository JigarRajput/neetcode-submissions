// Jai Ganesh
class Solution {
private:
    int solve(int index, string s, vector<int> &dp) {
        // if we are on last index.
        if(index == (s.size() - 1)) {
            return s[index] - '0' > 0;
        } else if(index >= s.size()) {
            return 1;
        }
        else if(dp[index] != -1) return dp[index];
        // invalid
        if(s[index] - '0' == 0) return dp[index] = 0;

        int left = solve(index+1, s, dp);
        int right = 0;
        // if less than second last index, taking two numbers is possible
        if(index < (s.size() - 1)) {
            int current = s[index] - '0';
            int next = s[index+1] - '0';

            int total = current*10 + next;

            if(total >= 1 && total <= 26) {
                right = solve(index+2, s, dp);
            }
        }

        return dp[index] = left+right;
    }    
public:
    int numDecodings(string s) {
        vector<int> dp(s.size(), -1);
        return solve(0, s, dp);
    }
};
