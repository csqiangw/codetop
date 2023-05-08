/**
 * 只要抓到一个点，它是1并且没有被访问过，那么岛屿数量一定加1，剩下只需要将它周围的点都置true，代表它们是一个岛即可
 */
public class _18_岛屿数量 {

    public boolean[][] visited;

    public void dfs(char[][] grid,int i,int j){
        visited[i][j] = true;
        if(i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]){
            dfs(grid,i - 1,j);
        }
        if(j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]){
            dfs(grid,i,j - 1);
        }
        if(i + 1 < grid.length && grid[i + 1][j] == '1' && !visited[i + 1][j]){
            dfs(grid,i + 1,j);
        }
        if(j + 1 < grid[0].length && grid[i][j + 1] == '1' && !visited[i][j + 1]){
            dfs(grid,i,j + 1);
        }
    }

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

}
