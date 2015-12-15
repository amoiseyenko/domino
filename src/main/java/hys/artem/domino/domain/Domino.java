package hys.artem.domino.domain;

/**
 * Created by artem on 12/12/15.
 */
public class Domino {

    public static int DOMINO_COMBINATIONS = 7;
    private Integer id;
    private Integer first;
    private Integer second;

    public Domino() {
    }

    public Domino(Integer id, Integer first, Integer second) {
        this.id = id;
        this.first = first;
        this.second = second;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Boolean connects(Domino other){
         return this.first == other.getFirst() ||
                this.first == other.getSecond() ||
                this.second == other.getFirst() ||
                this.second == other.getSecond();
    }

    public void rotate(){
        System.out.print("Flip " + shortToString() +" -> ");
        int t = this.second;
        this.second = first;
        this.first= t;
        System.out.println(shortToString());
    }

    @Override
    public String toString() {
        return "Domino{id=" + id +
                ", first=" + first +
                ", second=" + second + '}';
    }

    public String shortToString(){
        return "["+first +":"+second +"]";
    }

}
