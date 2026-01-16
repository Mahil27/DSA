import java.util.HashMap;

/*
 LeetCode 76 - Minimum Window Substring

 Problem:
 Given two strings s and t, return the minimum window substring of s
 such that every character in t (including duplicates) is included in the window.
 If there is no such substring, return an empty string.

 Approach:
 - Use Sliding Window technique with two HashMaps.
 - tmap stores frequency of characters in t.
 - smap stores frequency of characters in current window of s.
 - Expand window using right pointer.
 - When all characters are matched, shrink window from left to minimize length.
 - Track minimum window size and starting index.

 Time Complexity: O(N)
 Space Complexity: O(N)
*/

class Solution{

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        int left = 0, right = 0;
        int count = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        // Build frequency map for t
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        // Sliding window traversal
        while (right < s.length()) {

            char c = s.charAt(right);
            smap.put(c, smap.getOrDefault(c, 0) + 1);

            if (tmap.containsKey(c) && smap.get(c) <= tmap.get(c)) {
                count++;
            }

            // Shrink window when all characters matched
            while (count == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);
                smap.put(l, smap.get(l) - 1);

                if (tmap.containsKey(l) && smap.get(l) < tmap.get(l)) {
                    count--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
