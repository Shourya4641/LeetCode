class Solution {
    public void moveZeroes(int[] nums) {
        /*
            logic:
            1. start with 2 pointers at 0th index of the array
            2. if element == 0, then increment right pointer by 1
            3. else swap element at left and right pointer, then increment of left and right by 1
        */

        //two pointers
        int left = 0;
        int right = 0;

        //traverse through the array
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 0) {
                right++;
            } else {
                //swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                //increment
                left++;
                right++;
            }
        }
    }
}