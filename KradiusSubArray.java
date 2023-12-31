/*You are given a 0-indexed array nums of n integers, and an integer k.

The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.

The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.

For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2. */

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avg = new int[n];
        Arrays.fill(avg,-1);
        long sum = nums[0];
        if(n > 1){
            for(int i = 1 ; i <= k ; i++){
                if(i + k < n){
                 sum += (nums[i] + nums[i+k]);
                }
            }
        }
        int first = 0 , last = 2 * k;
        for(int i = k; i < n - k ; i++){
            avg[i] = (int)(sum/(2*k + 1));
            if(i < n - k - 1){
                sum = sum - nums[i-k] + nums[i+k+1];
            }
           first++;
           last++;
        }
        return avg;
    }
}