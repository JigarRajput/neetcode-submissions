// Jai Ganesh
class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];

        for(int num = 0; num <= n; num++) {
            ans[num] = getSetBitsCount(num);
        }

        return ans;
    }

    static int getSetBitsCount(int n) {
        int ans = 0;
        
        while(n > 0) {
            if((n & 1) == 1) {
                ans++;
            }

            n>>=1;
        }

        return ans;
    }
}
