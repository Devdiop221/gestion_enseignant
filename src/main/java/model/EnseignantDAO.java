package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnseignantDAO {
	
	public static Connection getConnection(){
		Connection con=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/bd_enseignant?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		}catch(Exception e){System.out.println(e);}
		return con;
		}
	
	public static int save(Enseignant e){
		int status=0;
		try{
		Connection con=EnseignantDAO.getConnection();
		PreparedStatement en=con.prepareStatement(
		"insert into bd_enseignant.enseignant(id,nom,prenom,grad,id_user) values (?,?,?,?,?)");
		en.setInt(1,e.getId());
		en.setString(2,e.getNom());
		en.setString(3,e.getPrenom());
		en.setString(4,e.getGrade());
		en.setString(5, e.getId_user());
		status=en.executeUpdate();
		con.close();
		}catch(Exception ex){ex.printStackTrace();}
		return status;
		}
	

	public static Enseignant getEnseignantById(int id){
		Enseignant enseignant =new Enseignant();
		try{
		Connection con=EnseignantDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from bd_enseignant.enseignant where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		enseignant.setId(rs.getInt(1));
		enseignant.setNom(rs.getString(2));
		enseignant.setPrenom(rs.getString(3));
		enseignant.setGrade(rs.getString(4));
		enseignant.setId_user(rs.getString(5));
		}
		con.close();
		}catch(Exception ex){ex.printStackTrace();}
		return enseignant;
	}
	
	public static List<Enseignant> getAllEnseignants(){
		List<Enseignant> list=new ArrayList<Enseignant>();
		try{
		Connection con=EnseignantDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from  bd_enseignant.enseignant");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
		Enseignant enseignant =new Enseignant();
		enseignant.setId(rs.getInt(1));
		enseignant.setNom(rs.getString(2));
		enseignant.setPrenom(rs.getString(3));
		enseignant.setGrade(rs.getString(4));
		enseignant.setId_user(rs.getString(5));
		list.add(enseignant);
		}
		con.close();
		}catch(Exception e){e.printStackTrace();}
		return list;
		}
	
	public static int delete(Enseignant e){
		int status = 0;
		Enseignant enseignant =new Enseignant();
		try{
		Connection con=EnseignantDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from bd_enseignant.enseignant where id=?");
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		enseignant.setId(rs.getInt(1));
		enseignant.setNom(rs.getString(2));
		enseignant.setPrenom(rs.getString(3));
		enseignant.setGrade(rs.getString(4));
		enseignant.setId_user(rs.getString(5));
		}
		con.close();
		}catch(Exception ex){ex.printStackTrace();}
		return status;
	}
	
	public static int update(Enseignant e){
		int status = 0;
		Enseignant enseignant =new Enseignant();
		try{
		Connection con=EnseignantDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from bd_enseignant.enseignant set nom = ?,prenom=?, grad=?,id_user=? where id=?");
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		enseignant.setId(rs.getInt(1));
		enseignant.setNom(rs.getString(2));
		enseignant.setPrenom(rs.getString(3));
		enseignant.setGrade(rs.getString(4));
		enseignant.setId_user(rs.getString(5));
		}
		con.close();
		}catch(Exception ex){ex.printStackTrace();}
		return status;
	}

}
