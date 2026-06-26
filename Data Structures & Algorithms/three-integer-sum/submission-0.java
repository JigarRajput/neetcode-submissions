    // Jai Ganesh
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int len = nums.length;

            List<List<Integer>> ans = new ArrayList<>();

            Arrays.sort(nums);

            for(int ind1 = 0; ind1 < len; ind1++) {
                int ind2 = ind1+1;
                int ind3 = len-1;
                if(ind1 > 0 && nums[ind1] == nums[ind1-1]) {
                    continue;
                }

                while(ind2 < ind3) {
                    int sum = nums[ind1] + nums[ind2] + nums[ind3];
                    if(sum == 0 && ind1 != ind2 && ind2 != ind3 && ind1 != ind3) {
                        ans.add(new ArrayList<>(List.of(nums[ind1], nums[ind2], nums[ind3])));
                        ind2++;
                        ind3--;

                        while(ind2 < ind3 && nums[ind2-1] == nums[ind2]) ind2++;

                        while(ind2 < ind3 && nums[ind3+1] == nums[ind3]) ind3--;
                    }

                    else if(sum > 0) {
                        ind3--;
                    }

                    else {
                        ind2++;
                    }
                }
            }

            return ans;
        }
    }