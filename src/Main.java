import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       // example1();
       // example2();
       // example3();
       // example4Suits();
       // example5CardsForPlayers();
        example6PlayersForCards();
    }

    private static void example6PlayersForCards() {
        Map<PlayingCard, String> cardMap2 = new HashMap<>();
        cardMap2.put( new PlayingCard("трефы", "дама"), "Вячеслав Т");
        cardMap2.put( new PlayingCard("бубны", "король"), "Юлия");
        cardMap2.put( new PlayingCard("пики", "8"), "Дмитрий");

        System.out.println("cardMap2 = " + cardMap2);
        PlayingCard cardX = new PlayingCard("бубны", "король");
        String nameY = cardMap2.get(cardX);

        System.out.println("nameY = " + nameY);

        Map<PlayingCard, String> cardMap3 = new TreeMap<>();
        cardMap3.put( new PlayingCard("трефы", "8"), "Алексей");
        cardMap3.put(new PlayingCard("червы", "8"), "Антон");
        System.out.println("cardMap3 = " + cardMap3);
        cardMap3.put( new PlayingCard("червы", "3"), "Андрей");
        cardMap3.putAll(cardMap2);
        System.out.println("cardMap3 = " + cardMap3);
    }

    private static void example5CardsForPlayers() {
        Map<String, PlayingCard> cardMap1 = new HashMap<>();
        cardMap1.put("Вячеслав Т", new PlayingCard("трефы", "дама"));
        cardMap1.put("Дмитрий", new PlayingCard("пики", "8"));
        cardMap1.put("Вячеслав", new PlayingCard("трефы", "9"));
        cardMap1.put("Алексей", new PlayingCard("трефы", "8"));
        cardMap1.put("Юлия", new PlayingCard("бубны", "король"));
        cardMap1.put("Анатолий", new PlayingCard("червы", "валет"));
        cardMap1.put("Антон", new PlayingCard("червы", "8"));
        cardMap1.put("Андрей", new PlayingCard("червы", "3"));
        cardMap1.put("Фёдор", new PlayingCard("бубны", "8"));

        System.out.println("cardMap1 = " + cardMap1);
        String name1="Андрей";
        String name2 = "Дмитрий";
        System.out.println("карта "+name1+" это " + cardMap1.get(name1));
        System.out.println("карта "+name2+" это " + cardMap1.get(name2));

        //Найти имя игрока с бубновым  королем
        PlayingCard cardX = new PlayingCard("бубны", "король");
        for (Map.Entry<String, PlayingCard> player: cardMap1.entrySet())     {
            //if (player.getValue().equals( cardX))
            if (player.getValue().getSuit() == cardX.getSuit() &&
                player.getValue().getRank() == cardX.getRank())
                    System.out.println("ура, мы нашли игрока "+player.getKey());
        }
        System.out.println(cardMap1.containsValue(cardX));

        for (Map.Entry<String, PlayingCard> player: cardMap1.entrySet()){
            System.out.println("player = " + player.getKey() + " hash = "+player.getKey().hashCode());
        }
    }

    private static void example4Suits() {
        //Подсчитаем, сколько в руке карт каждой масти
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("черви", "дама"));
        hand.add(new PlayingCard("пики", "дама"));
        hand.add(new PlayingCard("черви", "десятка"));
        hand.add(new PlayingCard("трефы", "дама"));
        hand.add(new PlayingCard("черви", "туз"));
        hand.add(new PlayingCard("пики", "двойка"));
        hand.add(new PlayingCard("бубны", "двойка"));
        
        Map<String, Integer> table2 = new TreeMap<>();
        for (PlayingCard card: hand){
            String x = card.getSuit();
            int counter = table2.getOrDefault(x, 0);
            table2.put(x, 1+counter);
        }

        System.out.println("table2 = " + table2);
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