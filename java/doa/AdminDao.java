package doa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Admin;
import service.AdminService;
import utility.DBUtil;

public class AdminDao implements AdminService {

	

	@Override
	public Admin addAdmin(Admin admin) {
		try
		{
		Connection con =DBUtil.getConnectionWithDb();
		PreparedStatement ps=con.prepareStatement("insert into Admin_table values(?,?,?,?,?,?,?)");
		ps.setInt(1,admin.getAdminId());
		ps.setString(2, admin.getAdminName());
		ps.setString(3,admin.getAdminAddress());
		ps.setString(4,admin.getAdminEmail());
		ps.setLong(5,admin.getAdminPhone());
		
		Date d1=(Date) admin.getAdminDob();
		long millseconds=d1.getTime();
		Date  dob=new Date(millseconds);
		ps.setDate(6, dob);
		ps.setInt(7,admin.getUser().getUserId());
		int adminStatus=ps.executeUpdate();
		if(adminStatus>0) {
			return admin;
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	

}
