package utils;
import java.sql.*;

import static utils.DButils.fetchDBConnetion;;

public class TestStatment {
	public static void main(String[] args)   {
		try (
			Connection cn = fetchDBConnetion();
			Statement st = cn.createStatement();
			ResultSet rst = st.executeQuery("select * from my_emp"); )
			{
			while(rst.next())
				{System.out.printf("Emp ID %d Name %-10s Address %-20s Sal %.1f Dept Id %s Join Date %s%n", rst.getInt(1),
							rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5), rst.getDate(6));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
