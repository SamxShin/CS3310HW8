public class SumOfSubsets {
    public static int w[] = {0,5,6,10,11,16};
    public static int W = 21;
    public static boolean include[] = new boolean[10];
    public static boolean found = false;

    public static void main(String[] args){
        SumOfSubsets sb = new SumOfSubsets();
        sb.sum_of_subsets(0,0,48);
    }
    private void sum_of_subsets(int i, int weight, int total){
        if(promising(i, weight, total) && !found){
            if(weight == W){
                found = true;
                printDigits();
            } else{
                include[i+1] = true;
                sum_of_subsets(i+1, weight + w[i+1], total - w[i+1]);
                include[i+1] = false;
                sum_of_subsets(i+1, weight, total-w[i+1]);
            }
        }
    }
    private void printDigits(){
        for(int i = 0; i < w.length; i++){
            if(include[i])
                System.out.println(w[i]);
        }
    }
    boolean promising(int i, int weight, int total){
        return(weight+total>=W) && (weight == W || weight + w[i+1] <= W);
    }
}
