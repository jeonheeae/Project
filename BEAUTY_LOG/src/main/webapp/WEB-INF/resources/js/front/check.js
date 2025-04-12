// 글쓰기 버튼 클릭시 로그인 체크
function checkLogin(userId) {
    if (!userId) {
        alert('로그인이 필요합니다.');
        location.href = '/BEAUTY_LOG/front/login.do';
    } else {
        location.href = '/BEAUTY_LOG/front/qnaWrite.do';
    }
}

// 댓글 작성 버튼 클릭시 로그인 체크
function checkCommentLogin(userId) {
    if (!userId) {
        alert('로그인이 필요합니다.');
        location.href = '/BEAUTY_LOG/front/login.do';
        return false; // form submit 막기
    }
    return true; // form submit 허용
}

function checkAttendance() {
    $.ajax({
        type: "POST",
        url: "/front/attendanceCheck.do", // ← 정확한 URL인지 확인
        success: function(data) {
            alert(data);  // 백엔드에서 보내준 "출석완료! 100P 지급!" 같은 메시지
            location.reload();
        },
        error: function() {
            alert("로그인이 필요합니다.");
        }
    });
}
