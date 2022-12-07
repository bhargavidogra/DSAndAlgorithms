class Scratch {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        String st= sc.next();
        int ans= palindromeIndex(st);
        System.out.println(ans);
    }


    static boolean isPalidrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) !=  s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static int palindromeIndex(String s)
    {
        int l = s.length();
        int start=0,end=l-1;
        int res=-1;
        while(start<end){
            char sc =s.charAt(start);
            char ec =s.charAt(end);
            if(sc!=ec){
                if (isPalidrom(s,start,end-1)) {
                    res= end;
                }else{
                    res=start;
                }
                break;
            }
            start++;
            end--;
        }

        return res;

    }
}