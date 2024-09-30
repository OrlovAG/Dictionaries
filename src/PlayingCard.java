public class PlayingCard {
   private String suit;    //масть
   private String rank;    //достоинство

    public PlayingCard(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "suit='" + suit + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}
