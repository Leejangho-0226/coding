package pack.model;

import java.sql.*;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao {
    @Autowired
    private MyDataSource dataSource;

    public ArrayList<JikwonDto> getListByJik(String jik) {
        ArrayList<JikwonDto> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT jikwonno, jikwonname, jikwongen, jikwonpay FROM jikwon WHERE jikwonjik = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jik);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                JikwonDto dto = new JikwonDto();
                dto.setJikwonno(rs.getString("jikwonno"));
                dto.setJikwonname(rs.getString("jikwonname"));
                dto.setJikwongen(rs.getString("jikwongen"));
                dto.setJikwonpay(rs.getString("jikwonpay"));
                list.add(dto);
            }

        } catch (Exception e) {
            System.out.println("getListByJik 오류: " + e);
        } finally {
            try { if (rs != null) rs.close(); if (pstmt != null) pstmt.close(); if (conn != null) conn.close(); } catch (Exception e2) {}
        }

        return list;
    }
}
