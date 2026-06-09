class Solution {
    // 
    public int trap(int[] height) {
        int n = height.length;
        int lmax = height[0];
        int rmax = height[n-1];
        int i = 0;
        int j = n-1;
        int trap = 0;
        while (i < j) {
            if (lmax < rmax) {
                ++i;
                lmax = Math.max(lmax, height[i]);
                trap+= lmax - height[i];
            } else {
                --j;
                rmax = Math.max(rmax, height[j]);
                trap+= rmax - height[j];
            }
           
        }
        return trap;
    }

    
}
