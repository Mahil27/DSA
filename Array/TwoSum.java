import java.util.HashMap;

// Problem: Two Sum
// LeetCode: 1
// Pattern: Hashing
// Approach:
// Use a HashMap to store each number with its index.
// For every element, check if (target - current) exists in map.
// If yes, return both indexes.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {-1, -1}; // safety return
    }
}
