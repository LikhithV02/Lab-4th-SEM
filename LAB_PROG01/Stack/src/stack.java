import java.util.ArrayList;
import java.util.Scanner;

public class stack {
    ArrayList<Integer> stack;
    int top = -1;

    public stack(){
        this.stack = new ArrayList<Integer>();
        this.top = -1;
    }

    public void push(Integer val){
        this.top++;
        this.stack.add(val);
    }

    public Integer pop(){
        if(this.top < 0){
            return null;
        }
        Integer item = this.stack.get(this.top);
        this.stack.remove(this.top--);
        return  item;
    }

    public void display(){
        System.out.println(stack);
    }

    public static void main(String[] args){
        stack s = new stack();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("1. Push\n2. Pop\n3. Display\n0. Exit\nEnter Choice: ");
            int choice = in.nextInt();
            int val = 0;
            switch (choice) {
                case 1:
                    System.out.print(" Enter integer value to push: ");
                    val = in.nextInt();
                    s.push(val);
                    break;
                case 2:
                    Integer value = s.pop();
                    if (value == null) {
                        System.out.println("Stack empty");
                    } else {
                        System.out.println("Popped value = " + value);
                    }
                    break;
                case 3:
                    System.out.println("Stack contents are:");
                    s.display();
                    break;
                case 0:
                    in.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice entered");
                    break;
            }
        }
    }
}
