import java.util.Random;
import java.util.Scanner;

public class ShipFight {
    static void ChooseRandomPoint(int[][] board){
        Random rnd = new Random();
        int x=rnd.nextInt(6);
        int y=rnd.nextInt(6);
        board[x][y]=1;
        //Gemi konumu belirlendi
    }
    static void Shoot(int[][] board){
        int x,y;
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter X to shoot:");
        x=sc.nextInt();
        System.out.print("Enter Y to shoot:");
        y=sc.nextInt();
        if(board[x][y]==1){
            board[x][y]=2;
            System.out.println("Shot landed!");
        }
    }
    static boolean Check(int[][] board){
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==2)return true;
            }
        }
        return false;
    }
    static void PrintBoard(int[][] board){
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] player1=new int[6][6];
        int[][] player2=new int[6][6];
        ChooseRandomPoint(player1);
        ChooseRandomPoint(player2);
        while(true){
            System.out.println("Player 1's turn\nBoard:");
            PrintBoard(player1);
            Shoot(player2);
            if(Check(player2)){
                System.out.print("Player 1 Won!");
                break;
            }
            System.out.println("Player 2's Turn\nBoard:");
            PrintBoard(player2);
            Shoot(player1);
            if(Check(player1)){
                System.out.print("Player 2 Won!");
                break;
            }
        }
    }
}
