public class Kraljice{
    static int BR = 0;
    //pozicije kraljica su predstavljene matricom int[] w, gde je svaka pozicija matrice jedna koordinata, dok je druga koordinata vrednost na toj poziciji 
    public static boolean NemaDijaNapada(int w[], int n){
        for(int i = 0; i < n-1; i++){
            for(int j = i+1 ; j <n; j++){
                if(Math.abs(i - j) == Math.abs(w[i]-w[j])){ //uporedi da li mu ima ista dijagonalno 
                    return false; //jer NEMA dij. napada
                }
            }
        }
        return true;
    }
    static void ispisiMatricu(int[] w){
        System.out.print("[ ");
        for(int i =0; i < w.length; i++){
            System.out.print(w[i]);
        }
        System.out.println(" ]");
    }
    static void postaviPrvi(int[] w, int n){ //postavlja sve od 0-7
        for(int i = 0; i <n; i++){
            w[i] = i;
        }
    }
    static boolean poslednji(int[] w, int n){//provera da li je matrica u vrednostima od 7-0 (tj obrnuti)
        for(int i =0; i < n; i++){
            if(w[i] != n-1-i){
                return false;
            }
        }
        return true;
    }
    static void swap(int[] w, int a, int b){
        int pom = w[a];
        w[a] = w[b];
        w[b] = pom;
    }
    static boolean isEqualNiz(int[] a, int[] b){
        for(int i = 0; i < a.length(); i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    static boolean jeURes(int[][] res, int[] a){
        for(int i = 0; i < res.length() ; i++){
            if(res[i])
        }
    }
    static void sledeci(int[] w, int n){
        int i = n-2;
        while(w[i] > w[i+1]){ //smanjuje i dok ne nadje jedan koji je <= onome ispred sebe
            i--;
        }
        int j = i+1;
        int k = n-1;
        while(j<k){ //sve dok se ne mimoidju j i k, radi swapove
            swap(w,j,k);
            j++;
            k--;
        }
        j = i+1;
        while(w[i] > w[j]){ //nezavisno od gornje while petlje, trazi j dok w na poziciji i je <= od w na poz j, pa tog vrti
            j++;
        }
        swap(w,i,j);    
    }
    static void obradi(int[] w, int n){
        if(NemaDijaNapada(w, n)){
            BR++;
            System.out.print(BR + ": ");
            ispisiMatricu(w);
        }
    }
    public static void main(String[] args){
        int n = 8; //chessboard velicina
        int[] w = new int[n];
        postaviPrvi(w,n);
        obradi(w,n);
        while(!poslednji(w,n)){
           sledeci(w,n);
           obradi(w,n); 
       }
    }
}