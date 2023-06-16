import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;

        String path ="c:"+separator+ "Users"+ separator + "Мирослав" +separator +
                "Desktop"+ separator + "input.txt";

        File file = new File(path);

        Scanner sc = new Scanner(file);

        String line = sc.nextLine();
        sc.close();
        double a = 0.0;
        double b = 0.0;
        char z = ' ';
        int m = 0;
        boolean is = true;
        for (String num : line.split(" ")) {
            m++;
            if (m == 1) {
                try {
                    a = Double.valueOf(num);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Not number\n");
                    is = false;
                    break;
                }
            }
            if (m == 3) {
                try {
                    b = Double.valueOf(num);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Not number\n");
                    is = false;
                    break;
                }
            }

        }
        if (is) {
            m = 0;
            for (String num : line.split(" ")) {
                m++;
                if (m == 2) {
                    try {
                        z = result(num, z);
                    } catch (Exception s) {
                        System.out.println("Operation Error!");
                        is = false;
                        break;
                    }
                }
            }
        }
        if (is) {
            switch (z) {
                case ('+'):
                    System.out.println(a + b);
                    break;
                case ('-'):
                    System.out.println(a - b);
                    break;
                case ('/'):
                    if (b == 0.0) {
                        System.out.println("Error! Division by zero");
                    } else {
                        System.out.println(a / b);
                    }
                    break;
                case ('*'):
                    System.out.println(a * b);
                    break;
            }
        }
    }


    public static char result(String nms,char z)throws Exception{
        if(nms.equals("/")||nms.equals("*")||nms.equals("+")||nms.equals("-")){
            z = nms.charAt(0);
            return z;
        }else {
            throw new Exception("OperationError");
        }
    }
}