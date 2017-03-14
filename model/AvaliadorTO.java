package model;

public class AvaliadorTO extends UsuarioTO{

	
	 public int area;
	   
	   
	   //construtor
	   public AvaliadorTO(String nome, String senha, String login, int area)
	   {
	      super(nome, senha, login);
	      this.area = area;
	   }
	   
	    public AvaliadorTO(String nome, String senha, int area, String login)
	   {
	      super(nome, senha, login);
	      this.area = area;
	   }
	   
	   public AvaliadorTO(String login)
	   {
	      super(login);
	   }
	   
	   public AvaliadorTO()
	   {
	   }
	   
	   //setters
	   public void setArea(int area)
	   {
	      this.area = area;
	   }
	   
	   //getter
	   public int getArea()
	   {
	      return area;
	   }

}
