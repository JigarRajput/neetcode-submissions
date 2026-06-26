// Jai Ganesh
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int len = strs.size();
        unordered_map<string, vector<string>> groups;

        for(int index = 0; index < len; index++) {
            string str = strs[index];
            int strLen = str.size();

            vector<int> freq(26);
            for(int pointer = 0; pointer < strLen; pointer++) {
                freq[str[pointer] - 'a']++;
            }
            string key = "";
            for(int ch = 0; ch < 26; ch++) {
                key = key + (char)(ch + 97) + ':' + to_string(freq[ch]) + ',';
            }
            groups[key].push_back(str);
        }

        vector<vector<string>> ans;

        for(auto entry : groups) {
            ans.push_back(entry.second);
        }

        return ans;
    }
};
