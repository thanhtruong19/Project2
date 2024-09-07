package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.sym.Name;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "19012003";
	@Override
	public List<BuildingEntity> findAll(String name, Long districtId) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("SELECT * FROM BUILDING WHERE 1 = 1 ");
		if(name != null && !name.equals("")) {
			sb.append("AND name like '%" + name + "%' ");
		}
		if(districtId != null) {
			sb.append("AND districtId = " + districtId + " ");
		}	
		List<BuildingEntity> result = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			     java.sql.Statement stmt = conn.createStatement();
			     ResultSet rs = stmt.executeQuery(sb.toString()); ) {
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setName(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("numberofBasement"));
				result.add(building);
			}
			} catch (SQLException e) {
			    // Xử lý ngoại lệ
			    e.printStackTrace();
			}
		return result;
	}
	public void DeleteByID(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE * FROM BUILDING WHERE id = " + id;
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			     java.sql.Statement stmt = conn.createStatement();
			     ResultSet rs = stmt.executeQuery(sql); ){ 
			} catch (SQLException e) {
			    // Xử lý ngoại lệ
			    e.printStackTrace();
			}
	}
	

	
}
