// 공통 로그인 알림 및 리다이렉트
function showLoginPrompt() {
    alert("로그인이 필요합니다.");
    location.href = "/front/login.do";
}

// Q & A 글쓰기 버튼 클릭 시 로그인 체크
function checkLogin(userId) {
    if (!userId) {
        showLoginPrompt();  
    } else {
        location.href = "/front/qnaWrite.do"; 
    }
}

// 댓글 작성 버튼 클릭 시 로그인 체크
function checkCommentLogin(userId) {
    if (!userId) {
        showLoginPrompt();
        return false;  
    }
    return true; 
}

// 출석 체크
function checkAttendance() {
    $.ajax({
        type: "POST",
        url: "/front/attendanceCheck.do", 
        success: function(data) {
            alert(data);  
            location.reload();
        },
        error: function() {
            showLoginPrompt(); 
        }
    });
}

// 리뷰 삭제 확인
function deleteReview(reviewSn, prdSn) {
    if (confirm("정말 삭제하시겠습니까?")) {
        location.href = "/front/reviewDelete.do?reviewSn=" + reviewSn + "&prdSn=" + prdSn;
    }
}