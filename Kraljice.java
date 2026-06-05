public class Kraljice{
    static int BR = 0;
    //pozicije kraljica su predstavljene matricom int[] w, gde je svaka pozicija matrice jedna koordinata, dok je druga koordinata vrednost na toj poziciji 
    public static boolean NemaDijaNapada(int w[], int n){
        for(int i = 0; i < n; i++){
            for(int j = 0 ; i <n; j++){
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
    static void sledeci(int[] w, int n){
        
    }
    public static void main(String[] args){
        int n = 8; //chessboard velicina
        int[] w = new int[n];
        postaviPrvi(w,n);
        ispisiMatricu(w);
        //obradi(w,n);
        while(!poslednji(w,n)){
           // sledeci(w,n);
          //  obradi(w,n);
       }
    }
}