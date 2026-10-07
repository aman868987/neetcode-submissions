class Solution {
    public int[] twoSum(int[] nums, int target) {
        // brute force, traverse with two loops and check the sum -O(N2)
        // use set to check the compliment
        // since result order is strict use hashmap to store the index

        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int comp = target - nums[i];
            // if(set.contains(comp)){
            //     res[1] = i;
            //     res[0] = ;
            //     return res;
            // }

            // set.add(nums[i]);
            if(map.containsKey(comp)){
                res[0] = map.get(comp);
                res[1] = i;
                return res;

            }
            map.put(nums[i],i);
        }
        return res;
    }
}
