class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        /*
            logic:
            1. the main target is to optimize the suitable number finding technique.
            2. hence transferring the elements into a hashmap would help in that.
            3. if a, b, c has difference of n between each other then it can also be written as a, a + n, a + 2n
            4. using the above logic we are going to find the triplets count
        */

        //create a hashmap
        HashMap<Integer, Integer> numsHashMap = new HashMap<>();

        //variable to store the triplet count
        int tripletCount = 0;

        //transferring the array elements into the hashmap -- key = element, value = index
        for (int i = 0; i<nums.length; i++) {
            numsHashMap.put(nums[i], i);
        }

        //traversing the elements in the array
        for (int num : nums) {
            if (numsHashMap.containsKey(num + diff) && numsHashMap.containsKey(num + (2 * diff))) {
                tripletCount++;
            }
        }

        return tripletCount;
    }
}