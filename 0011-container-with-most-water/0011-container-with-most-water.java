class Solution {
    public int maxArea(int[] height) {
        /*
            logic:
            1. 2 pointers - left and right at both ends of the array
            2. base can be found out from the left and right pointers
            3. calculate area
            4. check which one of the elements present at left and right 
            5. increment or decrement the pointer according to the bigger height
        */

        //pointers
        int left = 0;
        int right = height.length - 1;

        //largest area
        int largestArea = 0;

        while (left < right) {
            //get largest area
            int minHeight = Math.min(height[left], height[right]);

            int base = right - left;

            largestArea = Math.max(largestArea, (minHeight * base));

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;            }
        }

        return largestArea;
    }
}