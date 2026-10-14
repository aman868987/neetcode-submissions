class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        // INTUITION:
        // The array is sorted, so start with the smallest and largest numbers.
        // Move the pointers inward based on whether their sum is too large
        // or too small. This avoids checking every possible pair.

        while (low < high) {

            int sum = numbers[low] + numbers[high];

            if (sum > target) {

                // Sum is too large.
                // Since numbers[high] is the largest remaining number,
                // move high left to reduce the sum.
                high--;

            } else if (sum < target) {

                // Sum is too small.
                // Since numbers[low] is the smallest remaining number,
                // move low right to increase the sum.
                low++;

            } else {

                // Target found!
                // The problem requires 1-indexed positions, not values.
                return new int[]{low + 1, high + 1};
            }
        }

        // A valid solution is guaranteed by the problem.
        return new int[]{-1, -1};
    }
}
