package Strings;

public class DicePermutations {

    public static void main(String[] args) {
        int target = 10;
        dicePermutations("", target);
    }

    private static void dicePermutations(String ans, int target) {
        if(target == 0) {
            System.out.println(ans);
            return;
        }
        for(int i = 1; i <= 6 && i <= target; i++) {
            dicePermutations(ans+i, target-i);
        }

    }
    
}
