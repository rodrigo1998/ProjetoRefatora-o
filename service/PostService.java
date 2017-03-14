package service;

import java.sql.Connection;

import dao.PostDAO;
import dao.UsuarioDAO;
import model.PostTO;
import model.UsuarioTO;

public class PostService {

		
		PostDAO dao = new PostDAO();
			

			
			public PostTO Incluir(int id){
				Connection conn = null;
				return dao.incluir(conn);
			}
}
