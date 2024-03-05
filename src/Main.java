import classes.Vetor;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception{


        Vetor vetorProdutos;

        Integer tamanhoVetor = determinarTamanhoVetor();

        vetorProdutos = new Vetor(tamanhoVetor);

        limparTerminal();

        scanner.close();

    }

    public static void limparTerminal(){
        System.out.print("\033[H\033[2J");
        return;
    }

    public static Integer determinarTamanhoVetor(){

        Integer tamanhoVetor = null;
        while (tamanhoVetor == null){ // Determinar o tamanho do vetor
            try{

                System.out.println("\nInforme o tamanho da lista de produtos: ");
                tamanhoVetor = scanner.nextInt();

                if(tamanhoVetor <= 0){
                    throw new Exception("Tamanho inválido do vetor");
                }

            } catch (Exception e){
                tamanhoVetor = null;
                e.printStackTrace();
            }
        }
        return tamanhoVetor;
    }
}