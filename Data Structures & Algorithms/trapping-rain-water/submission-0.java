class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = -1;
        rmax[n-1] = -1;
        for (int i = 1; i < n; i++) {
            if (lmax[i-1] == -1 || height[lmax[i-1]] < height[i-1]) {
                lmax[i] = i-1;
            } else {
                lmax[i] = lmax[i-1];
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (rmax[i+1] == -1 || height[rmax[i+1]] < height[i+1]) {
                rmax[i] = i+1;
            } else {
                rmax[i] = rmax[i+1];
            }
        }

        //print(lmax, height);
        //print(rmax, height);

        int water = 0;
        for (int i = 0; i < n; i++) {
            if (lmax[i] != -1 && rmax[i] != -1) {
                int minH = Math.min(height[lmax[i]], height[rmax[i]]);
                if (minH > height[i]) {
                    water += minH - height[i];
                }
                
            }
        }
        return water;
    }

    private void print(int[] num, int[] height) {
        StringJoiner sb = new StringJoiner(",");
        for(int i : num) {
            if (i == -1) sb.add(""+i);
            else sb.add(""+height[i]);
        }
        System.out.println(sb);
    }
}
