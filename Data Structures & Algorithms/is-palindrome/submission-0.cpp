// Jai Ganesh
class Solution {
private:
    bool areBothValid(int low, int high, string& s) {
        char lowChar = s[low];
        char highChar = s[high];

        if(((lowChar >= 'a' && lowChar <= 'z') || (lowChar >= 'A' && lowChar <= 'Z'))  && ((highChar >= 'A' && highChar <= 'Z') || (highChar >= 'a' && highChar <= 'z'))) {
            return true;
        }
        return false;
    }

    bool isValid(int low, string& s) {
        char lowChar = s[low];
        if((lowChar >= 'a' && lowChar <= 'z') || (lowChar >= 'A' && lowChar <= 'Z')) {
            return true;
        }
        return false;
    }

public:
    bool isPalindrome(string s) {
        int low = 0, high = s.size();
        transform(s.begin(), s.end(), s.begin(), ::tolower);

        while(low <= high) {
            if(areBothValid(low, high, s) && s[low] != s[high]) {
                return false;
            }
            if(!isValid(low, s)) {
                low++;
            }
            if(!isValid(high, s)) {
                high--;
            }
            else {
                low++;
                high--;
            }
        }
        return true;
    }
};
