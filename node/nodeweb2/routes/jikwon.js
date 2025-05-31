// 직원 관련 라우터 모듈

import { Router } from 'express';
import path from 'path';
import { fileURLToPath } from 'url';
const router = Router();


// 기본 직원 목록
router.get('/', (req, res) => {
  res.send('직원 전체 목록 출력쓰~');
});

// cheer 메시지
router.get('/nice', (req, res) => {
  res.send('직원들 화이팅');
});

// 동적 라우트 (우수직원 이름 받기)
router.get('/nice/:irum', (req, res) => {
  const irum = req.params.irum;   
  res.json({ '우수직원': irum }); 
});

const __filename = fileURLToPath(import.meta.url);  
const __dirname = path.dirname(__filename);         
router.get('/main', (req, res) => {
  res.sendFile(path.join(__dirname,'../public/main.html'));
});

const emps = [
    {id:1,name:'손오공'},
    {id:2,name:'피콜로'},
    {id:3,name:'크리링'}
];

router.get('/emps', (req, res) => {
    res.json(emps);
});

// 직원 추가(post방식)
router.post('/emps', (req, res) => {
  const newEmp = req.body;

  if (!newEmp || !newEmp.name) {
    return res.status(400).json({ error: 'invalid emp data'});
  }

  emps.push( newEmp );
  res.status(201).json(newEmp);
});

export default router;
