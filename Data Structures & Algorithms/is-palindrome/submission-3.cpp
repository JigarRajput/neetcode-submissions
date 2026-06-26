// Jai Ganesh
class Solution {
private:
    bool isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    bool isLetter(char ch) {
        return ((ch >= 'a' && ch <= 'z') || (ch <= 'Z' && ch >= 'A'));
    }
    bool areBothValid(int low, int high, string& s) {
        char lowChar = s[low];
        char highChar = s[high];

        if((isLetter(lowChar) || isDigit(lowChar))  && (isLetter(highChar) || isDigit(highChar))) {
            return true;
        }
        return false;
    }

    bool isValid(int low, string& s) {
        char lowChar = s[low];
        return isDigit(lowChar) || isLetter(lowChar);
    }

public:
    bool isPalindrome(string s) {
        int low = 0, high = s.size()-1;
        transform(s.begin(), s.end(), s.begin(), ::tolower);
        cout<<" s "<<s<<endl;

        while(low <= high) {
            if(!isValid(low, s)) {
                low++;
            }
            if(!isValid(high, s)) {
                high--;
            }
            else if(areBothValid(low, high, s) && s[low] == s[high]) {
                low++;
                high--;
            }
            else if(areBothValid(low, high, s) && s[low] != s[high]) {
                return false;
            }
        }
        return true;
    }
};
