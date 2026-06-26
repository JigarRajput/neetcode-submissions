// Jai Ganesh
static class Cell {
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[grid.length][grid[0].length];
        int lengthOfMaxIsland = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // we got island cell that is not visited
                if(grid[row][col] == 1 && visited[row][col] == 0) {
                    int lengthOfIsland = bfs(grid, visited, new Cell(row, col));
                    lengthOfMaxIsland = Math.max(lengthOfIsland, lengthOfMaxIsland);
                }
            }
        }

        return lengthOfMaxIsland;
    }

    // This method would traverse for cell 
    // neighbors and give the island length
    static int bfs(int[][] grid, int[][] visited, Cell cellToTraverse) {
        Queue<Cell> queue = new LinkedList<>();
        Cell[] neighbourDiff = {new Cell(0, -1), new Cell(-1, 0), new Cell(0, 1), new Cell(1, 0)};
        int length = 0;

        queue.offer(cellToTraverse);

        while(!queue.isEmpty()) {
            // traverse its four neighbours
            Cell cell = queue.poll();
            length++;
            visited[cell.row][cell.col] = 1;

            for(int ind = 0; ind < 4; ind++) {
                int neighbourRow = cell.row + neighbourDiff[ind].row;
                int neighbourCol = cell.col + neighbourDiff[ind].col;

                if(isValidCell(grid, neighbourRow, neighbourCol) && visited[neighbourRow][neighbourCol] == 0 && grid[neighbourRow][neighbourCol] == 1) {
                    queue.offer(new Cell(neighbourRow, neighbourCol));
                    visited[neighbourRow][neighbourCol] = 1;
                }
            }
        }

        return length;
    }

    static boolean isValidCell(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }

        return true;
    }
}
