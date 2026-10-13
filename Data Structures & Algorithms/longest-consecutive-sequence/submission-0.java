class Solution {
    public int longestConsecutive(int[] nums) {

        // INTUITION:
        // Sorting takes O(n log n). To achieve O(n), use a HashSet
        // for O(1) average-time lookups and to automatically remove duplicates.
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }
        int res = 0;

        for(int i : nums){
            // KEY OBSERVATION:
            // If num - 1 exists, num is NOT the beginning of a sequence.
            // Skip it because its sequence will be counted from an earlier number.
            //
            // Example: For [2, 3, 4, 5], start counting only from 2,
            // not from 3, 4, or 5. This prevents repeated traversal.
            if(!set.contains(i-1)){
                // We found the smallest number of a consecutive sequence.
                int currnum = i;
                int currLen = 1;

                // Keep looking for the next consecutive number.
                // Since we start only at sequence beginnings, each sequence
                // is traversed once, keeping the overall work linear.

                while(set.contains(currnum+1)){
                    currnum++;
                    currLen++;
                }
                res = Math.max(res,currLen);
            }
            
        }
        return res;
    }
}
