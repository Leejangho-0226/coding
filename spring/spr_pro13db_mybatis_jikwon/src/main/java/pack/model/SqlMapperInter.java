package pack.model;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

public interface SqlMapperInter {

    // 1️⃣ 직원 목록 출력
    @Select(
        "SELECT jikwonno, jikwonname, " +
        "IFNULL(b.busername, '무소속') AS busername, " +
        "YEAR(jikwonibsail) AS ibsayear " +
        "FROM jikwon j " +
        "LEFT JOIN buser b ON j.busernum = b.buserno " +
        "ORDER BY jikwonno"
    )
    @Results({
        @Result(property = "jikwonno", column = "jikwonno"),
        @Result(property = "jikwonname", column = "jikwonname"),
        @Result(property = "busername", column = "busername"),
        @Result(property = "ibsayear", column = "ibsayear")
    })
    List<JikwonDto> selectAllJikwon();

    // 2️⃣ 부서별 인원수
    @Select(
        "SELECT IFNULL(b.busername, '무소속') AS busername, COUNT(*) AS cnt " +
        "FROM jikwon j LEFT JOIN buser b ON j.busernum = b.buserno " +
        "GROUP BY busername " +
        "ORDER BY busername"
    )
    @Results({
        @Result(property = "busername", column = "busername"),
        @Result(property = "cnt", column = "cnt")
    })
    List<JikwonDto> selectBuserCount();

    // 3️⃣ 부서별 최대 급여자
    @Select(
        "SELECT IFNULL(b.busername, '무소속') AS busername, jikwonname, jikwonpay " +
        "FROM jikwon j LEFT JOIN buser b ON j.busernum = b.buserno " +
        "WHERE (jikwonpay, IFNULL(b.busername, '무소속')) IN ( " +
        "  SELECT MAX(jikwonpay), IFNULL(b.busername, '무소속') " +
        "  FROM jikwon j2 LEFT JOIN buser b ON j2.busernum = b.buserno " +
        "  GROUP BY b.busername " +
        ") " +
        "ORDER BY busername"
    )
    @Results({
        @Result(property = "busername", column = "busername"),
        @Result(property = "jikwonname", column = "jikwonname"),
        @Result(property = "jikwonpay", column = "jikwonpay")
    })
    List<JikwonDto> selectMaxPayByBuser();
}
