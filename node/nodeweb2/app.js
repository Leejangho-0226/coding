// get, post 요청 처리 연습

import express from 'express';                      
import path from 'path';                            
import cors from 'cors';                            
import { fileURLToPath } from 'url';                

//  jikwon 라우터 모듈 불러오기
import jikwonRouter from './routes/jikwon.js';      //  routes 폴더 안에 있는 jikwon.js 모듈을 import
import gogekRouter from './routes/gogek.js';

const app = express();                              
const PORT = 3000;
app.set('port', PORT);                              //  포트 번호를 app 설정에 저장 (추후 app.get으로 가져오기 위해)                                  

//  ES 모듈에서는 __dirname을 직접 쓸 수 없기 때문에 아래 코드로 설정
const __filename = fileURLToPath(import.meta.url);  //  현재 파일 경로 얻기 (파일 자체)
const __dirname = path.dirname(__filename);         //  현재 디렉토리 경로 얻기 (폴더 경로)

//  미들웨어 설정
app.use(cors());                                    //  모든 출처에서 요청 허용 (CORS 정책 완화)
app.use(express.json());                            //  JSON 형식 요청 본문을 파싱함 (req.body로 접근 가능)
app.use(express.urlencoded({ extended: true }));    //  폼 전송 (application/x-www-form-urlencoded) 데이터 파싱
app.use(express.static(path.join(__dirname, 'public'))); //  정적 파일(html, css, js 등)을 제공할 public 폴더 지정

//  외부 라우터(jikwon.js) 등록 (선행 문자열 /jikwon)
app.use('/jikwon', jikwonRouter);                   //  "/jikwon"으로 시작하는 모든 요청은 jikwonRouter에서 처리
app.use('/gogek',  gogekRouter); 

//  기본 GET 요청 (루트)
app.get('/', (req, res) => {                        //  root 요청청
 // res.send('메인');                                 //  클라이언트에게 문자열을 전송
    res.sendFile(path.join(__dirname,'./public/main.html'));
});



//  서버 실행
app.listen(PORT, () => {
  console.log(app.get('port'), '번 포트번호로 웹서버 서비스 시작 ...'); 
});
