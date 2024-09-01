class Solution {
    public String reverseWords(String s) {
        /*
            logic:
            1. convert the string into a string array
            2. traverse through the array
            3. reverse the array element by using the string builder
            4. add the reversed element into a string builder
            5. return the string builder by converting it to the string
        */

        //split the string
        String[] words = s.split(" ");

        //length of the array
        int arrayLength = words.length;

        //string builder to store the reversed element
        StringBuilder reversedString = new StringBuilder("");

        //traversing through the loop
        for (int i = 0; i<arrayLength; i++) {
            StringBuilder word = new StringBuilder(words[i]);

            word = word.reverse();

            reversedString.append(word);

            //put the space at same place
            if (i != (arrayLength - 1)) {
                reversedString.append(" ");
            }
        }

        return reversedString.toString();
    }
}