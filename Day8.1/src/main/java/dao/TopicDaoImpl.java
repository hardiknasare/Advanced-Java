package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.fetchDBConnection;

public class TopicDaoImpl implements ITopicDao {
	private Connection cn;
	private PreparedStatement pst1;
	public TopicDaoImpl() throws ClassNotFoundException,SQLException{
		//get Singleton cn instance from DBUtils
		cn=fetchDBConnection();
		pst1=cn.prepareStatement("select name from topics");
		System.out.println("topic dao created....");
	}

	@Override
	public List<String> getAllTopicNames() throws SQLException {
		List<String> topicNames=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				topicNames.add(rst.getString(1));
		}
		return topicNames;
	}
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		System.out.println("topic dao cleaned up");
	}

}
