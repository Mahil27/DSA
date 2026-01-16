/*
 LeetCode 424: Longest Repeating Character Replacement

 Problem:
 Given a string s and an integer k, you can replace at most k characters
 in the string so that the resulting substring contains only the same character.
 Return the length of the longest such substring.

 Approach:
 We use the Sliding Window technique with a HashMap to store character frequencies.
 The window is valid as long as:
     (window size - max frequency of a character) <= k

 This ensures that we can replace at most k characters to make the window uniform.

 Time Complexity: O(n)
 Space Complexity: O(1)   // because only 26 uppercase letters
*/

import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = 0, maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((right - left + 1) - maxFreq > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
