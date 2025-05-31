// 라우팅 연습

import express from 'express';                      // Express 모듈 불러오기
import path from 'path';                            // 경로 조작을 위한 path 모듈
import cors from 'cors';                            // CORS 모듈 (다른 출처에서 요청 허용)
import { fileURLToPath } from 'url';                // 현재 모듈의 파일 경로와 디렉토리 경로 설정에 사용

const app = express();                              // Express 애플리케이션 생성
app.set('port', process.env.PORT || 3000);          // 포트 설정 (환경변수가 없으면 3000번 사용)

// CORS 설정 (CORS 정책을 해제해서 모든 외부 사이트에서 접근 가능하게 허용)
// npm i cors
// file:// 또는 다른 포트에서 HTML이 접근할 수 있도록 함
// 이클립스에서 static에서의 HTML에서도 접근이 가능함
// app.use(cors());  // CORS 미들웨어를 활성화     
const corsOptions = {
  origin: 'http://localhost:3000',              // 접근을 허용할 출처 (도메인)
  methods: ['GET', 'POST'],                     // 허용할 HTTP 메서드
  allowedHeaders: ['Content-Type', 'Authorization'] // 허용할 요청 헤더
};

// CORS 미들웨어 적용 (제한된 옵션 사용)
app.use(cors(corsOptions));                     

// import.meta.url : 현재 실행 중인 ES 모듈의 파일 경로(URL 형태, file://...)
// fileURLToPath(import.meta.url) : 위 URL을 일반적인 파일 경로 문자열로 변환
// CommonJS에서는 __filename이 기본 제공되지만,
// ESM 환경에서는 아래처럼 직접 만들어줘야 한다
const __filename = fileURLToPath(import.meta.url);  // __filename : 현재 실행 중인 JS 파일의 절대 경로

// __dirname : 현재 파일이 위치한 폴더 경로
// path.dirname(__filename)을 이용해 ESM에서도 __dirname처럼 사용 가능
const __dirname = path.dirname(__filename);         

// 정적 파일 서빙 (public 폴더에 있는 정적 자원 HTML, CSS, JS)
app.use(express.static(path.join(__dirname, 'public')));

// 라우팅 설정
app.get('/', (req, res) => {                         // 루트 경로 요청
  res.send('<h2>🏠 메인 페이지입니다</h2>');          // 클라이언트에게 문자열을 전송
});

app.get('/java', (req, res) => {                     // '/java' 요청
  res.send('<h2>👤 java 소개 페이지입니다</h2>');
});

app.get('/node', (req, res) => {                     // '/node' 요청
  res.send('<a href="https://cafe.daum.net/flowlife/RM66/7">💁node 안내</a>');
});

app.get('/abc', (req, res) => {                      // '/abc' 요청
  res.sendFile(path.join(__dirname, 'abc.html'));    // 현재 디렉토리의 abc.html을 전송
});

app.get('/json', (req, res) => {                     // '/json' 요청
  res.json({ '이름': '하마' });                       // JSON 전송
});

app.get('/member/:bun/:irum', (req, res) => {        // '/member/번호/이름' 요청
  const { bun, irum } = req.params;                  // bun과 irum 추출
  res.json({ bun: bun, irum });                      // JSON 응답
});

app.get('/user/:season', (req, res) => {             // '/user/계절' 요청
  const { season } = req.params;

  if (season === "summer") {
    res.json({ 'season': '뜨거워' });
  } else {
    res.json({ 'season': '추워' });
  }
});

app.get('/test', (req, res) => {                     // '/test' 요청
  res.sendFile(path.join(__dirname, 'test.html'));   // 현재 디렉토리의 test.html 전송
});

// 서버 실행
app.listen(app.get('port'), () => {
  console.log(app.get('port'), '번 포트번호로 웹서버 서비스 시작 ...');
});
