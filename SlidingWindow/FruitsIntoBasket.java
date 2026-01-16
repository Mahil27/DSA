/*
 LeetCode 904: Fruit Into Baskets

 Problem:
 You are given an array fruits where fruits[i] is the type of fruit.
 You have two baskets and can collect only one type of fruit in each basket.
 Starting from any index, collect fruits consecutively while keeping at most
 two different fruit types.

 Return the maximum number of fruits you can collect.

 Approach:
 We use a sliding window with a HashMap to store fruit counts.
 The window is valid while it contains at most two different fruit types.
 If it exceeds, we shrink the window from the left.

 Time Complexity: O(n)
 Space Complexity: O(1)   (only two fruit types stored)
*/

import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0;

        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // Shrink window if more than 2 fruit types
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            // Update maximum window size
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
