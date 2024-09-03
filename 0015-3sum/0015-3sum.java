class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
            logic:
            1. sort the given array
            2. initiate 3 pointers -- i, j, k
            3. keep i static at 0th index first
            4. then out j = i + 1 and k = nums.length - 1
            5. check if the triplet sum is 0
            6. if > 0, then decrease k
            7. if < 0, then increase j
            8. loop untill j<k, then increment i
            9. incase you get the target, push the triplet into the list
        */

        //sort the array
        Arrays.sort(nums);

        //create list of list
        List<List<Integer>> tripletList = new ArrayList<>();

        //traverse the array
        for (int i = 0; i<nums.length; i++) {

            //no use of having same starting value in multiple triplets
            if ((i > 0) && (nums[i] == nums[i-1])) {
                continue;
            }

            int small = i + 1;
            int big = nums.length - 1;

            //traverse the inner array keeping your i constant
            while (small < big) {
                int sum = nums[i] + nums[small] + nums[big];

                if (sum < 0) {
                    small++;
                } else if (sum > 0) {
                    big--;
                } else {
                    tripletList.add(Arrays.asList(nums[i], nums[small], nums[big]));
                    small++;

                    //checking for no duplcating result
                    while (nums[small] == nums[small - 1] && (small < big)) {
                        small++;
                    }
                }
            }
        }

        return tripletList;
    }
}