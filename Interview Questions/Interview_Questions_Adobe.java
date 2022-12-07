//Interview Questions - Adobe
// 1)Find the greatest element to its right
// 2)Maximum Sum Subarry
// 3)Given a binary tree and two nodes find there common ancestral/Parent node which is nearet  to both given nodes


import java.util.*;

class Scratch {


    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int d, TreeNode l,TreeNode r){
            this.data = d;
            this.left=l;
            this.right=r;
        }
    }


    public static ArrayList<Integer> RoottoNodePath(TreeNode root, int value ){

        if(root==null){
            return new ArrayList<Integer>();
        }
        if(root.data == value){
            ArrayList<Integer> barr = new ArrayList<Integer>();
            barr.add(root.data);
            return barr;
        }

        ArrayList<Integer> ll = RoottoNodePath(root.left, value);
        if(ll.size()>0){
            ll.add(root.data);
            return  ll;
        }

        ArrayList<Integer> rl = RoottoNodePath(root.right, value);
        if(rl.size()>0){
            ll.add(root.data);
            return  rl;
        }

        return new ArrayList<Integer>();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
       // int res[]= neg_ele(arr);

        int result = maxsubarraysum(arr);
        System.out.println(result);
//        for(int i:res){
//            System.out.println(i);
//        }
    }

   public static int[] neg_ele(int arr[]){
        int n = arr.length;

        int res[]= new int[n];
        res[n-1]=-1;
       int omax = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>omax){
                omax =arr[i];
                res[i]=-1;
            }else {
                res[i] = omax;
            }
        }
        return res;
   }

   public static int maxsubarraysum(int arr[]){
        int n = arr.length;
        int omax=Integer.MIN_VALUE;
        int curr_sum=0;
        for(int i=0;i<n;i++){
            if(curr_sum>=0){
                curr_sum+=arr[i];
            }else{
                curr_sum=arr[i];
            }
            omax = Math.max(omax,curr_sum);
        }
        return omax;
   }

}



//[10,2,3,6,1,3,7]
//[-1,7,7 7,7,7,-1]


//[1,2,3,4,5,-1,2,8,9]



      1
  2        3
4  5     6   7
       9 10


9 - 1>3>6>9
7 - 1>3>7











