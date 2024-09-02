class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        /*
            logic:
            1. traverse through the matrix
            2. swap the elements in each row
            3. invert each element while swaping using the XOR
        */

        int columns = image.length;
        int rows = image[0].length;

        //traverse
        for (int i = 0; i<columns; i++) {
            for (int j = 0; j<(rows + 1)/2; j++) {
                //two pointers
                int left = j;
                int right = rows - j - 1;

                //swap and invert using XOR
                int temp = image[i][left] ^ 1;
                image[i][left] = image[i][right] ^ 1;
                image[i][right] = temp;
            }
        }

        return image;
    }
}