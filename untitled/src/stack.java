/*import java.lang.*;
import java.util.*;

public class stack {
    ArrayList<Integer> stack;
    int top;

    public stack(){
        this.stack = new ArrayList<Integer>(10);
        this.top = -1;
    }

    public void push(int val){
        if(this.top < 9) {
            this.top++;
            this.stack.add(val);
            return;
        }
        System.out.println("Stack Overflow!!!");
    }

    public int pop(){
        if(this.top < 0){
            System.out.println("Stack Underflow!!!");
            return Integer.MIN_VALUE;
        }
        Integer item = this.stack.get(this.top);
        this.stack.remove(this.top--);
        return  item;
    }

    public void display(){

        System.out.println(stack);
    }

    public static void choice(int ch, stack s){
        Scanner in = new Scanner(System.in);
        int val = 0;
        switch (ch) {
            case 1 -> {
                System.out.print("Enter integer value to push: ");
                val = in.nextInt();
                s.push(val);
            }
            case 2 -> {
                Integer value = s.pop();
            }
            case 3 -> {
                System.out.println("Elements in Stack are:");
                s.display();
            }
            case 0 -> System.exit(0);
            default -> System.out.println("Invalid choice entered");
        }
    }

    public static void main(String[] args){
        stack s = new stack();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("1. Push\n2. Pop\n3. Display\n0. Exit\nEnter Choice: ");
            int ch = in.nextInt();
            choice(ch, s);
        }
    }
}
*/


import java.util.Scanner;
class Stack
{
    int top;
    int maxsize = 10;
    int[] arr = new int[maxsize];


    boolean isEmpty()
    {
        return (top < 0);
    }
    Stack()
    {
        top = -1;
    }
    boolean push (Scanner sc)
    {
        if(top == maxsize-1)
        {
            System.out.println("Overflow !!");
            return false;
        }
        else
        {
            System.out.println("Enter Value");
            int val = sc.nextInt();
            top++;
            arr[top]=val;
            System.out.println("Item pushed");
            return true;
        }
    }
    boolean pop ()
    {
        if (top == -1)
        {
            System.out.println("Underflow !!");
            return false;
        }
        else
        {
            top --;
            System.out.println("Item popped");
            return true;
        }
    }
    void display ()
    {
        System.out.println("Printing stack elements .....");
        for(int i = top; i>=0;i--)
        {
            System.out.println(arr[i]);
        }
    }
}
public class stack {
    public static void main(String[] args) {
        int choice=0;
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        System.out.println("****Stack operations using array****\n");
        System.out.println("\n------------------------------------------------\n");
        while(choice != 4)
        {
            System.out.println("\nChose one from the below options...\n");
            System.out.println("\n1.Push\n2.Pop\n3.Show\n4.Exit");
            System.out.println("\n Enter your choice \n");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                {
                    s.push(sc);
                    break;
                }
                case 2:
                {
                    s.pop();
                    break;
                }
                case 3:
                {
                    s.display();
                    break;
                }
                case 4:
                {
                    System.out.println("Exiting....");
                    System.exit(0);
                    break;
                }
                default:
                {
                    System.out.println("Please Enter valid choice ");
                }
            };
        }
    }
}