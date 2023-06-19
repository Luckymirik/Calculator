import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String separator = File.separator;

        String path ="c:"+separator+ "Users"+ separator + "Мирослав" +separator +
                "Desktop"+ separator + "input.txt";
        String path2 = "c:"+separator+ "Users"+ separator + "Мирослав" +separator +
                "Desktop"+ separator + "output.txt";

        File file = new File(path);
        File file2 = new File(path2);

        Scanner sc = new Scanner(file);
        FileWriter fw = new FileWriter(file2,false);

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
                    fw.write("Error! Not number\n");
                    fw.flush();
                    return;
                }
            }
            if (m == 3) {
                try {
                    b = Double.valueOf(num);
                } catch (NumberFormatException e) {
                    fw.write("Error! Not number\n");
                    fw.flush();
                    return;
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
                        fw.write("Operation Error!");
                        fw.flush();
                        return;
                    }
                }
            }
        }
        if (is) {
            switch (z) {
                case ('+') -> {
                    fw.write(String.valueOf((a + b)));
                    fw.flush();

                }
                case ('-') -> {
                    fw.write(String.valueOf((a - b)));
                    fw.flush();

                }
                case ('/') -> {
                    if (b == 0.0) {
                        fw.write("Error! Division by zero");
                        fw.flush();

                    } else {
                        fw.write(String.valueOf (a / b));
                        fw.flush();

                    }
                }
                case ('*') -> fw.write(String.valueOf (a * b));
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