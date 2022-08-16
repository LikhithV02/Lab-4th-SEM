import java.util.Scanner;

/**
 * Write a Java class called Customer to store their name and date_of_birth.
 * The date_of_birth format should be dd/mm/yyyy.
 * Write methods to read customer data as <name dd/mm/yyyy> and
 * display as <name, dd, mm, yyyy> considering the delimiter character as “/”.
 */


public class Customer {
    private String name;
    private String dob;
    public static final int[] daysimonth = {
            // insert values here
            31,29,31,30,31,30,31,31,30,31,30,31
    };

    public Customer(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public void display() {
        String[] arrdob = this.dob.split("/");
//insert code here
        System.out.println("Name: " + this.name);
        System.out.println("DOB: " + arrdob[0] + "/" + arrdob[1] + "/" + arrdob[2]);
        return;
    }

    public static boolean validate(String dob) {
        String[] arr = dob.split("/");
        if (arr.length != 3) {
            return false;
        }
        int day = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);

        if(month == 2 && day == 29) {
            if (year % 400 == 0) {
                return true;
            }
            if (year % 100 == 0) {
                return false;
            }
            if (year % 4 == 0) {
                return true;
            }
            return false;
        }
        if(month > 12){
            return false;
        }
        if(day > daysimonth[month-1]){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in;
        String name;
        String dob;
        String arrdob;
        Customer customer;

        // Replace the following five lines to read data from command line
        in = new Scanner(System.in);
        System.out.print("Enter Name: ");
        name = in.nextLine();
        System.out.print("Enter DoB (dd/mm/yyyy): ");
        arrdob = in.nextLine();

        if (validate(arrdob)) {
            customer = new Customer(name, arrdob);
            customer.display();
        } else {
            System.out.println("Invalid date :" + arrdob);
        }
    }
}
