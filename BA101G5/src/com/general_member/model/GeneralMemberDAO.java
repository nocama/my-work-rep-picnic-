package com.general_member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GeneralMemberDAO implements GeneralMemberDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT = "INSERT INTO GENERAL_MEMBER(MEM_NO, MEM_NAME, MEM_GEN, MEM_BIRTH, MEM_ADDR, MEM_MAIL, MEM_PSW, MEM_COIN, MEM_STATE,MEM_PHONE,MEM_PBOARD)"
			+ "VALUES('MG' || LPAD(MEM_NO_SQ.NEXTVAL, 8, '0'),?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE GENERAL_MEMBER SET MEM_NAME=?,MEM_GEN=?,MEM_BIRTH=?, MEM_ADDR=?, MEM_MAIL=? , MEM_PSW=?, MEM_COIN=?, MEM_STATE=? ,MEM_PHONE=?,MEM_PBOARD=? WHERE MEM_NO=?";
	private static final String DELETE = "DELETE FROM GENERAL_MEMBER WHERE MEM_NO=?";
	private static final String FINDBYKEY = "SELECT MEM_NAME, MEM_GEN, MEM_BIRTH, MEM_ADDR, MEM_MAIL, MEM_PSW, MEM_COIN, MEM_STATE,MEM_PHONE,MEM_PBOARD FROM GENERAL_MEMBER WHERE MEM_NO=?";
	private static final String FINDALL = "SELECT * FROM GENERAL_MEMBER";

	@Override
	public void insert(GeneralMemberVO generalmemberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, generalmemberVO.getMEM_NAME());
			pstmt.setString(2, String.valueOf(generalmemberVO.getMEM_GEN()));
			pstmt.setDate(3, generalmemberVO.getMEM_BIRTH());
			pstmt.setString(4, generalmemberVO.getMEM_ADDR());
			pstmt.setString(5, generalmemberVO.getMEM_MAIL());
			pstmt.setString(6, generalmemberVO.getMEM_PSW());
			pstmt.setInt(7, generalmemberVO.getMEM_COIN());
			pstmt.setString(8, String.valueOf(generalmemberVO.getMEM_STATE()));
			pstmt.setString(9, generalmemberVO.getMEM_PHONE());
			pstmt.setString(10, String.valueOf(generalmemberVO.getMEM_PBOARD()));

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void update(GeneralMemberVO generalmemberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, generalmemberVO.getMEM_NAME());
			pstmt.setString(2, String.valueOf(generalmemberVO.getMEM_GEN()));
			pstmt.setDate(3, generalmemberVO.getMEM_BIRTH());
			pstmt.setString(4, generalmemberVO.getMEM_ADDR());
			pstmt.setString(5, generalmemberVO.getMEM_MAIL());
			pstmt.setString(6, generalmemberVO.getMEM_PSW());
			pstmt.setInt(7, generalmemberVO.getMEM_COIN());
			pstmt.setString(8, String.valueOf(generalmemberVO.getMEM_STATE()));
			pstmt.setString(9, generalmemberVO.getMEM_PHONE());
			pstmt.setString(10, String.valueOf(generalmemberVO.getMEM_PBOARD()));
			pstmt.setString(11, generalmemberVO.getMEM_NO());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void delete(String MEM_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setString(1, MEM_NO);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public GeneralMemberVO findByPrimaryKey(String MEM_NO) {
		GeneralMemberVO gVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FINDBYKEY);
			pstmt.setString(1, MEM_NO);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				gVO = new GeneralMemberVO();
				gVO.setMEM_NAME(rs.getString("MEM_NAME"));
				gVO.setMEM_GEN(rs.getString("MEM_GEN").charAt(0));
				gVO.setMEM_BIRTH(rs.getDate("MEM_BIRTH"));
				gVO.setMEM_ADDR(rs.getString("MEM_ADDR"));
				gVO.setMEM_MAIL(rs.getString("MEM_MAIL"));
				gVO.setMEM_PSW(rs.getString("MEM_PSW"));
				gVO.setMEM_COIN(rs.getInt("MEM_COIN"));
				gVO.setMEM_STATE(rs.getString("MEM_STATE").charAt(0));
				gVO.setMEM_PHONE(rs.getString("MEM_PHONE"));
				gVO.setMEM_PBOARD(rs.getString("MEM_PBOARD").charAt(0));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return gVO;
	}

	@Override
	public List<GeneralMemberVO> getAll() {
		List<GeneralMemberVO> list = new ArrayList<GeneralMemberVO>();
		GeneralMemberVO gVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FINDALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				gVO = new GeneralMemberVO();
				gVO.setMEM_NO(rs.getString("MEM_NO"));
				gVO.setMEM_NAME(rs.getString("MEM_NAME"));
				gVO.setMEM_GEN(rs.getString("MEM_GEN").charAt(0));
				gVO.setMEM_BIRTH(rs.getDate("MEM_BIRTH"));
				gVO.setMEM_ADDR(rs.getString("MEM_ADDR"));
				gVO.setMEM_MAIL(rs.getString("MEM_MAIL"));
				gVO.setMEM_PSW(rs.getString("MEM_PSW"));
				gVO.setMEM_COIN(rs.getInt("MEM_COIN"));
				gVO.setMEM_STATE(rs.getString("MEM_STATE").charAt(0));
				gVO.setMEM_PHONE(rs.getString("MEM_PHONE"));
				gVO.setMEM_PBOARD(rs.getString("MEM_PBOARD").charAt(0));
				list.add(gVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;
	}

}