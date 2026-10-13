class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        int curr = 1;

        // Prefix products: product of all elements to the left
        prefix[0] = curr;

        for (int i = 1; i < n; i++) {
            curr = curr * nums[i - 1];
            prefix[i] = curr;
        }

        curr = 1;

        // Postfix products: product of all elements to the right
        postfix[n - 1] = curr;

        for (int i = n - 2; i >= 0; i--) {
            curr = curr * nums[i + 1];
            postfix[i] = curr;
        }

        // Multiply prefix and postfix products
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * postfix[i];
        }

        return res;
    
    }
}  
