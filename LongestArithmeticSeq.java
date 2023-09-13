/*Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Note that:

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).
*/

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max = 0;
        HashMap<Integer,Integer>[] dp = new HashMap[nums.length];
        for(int r = 0; r < nums.length; r++){
            dp[r] = new HashMap<>();
            for(int l = 0; l < r; l++){
                int diff = nums[r] - nums[l];
                dp[r].put (diff, dp[l].getOrDefault(diff , 1) + 1);
                max = Math.max(max, dp[r].get(diff));
            }
        }
        return max;
    }
}