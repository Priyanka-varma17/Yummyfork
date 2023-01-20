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
	
	public int addAdmin(Admin admin)throws SQLException{		//ex
		
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
				System.out.println("Record inserted successfully");
				System.out.println("*****************************");
				return 1;
			}
			else {
				System.out.println("Failed to insert record");
				return 0;
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
//public int getAdminByEmail(Admin admin) throws SQLException{			//ex
//		
//		
//		try(Connection con=db.getConnection();
//				PreparedStatement pst=con.prepareStatement(QueryUtil.getAdminByEmail);
//				){
//			
//			pst.setString(1, admin.getAdminEmail());
//			ResultSet rs=pst.executeQuery();
//			if(rs.next()) {
//		
//				
//				//getFoodInfo(new Food(rs.getString(1),rs.getFloat(2),rs.getInt(3),rs.getString(4)));
//					
//				System.out.println("Admin name:"+rs.getString("adminname"));
//				System.out.println("Admin Address:"+rs.getString("adminaddress"));
//				System.out.println("Admin Mobile:"+rs.getLong("adminmobile"));
//				System.out.println("Admin Email:"+rs.getString("adminemail"));
//				
//				return 1;
//			}
//			else {
//				System.out.println("Record not found for admin email:  "+admin.getAdminEmail());
//				return 0;
//			}
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
//		
//	}
	
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
