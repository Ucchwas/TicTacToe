import java.util.*;

public class TicTacToe {

    static String winOrDraw(String[][] board){

        int n = board.length;
        List<String> match = new ArrayList<>();
        for(int i=0;i<n;i++){
            String cur = "";
            for(int j=0;j<n;j++){
                cur += board[i][j];
            }
            match.add(cur);
        }

        for(int i=0;i<n;i++){
            String cur_str = "";
            for(int j=0;j<n;j++){
                cur_str += board[j][i];
            }
            match.add(cur_str);
        }

        String cur_str = "";
        for(int i=0;i<n;i++){
            cur_str += board[i][i];
        }
        match.add(cur_str);

        cur_str = "";
        for(int i=n-1;i>=0;i--){
            cur_str += board[i][n-i-1];
        }
        match.add(cur_str);

        //System.out.println(match);
        String x = "";
        String o = "";
        for(int i=0;i<n;i++){
            x += "X";
            o += "Y";
        }
        for(int i=0;i<match.size();i++){
            if(match.contains(x))
                return "X";
            else if(match.contains(o))
                return "O";
        }
        String flag = "d";
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j].equals("#")){
                    flag = "nd";
                    break;
                }
            }
        }
        if(flag.equals("d"))
            return "Draw";
        return null;
    }

    static void printBoard(String[][] board)
    {
        int n = board.length;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        while(true) {
            n = sc.nextInt();
            if(n > 0)
                break;
            System.out.println("Enter Positive Number");
        }
        String[][] board = new String[n][n];
        String player = "X";
        String pl = null;

        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = String.valueOf("#");
            }
        }
        //System.out.println("hello");
        printBoard(board);
        Set<String> visited = new HashSet<>();
        while(pl == null){
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(row >= n || col >= n){
                System.out.println("Enter position from 0 to n");
                continue;
            }
            String inp = String.valueOf(row)+String.valueOf(col);
            if(!visited.contains(inp)){
                visited.add(inp);
                board[row][col] = player;
                pl = winOrDraw(board);
                if(player.equals("X"))
                    player = "O";
                else
                    player ="X";
                printBoard(board);
            }
            else{
                pl = null;
                System.out.println("Give input in blank position");
            }
        }
        System.out.println("Winner is:" +pl);
    }
}
