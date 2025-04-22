// Q & A 글쓰기 버튼 클릭 시 로그인 체크
function checkLogin(userId) {
    if (!userId) {
        alert('로그인이 필요합니다.');
        location.href = '/front/login.do';  // 로그인 페이지로 이동
    } else {
        location.href = '/front/qnaWrite.do';  // 글쓰기 페이지로 이동 (경로 확인)
    }
}

// 댓글 작성 버튼 클릭 시 로그인 체크
function checkCommentLogin(userId) {
    if (!userId) {
        alert('로그인이 필요합니다.');
        location.href = '/front/login.do';  // 로그인 페이지로 이동
        return false;  // 폼 제출 막기
    }
    return true; // 폼 제출 허용
}

// 출석 체크
function checkAttendance() {
    $.ajax({
        type: "POST",
        url: "/front/attendanceCheck.do", 
        success: function(data) {
            alert(data);  
            location.reload(); // 페이지 새로고침
        },
        error: function() {
            alert("로그인이 필요합니다.");
            location.href = '/front/login.do'; // 로그인 페이지로 리다이렉트
        }
    });
}

function showLoginPrompt() {
    alert("로그인이 필요합니다.");
    var contextPath = window.location.pathname.split('/')[1]; // context path 추출
    location.href = "/" + contextPath + "/front/login.do";  // 로그인 페이지로 리다이렉트
}

// 리뷰 삭제 확인
function deleteReview(reviewSn, prdSn) {
    if (confirm("정말 삭제하시겠습니까?")) {
        window.location.href = `/front/review/delete.do?reviewSn=${reviewSn}&prdSn=${prdSn}`;
    }
}