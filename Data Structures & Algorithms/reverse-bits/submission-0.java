// Jai Ganesh

class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        int i = 0;

        while(i < 32) {
            if((n&1) == 1) {
                int mask = 1 << (31-i);
                ans |= mask;
            }
            i++;
            n >>=1;
        }       
        return ans;
    }
}
