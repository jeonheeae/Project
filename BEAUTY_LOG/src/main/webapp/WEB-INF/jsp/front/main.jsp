<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <meta property="og:image" content="../view/img/thumbnail.svg">
    <meta property="og:type" content="website">
    <meta property="og:title" content="Beauty Log">
    <meta property="og:site_name" content="Beauty Log">
    <meta property="og:description" content="뷰티랭킹 관련 포트폴리오입니다.">
    <!-- E : OG 오픈그래프 (카카오톡 미리보기) -->

    <title>Beauty Log</title>
    <!-- E : Beauty Log 설명 -->

    <!-- S : bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <!-- E : bootstrap -->

    <!-- S : CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/front/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/front/main.css">
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
                            <li class="nav-item">
                                <a href="<c:url value='/front/login.do'/>" class="nav-link link-body-emphasis px-2"><i class="bi bi-box-arrow-in-right me-2"></i>로그인</a>
                            </li>
                            <li class="nav-item">
                                <a href="<c:url value='/front/join.do'/>" class="nav-link link-body-emphasis px-2"><i class="bi bi-person-plus me-2"></i>회원가입</a>
                            </li>
                        </ul>
                        <!-- 로그인 후 -->
                        <ul class="nav d-none">
                            <li class="nav-item">
                                <a href="javascript:" class="nav-link link-body-emphasis px-2"><i class="bi bi-box-arrow-left me-2"></i>로그아웃</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <!-- E : header -->

        <main class="main">
            <!-- 슬라이드 -->
            <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="${pageContext.request.contextPath}/images/front/main/slide01.jpg" alt="슬라이드">
                        <div class="container">
                            <div class="carousel-caption slide01 text-start">
                                <h2 class="fw-bold">지금 가장 HOT한 뷰티 아이템</h2>
                                <p class="fw-medium">실시간 인기 뷰티 랭킹을 확인하고, 베스트 제품을 만나보세요!<br> 매일 업데이트되는 트렌디한 뷰티 정보를 놓치지 마세요.</p>
                                <a class="btn btn-lg btn-primary" href="#">Rank로 이동</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/images/front/main/slide02.jpg" alt="슬라이드">
                        <div class="container">
                            <div class="carousel-caption slide02 text-start">
                                <h2 class="fw-bold">"솔직한 리뷰, 가짜 없는 리얼 후기!</h2>
                                <p class="fw-medium">수천 개의 실제 사용자 리뷰를 확인하고 나에게 맞는 뷰티템을 선택하세요.<br> 뷰티 경험을 공유하고 함께 성장하는 커뮤니티!</p>
                                <a class="btn btn-lg btn-primary" href="#">Review로 이동</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/images/front/main/slide03.jpg" alt="슬라이드">
                        <div class="container">
                            <div class="carousel-caption slide03 text-start text-white">
                                <h2 class="fw-bold">하루 한 번! 출석하면 보상이 쏟아진다</h2>
                                <p class="fw-medium">매일 출석하고 포인트, 쿠폰, 특별 혜택까지 받아가세요!<br> 꾸준한 출석이 곧 리워드로 돌아옵니다. 지금 참여하세요!</p>
                                <a class="btn btn-lg btn-primary" href="#">Event로 이동</a>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden"></span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden"></span>
                </button>
            </div>
            <!-- 슬라이드 끝 -->

            <div class="container marketing">
                <!-- S : 소개 -->
                <div class="row intro text-center">
                    <div class="col-lg-3">
                        <img src="${pageContext.request.contextPath}/images/front/main/intro01.jpg" class="bd-placeholder-img rounded-circle" width="140" height="140">
                        <p class="fw-semibold mt-4">🏆 랭킹</p>
                    </div>
                    <div class="col-lg-3">
                        <img src="${pageContext.request.contextPath}/images/front/main/intro02.jpg" class="bd-placeholder-img rounded-circle" width="140" height="140">
                        <p class="fw-semibold mt-4">🎖️ 뷰티 어워드</p>
                    </div>
                    <div class="col-lg-3">
                        <img src="${pageContext.request.contextPath}/images/front/main/intro03.jpg" class="bd-placeholder-img rounded-circle" width="140" height="140">
                        <p class="fw-semibold mt-4">🧴 베스트 신제품</p>
                    </div>
                    <div class="col-lg-3">
                        <img src="${pageContext.request.contextPath}/images/front/main/intro04.jpg" class="bd-placeholder-img rounded-circle" width="140" height="140">
                        <p class="fw-semibold mt-4">💆🏻 효능/효과</p>
                    </div>
                </div>
                <!-- E : 소개 -->

                <!-- S : 조회수 급상승 -->
                <div class="row featurette">
                    <h3 class="fw-bold">조회수 급상승</h3>
                    <div class="col-md-4">
                        <h4 class="fw-semibold mb-2">제품명01</h4>
                        <p>가격 : 23,900원</p>
                        <p class="mb-4 d-flex align-items-center"><i class="bi bi-star-fill me-2"></i><span class="grade me-1">4.7</span><span class="review-num">(16,114)</span></p>
                        <img src="${pageContext.request.contextPath}/images/front/main/product01.jpg" class="bd-placeholder-img" width="400" height="400">
                    </div>
                    <div class="col-md-4">
                        <h4 class="fw-semibold mb-2">제품명02</h4>
                        <p>가격 : 23,900원</p>
                        <p class="mb-4 d-flex align-items-center"><i class="bi bi-star-fill me-2"></i><span class="grade me-1">4.7</span><span class="review-num">(16,114)</span></p>
                        <img src="${pageContext.request.contextPath}/images/front/main/product02.jpg" class="bd-placeholder-img" width="400" height="400">
                    </div>
                    <div class="col-md-4">
                        <h4 class="fw-semibold mb-2">제품명03</h4>
                        <p>가격 : 23,900원</p>
                        <p class="mb-4 d-flex align-items-center"><i class="bi bi-star-fill me-2"></i><span class="grade me-1">4.7</span><span class="review-num">(16,114)</span></p>
                        <img src="${pageContext.request.contextPath}/images/front/main/product03.jpg" class="bd-placeholder-img" width="400" height="400">
                    </div>
                </div>
                <!-- S : 조회수 급상승 -->
            </div>
        </main>

        <!-- S : footer -->
        <div class="container w-100">
            <footer class="py-3 my-4">
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcYZEqDbrHqkCK0m6k" crossorigin="anonymous"></script>
</body>

</html>
