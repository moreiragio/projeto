package javaBeans;

public class Usuario extends Conectar {
    private int pkUser; // Chave primária do usuário
    private String nome;
    private String email;
    private String senha;
    private String celular;
    private String nivel; // Corrigido de "Stringa" para "String"

    // Método para verificar login
    public boolean getLogin() {
        return email.equals("admin") && senha.equals("1234");
    }

    // Getters e Setters (opcional, mas recomendável)
    public int getPkUser() {
        return pkUser;
    }

    public void setPkUser(int pkUser) {
        this.pkUser = pkUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
