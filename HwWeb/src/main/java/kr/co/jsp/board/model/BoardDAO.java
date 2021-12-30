package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.jsp.board.common.PageVO;

public class BoardDAO implements IBoardDAO {
	
private DataSource ds;
	
	private BoardDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	///////////////////////////////////////////////////////////////////

	//글 등록 메서드
	@Override
	public void regist(String writer, String title, String content) {
		String sql = "INSERT INTO hw_board "
				+ "(board_id, writer, title, content) "
				+ "VALUES(hw_board_seq.nextval,?,?,?)";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//글 전체 목록을 가지고 오는 메서드(페이징)
	@Override
	public List<BoardVO> listBoard(PageVO paging) {
		List<BoardVO> articles = new ArrayList<>();
		String sql = "SELECT * FROM"
	            + "   ("
	            + "   SELECT ROWNUM AS rn, tbl.* FROM "
	            + "      ("
	            + "      SELECT * FROM hw_board"
	            + "      ORDER BY board_id DESC"
	            + "      ) tbl"
	            + "   )"
	            + "WHERE rn > " + (paging.getPage()-1) * paging.getCountPerPage()
	            + "AND rn <= " + paging.getPage() * paging.getCountPerPage();
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date")
						);
				articles.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return articles;
	}

	//글 상세보기 요청을 처리할 메서드
	@Override
	public BoardVO contentBoard(int bId) {
		BoardVO vo = null;
		String sql = "SELECT * FROM hw_board WHERE board_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date")
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	//글 수정 요청을 처리할 메서드
	@Override
	public void updateBoard(String title, String content, int bId) {
		String sql = "UPDATE hw_board SET title=?, content=? WHERE board_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//글 삭제 요청을 처리할 메서드
	@Override
	public void deleteBoard(int bId) {
		String sql = "DELETE FROM hw_board WHERE board_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//총 게시물의 수를 조회하는 메서드 (페이징 때문에 필요함)
	@Override
		public int countArticles() {
			int count = 0;
			String sql = "SELECT COUNT(*) FROM hw_board";
			try(Connection conn = ds.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					count = rs.getInt("count(*)");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return count;
		}
	
	//게시판 글 검색 메서드
	@Override
		public List<BoardVO> searchBoard(String keyword) {
			List<BoardVO> articles = new ArrayList<>();
			String sql = "SELECT * FROM hw_board WHERE title LIKE ? ORDER BY board_id DESC";
			
			try(Connection conn = ds.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, "%" + keyword + "%");
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardVO vo = new BoardVO(
							rs.getInt("board_id"),
							rs.getString("writer"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getTimestamp("reg_date")
							);
					articles.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return articles;
		}
	
	//메인페이지 게시판 최근 게시물 5개 가져오는 메서드
	@Override
		public List<BoardVO> mainBoard() {
			List<BoardVO> main = new ArrayList<>();
			String sql = "SELECT * FROM (SELECT * FROM hw_board ORDER BY board_id DESC) WHERE ROWNUM <= 5";
			
			try(Connection conn = ds.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
							ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					BoardVO vo = new BoardVO(
							rs.getInt("board_id"),
							rs.getString("writer"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getTimestamp("reg_date")
							);
					main.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return main;
		}

}
