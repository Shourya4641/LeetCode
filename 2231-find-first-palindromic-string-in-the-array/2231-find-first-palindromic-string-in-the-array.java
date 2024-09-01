class Solution {
    public String firstPalindrome(String[] words) {
        /*
            loigc:
            1. traverse the array
            2. check if both end characters of each string are same or not
            3. if not return false
        */

        //traverse the array
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}