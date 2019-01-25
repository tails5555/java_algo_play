package net.hackerrank.sort;

import java.util.Arrays;
import java.util.Comparator;

// Hacker Rank Sorting 문제
// Comparator 문제 (개꿀문제)
class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        if(a.score < b.score) return 1;
        else if(a.score > b.score) return -1;
        else return a.name.compareTo(b.name);
    }
}

public class Example03 {
    public static void main(String[] args) {
        Player[] player = new Player[] {
            new Player("박재범", 45), new Player("Sik-K", 75), new Player("pH-1", 60), new Player("우디 고차일드", 45), new Player("HAON", 110), new Player("Gray", 119)
        };
        Checker checker = new Checker();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
