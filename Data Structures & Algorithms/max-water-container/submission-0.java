class Solution {
    public int maxArea(int[] heights) {

        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        // INTUITION:
        // Start with the widest possible container.
        // The water area depends on:
        // width * minimum of the two heights.
        while (l < r) {

            int len = r - l;
            int breadth = Math.min(heights[l], heights[r]);
            int area = len * breadth;

            // Keep track of the maximum area found so far.
            res = Math.max(res, area);

            // KEY OBSERVATION:
            // The shorter bar limits the water level.
            // Moving the taller bar inward reduces width without
            // increasing the limiting height, so it cannot improve
            // the area for that shorter bar.
            //
            // Therefore, always move the pointer at the shorter bar.
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }

        return res;
    }
}