package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dto.CustomerDTO;

import com.util.DBUtil;




public class CustomerDAO {


	//private static final int Accno = 0;

	public static boolean insertCustomer(CustomerDTO cm)throws Exception {
			Connection con = DBUtil.connect();
			 String query ="INSERT INTO CUSTOMER VALUES (?,?,?,?)";
			 PreparedStatement ps = con.prepareStatement(query);
			 ps.setInt(1, cm.getAccno());
			 ps.setString(2, cm.getCname());
			 ps.setDouble(3,cm.getBalance() );
			 ps.setString(4, cm.getPhone());
			 
			 return ps.executeUpdate()==1;
		}
	 
	 public static boolean deleteCustomer(int Accno) throws Exception{
	    	Connection con = DBUtil.connect(); 
	    	String query="DELETE FROM Customer WHERE Accno =?";
	    	PreparedStatement ps = con.prepareStatement(query);
	    	ps.setInt(1, Accno);
	    	return ps.executeUpdate() ==1;
}
	 public static boolean updateCustomer(CustomerDTO cm) throws Exception{
	    	Connection con =DBUtil.connect();
	    	String query ="UPDATE Customer SET CNAME =?,BALANCE=?, PHONE =? WHERE ACCNO=?";
	    	PreparedStatement ps = con.prepareStatement(query);
	    	ps.setInt(4, cm.getAccno());
	    	ps.setString(1, cm.getCname());
	    	ps.setDouble(2, cm.getBalance());
	    	ps.setString(3,cm.getPhone());
	    	return ps.executeUpdate()==1;
	    }
	 public static CustomerDTO selectCustomer(int accno) throws Exception{
		   	Connection con =DBUtil.connect();
		    	String query ="SELECT * FROM Customer WHERE Accno =?";
		    	PreparedStatement ps = con.prepareStatement(query);
		    	ps.setInt(1, accno);
		    	CustomerDTO e =null;
		    	ResultSet rs = ps.executeQuery();
		    	if(rs.next()){
		    		e=new CustomerDTO();
		    		e.setAccno(rs.getInt(1));
		   		    e.setCname(rs.getString(2));
		            e.setBalance(rs.getDouble(3));
		    		e.setPhone(rs.getString(4));
		    	}
		    	return e;
		     }
	 
	 public static ArrayList<CustomerDTO> selectAllCustomer () throws Exception {
 		Connection con1 =DBUtil.connect();
 		String query1 ="SELECT * FROM Customer";
 		PreparedStatement ps1 = con1.prepareStatement(query1);
 		CustomerDTO e1 =null;
 		ArrayList<CustomerDTO> al =new ArrayList<CustomerDTO>();
 		ResultSet rs1 = ps1.executeQuery();
 		
 		while(rs1.next()){
     		e1=new CustomerDTO();
     		e1.setAccno(rs1.getInt(1));
     		
    		    e1.setCname(rs1.getString(2));
             e1.setBalance(rs1.getDouble(3));
     		e1.setPhone(rs1.getString(4));
     		al.add(e1);
     	}
     	return al;
 		  
 		
 		
 	}

}
