import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Queue;

public class Ex01_Clinica {
    public static void main(String[] args) {
        Queue<String> pacientes = new LinkedList<>();
        final int LIMITE_SENHA = 20;

        while (pacientes.size() < LIMITE_SENHA) {
            String nome = JOptionPane.showInputDialog("Nome do paciente (ou Cancel para parar a lista):");
            if (nome == null) {
                break;
            }
            pacientes.offer(nome);
        }

        StringBuilder listaString = new StringBuilder("Lista de pacientes:\n");
        for (String paciente : pacientes) {
            listaString.append(paciente).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaString.toString());

        while (true) {
            int opcao = JOptionPane.showOptionDialog(
                    null,
                    "O que você deseja fazer?","Clinica",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[] {"Adicionar pacientes", "Chamar próximo paciente"},
                    "Continuar adicionando pacientes"
            );

            switch (opcao) {
                case 0:
                    while (pacientes.size() < LIMITE_SENHA) {
                        String nome = JOptionPane.showInputDialog("Nome do paciente (ou Cancel para parar a lista):");
                        if (nome == null) {
                            break;
                        }
                        pacientes.offer(nome);
                    }
                    break;
                case 1:
                    if (!pacientes.isEmpty()) {
                        String proximoPaciente = pacientes.poll();
                        JOptionPane.showMessageDialog(null, "Próximo paciente: " + proximoPaciente);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não tem pacientes na fila.");
                    }
                    break;
                case JOptionPane.CLOSED_OPTION:
                    return;
            }
        }
    }
}