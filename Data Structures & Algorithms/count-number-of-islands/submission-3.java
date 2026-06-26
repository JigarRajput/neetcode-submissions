// Jai Ganesh
class Solution {
   static class Cell {
        int row;
        int col;

        public Cell(int r, int c) {
            row = r;
            col = c;
        }
    }
    static boolean isValid(int row, int col, char[][] grid) {
        if(row < grid.length && 
           col < grid[0].length && 
           row >= 0 && col >= 0) {
            return true;
        }

        return false;
    }

    static void bfsTraverse(char[][] grid, char[][] vis, int row, int col) {

        Queue<Cell> que = new LinkedList<Cell>();

        que.offer(new Cell(row, col));

        int[] drow = {0, -1, 0, 1};
        int[] dcol = {-1, 0, 1, 0};
        
        while(!que.isEmpty()) {
            Cell cell = que.poll();
            int r = cell.row;
            int c = cell.col;

            vis[r][c] = 'y';
            
            for(int ind = 0; ind < 4; ind++) {
                int newR = r + drow[ind];
                int newC = c + dcol[ind];

                if(isValid(newR, newC, grid) && vis[newR][newC] != 'y') {
                    // System.out.println("Adding cell "+newR + " "+newC);
                    que.offer(new Cell(newR, newC));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        char[][] vis = new char[grid.length][grid[0].length];
        int islands = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == '1' && vis[r][c] != 'y') {
                    islands++;
                    bfsTraverse(grid, vis, r, c);
                }
            }
        }
        return islands;
    }
}
