package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.Tutorial;

import static utils.DBUtils.fetchDBConnection;

public class TutorialDaoImpl implements ITutorialDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public TutorialDaoImpl() throws ClassNotFoundException, SQLException {
		// get cn
		cn = fetchDBConnection();
		// pst1 : join query to fetch tut names for a specific topic
		pst1 = cn.prepareStatement(
				"select t1.name from tutorials t1 inner join topics t2 on t1.topic_id=t2.id where t2.name=? order by visits desc");
		// pst2 : get tut details by it's name
		pst2 = cn.prepareStatement("select * from tutorials where name=?");
		// pst3 : update visits
		pst3 = cn.prepareStatement("update tutorials set visits=visits+1 where name=?");
		System.out.println("tut dao created...");

	}

	@Override
	public List<String> getAllTutorialsByTopic(String topicName) throws SQLException {
		List<String> tutNames = new ArrayList<>();
		// set IN param : topic name
		pst1.setString(1, topicName);
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				tutNames.add(rst.getString(1));
		}
		return tutNames;
	}

	@Override
	public Tutorial getTutorialDetails(String tutName) throws SQLException {
		// set In param : tut name
		pst2.setString(1, tutName);
		try (ResultSet rst = pst2.executeQuery()) {
			if (rst.next())
				// int tutorialId, String tutorialName, String author, Date publishDate, int
				// visits, int topicId,String contents) {

				return new Tutorial(rst.getInt(1), tutName, rst.getString(3), rst.getDate(4), rst.getInt(5),
						rst.getInt(6),rst.getString(7));
		}
		return null;
	}

	@Override
	public String updateVisits(String tutName) throws SQLException {
		// set IN param
		pst3.setString(1, tutName);
		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "Visits updated";
		return "Visits updation failed...";
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("tut dao cleaned up");
	}

}
