package pack.mybatis;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pack.model.SqlMapperInter;

public class SqlMapConfig {
  public static SqlSessionFactory sqlSessionFactory;  //DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.
 
  static{
     String resource = "pack/mybatis/Configuration.xml";
     try {
         Reader reader = Resources.getResourceAsReader(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
         reader.close();
         
         // MyBatis Annotation을 사용하는 경우
         Class[] mappers = {SqlMapperInter.class};
         for(Class c1:mappers) {
        	 sqlSessionFactory.getConfiguration().addMapper(c1);
         }
         
     } catch (Exception e) {
     System.out.println("SqlMapConfig 오류 : " + e);
  }
}
 
public static SqlSessionFactory getSqlSession(){
     return sqlSessionFactory;
  }
}