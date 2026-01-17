/*
 Problem: Find All Anagrams in a String (LeetCode 438)

 Given two strings s and p, return all the start indices of p's anagrams in s.

 -------------------------------------------------------
 Approach: Sliding Window with HashMap

 1. Create a frequency map of string p.
 2. Use a sliding window of size k = p.length() on string s.
 3. Maintain another map for current window character frequencies.
 4. Expand the window using right pointer.
 5. When window size becomes k:
      - Compare both maps.
      - If equal, store left index.
      - Shrink window from left.

 -------------------------------------------------------
 Time Complexity:
   O(n * 26) ≈ O(n)   (HashMap comparison is small since only characters)

 Space Complexity:
   O(26) ≈ O(1)

 -------------------------------------------------------
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> str = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        // Frequency map of p
        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0)+1);
        }

        int left = 0, right = 0;
        int k = p.length();
        int count = 0;

        while(right < s.length()){

            char c = s.charAt(right);
            str.put(c, str.getOrDefault(c,0)+1);
            count++;

            // Maintain window size
            while(count == k){

                if(str.equals(map)){
                    res.add(left);
                }

                char x = s.charAt(left);
                str.put(x, str.get(x)-1);

                if(str.get(x) == 0){
                    str.remove(x);
                }

                count--;
                left++;
            }

            right++;
        }

        return res;
    }
}
