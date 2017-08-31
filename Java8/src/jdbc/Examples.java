package jdbc;

import java.sql.*;
import java.util.*;
import java.time.*;
import java.util.HashMap;

/* Key JDBC interfaces:
 * - Driver
 * - Connection
 * - Statement
 * - ResultSet
 * 
 * ResultSet get methods:
 * boolean 				getBoolean()
 * int					getInt()
 * double				getDouble()
 * long					getLong()
 * String				getString()
 * Object				getObject()
 * java.sql.Date		getDate()
 * java.sql.Time		getTime()
 * java.sql.Timestamp	getTimestamp()
 * 
 * */

public class Examples {

	public static void main(String[] args) throws SQLException, 
													ClassNotFoundException {
		
		
		//jdbc:vendor:specificPart(includes a database name)
		System.out.println("_____EXAMPLE GENERAL_____");
		String url = "jdbc:derby:zoo";
		Class.forName("java.sql.Driver"); //required in JDBC <= 3.0 Driver
		try (
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(
											ResultSet.TYPE_SCROLL_INSENSITIVE,
											ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select name from animal")
			) 
		{
			while(rs.next())
				System.out.println(rs.getString(1));
		}
		
		
		
		System.out.println("_____EXAMPLE RESULTSET GET METHODS_____");
		Map<Integer, String> idToNameMap = new HashMap<>();
		try (
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id, name from species")
			) 
		{
			while(rs.next()) {  			//ALWAYS USE THIS OR if(rs.next())
				int id = rs.getInt("id");          //preferable to .getInt(1) 
				String name = rs.getString("name");//preferable to .getString(2) 
				idToNameMap.put(id, name);	
			}			
			System.out.println(idToNameMap);
//			rs.getInt("bad column"); //SQLException
//			rs.getInt(0);			 //SQLException
			
				
		}
		
		System.out.println("_____EXAMPLE RESULTSET SCROLLING_____");
		try (
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(
											ResultSet.TYPE_SCROLL_INSENSITIVE,
											ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select id from animal order by "
																		+ "id")
			) 
		{	
			rs.afterLast();
			System.out.println(rs.previous());  //true
			System.out.println(rs.getInt(1));   //5
			System.out.println(rs.previous());  //true
			System.out.println(rs.getInt(1));   //4
			System.out.println(rs.last());  	//true
			System.out.println(rs.getInt(1));   //5
			System.out.println(rs.first());  	//true
			System.out.println(rs.getInt(1));   //1
			rs.beforeFirst();
			//if we try to use a get method -> SQLException
			System.out.println(rs.absolute(2)); 	 //true
			System.out.println(rs.getString("id"));  //2
			System.out.println(rs.absolute(-2)); 	 //true
			System.out.println(rs.getString("id"));  //4
			System.out.println(rs.relative(-1)); 	 //true
			System.out.println(rs.getString("id"));  //3
		}
		
		
		System.out.println("_____EXAMPLE DATES_____");
		try (
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			
			) 
		{	
			ResultSet rs = stmt.executeQuery("select date_born from animal "
					+ "where name='Elsa'");
			if(rs.next()) {  			
				java.sql.Date sqlDate = rs.getDate(1);          
				LocalDate localDate = sqlDate.toLocalDate(); 
				System.out.println(localDate);
			}
			rs = stmt.executeQuery("select date_born from animal where "
															+ "name='Elsa'");
			if(rs.next()) {  			
				java.sql.Time sqlTime = rs.getTime(1);          
				LocalTime localTime = sqlTime.toLocalTime(); 
				System.out.println(localTime);
			}
			rs = stmt.executeQuery("select date_born from animal where "
															+ "name='Elsa'");
			if(rs.next()) {  			
				java.sql.Timestamp sqlDateTime = rs.getTimestamp(1);          
				LocalDateTime localDateTime = sqlDateTime.toLocalDateTime(); 
				System.out.println(localDateTime);
			}			
			
			
			
				
		}
		
	}

}
