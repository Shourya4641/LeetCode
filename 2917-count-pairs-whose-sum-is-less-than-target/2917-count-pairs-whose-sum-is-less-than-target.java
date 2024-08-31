class Solution {
    public int countPairs(List<Integer> nums, int target) {
        //sort the given list
        Collections.sort(nums);

        //length of the given list
        int length = nums.size();

        //initializing the pointers and other variables
        int left = 0;
        int right = length - 1;
        int pairSum = 0;
        int validPairCount = 0;

        //traversing through the array
        while (left < right) {
            pairSum = nums.get(left) + nums.get(right);     //adding the 2 elements present at left and right pointer

            if (pairSum < target) {
                validPairCount += (right - left);  //in case the condition is true, then this implies that all the sum of 2 elements present
                left++;                            //between the left and right pointer would satisfy the condition because the array is sorted.
            } else {                               
                right--;                           //otherwise decrease the right pointer.
            }
        }
        return validPairCount;
    }
}