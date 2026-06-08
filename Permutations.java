import java.util.*;
class Permutations
{
    public List<List<Integer>> permute(int[] arr)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        boolean[] check = new boolean[arr.length];
        permutations(arr,check,a,ans);
        return ans;
    }
    private void permutations(int[] arr, boolean[] check, List<Integer> a, List<List<Integer>> ans)
    {
        int n = arr.length;
        if(a.size() == n)
        {
            List<Integer> copy = new ArrayList<>(a);
            ans.add(copy);
            return;
        }
        for(int i=0; i<n; i++)
        {
            if(!check[i])
            {
                a.add(arr[i]);
                check[i] = true;
                permutations(arr,check, a, ans);
                a.remove(a.size()-1);
                check[i] = false;
            }
        }
    }
}