package loja.entidades;

import java.math.BigDecimal;

public class Funcionario extends Pessoa {
    private BigDecimal salario;

    public Funcionario(String nome, String cpf, BigDecimal salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    public Funcionario() {
        super("", "");
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Funcionário: " + nome + ", CPF: " + cpf + ", Salário: " + salario);
    }
}
