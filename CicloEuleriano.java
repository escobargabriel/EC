import java.io.*; 
import java.util.*; 


public class CicloEuleriano {
    public static int n = 7;
    public static int[][] grafo = new int[n][n];
    public static int somaArestas[];
    public static int linhas, colunas, verticeInicial, pegaColuna, vInicial;
    public static boolean paridade = false;
    public static String mostraCiclo = "O Caminho Euleriano eh: ";


    public static void main(String[] args) {
 


    	grafo[0][0]=0;
		grafo[0][1]=1;
		grafo[0][2]=0;
		grafo[0][3]=1;
		grafo[0][4]=0;
        grafo[0][5]=0; 		

		grafo[1][0]=1;
		grafo[1][1]=0;
		grafo[1][2]=1;
		grafo[1][3]=1;
		grafo[1][4]=1;
        grafo[1][5]=1;
		
		grafo[2][0]=0;
		grafo[2][1]=1;
		grafo[2][2]=0;
		grafo[2][3]=1;
		grafo[2][4]=0;
		grafo[2][5]=0;

		grafo[3][0]=1;
		grafo[3][1]=1;
		grafo[3][2]=1;
		grafo[3][3]=0;
		grafo[3][4]=1;
        grafo[3][5]=1;
		
		grafo[4][0]=0;
		grafo[4][1]=1;
		grafo[4][2]=0;
		grafo[4][3]=1;
		grafo[4][4]=0;
        grafo[4][5]=0;	

        grafo[5][0]=0;
		grafo[5][1]=1;
		grafo[5][2]=0;
		grafo[5][3]=1;
		grafo[5][4]=0;
        grafo[5][5]=0;
        
        paridade = verificaParidadeVertices();

        if (paridade == true) {
            verificaGrafoEuleriano();
        } else {
            System.out.println("O grafo nao possui o Ciclo Euleriano!");
        }
     }
   
    public static  boolean verificaParidadeVertices() {
        linhas = grafo.length;

        colunas = linhas;

        somaArestas = new int[linhas];
        int l, c;

        for (l = 0; l < linhas; l++) {
            for (c = 0; c < colunas; c++) {
                somaArestas[l] += grafo[l][c];
            }
            if (somaArestas[l] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static int contaArestas(int verticeInicial) {

        int numArestas = 0;

        for (int c = 0; c < colunas; c++) {
            numArestas += grafo[verticeInicial][c];
        }
        return numArestas;
    }


    public static int totalOcorrencias() {

        int total = 0, l, c;
        for (l = 0; l < linhas; l++) {
            for (c = 0; c < colunas; c++) {
                total += grafo[l][c];
            }
        }
        return total;
    }

    
    public static void verificaGrafoEuleriano() {

        for (int l = 0; l < n; l++) {

            for (int i = 0; i < n; i++) {

                if (grafo[verticeInicial][i] == 1) {

                    pegaColuna = i;
                    
                   
                    if(pegaColuna==vInicial){

                    	if(totalOcorrencias()==2){

                    		pegaColuna=pegaColuna;
                    	}else{

                    		for(int k=0;k<linhas;k++){
                    			if(grafo[verticeInicial][k]==1 && k!=vInicial){
                    				pegaColuna=k;
                    				break;
                    			}
                    		}
                    	}
                    }
                   
                    if(contaArestas(pegaColuna)==2 && grafo[pegaColuna][vInicial]==1){

                    	if(totalOcorrencias()==2){
                    		pegaColuna=pegaColuna;
                    	}else{

                    		for(int k=0;k<linhas;k++){
                    			if(grafo[verticeInicial][k]==1 && k!=pegaColuna){
                    				pegaColuna=k;
                    				break;
                    			}
                    		}
                    		
                    	}
                    }
             
                    grafo[verticeInicial][pegaColuna] = 0;

                    System.out.println("aresta removida  " + verticeInicial + "-" + pegaColuna);

                    grafo[pegaColuna][verticeInicial] = 0;

                    mostraCiclo += "{" + verticeInicial + "," + pegaColuna + "}";
              
                    verticeInicial = pegaColuna;

                }
            }
        }
        if(totalOcorrencias()==0){
        System.out.println(mostraCiclo);
        }else{
        	System.out.println("O grafo eh desconexo");
        }
    }
}

