package com.place.model;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class PlaceJDBCDAO implements Place_interface {
	String driver = "Oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin@localhost:1521:XE";
	String userid = "ba101";
	String passwd = "ba101";

	private static final String INSERT_STMT = "insert into PLACE (P_NO,MF_NO,MEM_NO,P_NAME,P_UNTIL,P_PLACE,P_POP,PIMG,P_INFO,P_STA,P_PRICE)values('P'||LPAD(P_NO_SQ.NEXTVAL,9,0),?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "select * from PLACE ORDER BY P_NO";
	private static final String GET_ONE_STMT = "select MF_NO,MEM_NO,P_NAME,P_UNTIL,P_PLACE,P_POP,PIMG,P_INFO,P_STA,P_PRICE from PLACE WHERE P_NO= ?";
	private static final String DELETE_STMT = "delete from PLACE where P_NO = ?";
	private static final String UPDATE_STMT = "update PLACE set MF_NO=?,MEM_NO=?,P_NAME=?,P_UNTIL=?,P_PLACE=?,P_POP=?,PIMG=?,P_INFO=?,P_STA=?,P_PRICE=? where P_NO=?";

	@Override
	public void insert(PlaceVO placeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, placeVO.getMf_no());
			pstmt.setString(2, placeVO.getMem_no());
			pstmt.setString(3, placeVO.getP_name());
			pstmt.setTimestamp(4, placeVO.getP_until());
			pstmt.setString(5, placeVO.getP_place());
			pstmt.setInt(6, placeVO.getP_pop());
			pstmt.setBytes(7, placeVO.getPimg());
			pstmt.setString(8, placeVO.getP_info());
			pstmt.setString(9, placeVO.getP_sta());
			pstmt.setInt(10, placeVO.getP_price());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(PlaceVO placeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);
			pstmt.setString(1, placeVO.getMf_no());
			pstmt.setString(2, placeVO.getMem_no());
			pstmt.setString(3, placeVO.getP_name());
			pstmt.setTimestamp(4, placeVO.getP_until());
			pstmt.setString(5, placeVO.getP_place());
			pstmt.setInt(6, placeVO.getP_pop());
			pstmt.setBytes(7, placeVO.getPimg());
			pstmt.setString(8, placeVO.getP_info());
			pstmt.setString(9, placeVO.getP_sta());
			pstmt.setInt(10, placeVO.getP_price());
			pstmt.setString(11, placeVO.getP_no());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(String p_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setString(1, p_no);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public PlaceVO findByPrimaryKey(String p_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PlaceVO placeVO = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, p_no);
			rs = pstmt.executeQuery();

			placeVO = new PlaceVO();
			placeVO.setMf_no(rs.getString("MF_NO"));
			placeVO.setMem_no(rs.getString("MEM_NO"));
			placeVO.setP_name(rs.getString("P_NAME"));
			placeVO.setP_until(rs.getTimestamp("P_UNTIL"));
			placeVO.setP_place(rs.getString("P_PLACE"));
			placeVO.setP_pop(rs.getInt("P_POP"));
			placeVO.setPimg(rs.getBytes("PIMG"));
			placeVO.setP_info(rs.getString("P_INFO"));
			placeVO.setP_sta(rs.getString("P_STA"));
			placeVO.setP_price(rs.getInt("P_PRICE"));

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return placeVO;

	}

	@Override
	public List<PlaceVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<PlaceVO> list = new ArrayList<PlaceVO>();
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PlaceVO placeVO = new PlaceVO();
				placeVO.setMf_no(rs.getString("MF_NO"));
				placeVO.setMem_no(rs.getString("MEM_NO"));
				placeVO.setP_name(rs.getString("P_NAME"));
				placeVO.setP_until(rs.getTimestamp("P_UNTIL"));
				placeVO.setP_place(rs.getString("P_PLACE"));
				placeVO.setP_pop(rs.getInt("P_POP"));
				placeVO.setPimg(rs.getBytes("PIMG"));
				placeVO.setP_info(rs.getString("P_INFO"));
				placeVO.setP_sta(rs.getString("P_STA"));
				placeVO.setP_price(rs.getInt("P_PRICE"));
				list.add(placeVO);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		PlaceJDBCDAO placejdbcdao = new PlaceJDBCDAO();
// insert
		// PlaceVO placeVO = new PlaceVO();
		// placeVO.setMf_no("");
		// placeVO.setMem_no("");
		// placeVO.setP_name("");
		// placeVO.setP_until(java.sql.Timestamp.valueOf("0-0-0 0:0:0"));
		// placeVO.setP_place("");
		// placeVO.setP_pop(1);
		// placeVO.setPimg(getPicture("nothing-here.jpg"));
		// placeVO.setP_info("");
		// placeVO.setP_sta("");
		// placeVO.setP_price(12);
		
		// placejdbcdao.insert(placeVO);
// update
		// PlaceVO placeVO = new PlaceVO();
		// placeVO.setP_no("");
		// placeVO.setMf_no("");
		// placeVO.setMem_no("");
		// placeVO.setP_name("");
		// placeVO.setP_until(java.sql.Timestamp.valueOf("0-0-0 0:0:0"));
		// placeVO.setP_place("");
		// placeVO.setP_pop(1);
		// placeVO.setPimg(getPicture("nothing-here.jpg"));
		// placeVO.setP_info("");
		// placeVO.setP_sta("");
		// placeVO.setP_price(12);
		
		// placejdbcdao.update(placeVO);
//delete
		//placejdbcdao.delete("");
//search one
		// PlaceVO placeVO =placejdbcdao.findByPrimaryKey("");
		// System.out.println(placeVO.getP_no());
		// System.out.println(placeVO.getMf_no());
		// System.out.println(placeVO.getMem_no());
		// System.out.println(placeVO.getP_name());
		// System.out.println(placeVO.getP_until());
		// System.out.println(placeVO.getP_place());
		// System.out.println(placeVO.getP_pop());
		// System.out.println(placeVO.getPimg());
		// System.out.println(placeVO.getP_info());
		// System.out.println(placeVO.getP_sta());
		// System.out.println(placeVO.getP_price());
		// System.out.println("---------------------");
//search all
		// List<PlaceVO> list=placejdbcdao.getAll();
		// for(PlaceVO placeVO :list){
		// // System.out.println(placeVO.getP_no());
		// // System.out.println(placeVO.getMf_no());
		// // System.out.println(placeVO.getMem_no());
		// // System.out.println(placeVO.getP_name());
		// // System.out.println(placeVO.getP_until());
		// // System.out.println(placeVO.getP_place());
		// // System.out.println(placeVO.getP_pop());
		// // System.out.println(placeVO.getPimg());
		// // System.out.println(placeVO.getP_info());
		// // System.out.println(placeVO.getP_sta());
		// // System.out.println(placeVO.getP_price());
		// // System.out.println("---------------------");
		// }
		
		

	}

	private static byte[] getPicture(String path) {
		byte[] data = null;
		FileInputStream fileinput;
		try {
			fileinput = new FileInputStream(new File(path));
			ByteArrayOutputStream fileoutput = new ByteArrayOutputStream();
			byte[] buffer = new byte[8152];
			int len = 0;
			while ((len = fileinput.read(buffer)) != -1) {
				fileoutput.write(buffer, 0, len);
			}
			data = fileoutput.toByteArray();
			fileinput.close();
			fileoutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
}
