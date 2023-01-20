package com.yummyfork.connection;

public class QueryUtil {
		
	public static String addFood="INSERT INTO FOOD(FOODNAME,FOODPRICE,FOODQUANTITY,FOODCATEGORY,IMAGEFILENAME) VALUES(?,?,?,?,?)";
	
	public static String updateFood="UPDATE FOOD SET FOODNAME=?,FOODPRICE=?,FOODQUANTITY=?,FOODCATEGORY=? WHERE FOODID =?";
	
	public static String deleteFoodById= "DELETE FROM FOOD WHERE FOODID= ?";
	
	public static String getFoodById="SELECT * FROM FOOD WHERE FOODID =?";
		
	public static String getFoodByName="SELECT * FROM FOOD WHERE FOODNAME LIKE ? ";
	
	public static String getFoodByCategory="SELECT * FROM FOOD WHERE FOODCATEGORY=?" ;
	
	public static String getAllFood="SELECT * FROM FOOD" ;
	
	
	public static String addCustomer="INSERT INTO CUSTOMER(CUSTNAME,CUSTADDRESS,CUSTMOBILE,CUSTEMAIL) VALUES(?,?,?,?)";
	
	public static String updateCustomer="UPDATE CUSTOMER SET CUSTNAME=?,CUSTADDRESS=?,CUSTMOBILE=? WHERE CUSTEMAIL=?";
	
	public static String deleteCustomerByEmail="DELETE FROM CUSTOMER WHERE CUSTEMAIL=?";
	
	public static String getCustomerById="SELECT * FROM CUSTOMER WHERE CUSTID=?";
	
	public static String getCustomerByEmail="SELECT * FROM CUSTOMER WHERE CUSTEMAIL=?";

	
	//public static String getCustomerByName="SELECT * FROM CUSTOMER WHERE CUSTNAME=?";
	
	public static String getAllCustomer="SELECT * FROM CUSTOMER";
	
	
	public static String addFoodCategory="INSERT INTO FOODCATEGORY VALUES(?,?)";
	
	public static String updateFoodCategory="UPDATE FOODCATEGORY SET MAINCATEGORY=? WHERE FOODCATENAME=?";
	
	public static String deleteFoodCategory="DELETE FROM FOODCATEGORY WHERE FOODCATENAME=?";
	
	public static String getFoodCategoryByName="SELECT * FROM FOODCATEGORY WHERE FOODCATENAME=?";
	
	public static String getFoodCategory="SELECT * FROM FOODCATEGORY";
	
	
	public static String ADD_TO_CART="INSERT INTO CART(FOOD_ID,CUSTOMER_EMAIL,CART_QUANTITY,FOODNAME) VALUES(?,?,?,?);";
	
	public static String UPDATE_CART="UPDATE CART SET CART_QUANTITY=? WHERE CUSTOMER_EMAIL=? AND FOOD_ID=?;";
	
	public static String CART_PRESENT="SELECT COUNT(*) FROM CART WHERE CUSTOMER_EMAIL=? AND FOOD_ID=?;";
	
	public static String DELETE_CART="DELETE FROM CART WHERE CART_ID=? AND CUSTOMER_EMAIL=? AND FOOD_ID=?;";
	
	public static String DELETE_CART_BY_EMAIL="DELETE FROM CART WHERE CUSTOMER_EMAIL=?;";
		
	public static String getCartByEmail="SELECT CA.CART_ID,CA.FOOD_ID,F.FOODNAME,CA.CART_QUANTITY FROM CART AS CA INNER JOIN "
			+ "FOOD AS F ON CA.FOOD_ID=F.FOODID WHERE CA.CUSTOMER_EMAIL=?;";
	
	
	
	public static String getTotalPrice="SELECT SUM(F.FOODPRICE*CA.CART_QUANTITY)"
			+ "FROM FOOD AS F INNER JOIN CART AS CA ON F.FOODID=CA.FOOD_ID WHERE CA.CUSTOMER_EMAIL=?;";
	
	public static String addOrders="INSERT INTO ORDERS(TOTAL_PRICE,STATUS,CUST_EMAIL) VALUES(?,?,?);";
	
	public static String getOrderListByEmail="SELECT * FROM ORDERS WHERE CUST_EMAIL=?;";

	
	public static String addUser="INSERT INTO USER VALUES (?,?,?)";
	
	public static String updateUser="UPDATE USER SET PASSWORD=? WHERE USERNAME=?";
	
	public static String deleteUserByUsername="DELETE FROM USER WHERE USERNAME=?";
	
	public static String getUserByEmail="SELECT * FROM USER WHERE USERNAME=?";
	
	public static String isUserValid="SELECT * FROM USER WHERE ROLE=? AND USERNAME=? AND PASSWORD=?";
	
	public static String isUsernameExist="SELECT * FROM USER WHERE USERNAME=?;";
	
	public static String checkPwdByEmail="SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=? ";
	
	public static String updatePassword="UPDATE USER SET PASSWORD=? WHERE USERNAME=?;";
	
	
	public static String addAdmin="INSERT INTO ADMIN(ADMINNAME,ADMINADDRESS,ADMINMOBILE,ADMINEMAIL) VALUES(?,?,?,?)";
	
	public static String updateAdmin="UPDATE ADMIN SET ADMINNAME=?,ADMINADDRESS=?,ADMINMOBILE=? WHERE ADMINEMAIL=?";
	
	public static String deleteAdminById="DELETE FROM ADMIN WHERE ADMINID=?";
	
	public static String getAdminById="SELECT * FROM ADMIN WHERE ADMINID=?";
	
	public static String getAdminByEmail="SELECT * FROM ADMIN WHERE ADMINEMAIL=?";

}
