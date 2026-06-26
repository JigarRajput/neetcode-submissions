class Solution {
public:
    bool isAnagram(string s, string t) {
     int sLen = s.size();
     int tLen = t.size();

     if(sLen != tLen) return false;

     unordered_map<char, int> freq;

     for(int index = 0; index < sLen; index++) {
        freq[s[index]]++;
     }

    for(int index = 0; index < sLen; index++) {
        freq[t[index]]--;
        if(freq[t[index]] < 0) return false;
    }  
    return true;
    }
};
