// A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.
//
//        A basic queue has the following operations:
//
//        Enqueue: add a new element to the end of the queue.
//        Dequeue: remove the element from the front of the queue and return it.
//        In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:
//
//        1 x: Enqueue element  into the end of the queue.
//        2: Dequeue the element at the front of the queue.
//        3: Print the element at the front of the queue.
//
//        Sample Input
//
//        STDIN   Function
//        -----   --------
//        10      q = 10 (number of queries)
//        1 42    1st query, enqueue 42
//        2       dequeue front element
//        1 14    enqueue 42
//        3       print the front element
//        1 28    enqueue 28
//        3       print the front element
//        1 60    enqueue 60
//        1 78    enqueue 78
//        2       dequeue front element
//        2       dequeue front element
//
//        Sample Output
//
//        14
//        14

import java.io.*;
import java.util.*;

 class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        int fe=0;
        for(int i=0;i<q;i++){
            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    int ele= sc.nextInt();
                    if(s1.size()==0){
                        fe=ele;
                    }
                    s1.push(ele);
                    break;
                case 2:
                    if(s2.size()==0 && s1.size()!=0)
                        moveeleto2ndstack(s1,s2);
                    s2.pop();
                    break;
                case 3:
                    if(s2.size()==0)
                        System.out.println(fe);
                    else{
                        System.out.println(s2.peek());
                    }
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }

    public static void moveeleto2ndstack(Stack<Integer> s1, Stack<Integer> s2){
        while(s1.size()>0){
            s2.push(s1.pop());
        }
    }
}
