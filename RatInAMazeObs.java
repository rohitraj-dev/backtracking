import java.util.ArrayList;
class RatInAMazeObs
{
    public ArrayList<String> ratInMaze(int[][] maze)
    {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        paths(0,0,n-1,n-1, visited,"",maze,ans);
        return ans;
    }
    public static void paths(int r, int c, int er, int ec, boolean[][] visited, String s, int[][] maze, ArrayList<String> ans)
    {
        if(r>er || c>ec || r<0 || c<0 || maze[r][c]==0 || visited[r][c])
            return;
        visited[r][c] = true;
        if(r==er && c==ec)
        {
            ans.add(s);
            visited[r][c] = false;
            return;
        }
        paths(r,c-1,er,ec,visited,s+'L',maze,ans);
        paths(r-1,c,er,ec,visited,s+'U',maze,ans);
        paths(r,c+1,er,ec,visited,s+'R',maze,ans);
        paths(r+1,c,er,ec,visited,s+'D',maze,ans);
        visited[r][c] = false;
    }
}