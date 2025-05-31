// ✅ 기존에는 row[0] → 하나만 가져왔는데, 전체 출력 위해 row 전체 리턴으로 수정

export async function getLibraryData() {
  const url = "http://openapi.seoul.go.kr:8088/sample/json/SeoulLibraryTimeInfo/1/5/";
  const response = await fetch(url);
  const json = await response.json();
  return json.SeoulLibraryTimeInfo.row; // 리스트 전체 리턴
}
