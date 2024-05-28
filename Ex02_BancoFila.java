import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Queue;

public class Ex02_BancoFila {
    private static Queue<Cliente> atendimentoPrioritario = new LinkedList<>();
    private static Queue<Cliente> atendimentoNormal = new LinkedList<>();
    private static int senhaAtual = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Controle de filas do banco.\n\n" +
                            "1. Adicionar cliente\n" +
                            "2. Chamar próximo cliente\n" +
                            "0. Sair"
            ));

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    chamarProximoCliente();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Sistema foi finalizado.BancoFila");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void adicionarCliente() {
        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Ano de nascimento do cliente:"));

        Cliente cliente = new Cliente(senhaAtual++, nome, anoNascimento);
        int idade = 2024 - anoNascimento;

        if (idade >= 65) {
            atendimentoPrioritario.offer(cliente);
            JOptionPane.showMessageDialog(null, "Cliente " + cliente.nome + " adicionado na fila de atendimento prioritário.");
        } else {
            atendimentoNormal.offer(cliente);
            JOptionPane.showMessageDialog(null, "Cliente " + cliente.nome + " adicionado na fila de atendimento normal.");
        }
    }

    private static void chamarProximoCliente() {
        if (!atendimentoPrioritario.isEmpty()) {
            Cliente clientePrioritario = atendimentoPrioritario.poll();
            JOptionPane.showMessageDialog(null, "Chamando o cliente prioritário: " + clientePrioritario.nome + " (senha " + clientePrioritario.senha + ")");
            if (!atendimentoPrioritario.isEmpty()) {
                Cliente clientePrioritario2 = atendimentoPrioritario.poll();
                JOptionPane.showMessageDialog(null, "Chamando o cliente prioritário: " + clientePrioritario2.nome + " (senha " + clientePrioritario2.senha + ")");
                if (!atendimentoNormal.isEmpty()) {
                    Cliente clienteNormal = atendimentoNormal.poll();
                    JOptionPane.showMessageDialog(null, "Chamando o cliente normal: " + clienteNormal.nome + " (senha " + clienteNormal.senha + ")");
                }
            }
        } else if (!atendimentoNormal.isEmpty()) {
            Cliente clienteNormal = atendimentoNormal.poll();
            JOptionPane.showMessageDialog(null, "Chamando o cliente normal: " + clienteNormal.nome + " (senha " + clienteNormal.senha + ")");
        } else {
            JOptionPane.showMessageDialog(null, "Não tem clientes na fila.");
        }
    }

    private static class Cliente {
        int senha;
        String nome;
        int anoNascimento;

        public Cliente(int senha, String nome, int anoNascimento) {
            this.senha = senha;
            this.nome = nome;
            this.anoNascimento = anoNascimento;
        }
    }
}