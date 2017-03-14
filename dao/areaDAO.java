package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.areaTO;

public class areaDAO {


	public static areaTO carregar(int id) {
		areaTO area = new areaTO();
		area.setId(id);
		String sqlSelect = "SELECT Nome FROM area WHERE ID = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, area.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					area.setNome(rs.getString("nome"));

				} else {
					area.setId(-1);
					area.setNome(null);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return area;
	}

}
