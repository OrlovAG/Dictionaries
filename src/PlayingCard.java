import java.util.Objects;

public class PlayingCard implements Comparable<PlayingCard>{
   private String suit;    //масть
   private String rank;    //достоинство

    public PlayingCard(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCard that = (PlayingCard) o;
        return Objects.equals(suit, that.suit) && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
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


    @Override
    public int compareTo(PlayingCard other) {
        if(this.rank.equals(other.rank))
            return this.suit.compareTo(other.suit);
        if(this.rank.equals("туз"))  return 1;
        if(other.rank.equals("туз")) return -1;
        if(this.rank.equals("король"))  return 1;
        if(other.rank.equals("король")) return -1;
        if(this.rank.equals("дама"))  return 1;
        if(other.rank.equals("дама")) return -1;
        if(this.rank.equals("валет"))  return 1;
        if(other.rank.equals("валет")) return -1;
        if(this.rank.equals("10"))  return 1;
        if(other.rank.equals("10")) return -1;

        return this.rank.compareTo(other.rank);
    }
}
