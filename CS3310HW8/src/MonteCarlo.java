//samuel Shin

import java.util.Random;

public class MonteCarlo {
    public static int MAX = 8;
    public static int[] col = new int[MAX + 1];
    public static Random rd = new Random();

    public static int estimateNQueens(int n){
        int i = 0, j, m = 1;
        int numNodes = 1;
        int mprod = 1;
        int random;

        while(m != 0 && i != n){
            mprod = mprod * m;
            numNodes =numNodes + mprod * n;
            i++;
            m = 0;
            int prom_children[] = new int [MAX + 1];
            for(j = 1; j <= n; j++){
                col[i] = j;
                if(promising(i)){
                    m++;
                    prom_children[j] = 1;
                }
            }
            if(m != 0){
                while(true){
                    random = (Math.abs(rd.nextInt()) % MAX) + 1;
                    if(prom_children[random] == 1) {
                        j = random;
                        break;
                    }
                }
                col[i] = j;
            }
        }
        return numNodes;
    }
    public static boolean promising(int i){
        int k = 1;
        boolean Switch = true;
        while(k < i && Switch){
            if(col[i] == col[k] || Math.abs(col[i] - col[k]) == i-k)
                Switch = false;
            k++;
        }
        return Switch;
    }
    public static void main(String[] args){
        int ret = 0, tot = 0;

        for(int i = 0; i < 20; i++){
            ret = estimateNQueens(8);
            tot += ret;
            System.out.printf("\tseq[%d]: numNodes = %d\n", i, ret);
        }
        System.out.printf("\ttot = %d\tavg = %d\n", tot, tot/20);
    }
}
