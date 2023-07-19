class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0; // There are no bars to trap water.

        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            // Check the lower side to find trapped water.
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    // Update the leftMax to the current height if it's greater.
                    leftMax = height[left];
                } else {
                    // Trap water as the current height is less than leftMax.
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    // Update the rightMax to the current height if it's greater.
                    rightMax = height[right];
                } else {
                    // Trap water as the current height is less than rightMax.
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
}
