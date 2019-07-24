package com.xxx.bl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xxx.model.Customer;

public class CustomerCRUD 
{
	public boolean addcustomer (Customer C) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.h2.Driver");
		Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
		PreparedStatement ps=con.prepareStatement("insert into customer values (?,?,?,?)");
		ps.setString(1, C.getFname());
		ps.setString(2, C.getLname());
		ps.setString(3, C.getEmailID());
		ps.setString(4, C.getUser_Password());
		if(ps.executeUpdate()!=0)
		return true;
		else
		return false;
	}
	public ArrayList<Customer> SelectAllCustomer() throws ClassNotFoundException, SQLException {
	Class.forName("org.h2.Driver");
	Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
	Statement s= con.createStatement();
	ResultSet rs=s.executeQuery("Select * from Customer");
	System.out.println(rs);
	ArrayList<Customer> custlist =new ArrayList<>();
	while (rs.next())
	{
		Customer c=new Customer ();
		c.setFname(rs.getString(1));
		c.setLname(rs.getString(2));
		c.setEmailID(rs.getString(3));
		custlist.add(c);
		System.out.println(custlist);
	}
	return custlist;
}}


