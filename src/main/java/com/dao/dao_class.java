package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import com.bo.bo_class;
import com.bo.bo_class_add;
import java.util.*;
public class dao_class {
	public  static Connection connect()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysecond?useSSL=false&allowPublicKeyRetrieval=true","root","Pass@12345");
			
			return con;
			
		} catch (Exception e) {
			return null;
			
		}
		
	}
	public static int signup(bo_class lb)
	{
	Connection con=	dao_class.connect();
	int status=0;
	try {
		String s="insert into project_real(username,email,password,confirm_pass) values(?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(s);
		
		ps.setString(1, lb.getUsername());
		ps.setString(2, lb.getEmail());
		ps.setInt(3, lb.getPassword());
		
		ps.setInt(4, lb.getConfirm_pass());
		
		
		
		status=ps.executeUpdate();
		
	} 
	catch (Exception e) {
		
		System.out.println(e);
		
	}
	return status;
		
	}
	public static boolean login(String user ,int pass)
	{
		boolean status=false;
		Connection con=dao_class.connect();
		try
		{
			String s="select * from project_real where username=? and password=?";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1, user);
			ps.setInt(2, pass);
			
			ResultSet rs=ps.executeQuery();
			
			status=rs.next();
			
		}
		catch(Exception e)
		{
		System.out.println(e);	
		}
		return status;
	}
	
	public static int add(bo_class_add lb)
	{
		int status=0;
		try {
			
			Connection con=dao_class.connect();
			String s="insert into add_date (id ,name , city, Department, join_date,salary) values(?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1, lb.getId());
			ps.setString(2,lb.getName());
			ps.setString(3, lb.getCity());
			ps.setString(4, lb.getDepartment());
			ps.setString(5, lb.getJoin());
			ps.setInt(6, lb.getSalary());
			
			 status=ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
		
	}
	public static List fetch()
	{
		Connection con=dao_class.connect();
		List< bo_class_add> ob=new ArrayList< bo_class_add>();
		int status=0;
		try {
			
			String s="select * from add_date";
			PreparedStatement ps=con.prepareStatement(s);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 bo_class_add lbo=new  bo_class_add();
				lbo.setId(rs.getInt(1));
				lbo.setName(rs.getString(2));
				lbo.setCity(rs.getString(3));
				lbo.setDepartment(rs.getString(4));
				lbo.setJoin(rs.getString(5));
				lbo.setSalary(rs.getInt(6));
				
	          ob.add(lbo);
			 
			}
			
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return ob;
		
	}
	public static int delete(int id)
	{
		Connection con=dao_class.connect();
		int status=0;
		try {
			String s="delete from add_date where id=?";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1, id );
			
			status=ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	
	public static int update(bo_class_add lb)
	{
		Connection con=dao_class.connect();
		int status=0;
		try {
			
			String s="update add_date set name=? ,city=?,department=?,join_date=? ,salary=? where id=?";
			PreparedStatement ps=con.prepareStatement(s);
			
			ps.setString(1, lb.getName());
			ps.setString(2, lb.getCity());
			ps.setString(3, lb.getDepartment());
			ps.setString(4, lb.getJoin());
			ps.setInt(5, lb.getSalary());
			ps.setInt(6, lb.getId());
		
			
			
			status=ps.executeUpdate();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
		
	}
	
	public static bo_class_add element_byid(int id)
	{
		int status=0;
		bo_class_add ob=new bo_class_add();
		Connection con=dao_class.connect();
		try {
			String s="select * from add_date where id=?";
			PreparedStatement ps=con.prepareStatement(s);
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setCity(rs.getString(3));
				ob.setDepartment(rs.getString(4));
				ob.setJoin(rs.getString(5));
				ob.setSalary(rs.getInt(6));
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}
	public static List search(int id,String name1)
	{
		
		int status=0;
		List <bo_class_add> ob=new ArrayList();
		try {
			
			Connection con=dao_class.connect();
			String s="select * from add_date where id=? or name=? ";
			PreparedStatement ps=con.prepareStatement(s);
			
			ps.setInt(1, id);
			ps.setString(2,name1 );
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 bo_class_add lbo=new  bo_class_add();
				lbo.setId(rs.getInt(1));
				lbo.setName(rs.getString(2));
				lbo.setCity(rs.getString(3));
				lbo.setDepartment(rs.getString(4));
				lbo.setJoin(rs.getString(5));
				lbo.setSalary(rs.getInt(6));
				
	          ob.add(lbo);
			 
			}
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}
	
	

}
