import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        //Objeto de funcionários
        Funcionario funcionario1 = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador");
        Funcionario funcionario2 = new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador");
        Funcionario funcionario3 = new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador");
        Funcionario funcionario4 = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor");
        Funcionario funcionario5 = new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista");
        Funcionario funcionario6 = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador");
        Funcionario funcionario7 = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador");
        Funcionario funcionario8 = new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente");
        Funcionario funcionario9 = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista");
        Funcionario funcionario10 = new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente");

        //Adicionar funcionários
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        funcionarios.add(funcionario4);
        funcionarios.add(funcionario5);
        funcionarios.add(funcionario6);
        funcionarios.add(funcionario7);
        funcionarios.add(funcionario8);
        funcionarios.add(funcionario9);
        funcionarios.add(funcionario10);

        //Remover João
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        //Imprimir todos os funcionários
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        System.out.println(" ");
        System.out.println("###########################################################################");
        System.out.println(" ");

        //Reajuste de salário em 10%
        for (Funcionario funcionario : funcionarios) {
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.10"));
            BigDecimal novoSalario = funcionario.getSalario().add(reajuste);
            funcionario.setSalario(novoSalario);
        }

        //Map de funcionários por Função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        //Imprimir por função
        funcionariosPorFuncao.forEach((funcao, listaDeFuncionarios) -> {
            System.out.println("Função: " + funcao);
            listaDeFuncionarios.forEach(funcionario -> System.out.println(funcionario));
            System.out.println(" ");
        });


        System.out.println("###########################################################################");
        System.out.println(" ");

        //Imprimir funcionarios nascido nos meses 10 e 12
        funcionarios.stream().filter(f -> {
            Month mes = f.getDataNascimento().getMonth();
            return mes == Month.OCTOBER || mes == Month.DECEMBER;
        }).forEach(f -> {
            System.out.println(f);
        });


        System.out.println(" ");
        System.out.println("###########################################################################");
        System.out.println(" ");

        //Pega o funcionário mais velho
        Optional<Funcionario> funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento));

        //Faz a impressão do funcinários mais velho
        if(funcionarioMaisVelho.isPresent()) {
            Funcionario maisVelho = funcionarioMaisVelho.get();
            String nome = maisVelho.getNome();
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
        }

        System.out.println(" ");
        System.out.println("###########################################################################");
        System.out.println(" ");

        //Funcionários por ordem alfabética
        funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(funcionario -> System.out.println(funcionario));

        System.out.println(" ");
        System.out.println("###########################################################################");
        System.out.println(" ");

        //Soma dos salários
        BigDecimal somaSalarios = funcionarios.stream().map(funcionario -> funcionario.getSalario()).reduce(BigDecimal.valueOf(0), BigDecimal::add);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.print("Soma dos salários: ");
        System.out.println(df.format(somaSalarios));

        System.out.println(" ");
        System.out.println("###########################################################################");
        System.out.println(" ");

        //Quantidade de salários mínimos
        for (Funcionario funcionario : funcionarios) {
            BigDecimal quantSalarioMinimo = funcionario.getSalario().divide(BigDecimal.valueOf(1212.00), 0, RoundingMode.DOWN);
            System.out.println(funcionario.getNome() + " recebe " + quantSalarioMinimo + " salários mínimos");
            System.out.println(" ");
        }
    }


}