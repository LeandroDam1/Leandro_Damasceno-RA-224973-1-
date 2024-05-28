import javax.swing.JOptionPane;
import java.util.Stack;

public class Ex05_Deposito5pilhas {
    private static final int CAPACIDADE_MAXIMA = 10;
    private static final int NUM_PILHAS = 5;

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
        Stack<Produto>[] pilhas = new Stack[NUM_PILHAS];
        for (int i = 0; i < NUM_PILHAS; i++) {
            pilhas[i] = new Stack<>();
        }

        while (true) {
            String opcao = JOptionPane.showInputDialog("1. Adicionar o produto em uma pilha\n2. Despachar o produto de uma pilha\n3. Exibir o status das pilhas\n4. Sair");

            switch (opcao) {
                case "1":
                    int pilhaIndex = selecionarPilha();
                    if (pilhaIndex == -1) {
                        break;
                    }

                    if (pilhas[pilhaIndex].size() == CAPACIDADE_MAXIMA) {
                        JOptionPane.showMessageDialog(null, "A pilha " + (pilhaIndex + 1) + " está cheia. Não é possível adicionar mais produtos.");
                    } else {
                        int codProduto = Integer.parseInt(JOptionPane.showInputDialog("Código do produto:"));
                        String descricao = JOptionPane.showInputDialog("Descrição do produto:");
                        String dataEntrada = JOptionPane.showInputDialog("Data de entrada do produto:");
                        String ufOrigem = JOptionPane.showInputDialog("UF de origem do produto:");
                        String ufDestino = JOptionPane.showInputDialog("UF de destino do produto:");

                        Produto novoProduto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                        pilhas[pilhaIndex].push(novoProduto);
                        JOptionPane.showMessageDialog(null, "O produto foi adicionado na pilha " + (pilhaIndex + 1) + ".");
                    }
                    break;

                case "2":
                    int pilhaIndexParaDespachar = selecionarPilha();
                    if (pilhaIndexParaDespachar == -1) {
                        break;
                    }

                    if (pilhas[pilhaIndexParaDespachar].isEmpty()) {
                        JOptionPane.showMessageDialog(null, "A pilha " + (pilhaIndexParaDespachar + 1) + " está vazia. Não tem produto para ser despachado.");
                    } else {
                        Produto produtoDespacho = pilhas[pilhaIndexParaDespachar].pop();
                        JOptionPane.showMessageDialog(null, "O produto foi despachado: " + produtoDespacho);
                    }
                    break;

                case "3":
                    String statusPilhas = "Status das Pilhas:\n";
                    for (int i = 0; i < NUM_PILHAS; i++) {
                        statusPilhas += "Pilha " + (i + 1) + ":\n";
                        for (Produto produto : pilhas[i]) {
                            statusPilhas += produto + "\n";
                        }
                        statusPilhas += "\n";
                    }
                    JOptionPane.showMessageDialog(null, statusPilhas);
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static int selecionarPilha() {
        String[] pilhaOptions = new String[NUM_PILHAS];
        for (int i = 0; i < NUM_PILHAS; i++) {
            pilhaOptions[i] = "Pilha " + (i + 1);
        }
        int pilhaIndex = JOptionPane.showOptionDialog(null, "Selecione a pilha:", "Selecionar Pilha",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, pilhaOptions, pilhaOptions[0]);
        return pilhaIndex;
    }
}