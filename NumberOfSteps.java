public class NumberOfSteps {

    public static void main(String[] args) {
         int ans = numberofSteps(36, 0);
         System.out.println(ans);

    }

    private static int numberofSteps(int i, int count) {
        if(i == 0) return count;
        if(i%2==0) {
           return numberofSteps(i/2, count+1);
        } else {
           return numberofSteps(i-1, count+1);
        }
    }
    
}
