class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //  -sum = a + b
        //  -1,0,1,2,-1,-4
        //  -4,-1,-1,0,1,2
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            
            if (i > 0 && nums[i-1] == nums[i]) continue;
            int j = i+1;
            int k = n-1;
            int target = -nums[i];
            
            while (j < k) {

                if (nums[j] + nums[k] == target) {
                    ans.add(List.of(nums[j], nums[k], nums[i]));
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k-1] == nums[k]) k--;
                    ++j;
                    --k;        
                } else if (nums[j] + nums[k] < target) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return ans;
    }
}
