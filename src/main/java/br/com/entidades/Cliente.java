package br.com.entidades;

public class Cliente {
    private String nome;
    private String email;
    private int idade;
    private int devedor;

    public int getDevedor() {
        return devedor;
    }

    public void setDevedor(int devedor) {
        this.devedor = devedor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
