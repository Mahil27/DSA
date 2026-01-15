import java.util.*;
// Problem: 3Sum
// LeetCode: 15
// Pattern: Two Pointers + Sorting
// Approach:
// 1. Sort the array.
// 2. Fix one element and use two pointers to find remaining two.
// 3. Skip duplicates to avoid repeated triplets.
//
// Time Complexity: O(n^2)
// Space Complexity: O(1) (excluding result list)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // Skip duplicates for second pointer
                    while (j < k && nums[j] == nums[j - 1]) j++;

                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
