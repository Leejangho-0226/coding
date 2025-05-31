package pack.model;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pack.mybatis.SqlMapConfig;

public class DataDao {
    private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

    public List<JikwonDto> getJikwonList() {
        SqlSession session = factory.openSession();
        List<JikwonDto> list = null;
        try {
            SqlMapperInter inter = session.getMapper(SqlMapperInter.class);
            list = inter.selectAllJikwon();
        } catch (Exception e) {
            System.out.println("getJikwonList 오류 : " + e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<JikwonDto> getBuserCount() {
        SqlSession session = factory.openSession();
        List<JikwonDto> list = null;
        try {
            SqlMapperInter inter = session.getMapper(SqlMapperInter.class);
            list = inter.selectBuserCount();
        } catch (Exception e) {
            System.out.println("getBuserCount 오류 : " + e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<JikwonDto> getMaxPayByBuser() {
        SqlSession session = factory.openSession();
        List<JikwonDto> list = null;
        try {
            SqlMapperInter inter = session.getMapper(SqlMapperInter.class);
            list = inter.selectMaxPayByBuser();
        } catch (Exception e) {
            System.out.println("getMaxPayByBuser 오류 : " + e);
        } finally {
            session.close();
        }
        return list;
    }
}
