import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class produtovalidade {
    public static void main(String[] args) throws Exception {

        Produto p1 = new Produto("Bolacha", 3.0, 6.0, LocalDate.of(2022, 02, 25), LocalDate.of(2022, 03, 25));
        Produto p2 = new Produto("Biscoito", 5.0, 8.0, LocalDate.of(2023, 05, 1), LocalDate.of(2023, 06, 1));

        System.out.println(p1);
        System.out.println(p2);

        // Exemplo de produto sem especificar a validade (automaticamente calculada)
        Produto p3 = new Produto("Chocolate", 10.0);
        System.out.println(p3);

        // Verificar se algum produto está vencido
        System.out.println("Produto " + p1.getNome() + " venceu? " + p1.isVencido());
        System.out.println("Produto " + p2.getNome() + " venceu? " + p2.isVencido());
        System.out.println("Produto " + p3.getNome() + " venceu? " + p3.isVencido());
    }
}

class Produto {

    private String nome;
    private double precoCusto, precoVenda;
    private LocalDate fabricacao, validade;

    // Getters
    public String getNome() {
        return nome;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public LocalDate getValidade() {
        return validade;
    }

    // Sobrescrevendo toString para exibir melhor
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", precoVenda=" + precoVenda +
                ", validade=" + validade +
                (isVencido() ? " (Produto VENCIDO)" : " (Produto dentro da validade)") +
                '}';
    }

    // Construtor para relacionar tudo
    public Produto(String nome, double precoCusto, double precoVenda, LocalDate fabricacao, LocalDate validade) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.fabricacao = fabricacao;
        this.validade = validade;
    }

    // Construtor para calcula a validade com base na fabricação
    public Produto(String nome, double precoCusto) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoCusto * 1.1; // Exemplo de margem de 10%
        this.fabricacao = LocalDate.now();
        this.validade = fabricacao.plus(1, ChronoUnit.MONTHS);
    }

    // Verificar se o produto está vencido
    public boolean isVencido() {
        return LocalDate.now().isAfter(validade);
    }
}
