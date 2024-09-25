import java.time.LocalDate; //importar biblioteca para datas
import java.time.temporal.ChronoUnit; // importei essa biblioteca com ajuda de IA :(

public class produtovalidade {
    public static void main(String[] args) throws Exception {

        Produto p1 = new Produto("Bolacha", 3.0, 6.0, LocalDate.of(2022, 02, 25), LocalDate.of(2024, 10, 20));
        Produto p2 = new Produto("Biscoito", 5.0, 8.0, LocalDate.of(2023, 05, 1), LocalDate.of(2023, 12, 30));

        System.out.println(p1);
        System.out.println(p2);
    }
}

    class Produto {

    //Construtor para receber os atributos
    private String nome;
    private double precoCusto, precoVenda;
    private LocalDate fabricacao, validade;

    public String getNome()  {
        return nome;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }
    
    public LocalDate getValidade () {
        return validade;
    }

    @Override
    public String toString() {
        return "Produto{" +
        "nome ='" + nome + '\'' +
        ", precoVenda = " + precoVenda +
        ", validade = " + validade +
        '}';

    } 

    //Construtor que calcula a validade com base na fabricação
    public Produto(String nome, double precoCusto, double precoVenda, LocalDate fabricacao, LocalDate validade) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.fabricacao = fabricacao;
        this.validade = validade;
    }

    //Metodo para calcular preço da venda e data de validade
    public Produto(String nome, double precoCusto) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoCusto * 1.1;
        this.fabricacao = LocalDate.now();
        this.validade = fabricacao.plus(1, ChronoUnit.MONTHS);
    }

    //Metodo para verificação do produdo vencido
    public boolean isVencido() {
        return LocalDate.now().isAfter(validade);
    }
}
