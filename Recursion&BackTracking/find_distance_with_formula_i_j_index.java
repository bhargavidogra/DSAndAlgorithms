//Given a 2d matrix with value 0 and -1. mat[i][j] == -1 is boundary pixel. Calculate the minimum distance of each node mat[i][j] from nearest boundary pixel.
//        e.g:-
//        0 0 0 0 0 0 0 0 0
//        0 0 -1 -1 0 0 0 0
//        0 -1 0 0 -1 -1 0 0
//        0 0 -1 0 0 0 -1 0 0
//        0 -1 0 0 0 -1 0 0 0
//        0 0 -1 -1 -1 0 0 0 0
//        0 0 0 0 0 0 0 0 0
//
//        Distance is calculated as |x1-x2| + |y1-y2|
//        mat[i][j] =
//        0 0 0
//        0 -1 0
//        0 0 0
//        Output:
//        mat[i][j]
//        2 1 2
//        1 0 1
//        2 1 2


import java.util.ArrayDeque;

class Scratch {
    public static void main(String[] args) {
        // Example 1
//        int matrix1[][] = new int[][]{
//                {-1, 0, 0},
//                {0, 0, -1},
//                {0, -1, 0}
//        };
//        minimumDistance(matrix1);
        // Example 2
//        int matrix2[][] = new int[][]{
//                {0, 0, 0},
//                {0, 0, 0},
//                {-1, 0, -1}
//        };
//        minimumDistance(matrix2);

        int matrix3[][] = new int[][]{
                {0 ,0 ,0},
                {0, -1, 0},
                {0 ,0 ,0}
        };
        minimumDistance(matrix3);
    }

    static class Coordinates{
        int i;
        int j;
        Coordinates(int i,int j){
            this.i= i;
            this.j= j;
        }
    }

    public static void minimumDistance(int mat[][]){
        int n = mat.length;;
        int m =mat[0].length;
        int ans[][]= new int[n][m];

        ArrayDeque<Coordinates> q = new ArrayDeque<Coordinates>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==-1){
                    q.add(new Coordinates(i,j));
                }
            }
        }
        Coordinates rcp = q.peek();
        ans[rcp.i][rcp.j]=0;
        while(q.size()>0){
            Coordinates rc = q.remove();


            //top
            int tci=rc.i-1;
            int tcj= rc.j;

            if((tci>=0 && tci<n) &&(tcj>=0 && tcj<m) && mat[tci][tcj]==0){
                ans[tci][tcj]=ans[rc.i][rc.j]+ Math.abs(tci-rc.i)+Math.abs(tcj- rc.j);
                mat[tci][tcj]=1;
                q.add(new Coordinates(tci,tcj));
            }
            //right
            int rci=rc.i;
            int rcj= rc.j+1;
            if((rci>=0 && rci<n) &&(rcj>=0 && rcj<m) && mat[rci][rcj]==0){
                ans[rci][rcj]=ans[rc.i][rc.j]+  Math.abs(rci-rc.i)+Math.abs(rcj- rc.j);
                mat[rci][rcj]=1;
                q.add(new Coordinates(rci,rcj));
            }

            //bottom
            int bci=rc.i+1;
            int bcj= rc.j;
            if((bci>=0 && bci<n) &&(bcj>=0 && bcj<m) && mat[bci][bcj]==0){
                ans[bci][bcj]=ans[rc.i][rc.j]+  Math.abs(bci-rc.i)+Math.abs(bcj- rc.j);
                mat[bci][bcj]=1;
                q.add(new Coordinates(bci,bcj));
            }

            //left
            int lci=rc.i;
            int lcj= rc.j-1;
            if((lci>=0 && lci<n) &&(lcj>=0 && lcj<m) && mat[lci][lcj]==0){
                ans[lci][lcj]=ans[rc.i][rc.j]+  Math.abs(lci-rc.i)+Math.abs(lcj- rc.j);
                mat[lci][lcj]=1;
                q.add(new Coordinates(lci,lcj));
            }
        }

        print(ans);

    }
    public static void print(int ans[][]){
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }


}