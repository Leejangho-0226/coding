import express from "express";
import cors from "cors";
import path from "path";
import { fileURLToPath } from "url";
import session from "express-session";

const app = express();
const PORT = 3000;

// __dirname 설정
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

//  미들웨어 설정
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true })); // urlencoded 데이터(주로 HTML의 form 데이터, JSON)를 파싱하도록 처리


//  EJS 설정
app.set("view engine", "ejs"); // ejs를 템플릿엔진으로 사용
app.set("views", path.join(__dirname, "views")); // 뷰 파일의 디렉토리 설정

const auth = {  // 인증에 사용할 정보
  id: 'kor',
  password: '111'
};

//  express-session 설정
app.use(
  session({
    secret: "Kjf3984!@#42kasdfR*#$zxcv290423",   // secret: "secret-key",
    resave: false,
    saveUninitialized: true,
    cookie: { maxAge: 30 * 60 * 1000 } // 30분
  })
);

//  기본 라우팅 (로그인 페이지 제공)
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, 'login.html')); 
});

app.post("/login", (req, res) => {
  const { id, password } = req.body;
  // console.log(id, password);
  if (id === auth.id && password === auth.password) {
    req.session.user = { id };  // 세션에 사용자 id 저장
    res.redirect("/main");  // 로그인 성공시 메인 페이지로 이동하기 위한 요청
  } else {
    res.send(`로그인 실패! <a href="/">다시 로그인</a>`);
  }
});

app.get('/main', (req, res)=> {
    if (req.session.user) {
    res.render('mymain', {sessionId:req.session.user.id});  // forwarding
  } else {
    res.send(`접근 불가함 <a href='/'>로그인 화면으로</a>`);
  }
});

app.get("/logout", (req, res) => {
  req.session.destroy((err) => {  // 세션을 제거
    if(err){
        // 세션 제거 중 오류 발생시 메인페이지로 이동
        return res.redirect('/main');
     }
    res.clearCookie('connect.sid'); // 세션 쿠키 삭제
    res.redirect('/');
  });
});

//  서버 시작
app.listen(PORT, () => {
  console.log(`server is running at http://localhost:${PORT}`);
});
