class Solution {
    public int[] getConcatenation(int[] nums) {
        //get the length of nums
        int n = nums.length;

        //length of ans
        int ansLength = 2 * n;

        // create array ans
        int[] ans = new int[ansLength];

        // variable to store the position of elements in nums
        int count = 0;

        // loop through the new array
        for (int i = 0; i<ansLength; i++) {

            //condition for the last element of nums
            if (count == n) count = 0;
            ans[i] = nums[count++];
        }
        return ans;
    }
}