// Jai Ganesh
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int len = s.length();
        int maxLength = 0;

        int start = 0, end = 0;

        while(end < len) {
            char ch = s.charAt(end);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while((freq.get(ch) > 1) && start < end) {
                freq.put(s.charAt(start), freq.get(s.charAt(start)) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }
}
