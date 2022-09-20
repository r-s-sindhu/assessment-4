package com.test;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

class AverageScoreComparator implements Comparator<Player>{
    public int compare(Player p1, Player p2) {
        return (int) (p1.getAvg()-p2.getAvg());
    }
}

	public class PlayerDao {
		public static Connection getConnection() {
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios","root","password");
			} catch (Exception e) {
				System.out.println(e);
			}
			return con;
		}

		public static int save(Player p) {
			int status = 0;
			try {
				Connection con = PlayerDao.getConnection();		
				PreparedStatement ps = con.prepareStatement("insert into player(name,matches,score,wicket,zero_out,player_type,average) values (?,?,?,?,?,?,?)");
				ps.setString(1, p.getName());
				ps.setInt(2, p.getMatch());
				ps.setInt(3, p.getScore());
				ps.setInt(4, p.getWicket());
				ps.setInt(5, p.getZero_out());
				ps.setString(6, p.getPlayer_type());
				ps.setDouble(7, (p.getScore()/p.getMatch()));
				status = ps.executeUpdate();
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return status;
		}

		public static int update(Player p) {
			int status = 0;
			try {
				Connection con = PlayerDao.getConnection();
				PreparedStatement ps = con.prepareStatement("update player set name=?,matches=?,score=?,wicket=?,zero_out=?,player_type=?,average=? where id=?");
				ps.setString(1, p.getName());
				ps.setInt(2, p.getMatch());
				ps.setInt(3, p.getScore());
				ps.setInt(4, p.getWicket());
				ps.setInt(5, p.getZero_out());
				ps.setString(6, p.getPlayer_type());
				ps.setDouble(7, (p.getScore()/p.getMatch()));
				ps.setInt(8, p.getId());
				
				status = ps.executeUpdate();

				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return status;
		}

		
		public static Player getPlayerById(int id) {
			Player p = new Player();
			try {
				Connection con = PlayerDao.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from player where id=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setMatch(rs.getInt(3));
					p.setScore(rs.getInt(4));
					p.setWicket(rs.getInt(5));
					p.setZero_out(rs.getInt(6));
					p.setPlayer_type(rs.getString(7));
					p.setAvg(rs.getDouble(8));
				}
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return p;
		}

		public static List<Player> getAllPlayers() {
			List<Player> list = new ArrayList<Player>();
			try {
				Connection con = PlayerDao.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from player order by name");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Player p = new Player();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setMatch(rs.getInt(3));
					p.setScore(rs.getInt(4));
					p.setWicket(rs.getInt(5));
					p.setZero_out(rs.getInt(6));
					p.setPlayer_type(rs.getString(7));
					p.setAvg(rs.getDouble(8));
					list.add(p);
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public static List<Player> getSelectedPlayers() {
			List<Player> list = new ArrayList<Player>();
			try {
				Connection con = PlayerDao.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from player order by average desc limit 11");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Player p = new Player();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setMatch(rs.getInt(3));
					p.setScore(rs.getInt(4));
					p.setWicket(rs.getInt(5));
					p.setZero_out(rs.getInt(6));
					p.setPlayer_type(rs.getString(7));
					p.setAvg(rs.getDouble(8));
					list.add(p);
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	}
	
