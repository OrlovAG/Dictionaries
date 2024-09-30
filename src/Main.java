import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
       // example1();
       // example2();
       // example3();
        example4Suits();
    }

    private static void example4Suits() {

    }


    private static void example3() {
        //Прочитать строку от пользователя и подсчитать, сколько раз встречается каждое слово
        //нам нужна "таблица", в которой ключ - это слово, а значение - счетчик
        Map<String, Integer> table = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите строку");
        String line = scanner.nextLine();
        String[] massiv = line.split(" ");
        for (String s: massiv){
            int counter = table.getOrDefault(s, 0);
            table.put(s, 1+counter);
        }
        System.out.println("table = " + table);
    }



    private static void example2() {
        Map<String, String> slovar2 = new TreeMap<>();
        try(Scanner scanner = new Scanner(new File("slovar.txt"))){
            while (scanner.hasNext()){
                String s = scanner.nextLine();
                String[] massiv = s.split(" ");
                slovar2.put(massiv[0], massiv[1]);
            }            
        } catch (Exception e) {
            System.out.println("Все сломалось");
        }
        System.out.println("slovar2 = " + slovar2);
    }

    private static void example1() {
        Map<String, String> slovar1 = new TreeMap<>();
        slovar1.put("yes", "да");
        slovar1.put("no", "нет");
        slovar1.put("make", "делать");
        slovar1.put("show", "показать");
        slovar1.put("do", "делать");
        slovar1.put("show", "представление");
        System.out.println("slovar1 = " + slovar1); 
        //{do=делать, make=делать, no=нет, show=представление, yes=да}  значения могут повторяться, а ключ нет
        
        String x = "make";
        String y = slovar1.get(x);
        System.out.println("y = " + y);
        x = "developer";
        y = slovar1.get(x);
        System.out.println("y = " + y);
        
        y= slovar1.getOrDefault(x, "не могу перевести "+x);
        System.out.println("y = " + y);
    }
}