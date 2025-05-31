// ✅ 기존에 import axios from ... 사용하면 에러 발생 (CDN 방식에서는 import 불가)
//    → 그래서 window.axios로 접근함 (글로벌로 로드된 axios 사용)

export async function getLibraryData() {
  const url = "http://openapi.seoul.go.kr:8088/sample/json/SeoulLibraryTimeInfo/1/5/";
  const response = await window.axios.get(url); //  전역 객체로 axios 접근
  return response.data.SeoulLibraryTimeInfo.row; //  전체 도서관 리스트 리턴
}
