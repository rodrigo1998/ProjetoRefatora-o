package model;

public class UsuarioTO {

	   private String nome;
	   private String senha;
	   private String login;
	   private int id;
	   
	   //Construtores
	   public UsuarioTO(String nome, String senha, String login)
	   {
	      setNome(nome);
	      setSenha(senha);
	      setLogin(login);
	   }
	   public UsuarioTO(String nome, int area, String senha, String login)
	   {
	      setNome(nome);
	      setSenha(senha);
	      setLogin(login);
	   }
	   
	   public UsuarioTO(int id, String nome, String senha, String login)
	   {
	      setNome(nome);
	      setSenha(senha);
	      setLogin(login);
	   }
	   public UsuarioTO(String login)
	   {
	      setLogin(login);
	   }
	   public UsuarioTO()
	   {
	   }
	   
	   //setters
	   public void setId(int id)
	   {
	      this.id = id;
	   }
	   public void setNome(String nome)
	   {
	      this.nome = nome;
	   }
	   
	   public void setSenha(String senha)
	   {
	      this.senha = senha;
	   }
	   
	   public void setLogin(String login)
	   {
	      this.login = login;
	   }
	   
	   //Getters
	   public int getId()
	   {
	      return id;
	   }
	   public String getNome()
	   {
	      return nome;
	   }
	   
	   public String getSenha()
	   {
	      return senha;
	   }
	   
	   public String getLogin()
	   {
	      return login;
	   }
	   
	   public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UsuarioTO other = (UsuarioTO) obj;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (senha == null) {
				if (other.senha != null)
					return false;
			} else if (!senha.equals(other.senha))
				return false;
			if (id != other.id)
				return false;
			if (login == null) {
				if (other.login != null)
					return false;
			} else if (!login.equals(other.login))
				return false;
			return true;
		}

}
