package service;

import dao.UsuarioDAO;
import model.UsuarioTO;

public class UsuarioService {

	
UsuarioDAO dao = new UsuarioDAO();
	

	
	public UsuarioTO carregar(int id){
		return dao.carregar(id);
	}
}
