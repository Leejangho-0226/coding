<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>로그인 결과</title>
  <style>
    @keyframes fadeInUp {
      0% {
        opacity: 0;
        transform: translateY(30px);
      }
      100% {
        opacity: 1;
        transform: translateY(0);
      }
    }

    body {
      font-family: 'Segoe UI', sans-serif;
      background: linear-gradient(to right, #74ebd5, #ACB6E5); /* 배경 그라데이션 */
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .result-container {
      background-color: white;                      /* 박스 배경색 */
      padding: 40px 30px;                           /* 안쪽 여백 */
      border-radius: 12px;                          /* 둥근 테두리 */
      box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);    /* 그림자 */
      width: 320px;                                 /* 박스 너비 */
      animation: fadeInUp 1s ease;                  /* 애니메이션 효과 */
      text-align: center;                           /* 가운데 정렬 */
    }

    .result-message {
      font-size: 18px;
      color: #333;
      margin-bottom: 20px;
    }

    .footer {
      font-size: 13px;
      color: #888;
      margin-top: 15px;
      animation: fadeInUp 1.5s ease;
    }
  </style>
</head>
<body>
  <div class="result-container">
    <div class="result-message">
      결과 : ${data}
    </div>
    <div class="footer">ⓒ 2025 MyCompany</div>
  </div>
</body>
</html>
