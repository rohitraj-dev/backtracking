class NQueens
{
    public static void main(String[] args)
    {
        int n = 5;
        char[][] chessBoard = new char[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                chessBoard[i][j] = 'X';
            }
        }
        nQueens(0,chessBoard);
    }
    private static void nQueens(int row, char[][] chessBoard)
    {
        int n = chessBoard.length;
        if(row==n)
        {
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(chessBoard[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int col=0; col<n; col++)
        {
            if(canQueenBePlaced(row,col,chessBoard))
            {
                chessBoard[row][col] = 'Q';
                nQueens(row+1, chessBoard);
                chessBoard[row][col] = 'X';
            }
        }
    }
    private static boolean canQueenBePlaced(int row, int col, char[][] chessBoard)
    {
        int n = chessBoard.length;
        int i = row-1;
        while(i>=0)
        {
            if(chessBoard[i][col] == 'Q')
                return false;
            i--;
        }
        i = row-1;
        int j = col-1;
        while(i>=0 && j>=0)
        {
            if(chessBoard[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = row-1;
        j = col+1;
        while(i>=0 && j<n)
        {
            if(chessBoard[i][col] == 'Q')
                return false;
            i--;
            j++;
        }
        return true;
    }
}