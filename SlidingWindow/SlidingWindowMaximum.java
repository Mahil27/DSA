class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int p[]=new int[n];
        int s[]=new int[n];
        int ans[]=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(i%k==0){
                p[i]=nums[i];
            }
            else{
                p[i]=Math.max(p[i-1],nums[i]);
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1 || (i+1)%k==0){
                s[i]=nums[i];
            }
            else{
                s[i]=Math.max(s[i+1],nums[i]);
            }
        }
        for(int i=0;i<n-k+1;i++){
            ans[i]=Math.max(s[i],p[i+k-1]);
        }
        return ans;
    }
}