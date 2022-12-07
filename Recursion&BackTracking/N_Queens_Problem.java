//Place N queens on chess board of size n suh that they do not cross/kill each other , i.e
//not to be placed in same row, column or diagnoal.

//      Input:

//      4

//      Output:

//        0-1 , 1-3 , 2-0 , 3-2 ,
//        0100
//        0001
//        1000
//        0010
//
//        0-2 , 1-0 , 2-3 , 3-1 ,
//        0010
//        1000
//        0001
//        0100



import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int chess[][] = new int[n][n];
        printQueens(chess, "" , 0 );
        System.out.println("count_ways: "+count_ways);
    }
    public static int count_ways=0;
    public  static void printchessboard(int chess[][]){
        for(int i=0;i< chess.length;i++){
            for(int j=0;j<chess[0].length;j++){
                System.out.print(chess[i][j]);
            }
            System.out.println();
        }
    }

    public  static  void  printQueens(int chess[][], String qsf, int row){
        if(row==chess.length){
            System.out.println(qsf);
//            printchessboard(chess);
            count_ways++;
            return;
        }

        for(int col=0;col<chess.length;col++) {
            if(isSafe(chess,row,col)) {
                chess[row][col] = 1;
                printQueens(chess, qsf + row + "-" + col + " , ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean isSafe(int chess[][], int row, int col){

        for(int i=row-1,j=col;i>=0;i--){
            if(chess[i][j]==1){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--, j--){
            if(chess[i][j]==1){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--, j++){
            if(chess[i][j]==1){
                return false;
            }
        }

        return true;
    }
}