// 웹 서버 구축하기
// http 모듈 가져오기
import http from 'http'; // ES 모듈 방식 (CommonJS일 경우 const http = require('http') 사용)

// 서버 포트 설정
// const PORT = 3000;

// 서버 생성
http.createServer((req, res) => {
  // 응답 헤더 설정 (응답 코드 200, 콘텐츠 타입 설정)
  res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
  res.write('<h2>교육센터 메인</h2>');
  res.write('반갑습니다<br/>');
  res.end('안녕히 가십시오');
  
  
})

// 서버 실행
.listen(8080, () => {
  console.log(`서버 서비스 중...`);
});
