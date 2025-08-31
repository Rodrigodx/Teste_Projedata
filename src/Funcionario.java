import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa{

    private BigDecimal salario;
    private String funcao;

    public Funcionario() {}

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("#,##0.00");

        return "Funcionario: " +
                "Nome= " + getNome() +
                ", Data de nascimento= " + getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " salario= " +  df.format(salario) +
                ", funcao= '" + funcao + '\'' +
                '}';
    }
}
