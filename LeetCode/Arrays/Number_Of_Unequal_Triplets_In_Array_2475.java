class Solution {
    public int unequalTriplets(int[] nums) {
       int triplets = 0;
       int pairs = 0;
       int count[] = new int[1001];

       for (int i = 0; i < nums.length; i++) {
        triplets += pairs - count[nums[i]] * (i - count[nums[i]]);
        pairs += i - count[nums[i]];
        count[nums[i]]++;
       }
       return triplets;
    }
}