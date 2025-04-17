// 별점 표시 함수 (반올림 없이)
function displayStars(reviewId, rating) {
    let stars = '';
    
    // 채워진 별 표시 (소수점 없이 별점 그대로 사용)
    for (let i = 0; i < Math.floor(rating); i++) {
        stars += '<i class="bi bi-star-fill me-1"></i>';
    }

    // 반별 처리 (소수점 부분이 있으면 반별 표시)
    if (rating % 1 !== 0) {
        stars += '<i class="bi bi-star-half me-1"></i>';
    }

    // 해당 reviewId에 별점 추가
    document.getElementById('star-container-' + reviewId).innerHTML = stars + ` (${rating}점)`;
}

// 페이지가 로드되었을 때 별점 표시
window.onload = function() {
    // 리뷰들의 id와 별점 값을 동적으로 표시
    const reviews = document.querySelectorAll('.review-item');
    reviews.forEach(review => {
        const reviewId = review.getAttribute('data-review-id');
        const rating = parseFloat(review.getAttribute('data-rating'));
        displayStars(reviewId, rating);  // 별점 표시
    });
};
