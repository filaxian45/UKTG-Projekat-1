public class Kraljice{
    /*
    dalji koraci,
    4/7 transformacija (laki deo)
    poredjenje
    dodati da ubacuje u rez ako nijedan od tih nije vec u njemu
    */
    static int BR = 0;
    //pozicije kraljica su predstavljene matricom int[] w, gde je svaka pozicija matrice jedna koordinata, dok je druga koordinata vrednost na toj poziciji 
    public static boolean NemaDijaNapada(int[] w, int n){
        for(int i = 0; i < n-1; i++){
            for(int j = i+1 ; j <n; j++){
                if(Math.abs(i - j) == Math.abs(w[i]-w[j])){ //uporedi da li mu ima ista dijagonalno 
                    return false; //jer NEMA dij. napada
                }
            }
        }
        return true;
    }
    public static void ispisiMatricu(int[][] w, int n){
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n;j++){
                System.out.print(w[i][j] + " ");
            }
            System.out.println("");
        }
    }
    //[ 04763125 ]
    private static int[][] transform1D2D(int[] w, int n){//pretvara 1d niz u 2d niz
        int[][] nov = new int[n][n];
        for(int i = 0; i< n;i++){
            nov[i][w[i]] = w[i]+1; //dodato da bi 0 se mogla naci u 2d -> 1d
        }
        return nov;
    }
    private static int[] transform2D1D(int[][] w, int n){//pretvra 2d niz u 1d niz
        int[] nov = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <n; j++){
                if(w[i][j] != 0){
                    nov[i] = j; //prvobitno je bilo w[i][j] -1, sto je dovodilo 
                }
            }
        } 
        return nov;
    }
    private static int[] rot90(int[] w){
        int n = w.length;
        int temp;
        int[][] nov = transform1D2D(w, n);
        for(int i = 0; i <n; i++){ //transponovanje matrice
            for(int j = i; j<n;j++){
                temp = nov[j][i];
                nov[j][i] = nov[i][j];
                nov[i][j] = temp;
            }
        }
        for(int k = 0; k < n;k++){ // nakon transponovanja, obrcu se redovi
            for(int l = 0; l < n/2;l++){
                temp = nov[k][l];
                nov[k][l] = nov[k][n-1-l];
                nov[k][n-1-l] = temp;
            }
        }
        int[] output = transform2D1D(nov, n);
        return output;
    }
    private static int[] rot180(int[] w){
        int n = w.length;
        int temp;
        int[][] nov = transform1D2D(w, n);
        for(int k = 0; k < n;k++){ //obrcu se redovi
            for(int l = 0; l < n/2;l++){
                temp = nov[k][l];
                nov[k][l] = nov[k][n-1-l];
                nov[k][n-1-l] = temp;
            }
        }
        for(int i = 0;i<n;i++){//obrcu se kolone
            for(int j =0; j<n/2;j++){
                temp = nov[j][i];
                nov[j][i] = nov[n-j-1][i];
                nov[n-j-1][i] = temp;
            }
        }
        int[] output = transform2D1D(nov, n);
        return output;
    }
    private static int[] rot270(int[] w){
        int n = w.length;
        int temp;
        int[][] nov = transform1D2D(w, n);
        for(int i = 0; i <n; i++){ //transponovanje matrice
            for(int j = i; j<n;j++){
                temp = nov[j][i];
                nov[j][i] = nov[i][j];
                nov[i][j] = temp;
            }
        }
        for(int i = 0;i<n;i++){//obrcu se kolone
            for(int j =0; j<n/2;j++){
                temp = nov[j][i];
                nov[j][i] = nov[n-j-1][i];
                nov[n-j-1][i] = temp;
            }
        }
        int[] output = transform2D1D(nov, n);
        return output;
    }
    private static int[] flipV(int[] w){
        int n = w.length;
        int temp;
        int[][] nov = transform1D2D(w, n);
        for(int i = 0;i<n;i++){//obrcu se kolone
            for(int j =0; j<n/2;j++){
                temp = nov[j][i];
                nov[j][i] = nov[n-j-1][i];
                nov[n-j-1][i] = temp;
            }
        }
        int[] output = transform2D1D(nov, n);
        return output;
    }
    private static int[] flipH(int[] w){
        int n = w.length;
        int temp;
        int[][] nov = transform1D2D(w, n);
        for(int k = 0; k < n;k++){ //obrcu se redovi
            for(int l = 0; l < n/2;l++){
                temp = nov[k][l];
                nov[k][l] = nov[k][n-1-l];
                nov[k][n-1-l] = temp;
            }
        }
        int[] output = transform2D1D(nov, n);
        return output;
    }
    private static int[] flipMainD(int[] w){
         int n = w.length;
        int temp;
        int[][] nov = transform1D2D(w, n);
        for(int i = 0; i <n; i++){ //transponovanje matrice, time se obrce ono sto je iznad Gl. diagonale i ono sto je ispod
            for(int j = i; j<n;j++){
                temp = nov[j][i];
                nov[j][i] = nov[i][j];
                nov[i][j] = temp;
            }
        }
        int[] output = transform2D1D(nov, n);
        return output;
    }
    private static int[] flipSecD(int[] w){
         int n = w.length;
        int temp;
        int[][] nov = transform1D2D(w, n);
        for(int i = 0; i <n; i++){ //transponovanje matrice, time se obrce ono sto je iznad Spor. diagonale i ono sto je ispod
            for(int j = 0; j<n-1-i;j++){
                temp = nov[i][j];
                nov[i][j] = nov[n-1-j][n-1-i]; //stavljeno ovako zato sto ce n-1-i/j dati obrnuto od i/j trenutno u odnosu na Spor. dia, ide [i][j] sa [n-1-j][n-1-i] isto kao ij sa ji
                nov[n-1-j][n-1-i] = temp;
            }
        }
        int[] output = transform2D1D(nov, n);
        return output;
    }
    static void ispisiNiz(int[] w){
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
    static boolean poslednji(int[] w, int n){//provera da li je matrica u vrednostima od 7-0 (tj obrnuto od pocetnog)
        for(int i =0; i < n; i++){
            if(w[i] != n-1-i){
                return false;
            }
        }
        return true;
    }
    static void swap(int[] w, int a, int b){//what you see is what you get
        int pom = w[a]; 
        w[a] = w[b];
        w[b] = pom;
    }
    private static boolean isEqualNiz(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    private static boolean obradaIs(int[][] res, int[] a){ //WIP, nema funkcionalnost za proveru izomorfnost
        for(int i = 0; i < res.length ; i++){
            if(res[i] != null){
                if(isEqualNiz(a,rot90(res[i]))){  
                    return false;
                }
                if(isEqualNiz(a,rot180(res[i]))){ 
                    return false;
                }
                if(isEqualNiz(a,rot270(res[i]))){   
                    return false;
                }
                if(isEqualNiz(a,flipH(res[i]))){
                    return false;
                }
                if(isEqualNiz(a,flipV(res[i]))){
                    return false;
                }
                if(isEqualNiz(a, flipMainD(res[i]))){
                    return false;
                }
                if(isEqualNiz(a, flipSecD(res[i]))){ 
                    return false;
                }
                if(isEqualNiz(a, res[i])){  
                    return false;
                }
            }
        }
        return true;
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
    static void obradi(int[] w, int n, int[][] res){
        if(NemaDijaNapada(w, n)){
            if(obradaIs(res,w)){
                res[BR] = w.clone();
                BR++;
                System.out.print(BR + ": ");
                ispisiNiz(w);
                
            }
        }
    }
    public static void main(String[] args){
        int n = 8; //chessboard velicina
        int[][] rez = new int[100][];
        int[] w = new int[n];
        postaviPrvi(w,n);
        obradi(w,n,rez);
        while(!poslednji(w,n)){
            sledeci(w,n);
            obradi(w,n,rez); 
      }
    }
}