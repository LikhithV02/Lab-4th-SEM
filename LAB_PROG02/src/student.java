import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads data from file. First line contains number of entries N
 * Each of N lines contains 4 values separated by comma(,)
 * The program reads the data from the files, stores them in ArrayList and prints
 */

public class student {
    private String usn;
    private String name;
    private String branch;
    private String phone;

    // constructor
    public student(String usn, String name, String branch, String phone) {
        this.usn = usn;
        this.name = name;
        this.branch = branch;
        this.phone = phone;
    }

    public void display() {
        System.out.print("USN: " + this.usn + ", ");
        System.out.print("Name: " + this.name + ", ");
        System.out.print("Branch: " + this.branch + ", ");
        System.out.println("Phone:" + this.phone);
    }

    public static void main(String[] args) throws FileNotFoundException {
        // data filename is the argument
        ArrayList<student> students = new ArrayList<student>();
        String filename;
        if (args.length == 0) {
            Scanner in = new Scanner(System.in);
            System.out.println(("Enter input file"));
            filename = in.next();
        } else {
            filename = args[0];
        }
        System.out.println(filename);
        File infile = new File(filename);
        Scanner in = new Scanner(infile);
        int cnt = Integer.parseInt(in.nextLine()); // get number of records
        System.out.println("Total record: " + cnt);
        //String temp = in.nextLine();
        for(int a=0; a < cnt ;a++){
            if (a > cnt) {
                System.out.println("Input records =" + a + ", greater than " + cnt);
                System.exit(-1);
            }
        }
        for (int i = 0; i < cnt; i++) {
            if (!in.hasNext()) {
                System.out.println("Input records =" + i + ", less than " + cnt);
                System.exit(-1);
            }
            String line = in.nextLine(); // read one record at a time
            String[] arr = line.split(",");
            long a;
            if (arr.length < 4) {
                System.out.println("Insufficient input " + line);
                continue;
                //System.exit(-1);
            }

            students.add(new student(arr[0], arr[1], arr[2], arr[3]));
        }
        // all records are read. Display these
        for (student s : students) {
            s.display();
        }
    }
}
