package model;

public class ComentarioTO {
	private int idComentario;
	   private String comentario;
	   private int idUsuario;
	   private boolean aprovacao;
	   private String titulo;
	   
	   
	   //Construtores
	   public ComentarioTO( int idComentario, String comentario,int idUsuario,boolean aprovacao,String titulo)
	   {
	     
	      setIdComentario(idComentario);
	      setComentario(comentario);
	      setIdUsuario(idUsuario);
	      setAprovacao(aprovacao);
	      setTitulo(titulo);
	   }
	  
	  
	     
	   //setters
	   public void setIdUsuario(int idUsuario)
	   {
	      this.idUsuario = idUsuario;
	   }
	   public void setComentario(String comentario)
	   {
	      this.comentario =comentario;
	   }
	   
	   public void setIdComentario(int idComentario)
	   {
	      this.idComentario = idComentario;
	   }
	   
	    public void setAprovacao(boolean aprovacao)
	   {
	      this.aprovacao = aprovacao;
	   }
	      public void setTitulo(String titulo)
	   {
	      this.titulo = titulo;
	   }
	   
	   
	   
	   
	   //Getters
	   public int getIdUsario()
	   {
	      return idUsuario;
	   }
	 
	   public int getIdComentario()
	   {
	      return idComentario;
	   }
	   
	   public String getComentario()
	   {
	      return comentario;
	   }
	   
	    public boolean getAprovacao()
	   {
	      return aprovacao;
	   }
	    public String getTitulo()
	   {
	      return titulo;
	   }
	}

