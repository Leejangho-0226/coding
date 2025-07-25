import express from "express";
import cors from "cors";
import path from "path";
import { fileURLToPath } from "url";


const app = express();
const PORT = 3000;

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

app.use(express.json());

app.use(express.static(path.join(__dirname, 'public')));

let datas = [
  {id:1,name:'오공',position:'개발자'},
  {id:2,name:'팔계',position:'디자이너'}
]

let nextId = 3; // 새로운 직원 추가 시  id 증가값 설정

app.get('/', (req,res) => {
  res.send('자 그럼 요청을 시작합니다 /emp, /emp/1, /abc.html');
});

// 전체 직원 읽기
app.get('/emp', (req,res) => {
    res.json(datas);
});

// 직원 추가 
app.post('/emp', (req,res) => {
  const newEmp = {
      id:nextId++,
      name:req.body.name,
      position:req.body.position
  };

  datas.push(newEmp);
  res.status(201).json(newEmp); // 메소드 체이닝 구문 
});

// 1개 자료 읽기 부분(부분 데이터 읽기)
app.get('/emp/:id', (req,res) => {
    const employee = datas.find(emp => emp.id === parseInt(req.params.id,10));
    if(!employee) return res.status(404).send('data not found');

    res.json(employee);
});

// 직원 수정
app.put('/emp/:id', (req,res) => {
  //console.log(req.body, ' ', req.params.id); // { name: '호랑이', position: '선생님' }   3
  const employee = datas.find(emp => emp.id === parseInt(req.params.id,10));
  if(!employee) return res.status(404).send('data not found');

  // 클라이언트가 전송한 새 데이터(수정 데이터)가 있는 경우 이 값으로 기존 데이터 대체, 나머지는 유지
  employee.name = req.body.name || employee.name;
  employee.position = req.body.position || employee.position;
  res.json(employee);

});


// 직원 삭제
app.delete('/emp/:id', (req,res) => {
  const employeeIndex = datas.findIndex(emp => emp.id === parseInt(req.params.id,10));
  if(employeeIndex === -1) return res.status(404).send('data not found');

  // splice(인덱스, 갯수)
  const [delEmp] = datas.splice(employeeIndex, 1) // 삭제된 배열요소를 return(반환)
  res.json(delEmp); // 클라이언트에게 삭제된 배열 요소를 보여줌
});



app.listen(PORT, () => {
  console.log(`RESTful test is running at http://localhost:${PORT}`);
});
