/*
 Problem: Sliding Window Maximum (LeetCode 239)

 Given an integer array nums and an integer k, return the maximum value
 in every sliding window of size k.

 -------------------------------------------------------
 Approach: Block Preprocessing Technique (O(n))

 We preprocess the array using two helper arrays:

 1. p[i] (prefix max):
    - Stores the maximum from the start of the block to index i.
    - Block size = k
    - If i % k == 0 → start new block.

 2. s[i] (suffix max):
    - Stores the maximum from index i to the end of the block.
    - If (i+1) % k == 0 → end of block.

 For any window [i ... i+k-1]:
    max = max( s[i], p[i+k-1] )

 This works because:
   s[i] covers left part of window,
   p[i+k-1] covers right part of window.

 -------------------------------------------------------
 Time Complexity:
   O(n)

 Space Complexity:
   O(n)

 -------------------------------------------------------
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int p[] = new int[n];       // prefix max array
        int s[] = new int[n];       // suffix max array
        int ans[] = new int[n-k+1];

        // Build prefix max array
        for(int i=0;i<n;i++){
            if(i % k == 0){
                p[i] = nums[i];
            } else {
                p[i] = Math.max(p[i-1], nums[i]);
            }
        }

        // Build suffix max array
        for(int i=n-1;i>=0;i--){
            if(i == n-1 || (i+1) % k == 0){
                s[i] = nums[i];
            } else {
                s[i] = Math.max(s[i+1], nums[i]);
            }
        }

        // Compute answer for each window
        for(int i=0;i<=n-k;i++){
            ans[i] = Math.max(s[i], p[i+k-1]);
        }

        return ans;
    }
}
