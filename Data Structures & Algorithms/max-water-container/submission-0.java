class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n-1;

        int area = 0;
        while (i < j) {
            area = Math.max(area, Math.min(heights[i], heights[j])*(j-i));

            if (heights[i] == heights[j]) {
                ++i;
                --j;
            } else if (heights[i] < heights[j]) {
                ++i;
            } else {
                --j;
            }
        }

        return area;
    }
}
