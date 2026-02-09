/**
 * Problem:
 * Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]]
 * such that:
 *
 *      i != j, i != k, j != k
 *      nums[i] + nums[j] + nums[k] == 0
 *
 * The solution set must not contain duplicate triplets.
 *
 * Approach:
 * 1. Sort the array.
 *    Sorting helps us:
 *      - Use the two-pointer technique.
 *      - Easily skip duplicate values.
 *
 * 2. Fix one element at index i.
 *    For each i, we try to find two numbers after it that sum to -nums[i].
 *
 * 3. Use two pointers:
 *      j = i + 1  (start)
 *      k = n - 1  (end)
 *
 *    While j < k:
 *      - If sum == 0 → add triplet to result.
 *      - If sum < 0  → move j forward (increase sum).
 *      - If sum > 0  → move k backward (decrease sum).
 *
 * 4. Skip duplicates:
 *      - If nums[i] == nums[i - 1], skip to avoid duplicate triplets.
 *      - After finding a valid triplet, skip duplicate values for j.
 *
 * Time Complexity: O(n^2)
 *    - Sorting: O(n log n)
 *    - Two-pointer search for each element: O(n^2)
 *
 * Space Complexity: O(1)
 *    - Ignoring the output list.
 */
class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Skip duplicate values for j
                    while (j < k && nums[j] == nums[j - 1]) j++;

                } else if (sum < 0) {
                    j++;   // Need a bigger number
                } else {
                    k--;   // Need a smaller number
                }
            }
        }

        return res;
    }
}
