//checking if given input sting is balanced or not
import java.util.*;
class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('||ch == '{'|| ch== '['){
                s.push(ch);
            }

            if(ch==')'||ch == '}'|| ch== ']'){
                if(!s.empty()){
                    char x = s.pop();
                    switch(x){
                        case '(':
                            if(ch!=')'){
                                System.out.println(false);
                                return;
                            }
                            break;
                        case '{':
                            if(ch!='}'){
                                System.out.println(false);
                                return;
                            }
                            break;
                        case '[':
                            if(ch!=']'){
                                System.out.println(false);
                                return;
                            }
                            break;
                        default:
                            System.out.println(false);
                            break;
                    }
                }else{
                    System.out.println(false);
                    return;
                }

            }

        }
        if(s.size() == 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}