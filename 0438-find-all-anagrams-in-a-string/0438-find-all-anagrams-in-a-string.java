class Solution {
    
    private boolean isCountSame(int[] countS, int[] countP) {
        for (int i = 0; i<countS.length; i++) {
            if (countS[i] != countP[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        //result index list
        List<Integer> anagramIndex = new ArrayList<>();

        //if string s is shorter than string p
        if (s.length() < p.length()) {
            return anagramIndex;
        }

        //array to store the count of every character in both the strings
        int[] countS = new int[26];
        int[] countP = new int[26];

        //traversing till the length of string P in both the strings
        for (int i = 0; i<p.length(); i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }

        //compare both the arrays to check for the first occurence of anagram i.e. at index 0
        if (isCountSame(countS, countP)) {
            anagramIndex.add(0);
        }

        //check for the other occurence of the characters in the string s and slide the window one by one
        //window size is of the length of string p
        for (int i = p.length(); i<s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countS[s.charAt(i - p.length()) - 'a']--;
            if (isCountSame(countS, countP)) {
                anagramIndex.add(i - p.length() + 1);
            }
        }

        return anagramIndex;
    }
}