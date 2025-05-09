<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0">

    <!-- S : 파비콘 -->
    <link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/images/front/favicon/apple-touch-icon.png'/>">
    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value='/images/front/favicon/favicon-32x32.png'/>">
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/images/front/favicon/favicon-16x16.png'/>">
    <link rel="icon" type="image/png" sizes="192x192" href="<c:url value='/images/front/favicon/android-chrome-192x192.png'/>">
    <link rel="icon" type="image/png" sizes="512x512" href="<c:url value='/images/front/favicon/android-chrome-512x512.png'/>">
    <link rel="manifest" href="<c:url value='/images/front/favicon/site.webmanifest'/>">
    <!-- E : 파비콘 -->

    <!-- S : 네이버 필수 메타 태그 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Content-Script-Type" content="text/javascript">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta http-equiv="imagetoolbar" content="no">
    <!-- E : 네이버 필수 메타 태그 -->

    <!-- S : Beauty Log 설명 -->
    <meta name="title" content="Beauty Log">
    <meta name="keyword" content="Beauty Log, 뷰티, 화장품, 뷰티 랭킹, 포트폴리오, 개발자">
    <meta name="description" content="">

    <!-- S : OG 오픈그래프 (카카오톡 미리보기) -->
    <meta property="og:url" content="http://">
    <meta property="og:image" content="<c:url value='/WEB-INF/images/front/main/thumbnail.svg' />">
    <meta property="og:type" content="website">
    <meta property="og:title" content="Beauty Log">
    <meta property="og:site_name" content="Beauty Log">
    <meta property="og:description" content="뷰티랭킹 관련 포트폴리오입니다.">
    <!-- E : OG 오픈그래프 (카카오톡 미리보기) -->

    <title>Beauty Log</title>
    <!-- E : Beauty Log 설명 -->

    <!-- S : bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <!-- E : bootstrap -->

    <!-- S : CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/front/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/front/sub.css">
    <!-- E : CSS -->

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .b-example-divider {
            width: 100%;
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }

        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }

        .bd-mode-toggle {
            z-index: 1500;
        }

        .bd-mode-toggle .dropdown-menu .active .bi {
            display: block !important;
        }
    </style>
</head>

<body>
    <div id="wrap">
        <!-- S : header -->
        <header data-bs-theme="light">
            <nav class="navbar navbar-expand-md fixed-top bg-white shadow-sm">
                <div class="container-fluid">
                    <a class="navbar-brand" href="<c:url value='/index.do'/>">
                        <img src="${pageContext.request.contextPath}/images/front/common/logo_b.svg" alt="로고">
                    </a>
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav me-auto mb-2 mb-md-0">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/front/rank.do'/>">Rank</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/front/review.do'/>">Review</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/front/qna.do'/>">Q&A</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/front/event.do'/>">Event</a>
                            </li>
                        </ul>

					<!-- 로그인 전 -->
					<ul class="nav">   
					    <c:if test="${empty sessionScope.userId}">
					        <li class="nav-item">
					            <a href="<c:url value='/front/login.do'/>" class="nav-link link-body-emphasis px-2">
					                <i class="bi bi-box-arrow-in-right me-2"></i>로그인
					            </a>
					        </li>
					        <li class="nav-item">
					            <a href="<c:url value='/front/join.do'/>" class="nav-link link-body-emphasis px-2">
					                <i class="bi bi-person-plus me-2"></i>회원가입
					            </a>
					        </li>
					    </c:if>
					
					    <!-- 로그인 후 -->
					    <c:if test="${not empty sessionScope.userId}">
					        <li class="nav-item">
					            <a href="<c:url value='/front/logout.do'/>" class="nav-link link-body-emphasis px-2">
					                <i class="bi bi-box-arrow-left me-2"></i>로그아웃
					            </a>
					        </li>
					    </c:if>
						</ul>
                    </div>
                </div>
            </nav>
        </header>
        <!-- E : header -->

<!-- E : review-detail -->
<main class="main review-detail w-100">
    <div class="container pt-5">
        <h3 class="fw-bold">Review 상세보기</h3>

        <!-- S : 제품 -->
        <div class="row mb-5">
            <div class="col">
                <div class="card">
                    <div class="row g-0">
                        <div class="col-md-5">
						    <c:choose>
						        <c:when test="${not empty productImages}">
						            <c:forEach var="img" items="${productImages}" varStatus="loop">
						                <c:if test="${loop.index == 0}">
						                    <!-- 첫 번째 제품 이미지만 보여주기 -->
						                    <img src="<c:url value='/images/front/product/${img}' />" 
						                         alt="제품 이미지" 
						                         style="width: 100%; height: 250px; object-fit: cover;" />
						                </c:if>
						            </c:forEach>
						        </c:when>
						        <c:otherwise>
						            <!-- 이미지 없을 때 기존 Placeholder 유지 -->
						            <svg class="bd-placeholder-img" width="100%" height="250" xmlns="http://www.w3.org/2000/svg"
						                role="img" aria-label="Placeholder: Image" preserveAspectRatio="xMidYMid slice"
						                focusable="false">
						                <title>Placeholder</title>
						                <rect width="100%" height="100%" fill="#868e96" />
						                <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image</text>
						            </svg>
						        </c:otherwise>
						    </c:choose>
						</div>
                        <div class="col-md-7 d-flex align-items-center">
                            <div class="card-body">
                                <h5 class="card-title fw-semibold">${productName}</h5> <!-- 제품 이름 -->
                                <p class="card-text">${productDescription}</p> <!-- 제품 설명 -->
                                <p class="d-flex align-items-center">
                                    <i class="bi bi-star-fill me-2"></i>
                                    <span class="grade me-1">${rating}</span> <!-- 평점 -->
                                    <span class="review-num">(${reviewCount})</span> <!-- 리뷰 개수 -->
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- E : 제품 -->

        <!-- S : 리뷰 작성 버튼 (로그인한 사용자) -->
        <c:if test="${not empty userSn}">
            <div class="text-end mb-3">
                <a href="<c:url value='/front/review/write.do?prdSn=${reviews[0].prdSn}' />" class="btn btn-outline-primary">
                    <i class="bi bi-pencil-square me-1"></i>리뷰 작성
                </a>
            </div>
        </c:if>

		<!-- 로그인하지 않은 사용자 -->
		<c:if test="${empty userSn}">
		    <div class="text-end mb-3">
		        <!-- 로그인 알림을 띄운 후 로그인 페이지로 이동 -->
		        <a href="javascript:void(0);" class="btn btn-outline-primary" onclick="showLoginPrompt()">
		            <i class="bi bi-pencil-square me-1"></i>리뷰 작성
		        </a>
		    </div>
		</c:if>

        <!-- 리뷰 목록 -->
        <div class="row">
            <div class="table-wrap">
                <table class="table border-top">
                    <thead>
                        <tr>
                            <td class="px-5 py-3">
                                <h4 class="fw-semibold">리뷰</h4>
                            </td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="review" items="${reviews}">
                            <tr class="review-item" data-review-id="${review.reviewSn}" data-rating="${review.rating}">
                                <td class="p-5">
                                    <div class="d-flex align-items-center mb-3">
                                        <p class="name m-0 me-4 fw-semibold">${review.writer}</p> <!-- 리뷰 작성자 -->
                                        <div class="star d-flex align-items-center" id="star-container-${review.reviewSn}">
                                            <c:forEach var="i" begin="1" end="${review.rating}">
                                                <i class="bi bi-star-fill me-1"></i> <!-- 별 아이콘 -->
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <p class="review m-0">${review.content}</p> <!-- 리뷰 내용 -->

                                    <!-- 작성자 본인에게만 보이는 수정/삭제 -->
                                    <c:if test="${sessionScope.userSn == review.userSn}">
                                        <div class="mt-3 text-end">
                                            <a href="<c:url value='/front/review/edit.do?reviewSn=${review.reviewSn}'/>" class="btn btn-sm btn-outline-secondary me-2">수정</a>
                                            <button class="btn btn-sm btn-outline-danger" onclick="deleteReview(${review.reviewSn}, ${review.prdSn})">삭제</button>
                                        </div>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- E : 리뷰 목록 -->
    </div>
</main>
<!-- E : review-detail -->


        <!-- S : footer -->
        <div class="container">
            <footer class="pt-5">
                <ul class="d-flex justify-content-center opacity-75">
                    <li class="px-2"><i class="bi bi-instagram"></i></li>
                    <li class="px-2"><i class="bi bi-facebook"></i></li>
                    <li class="px-2"><i class="bi bi-chat-fill"></i></li>
                </ul>
                <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                    <li class="nav-item">
                        <a href="javascript:" class="nav-link px-2 text-body-secondary">개인정보처리방침</a>
                    </li>
                    <li class="nav-item">
                        <a href="javascript:" class="nav-link px-2 text-body-secondary">이용약관</a>
                    </li>
                    <li class="nav-item">
                        <a href="javascript:" class="nav-link px-2 text-body-secondary">사이트맵</a>
                    </li>
                </ul>
                <address class="text-center text-body-secondary">(우편번호) 주소</address>
                <p class="text-center text-body-secondary">전화번호</p>
                <p class="text-center text-body-secondary">COPYRIGHT © Beauty Log. ALL RIGHT RESERVED. </p>
            </footer>
        </div>
        <!-- E : footer -->
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
      <script src="<c:url value='/js/front/check.js?ver=2'/>"></script>
	
</body>

</html>
