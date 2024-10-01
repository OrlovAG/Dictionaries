import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

                example5CardsForCars();
    }

    private static void example5ForCars() {
    }


    private static void example5CardsForCars() {
        Map<String, Cars> cardMap1 = new HashMap<>();
        cardMap1.put("Вячеслав", new Cars("Corolla", 2011, "black"));
        cardMap1.put("Коля", new Cars("Civic", 2014, "yellow"));
        cardMap1.put("Маша", new Cars("HiLux", 2021, "red"));
        cardMap1.put("Даша", new Cars("Mini", 2019, "white"));


        System.out.println("cardMap1 = " + cardMap1);

    }
}