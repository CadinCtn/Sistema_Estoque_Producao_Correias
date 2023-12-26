

package usuarios;



public class Usuario {
    
    int id;
    String login;
    String senha;
    String permissao;

    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }    
    
    
}
