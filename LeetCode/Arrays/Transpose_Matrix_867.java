class Solution {
    public int[][] transpose(int[][] matrix) {

        // Case 1: Square Matrix, in-place transpose
        if (matrix.length == matrix[0].length) {
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = i + 1; j < matrix[0].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return matrix;
        }

        // Case 2: Rectangular Matrix, new result array
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) result[j][i] = matrix[i][j];
        }
        return result;
    }
}