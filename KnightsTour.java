import java.util.*;
class KnightsTour
{
    static boolean flag;
    public ArrayList<ArrayList<Integer>> knightTour(int n)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            ArrayList<Integer> a = new ArrayList<>();
            for(int j=0; j<n; j++)
            {
                a.add(-1);
            }
            ans.add(a);
        }
        flag = false;
        horse(0,0,0,ans);
        if(!flag)
        {
            ans = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            b.add(-1);
            ans.add(b);
        }
        return ans;
    }
    private void horse(int num, int row, int col, ArrayList<ArrayList<Integer>> ans)
    {
        int n = ans.size();
        if(row<0 || col<0 || row>=n || col>=n)
            return;
        ans.get(row).set(col,num);
        if(num == n*n-1)
        {
            flag = true;
            return;
        }
        horse(num+1,row-2,col-1,ans);
        horse(num+1,row-2,col+1,ans);
        horse(num+1,row+2,col-1,ans);
        horse(num+1,row+2,col+1,ans);
        horse(num+1,row-1,col+2,ans);
        horse(num+1,row+1,col+2,ans);
        horse(num+1,row-1,col-2,ans);
        horse(num+1,row+1,col-2,ans);

        if(!flag)
            ans.get(row).set(col,-1);
    }
}