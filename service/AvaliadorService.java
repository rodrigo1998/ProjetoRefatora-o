package service;

import com.mysql.jdbc.Connection;

import dao.AvaliadorDAO;
import model.AvaliadorTO;

public class AvaliadorService {


		
		AvaliadorDAO dao = new AvaliadorDAO();
			

			
			public AvaliadorTO carregar(int id){
				return dao.carregar(id);
				
			}
			public AvaliadorTO incluir(int id){
				Connection conn = null;
				return dao.incluir(conn);
				
			}
			
}
