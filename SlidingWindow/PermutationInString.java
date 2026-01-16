/*
 LeetCode 567: Permutation in String

 Problem:
 Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 otherwise return false.

 Approach:
 We use a sliding window of size s1.length() over s2.
 Two HashMaps are used:
   - map: frequency of characters in s1
   - res: frequency of characters in current window of s2

 At each window of size k, we compare both maps.
 If they are equal, a permutation exists.

 Time Complexity: O(n)
 Space Complexity: O(1)  (only 26 lowercase letters)
*/

import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int right = 0, left = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> res = new HashMap<>();

        // Frequency map of s1
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            char c = s2.charAt(right);
            res.put(c, res.getOrDefault(c, 0) + 1);

            // When window size equals s1 length
            if (right - left + 1 == k) {

                // Compare both maps
                if (map.equals(res)) return true;

                // Remove left character from window
                char ch = s2.charAt(left);
                res.put(ch, res.get(ch) - 1);

                if (res.get(ch) == 0) {
                    res.remove(ch);
                }
                left++;
            }
            right++;
        }
        return false;
    }
}
