/*
 LeetCode 643: Maximum Average Subarray I

 Problem:
 Given an integer array nums and an integer k, find the contiguous subarray
 of length k that has the maximum average value and return this value.

 Approach:
 We use a sliding window of size k.
 Maintain a running sum of the window.
 At each step, update the maximum sum and slide the window forward.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0;
        int sum = 0;
        double avg = 0, max = Integer.MIN_VALUE;

        while (right < nums.length) {
            sum += nums[right];

            // When window size becomes k
            if (right - left + 1 == k) {
                max = Math.max(max, sum);

                // Slide the window
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return (double) max / k;
    }
}
