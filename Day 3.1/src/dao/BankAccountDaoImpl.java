package dao;

import java.sql.*;
import static utils.DBUtils.fetchDBConnection;

public class BankAccountDaoImpl implements IBankAccountDao {
	
	private Connection cn;
	private CallableStatement cst1;
	
	public BankAccountDaoImpl() throws ClassCastException, SQLException {
		cn = fetchDBConnection();
		
	String query = "{call transfer_funds(?,?,?,?,?)}";
	cst1 = cn.prepareCall(query);
	
	// method of cst : public void registerOutParameter(int paramPos, int jdbcType)
	
	cst1.registerOutParameter(4, Types.DOUBLE);
	cst1.registerOutParameter(5, Types.DOUBLE);
	}
	@Override
	public String transferFunds(int srcId, int destId, double amount) throws SQLException {
		cst1.setInt(1, srcId);
		cst1.setInt(2, destId);
		cst1.setDouble(3, amount);
		//exec stored proc
		//public boolean execute() throws SE
		cst1.execute();
		//use CST's getters to get the results stored in OUT parameter
		StringBuilder sb=new StringBuilder("Funds transferred !");
		sb.append(" Updated Src balance "+cst1.getDouble(4));
		sb.append(" Updated dest balance "+cst1.getDouble(5));
		return sb.toString();
	}
	public void cleanUp() throws SQLException {
		if(cst1 != null)
			cst1.close();
		if(cn != null)
			cn.close();
		System.out.println("cleaned....");
	}
}
