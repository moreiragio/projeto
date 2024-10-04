package javaBeans;

public class Usuario extends Conectar {
    public int pkuser;
    public String nome;
    public String email;
    public String senha;
    public String celular;
    public Stringa nivel;

    public boolean getLogin() {
        if (email.equals("admin") && senha.equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
}
