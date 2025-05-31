const Home = {
  template: `
    <div class="d-flex flex-column justify-content-between" style="min-height: 90vh;">
      <!-- 중앙 카드 -->
      <div class="d-flex justify-content-center align-items-center flex-grow-1">
        <div class="card animate-fadeInUp" style="max-width: 600px; width: 100%;">
          <div class="card-header text-center">
            <h3>🏢 부서 관리 시스템</h3>
          </div>
          <div class="card-body">
            <p class="text-center">
              기업 내부 부서 및 직원 관리를 위한 통합 시스템입니다.<br/>
              대한민국 최고의 기업 정보를 확인하세요.
            </p>
            <ol class="mt-4">
              <li>📋 <strong>직원정보 조회</strong> - 전체 부서/직원 목록 확인</li>
              <li>➕ <strong>신규 부서 등록</strong> - 부서 정보 추가</li>
              <li>✏️ <strong>부서 정보 수정/삭제</strong> - 부서 관리 기능</li>
              <li>👥 <strong>부서별 직원 조회</strong> - 소속 직원 확인</li>
            </ol>
          </div>
        </div>
      </div>

      <!-- 바닥글 -->
      <footer class="text-center py-3">
        © 2025 장호 Corp. All rights reserved.
      </footer>
    </div>
  `
};
