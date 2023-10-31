package application;

import br.com.cej.dao.ProdutoDAO;
import br.com.cej.model.Produto;
import br.com.cej.screen.menu_screen;

import java.text.DecimalFormat;
import java.util.Scanner;

import java.sql.Connection;
import static db.DB.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = getConnection();

        new menu_screen();

        int opc = 0;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Deletar produto");
            System.out.println("0 - Sair");
            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();

            switch (opc){
                case 1:
                    System.out.println("Digite a descrição do produto:");
                    String descricao = sc.next();
                    System.out.println("Digite a unidade de medida do produto:");
                    String unidadeMedida = sc.next();
                    System.out.println("Digite a quantidade mínima do produto:");
                    Integer quantidadeMinimaEstoque = sc.nextInt();
                    System.out.println("Digite o preço de compra do produto:");
                    String aux = sc.next();
                    Double precoCompra = Double.parseDouble(aux.replace(",", "."));
                    System.out.println("Digite o preço de venda do produto:");
                    aux = sc.next();
                    Double precoVenda = Double.parseDouble(aux.replace(",", "."));

                    Produto produto = new Produto(descricao, unidadeMedida, quantidadeMinimaEstoque, precoCompra, precoVenda);
                    ProdutoDAO produtoDAO = new ProdutoDAO();

                    produtoDAO.Save(produto, connection);
                    break;
                case 2:
                    ProdutoDAO produtoDAO2 = new ProdutoDAO();
                    produtoDAO2.Read(connection);
                    break;
                case 3:
                    System.out.println("Digite o id do produto que deseja atualizar:");
                    Integer id = sc.nextInt();
                    System.out.println("Digite a descrição do produto:");
                    String descricao2 = sc.next();
                    System.out.println("Digite a unidade de medida do produto:");
                    String unidadeMedida2 = sc.next();
                    System.out.println("Digite a quantidade mínima do produto:");
                    Integer quantidadeMinimaEstoque2 = sc.nextInt();
                    System.out.println("Digite o preço de compra do produto:");
                    aux = sc.next();
                    Double precoCompra2 = Double.parseDouble(aux.replace(",", "."));
                    System.out.println("Digite o preço de venda do produto:");
                    aux = sc.next();
                    Double precoVenda2 = Double.parseDouble(aux.replace(",", "."));

                    Produto produto2 = new Produto(id, descricao2, unidadeMedida2, quantidadeMinimaEstoque2, precoCompra2, precoVenda2);
                    ProdutoDAO produtoDAO3 = new ProdutoDAO();

                    produtoDAO3.Update(produto2, connection);
                    break;
                case 4:
                    System.out.println("Digite o id do produto que deseja deletar:");
                    Integer id2 = sc.nextInt();

                    ProdutoDAO produtoDAO4 = new ProdutoDAO();

                    produtoDAO4.Delete(id2, connection);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        }while (opc != 0);


    }
}
