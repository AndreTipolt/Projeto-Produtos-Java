import classes.Produto;
import classes.Vetor;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private static Vetor vetorProdutos;
    public static void main(String[] args) throws Exception{


        Integer tamanhoVetor = determinarTamanhoVetor();
        vetorProdutos = new Vetor(tamanhoVetor);

        while (true){
            Integer opcaoUsuario = opcaoUsuario();

            if(opcaoUsuario == -1){
                break;
            }

            if(opcaoUsuario == 0) adicionarProduto();
            else if (opcaoUsuario == 1) listarProdutos();
            else if (opcaoUsuario == 2) excluirProduto();
        }
    }

    public static void limparTerminal(){
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }

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

    public static Integer opcaoUsuario(){
        Integer opcaoUsuario = null;
        while (opcaoUsuario == null){
            try{
                System.out.println("[-1 -> Sair]");
                System.out.println("[ 0 -> Adicionar um produto]");
                System.out.println("[ 1 -> Listar produtos]");
                System.out.println("[ 2 -> Excluir produto]");
                System.out.println("\nO que você deseja fazer: ");

                opcaoUsuario = scanner.nextInt();

                if(opcaoUsuario < -1 || opcaoUsuario > 4){ // Validar se esta dentro das opções
                    throw new Exception("Opção inválida");
                }

            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return opcaoUsuario;
    }

    public static void adicionarProduto(){

        while (true){

            System.out.println("Adicionar Produto");

            try{

                System.out.println("\nDigite o nome do produto:");
                String nomeProduto = scanner.next();

                System.out.println("\nDigite o preço do produto: (use vírgula [,] ao invés de [.])");
                Double preco = scanner.nextDouble();

                System.out.println("\nDigite a categoria do produto:");
                String categoria = scanner.next();

                if(nomeProduto.equals(" ") || nomeProduto.equals("")){
                    throw new Exception("Nome do produto não pode ser vazio");
                }

                if(categoria.equals(" ") || categoria.equals("")){
                    throw new Exception("Categoria não pode ser vazia");
                }

                Produto novoProduto = new Produto(nomeProduto, preco, categoria);

                vetorProdutos.adiciona(novoProduto);
                break;

            } catch(Exception e){

                e.printStackTrace();
            }
        }
        return;
    }

    public static void listarProdutos(){

        String toStringVetorProdutos = vetorProdutos.toString();

        if(toStringVetorProdutos.equals("[]")){
            System.out.println("\nNão existem produtos cadastrados até o momento");
            return;
        }

        System.out.println(toStringVetorProdutos);
        return;
    }

    public static void excluirProduto(){



        while (true){
            System.out.println("\nDigite o indíce do produto que deseja exlcuir: ");
            Integer indiceProduto = scanner.nextInt();

            try {

                vetorProdutos.remove(indiceProduto);
            } catch (Exception e){

                e.printStackTrace();
            }
        }
    }
}