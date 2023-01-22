package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.Admin;

public class AdminRepository {

DatabaseConnection db=new DatabaseConnection();
	
	public int addAdmin(Admin admin)throws SQLException{		
		
		try(Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.addAdmin);){
			pst.setString(1,admin.getAdminName());
			pst.setString(2,admin.getAdminName());
			pst.setLong(3,admin.getAdminMobile());
			pst.setString(4,admin.getAdminEmail());
			
			System.out.println(admin.getAdminName()+"\t"+admin.getAdminName()+"\t"+admin.getAdminMobile()+"\t"+admin.getAdminEmail());
			
			int rows=pst.executeUpdate();
			System.out.println(rows);
			if(rows>0) {
				return 1;
			}
			else {
				return 0;
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Admin getAdminByEmail(String mail) throws SQLException{		//ex--
		
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getAdminByEmail);
				
			
			pst.setString(1, mail);
			ResultSet rs=pst.executeQuery();

			while (rs.next()) {
				
			Admin a=new Admin();
				a.setAdminId(rs.getInt(1));
				a.setAdminName(rs.getString(2));
				a.setAdminAddress(rs.getString(3));
				a.setAdminmobile(rs.getLong(4));
				a.setAdminEmail(rs.getString(5));
				return a;
			}
		
		return null;
		
	}
	
	public int updateAdmin(Admin admin) throws SQLException {
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.updateAdmin);
			
			pst.setString(1, admin.getAdminName());
			pst.setString(2, admin.getAdminAddress());
			pst.setLong(3, admin.getAdminMobile());
			pst.setString(4, admin.getAdminEmail());
			
			System.out.println("inside admin repository");
			System.out.println(admin.getAdminName()+"==>"+admin.getAdminAddress()+"==>"+admin.getAdminMobile()+"==>"+admin.getAdminEmail());
			return pst.executeUpdate();
	}
	
}
