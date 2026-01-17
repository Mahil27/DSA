/*
 Problem: Substring with Concatenation of All Words (LeetCode 30)

 Given a string s and an array of words, each word has the same length.
 We need to find all starting indices of substrings in s that are formed by
 concatenating each word in words exactly once and without any extra characters.

 -------------------------------------------------------
 Approach:

 Let:
   len = length of one word
   k   = total length of all words combined

 Since words are of equal length, valid substrings can only start at
 indices aligned by multiples of len.

 So we try `len` different starting offsets:
   start = 0, 1, 2, ..., len-1

 For each offset:
   - Use a sliding window moving in steps of word length.
   - Build words of size `len` while moving `right`.
   - Maintain a hashmap `map` for current window word frequencies.
   - When window size equals `k`, compare map with target frequency map.
   - If equal → add left index to result.
   - Slide window by removing the left word.

 This avoids checking every index and ensures optimal traversal.

 -------------------------------------------------------
 Time Complexity:
   O(n * len)  → n = length of string

 Space Complexity:
   O(m) → number of words

 -------------------------------------------------------
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        HashMap<String,Integer> str = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        // Frequency map of given words
        for(int i=0;i<words.length;i++){
            str.put(words[i], str.getOrDefault(words[i],0)+1);
        }

        int len = words[0].length();
        int k = len * words.length;

        // Try all possible offsets
        for(int start=0; start<len; start++){

            HashMap<String,Integer> map = new HashMap<>();
            int left = start, right = start;
            String st = "";

            while(right < s.length()){

                // Build word of size len
                char c = s.charAt(right);
                st += c;

                if(st.length() == len){
                    map.put(st, map.getOrDefault(st,0)+1);
                    st = "";
                }

                // When window size equals total words length
                while(right - left + 1 == k){

                    if(map.equals(str)){
                        res.add(left);
                    }

                    String x = s.substring(left, left + len);
                    map.put(x, map.get(x) - 1);

                    if(map.get(x) == 0){
                        map.remove(x);
                    }

                    left += len;
                }

                right++;
            }
        }

        return res;
    }
}
