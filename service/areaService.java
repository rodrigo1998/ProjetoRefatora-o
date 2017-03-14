package service;

import model.areaTO;
import dao.areaDAO;


public class areaService {
	areaDAO dao = new areaDAO();
	

	
	public areaTO carregar(int id){
		return dao.carregar(id);
	}

}
