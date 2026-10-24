//brute force
// class Solution {
//     public int maxSubArray(int[] nums) {
        
//         int res = nums[0];

//         for (int i = 0; i < nums.length; i++) {
//             int currSum = 0;

//             for (int j = i; j < nums.length; j++) {
//                 // Intuition: Extend the subarray starting at i
//                 // by including the next element nums[j].
//                 currSum += nums[j];

//                 // Update the maximum after every extension,
//                 // including subarrays containing one element.
//                 res = Math.max(res, currSum);
//             }
//         }

//         return res;
//     }
// }

class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Intuition: Extend the current subarray if its sum
            // helps; otherwise, start a new subarray at nums[i].
            currSum = Math.max(nums[i], currSum + nums[i]);

            // Keep track of the maximum sum found so far.
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
