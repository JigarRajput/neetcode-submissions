// Jai Ganesh
// Jai Ganesh

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int total = rows * cols;

        int left = 0, top = 0, bottom = rows-1, right = cols-1;

        int counted = 0;
        List<Integer> spiral = new ArrayList<>();

        while(counted < total) {
            // top row visit
            for(int col = left; col <= right; col++) {
                spiral.add(matrix[top][col]);
                counted++;
            }

            top++;

            if(counted >= total) break;

            // right col visit
            for(int tuple = top; tuple<=bottom; tuple++) {
                spiral.add(matrix[tuple][right]);
                counted++;
            }

            right--;

            if(counted >= total) break;

            // bottom row visit
                for(int col = right; col >= left; col--) {
                spiral.add(matrix[bottom][col]);
                counted++;
            }

            bottom--;

            if(counted >= total) break;

            //first col visit
            for(int tuple = bottom; tuple>=top; tuple--) {
                spiral.add(matrix[tuple][left]);
                counted++;
            }

            left++;
        }

        return spiral;
    }
}