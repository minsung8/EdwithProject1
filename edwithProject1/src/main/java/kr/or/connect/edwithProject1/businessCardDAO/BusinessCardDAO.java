package kr.or.connect.edwithProject1.businessCardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import kr.or.connect.edwithProject1.businessCardDTO.BusinessCardDTO;
import kr.or.connect.edwithProject1.jdbcConnection.MyDBConnection;

public class BusinessCardDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null; 
	
	public void close() {
		
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addCard(Scanner sc) {
		
		int addCnt = 0;	
		
		try {
			
			conn = MyDBConnection.getConn();
			
			String sql = "insert into businesscard(name, phone, companyName) values (?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			
			System.out.println("이름을 입력하세요 : ");
			String name = sc.nextLine();
			System.out.println("전화번호를 입력하세요 : ");
			String phone = sc.nextLine();
			System.out.println("회사를 입력하세요 : ");
			String companyName = sc.nextLine();
			
		
			BusinessCardDTO dto = new BusinessCardDTO(name, phone, companyName);
			
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPhone());
			ps.setString(3, dto.getCompanyName());
			
			addCnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		if (addCnt == 1) {
			System.out.println("명함입력에 성공하였습니다.");
		} else {
			System.out.println("명함입력에 실패하였습니다.");
		}
	} 
	
	public void getCard(Scanner sc){
				
		conn = MyDBConnection.getConn();
		
		String sql = "select * from businesscard where name like '%'|| ? ||'%'";
		System.out.println("검색할  이름을 입력하세요 (% 검색)");
		String search_name = sc.nextLine();
		
		 
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, search_name);
			rs = ps.executeQuery();		
			
			System.out.println("이름  전화번호 회사이름 명함발급날짜");

			while (rs.next()) {
				
				String name = rs.getString(1);
				String phone = rs.getString(2);
				String companyName = rs.getString(3);
				Timestamp createDate = rs.getTimestamp(4);
				
				System.out.println(name +" "+ phone +" "+ companyName +" "+ createDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
