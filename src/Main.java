import classes.Produto;
import classes.Vetor;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private static Vetor vetorProdutos;

    public static void main(String[] args) throws Exception{


        Integer tamanhoVetor = determinarTamanhoVetor();
        vetorProdutos = new Vetor(tamanhoVetor); // Determina o tamanho do vetor e instanciando ele

        while (true){
            Integer opcaoUsuario = opcaoUsuario(); // Usuario pode digitar um nuymero de -1 até 5

            if(opcaoUsuario == -1){ // Ele quer sair da execução
                break;
            }

            if(opcaoUsuario == 0) adicionarProduto();
            else if (opcaoUsuario == 1) listarProdutos();
            else if (opcaoUsuario == 2) excluirProduto();
            else if (opcaoUsuario == 3) buscarProduto();
            else if (opcaoUsuario == 4) exibirTamanho();
            else if (opcaoUsuario == 5) adicionarNoInicioDoVetor();
        }
    }

    public static Integer determinarTamanhoVetor(){

        Integer tamanhoVetor;
        while (true){ // Determinar o tamanho do vetor
            try{

                System.out.println("\nInforme o tamanho da lista de produtos: ");
                tamanhoVetor = scanner.nextInt();

                if(tamanhoVetor <= 0){
                    throw new Exception("Tamanho inválido do vetor");
                }
                break;

            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return tamanhoVetor;
    }

    public static Integer opcaoUsuario(){
        Integer opcaoUsuario = null;
        while (opcaoUsuario == null){
            try{
                System.out.println("\n[-1 -> Sair]");
                System.out.println("[ 0 -> Adicionar um produto]");
                System.out.println("[ 1 -> Listar produtos]");
                System.out.println("[ 2 -> Excluir produto]");
                System.out.println("[ 3 -> Buscar um produto]");
                System.out.println("[ 4 -> Exibir tamanho do vetor]");
                System.out.println("[ 5 -> Adicionar no inicio do vetor]");
                System.out.println("\nO que você deseja fazer: ");

                opcaoUsuario = scanner.nextInt();

                if(opcaoUsuario < -1 || opcaoUsuario > 5){ // Validar se esta dentro das opções
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
            System.out.println("\nDigite o indíce do produto que deseja excluir: ");
            Integer indiceProduto = scanner.nextInt();

            try {

                Produto produtoAExcluir;

                try{

                    produtoAExcluir = (Produto) vetorProdutos.busca(indiceProduto);
                } catch (Exception e){

                    e.printStackTrace();
                    continue; // Caso não exista o produto ele vai perguntar novamente um novo indice
                }

                System.out.println("\n[0 -> Não quero escolher outro produto], [1 -> Quero excluir esse produto]");
                System.out.println("\n" + produtoAExcluir); // Mostra de qual produto ele quer remover

                System.out.println("Deseja excLuir esse produto:");
                Integer flagExcluirProduto = scanner.nextInt();

                if(flagExcluirProduto == 1) {

                    vetorProdutos.remove(indiceProduto);
                    System.out.println("\nProduto excluido com sucesso");
                    break;
                }

            } catch (Exception e){

                e.printStackTrace();
            }
        }
        return;
    }

    public static void buscarProduto(){

        while (true){
            System.out.println("\nDigite o indíce do produto que deseja buscar: ");
            Integer indiceProduto = scanner.nextInt();

            try {

                Produto produto = (Produto) vetorProdutos.busca(indiceProduto);
                System.out.println(produto);
                break;
            } catch (Exception e){

                e.printStackTrace();
            }
        }
        return;
    }

    public static void exibirTamanho(){
        System.out.println("\nO tamanho do vetor atual é de " + vetorProdutos.tamanho() + " elementos");
    }

    public static void adicionarNoInicioDoVetor(){

        while (true){

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

                System.out.println("\nEm qual posição você quer colocar nesse vetor: ");
                Integer posicaoVetor = scanner.nextInt();

                vetorProdutos.adicionaInicio(posicaoVetor, novoProduto);
                break;
            } catch (Exception e){
                e.printStackTrace();
                continue;
            }

        }
        return;
    }


}