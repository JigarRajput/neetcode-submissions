// Jai Ganesh
class Solution {
    public void rotate(int[][] matrix) {
        // vertical flip

        int start = 0;
        int end = matrix.length - 1;

        while(start < end) {
            for(int col = 0; col <matrix.length; col++) {
                int temp = matrix[start][col];
                matrix[start][col] = matrix[end][col];
                matrix[end][col] = temp;
            }
            start++;
            end--;
        }
        
        // transpose
        for(int row = 0; row < matrix.length - 1; row++) {
            for(int col = row + 1; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}
