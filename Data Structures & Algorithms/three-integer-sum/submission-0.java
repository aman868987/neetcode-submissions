class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        // Fix one number and find the other two using two pointers.
        // Sorting allows us to adjust pointers based on the sum
        // and skip duplicates without using an additional HashSet.
        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate fixed numbers to avoid duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {

                    // Sum is too small.
                    // Move left pointer right to increase the sum.
                    j++;

                } else if (sum > 0) {

                    // Sum is too large.
                    // Move right pointer left to decrease the sum.
                    k--;

                } else {

                    // Found a valid triplet.
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Move both pointers to search for another pair.
                    j++;
                    k--;

                    // Skip duplicate left values.
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // Skip duplicate right values.
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return res;
    }
}