class Solution {
    public int maxProfit(int[] prices) {
        int cp = prices[0];
        int res = 0;
        for(int ele : prices){
            cp = Math.min(ele,cp);
            res = Math.max(res,ele - cp);
        }
        return res;

    }
}
