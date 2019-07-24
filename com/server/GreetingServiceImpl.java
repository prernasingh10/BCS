package com.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.client.GreetingService;
import com.shared.FieldVerifier;
import com.shared.Reg;
import com.shared.farmerslist;
import com.shared.fdet;
import com.shared.nuti;
import com.shared.sevent;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {

	private static  String date = null;
	private static String location = null;
	private static String nutrients = null;
	private static String crops = null;
	private static  String land_area = null;
	private static  String longitude = null;
	private static  String latitude = null;
	private static  String gender = null;
	private static  String city = null;
	private static  String district = null;
	private static  String state = null;
	private static  String name = null;
	private static  String address = null;
	private static  String mobile = null;
	private static String aadhar = null;
	private static String email = null;
	private static  String password = null;
	private static  Long lat = null;
	private static Long lon = null;
	private static Float larea = null;
	private static Float nut = null;
	private static  String crop = null;
	
	Connection con= null;
	Statement st = null;
	public void init()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farm","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	String row()
	{
		init();
		ResultSet r= null;
		String rowCount="";
		try {
			r=st.executeQuery("select count(*) from farmer");
			r.next();
			 rowCount = r.getString(1);
			System.out.println(rowCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}
	@Override
	public String checkc(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet rs=null;
		String c="";
		try {
			rs=st.executeQuery("select c_id from consumer where name='"+s1+"'and password='"+s2+"'");
			if(rs.next())
				c=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public String checkf(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet rs=null;
		String f="";
		try {
			rs=st.executeQuery("select f_id from farmer where name='"+s1+"'and password='"+s2+"'");
			if(rs.next())
				f=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	@Override
	public String reg(Reg k) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		name=k.getName();
		address=k.getAddress();
		mobile=k.getMobile();
		aadhar=k.getAadhar();
		gender=k.getGender();
		city=k.getCity();
		district=k.getDistrict();
		state=k.getState();
		email=k.getEmail();
		password=k.getPassword();
		String sql="insert into consumer(name,address,mob_no,aadhar,gender,city,district,state,email,password)values('"+name+"','"+address+"','"+mobile+"','"+aadhar+"','"+gender+"','"+city+"','"+district+"','"+state+"','"+email+"','"+password+"')";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String x="registration success";
		return x;
	}
	@Override
	public String freg(Reg m) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		name=m.getName();
		address=m.getAddress();
		mobile=m.getMobile();
		aadhar=m.getAadhar();
		gender=m.getGender();
		city=m.getCity();
		district=m.getDistrict();
		state=m.getState();
		email=m.getEmail();
		password=m.getPassword();
		String sql="insert into farmer(name,address,mob_no,aadhar,gender,city,district,state,email,password)values('"+name+"','"+address+"','"+mobile+"','"+aadhar+"','"+gender+"','"+city+"','"+district+"','"+state+"','"+email+"','"+password+"')";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String x="registration success";
		return x;
	
	}
	@Override
	public String feed(String f) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		
		String y="NO";
		String sql="insert into feedback(feed)values('"+f+"')";
		try {
			st.executeUpdate(sql);
			y="YES";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return y;
	}
	@Override
	public String land(nuti n) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		latitude =n.getLatitude();
		longitude=n.getLongitude();
		land_area=n.getLand_area();
		crops=n.getCrops();
		nutrients=n.getNutrients();
		String sql="insert into land(latitude,longitude,land_area,crops,nutrients)values('"+latitude+"','"+longitude+"','"+land_area+"','"+crops+"','"+nutrients+"')";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String x="details entered";
		return x;
	}
	@Override
	public fdet det(fdet f,String i) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet rs= null;
		try {
			rs=st.executeQuery("select f_id,name,address,mob_no,aadhar,email from farmer where f_id='"+i+"'");
		if(rs.next()) {
			f.setF_id(rs.getString(1));
			f.setName(rs.getString(2));
			f.setAddress(rs.getString(3));
			f.setMobile(rs.getString(4));
			f.setAadhar(rs.getString(5));
			f.setEmail(rs.getString(6));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	@Override
	public String book(String r) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String sql="insert into book(name)values('"+r+"')";
		
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String y="Booking Successful";
		return y;
	}
	@Override
	public String show(String s) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet r=null;
		String req="";
		try {
			r=st.executeQuery("select req from book");
			while(r.next())
			{
				 req = r.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return req;
	}
	@Override
	public sevent evnt(sevent k) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet re = null;
		try {
	
			re=st.executeQuery("select * from event");
			while(re.next())
			{
				
			k.setName(re.getString(1));
			k.setDate(re.getString(2));
			k.setLocation(re.getString(3));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	
	}
	@Override
	public String fevnt(sevent l) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		name=l.getName();
		date=l.getDate();
		location=l.getLocation();
		String sql="insert into event(name,date,location)values('"+name+"','"+date+"','"+location+"')";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String x="submitted";
		return x;
	}
	@Override
	public farmerslist allfar(String l) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet r=null;
		String n="";
		farmerslist l1 = new farmerslist();
		n=row();
		int n1=Integer.parseInt(n);
		String a[]= new String[n1];
		int i=0;
		try {
			r=st.executeQuery("select f_id from farmer");
			while(r.next())
			{
				a[i]=r.getString(1);
				i++;
				l1.setN(n1);
				l1.setF(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l1;
	}
	
		}
