class Solution {
    public int lengthOfLongestSubstring(String s) {
        // length of the string
        int stringLength = s.length();

        //pointers
        int left = 0;
        int right = 0;

        //store the ma length of the substring
        int maxLength = 0;

        //hashmap to store the unique characters
        HashMap<Character, Integer> characterMap = new HashMap<>();

        //traverse through the string
        for (right = 0; right<stringLength; right++) {
            //check if the element is unique
            if (!characterMap.containsKey(s.charAt(right)) || characterMap.get(s.charAt(right)) < left) {
                characterMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, (right - left + 1));
            } else {
                //get the left pointer to the element next to the repeating element
                left = characterMap.get(s.charAt(right)) + 1;
                characterMap.put(s.charAt(right), right);
            }
        }
        return maxLength;
    }
}