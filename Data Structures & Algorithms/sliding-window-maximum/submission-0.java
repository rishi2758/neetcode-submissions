class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = start;
        // [-10, 9, -10, -5, -5]
        // [-10, 9, 9, 9, 9 ]
        // [9, 9, 9, 9]
        // [-10, 9]
        // max-index exists in window size = k
        // 

        // oe == max , max = next-max 
        // ie          max = max(max, ie)
        
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i2[0]-i1[0]);
        while (end < n) {
            int i = nums[end];
            
            pq.add(new int[]{i, end});

            if (end-start+1 == k) {
                while (!pq.isEmpty() && pq.peek()[1] < start) pq.poll();
                int[] maxE = pq.peek();
                ans.add(maxE[0]);
                ++start;
            }

            ++end;
        }
        int[] a = new int[ans.size()];
        int idx = 0;
        for(int i : ans) {
            a[idx++] = i;
        }
        return a;
    }
}
