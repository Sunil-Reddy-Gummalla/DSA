class Solution{
    public static void main(String[] args) {
        int[] B =  {15,4,2};
        int[] A = {6, 4, 1};
        int ans = MaxMoney(10, B,A );
        System.out.println(ans);
    }


    public static int MaxMoney(int M,int []B,int []A)
    {
        int max = 0;
        for(int i =0; i< B.length; i++) {
            if(B[i] < A[i]) {
                int temp = (M/B[i]) * A[i];
                if(temp > max) {
                    max = temp;
                }
            }
        }
        
        return max != 0 ? max : M;
    }
}
