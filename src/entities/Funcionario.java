package entities;

public class Funcionario {

    private String nome;

    private String email;
    private Double salario;

    public Funcionario(String nome, String email, Double salario) {
        this.nome = nome;
        this.salario = salario;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nFuncionário: " + nome + "\nSalário: " + String.format("%.2f",salario) + "\nEmail: " + email;
    }
}
