package buscasbinarias;

import javax.swing.JOptionPane;

public class BuscasBinarias {

    public static void main(String[] args) {
        new BuscasBinarias(); 
    }

    public BuscasBinarias() {  
        double vetex[] = {-30, 1, 6, 8, 9, 12, 34, 41, 67, 78, 92};
        System.out.println("8 encontrado na posição " + busca(vetex, 8));
        System.out.println("34 encontrado na posição " + busca(vetex, 34));
        System.out.println("67 encontrado na posição " + busca(vetex, 67));
        System.out.println("9 encontrado na posição " + busca(vetex, 9));
        System.out.println("15 encontrado na posição " + busca(vetex, 15));
      System.out.println("==================================================");
        String paisesA[] = {"Ucrânia", "Turquia", "Suíça", "México", "França", "Espanha",
            "Chile", "Brasil", "Argentina"};
        String paisesB[] = {"Argentina", "Brasil", "Chile", "Dinamarca", "Espanha", "França",
            "Inglaterra", "Turquia", "Uruguai"};
        String paisesC[] = {"Canadá", "Áustria", "Chile", "Itália", "Portugal", "Grécia",
            "Angola", "Moçambique", "Rússia"};

        String x = JOptionPane.showInputDialog("Digite o país que deseja encontrar");
        int indice = buscaBinariaEmListaCrescente(paisesB, x);
        System.out.println(indice);
        JOptionPane.showMessageDialog(null, x + " encontrado na posição " + indice);
        String y = JOptionPane.showInputDialog("Digite o país que deseja encontrar");
        int indice1 = buscaBinariaEmListaDecrescente(paisesA, y);
        System.out.println(indice1);
        JOptionPane.showMessageDialog(null, y + " encontrado na posição " + indice1);
        String z = JOptionPane.showInputDialog("Digite o país que deseja encontrar");
        int indice2 = buscaSequencial(paisesC, z);
        JOptionPane.showMessageDialog(null, z + " encontrado na posição " + indice2);
        

    }

    public int buscaBinariaEmListaCrescente(String paises[], String x) {
        int inicio, fim, centro; 
        inicio = 0;
        fim = paises.length - 1;  
        while (inicio <= fim) {
            centro = (inicio + fim) / 2;
            if (x.compareToIgnoreCase(paises[centro]) == 0) { 
                return centro;
            } else if (x.compareToIgnoreCase(paises[centro]) > 0) {  
                inicio = centro + 1;
            } else if (x.compareToIgnoreCase(paises[centro]) < 0) {  
                fim = centro - 1;
            }
        }
        return -1;  
    }

    public int buscaBinariaEmListaDecrescente(String paises[], String y) {
        int inicio, fim, centro; 
        inicio = 0;
        fim = paises.length - 1;  
        while (inicio <= fim) {
            centro = (inicio + fim) / 2;
            if (y.compareToIgnoreCase(paises[centro]) == 0) { 
                return centro;
            } else if (y.compareToIgnoreCase(paises[centro]) < 0) {  
                inicio = centro + 1;
            } else if (y.compareToIgnoreCase(paises[centro]) > 0) {  
                fim = centro - 1;
            }
        }
        return -1;
    }

    public int buscaSequencial(String paises[], String z) {
        int cont = 0;
        int i = 0;
        int fim = paises.length - 1;
        while (z.compareToIgnoreCase(paises[i]) != 0) {
            i++;
            cont++;
            if (i < fim && z.compareToIgnoreCase(paises[i]) == 0) {
                
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
  

    public int busca(double vetor[], double chave) {
        return buscaBinaria(vetor, 0, vetor.length - 1, chave);
    }

    private int buscaBinaria(double vetor[], int inf, int sup, double chave) {  // função recursiva    
        if (inf > sup) return -1;  //não foi encontrado o valor buscado (chave)
        int centro = (inf + sup) / 2;
        if (chave == vetor[centro]) {
              return centro;  //encontramos o valor procurado (chave) na posição centro
        } else if (chave < vetor[centro]) {
              return buscaBinaria(vetor, inf, centro - 1, chave);  //buscamos a chave no trecho inferior
        } else {
              return buscaBinaria(vetor, centro + 1, sup, chave);  //buscamos a chave no trecho superior
        }
    }

}
