class Solution {
    public String reversePrefix(String word, char ch) {
        //pointer variables
        int left = 0;
        int right = word.indexOf(ch);

        StringBuilder stringBuilder = new StringBuilder(word);

        while (left < right) {
            char temp = stringBuilder.charAt(left);
            stringBuilder.setCharAt(left, stringBuilder.charAt(right));
            stringBuilder.setCharAt(right, temp);
            left++;
            right--;
        }
        return stringBuilder.toString();
    }
}