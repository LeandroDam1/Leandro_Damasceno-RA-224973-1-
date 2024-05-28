import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex04_DepositoProduto {
    private static final int CAPACIDADE_MAXIMA = 10;

    static class Produto {
        private int codProduto;
        private String descricao;
        private String dataEntrada;
        private String ufOrigem;
        private String ufDestino;

        public Produto(int codProduto, String descricao, String dataEntrada, String ufOrigem, String ufDestino) {
            this.codProduto = codProduto;
            this.descricao = descricao;
            this.dataEntrada = dataEntrada;
            this.ufOrigem = ufOrigem;
            this.ufDestino = ufDestino;
        }

        public String toString() {
            return "Código: " + codProduto + ", Descrição: " + descricao + ", Data de Entrada: " + dataEntrada + ", UF de Origem: " + ufOrigem + ", UF de Destino: " + ufDestino;
        }
    }

    public static void main(String[] args) {
        Queue<Produto> fila = new LinkedList<>();
        Stack<Produto> pilha = new Stack<>();

        while (true) {
            String opcao = JOptionPane.showInputDialog("1. Adicionar o produto na fila\n2. Despachar o produto da pilha\n3. Sair");

            switch (opcao) {
                case "1":
                    int codProduto = Integer.parseInt(JOptionPane.showInputDialog("Código do produto:"));
                    String descricao = JOptionPane.showInputDialog("Descrição do produto:");
                    String dataEntrada = JOptionPane.showInputDialog("Data de entrada do produto:");
                    String ufOrigem = JOptionPane.showInputDialog("UF de origem do produto:");
                    String ufDestino = JOptionPane.showInputDialog("UF de destino do produto:");

                    Produto novoProduto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                    fila.offer(novoProduto);

                    String filaProdutos = "Produtos na fila:\n";
                    for (Produto produto : fila) {
                        filaProdutos += produto + "\n";
                    }
                    JOptionPane.showMessageDialog(null, filaProdutos);
                    break;

                case "2":
                    if (pilha.size() == CAPACIDADE_MAXIMA) {
                        JOptionPane.showMessageDialog(null, "A pilha está cheia. Não é possível adicionar mais produtos.");
                    } else if (fila.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "A fila está vazia. Não tem produto para ser despachado.");
                    } else {
                        Produto produtoDespacho = fila.poll();
                        pilha.push(produtoDespacho);
                        JOptionPane.showMessageDialog(null, "Produto foi despachado: " + produtoDespacho);

                        String pilhaProdutos = "Produtos na pilha:\n";
                        for (Produto produto : pilha) {
                            pilhaProdutos += produto + "\n";
                        }
                        JOptionPane.showMessageDialog(null, pilhaProdutos);
                    }
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}