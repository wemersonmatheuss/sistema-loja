package loja.entidades;

public class Cliente extends Pessoa {
    private String endereco;

    public Cliente(String nome, String cpf, String endereco) {
        super(nome, cpf);
        this.endereco = endereco;
    }

    public Cliente() {
        super("", "");
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Cliente: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco);
    }
}
