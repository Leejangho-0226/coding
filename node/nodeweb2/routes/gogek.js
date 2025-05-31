// 고객 관련 모듈 별도 작성
import { Router } from 'express';
const router = Router();

router.get('/', (req, res) => {
  res.send('고객 전체 목록 출력!');
});

export default router;
