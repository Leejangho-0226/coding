document.addEventListener("DOMContentLoaded", function () {
  // 삭제 버튼 처리
  const deleteButtons = document.querySelectorAll(".btn-delete");
  deleteButtons.forEach(btn => {
    btn.addEventListener("click", function (e) {
      if (!confirm("정말 삭제하시겠습니까?")) {
        e.preventDefault();
      }
    });
  });

  // 수정 버튼 처리
  const updateButtons = document.querySelectorAll(".btn-update");
  updateButtons.forEach(btn => {
    btn.addEventListener("click", function (e) {
      if (!confirm("정말 수정하시겠습니까?")) {
        e.preventDefault();
      }
    });
  });
});
