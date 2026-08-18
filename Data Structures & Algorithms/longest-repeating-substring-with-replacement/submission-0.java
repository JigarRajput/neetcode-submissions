// Jai Ganesh
class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];

        int start = 0, end = 0;
        int maxFrequency = 0;
        int maxSubArrayLength = 0;

        while(end < s.length()) {
            int ind = s.charAt(end) - 'A';
            
            frequency[ind]++;
            maxFrequency = Math.max(maxFrequency, frequency[ind]);

            // window valid
            int windowLength = end - start + 1;
            if((windowLength - maxFrequency) <= k) {
                maxSubArrayLength = Math.max(maxSubArrayLength, windowLength);
            }
            else {
                frequency[s.charAt(start) - 'A']--;
                start++;
            }

            end++;
        }

        return maxSubArrayLength;
    }
}