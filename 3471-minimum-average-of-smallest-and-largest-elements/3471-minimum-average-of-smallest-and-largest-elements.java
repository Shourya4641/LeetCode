class Solution {
    public double minimumAverage(int[] nums) {
        /*
            logic:
            1. sort the given array
            2. place 2 pointers at the start and at the end
            3. take the avg of the 2 numbers
            4. keep track of the smallest avg 
        */

        //sort the array
        Arrays.sort(nums);

        //initialze 2 pointers and the avg array
        int left = 0;
        int right = nums.length - 1;

        double min = nums[right];

        //traverse the array and find the averages
        while (left < right) {
            double avg = (nums[left] + nums[right])/2.0;
            if (min>avg) {
                min = avg;
            }
            left++;
            right--;
        }

        return min;
    }
}