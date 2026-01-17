/*
LeetCode 992 — Subarrays With K Distinct Integers

PATTERN:
Sliding Window + HashMap + Inclusion–Exclusion Principle

IDEA:
To count subarrays with exactly K distinct elements, we use:
    Exactly K = AtMost(K) - AtMost(K-1)

We create a helper function atMost(K) that counts subarrays
having at most K distinct numbers using sliding window.

SLIDING WINDOW LOGIC:
- Expand the right pointer and add element to HashMap.
- If distinct elements exceed K, shrink from the left.
- For every valid window [left ... right], the number of
  subarrays ending at 'right' is (right - left + 1).

WHY IT WORKS:
AtMost(K) counts all subarrays with ≤ K distinct.
AtMost(K-1) removes those with fewer than K distinct.
Remaining subarrays have exactly K distinct elements.

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(K)

PATTERN CATEGORY:
Sliding Window | HashMap Frequency | Subarray Counting
*/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] arr, int k) {
        int left = 0, right = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}
