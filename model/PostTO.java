package model;

public class PostTO {
	
	   //atributos
	   private int id;
	   private String titulo;
	   private String conteudo;
	   private String resposta;
	   private int idArea;
	   private int idCriador;
	   private int idAvaliador;
	   private int aceite;

	   
	   //Construtores
	   public PostTO()
	   {
	   }
	   
	   public PostTO(int IdCriador)
	   {
	      setCriador(IdCriador);
	   }
	   public PostTO(String titulo, String conteudo)
	   {
	      setTitulo(titulo);
	      setConteudo(conteudo);
	   }
	   public PostTO(int ID, String titulo, String conteudo, int idArea)
	   {
	      setCriador(ID);
	      setTitulo(titulo);
	      setConteudo(conteudo);
	      setArea(idArea);
	   }
	   
	   public PostTO(int ID, String resposta, int aceite, int idAvaliador)
	   {
	      setId(ID);
	      setResposta(resposta);
	      setAceite(aceite);
	      setAvaliador(idAvaliador);
	   }
	   
	   //setters
	   public void setId(int id)
	   {
	      this.id = id;
	   }
	   public void setTitulo(String titulo)
	   {
	      this.titulo = titulo;
	   }
	   
	   public void setConteudo(String conteudo)
	   {
	      this.conteudo = conteudo;
	   }
	   
	   public void setResposta(String resposta)
	   {
	      this.resposta = resposta;
	   }
	   
	   public void setArea(int idArea)
	   {
	      this.idArea = idArea;
	   }
	   
	   public void setCriador(int idCriador)
	   {
	      this.idCriador = idCriador;
	   }
	   
	   public void setAvaliador(int idAvaliador)
	   {
	      this.idAvaliador = idAvaliador;
	   }
	   
	   public void setAceite(int aceite)
	   {
	      this.aceite = aceite;
	   }
	   
	   //Getters
	   public int getId()
	   {
	      return id;
	   }
	   public String getTitulo()
	   {
	      return titulo;
	   }
	   
	   public String getConteudo()
	   {
	      return conteudo;
	   }
	   
	   public String getResposta()
	   {
	      return resposta;
	   }
	   
	   public int getArea()
	   {
	      return idArea;
	   }
	   
	   public int getCriador()
	   {
	      return idCriador;
	   }
	   
	   public int getAvaliador()
	   {
	      return idAvaliador;
	   }
	   
	   public int getAceite()
	   {
	      return aceite;
	   }

}
