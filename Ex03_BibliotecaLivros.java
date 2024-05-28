import javax.swing.JOptionPane;
import java.util.Stack;

public class Ex03_BibliotecaLivros {
    private static Stack<String> pilhaLivros = new Stack<>();

    public static void adicionarLivro(String livro) {
        pilhaLivros.push(livro);
        JOptionPane.showMessageDialog(null, "Livro adicionado: " + livro);
    }

    public static void listarLivros() {
        StringBuilder sb = new StringBuilder("Livros na pilha:\n");
        for (String livro : pilhaLivros) {
            sb.append("- ").append(livro).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void retirarLivro() {
        if (pilhaLivros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha de livros está vazia.");
            return;
        }

        String livroRemovido = pilhaLivros.pop();
        JOptionPane.showMessageDialog(null, "Livro removido: " + livroRemovido);
    }

    public static void main(String[] args) {
        adicionarLivro("Harry Potter e a Pedra Filosofal");
        adicionarLivro("Harry Potter e a Câmara Secreta");
        adicionarLivro("Harry Potter e o Prisioneiro de Azkaban");
        adicionarLivro("Harry Potter e o Cálice de Fogo");
        adicionarLivro("Harry Potter e a Ordem da Fênix");
        adicionarLivro("Harry Potter e o Enigma do Príncipe");
        adicionarLivro("Harry Potter e as Relíquias da Morte");

        while (true) {
            String menu =
                    "1. Adicionar livro\n"
                    + "2. Listar livros\n"
                    + "3. Retirar livro\n"
                    + "4. Sair";
            int escolha = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Biblioteca de Livros", JOptionPane.INFORMATION_MESSAGE));

            switch (escolha) {
                case 1:
                    String novoLivro = JOptionPane.showInputDialog(null, "Título do livro:", "Adicionar Livro", JOptionPane.QUESTION_MESSAGE);
                    adicionarLivro(novoLivro);
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    retirarLivro();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Encerrado.");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}