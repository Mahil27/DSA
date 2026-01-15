// Problem: Minimum Size Subarray Sum
// LeetCode: 209
// Pattern: Sliding Window
// Approach:
// Expand the window by moving right pointer.
// When sum >= target, shrink window from left to find minimum length.
//
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (r < n) {
            sum += nums[r];

            if (sum < target) {
                r++;
            } else {
                while (sum >= target) {
                    minLen = Math.min(minLen, r - l + 1);
                    sum -= nums[l];
                    l++;
                }
                r++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
