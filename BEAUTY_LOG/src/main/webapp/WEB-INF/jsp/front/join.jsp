<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <!-- E : Beauty Log 설명 -->

    <!-- S : OG 오픈그래프 (카카오톡 미리보기) -->
    <meta property="og:url" content="http://">
    <meta property="og:image" content="<c:url value='/WEB-INF/images/front/main/thumbnail.svg' />">
    <meta property="og:type" content="website">
    <meta property="og:title" content="Beauty Log">
    <meta property="og:site_name" content="Beauty Log">
    <meta property="og:description" content="뷰티랭킹 관련 포트폴리오입니다.">
    <!-- E : OG 오픈그래프 (카카오톡 미리보기) -->

    <title>Beauty Log</title>

    <!-- S : bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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

			<main class="main form-signin w-100">
		    <form action="<c:url value='/front/join.do'/>" method="post" class="pt-5">
		        <h3 class="fw-bold text-center">회원가입</h3>
		
		        <!-- 오류 메시지 출력 -->
		        <c:if test="${not empty errorMessage}">
		            <div class="alert alert-danger">
		                ${errorMessage}
		            </div>
		        </c:if>
		
		        <!-- 아이디 입력 -->
		        <div class="mb-3">
		            <label for="userId" class="form-label">아이디</label>
		            <input type="text" class="form-control" id="userId" name="userId" placeholder="아이디 입력" value="${not empty param.userId ? param.userId : ''}">
		        </div>
		
		        <!-- 비밀번호 입력 -->
		        <div class="mb-3">
		            <label for="userPwd" class="form-label">비밀번호</label>
		            <input type="password" class="form-control" id="userPwd" name="userPwd" placeholder="비밀번호 입력">
		        </div>
		
		        <!-- 비밀번호 확인 입력 -->
		        <div class="mb-3">
		            <label for="confirmPwd" class="form-label">비밀번호 확인</label>
		            <input type="password" class="form-control" id="confirmPwd" name="confirmPwd" placeholder="비밀번호 다시 입력">
		        </div>
		
		        <!-- 이름 입력 -->
		        <div class="mb-3">
		            <label for="userName" class="form-label">이름</label>
		            <input type="text" class="form-control" id="userName" name="userName" placeholder="이름 입력" value="${not empty param.userName ? param.userName : ''}">
		        </div>
		
		        <!-- 전화번호 입력 -->
		        <div class="mb-3">
		            <label for="userPhone" class="form-label">전화번호</label>
		            <div class="row g-2">
		                <div class="col">
		                    <select class="form-select" name="phonePrefix" aria-label="전화번호 지역" value="${not empty param.phonePrefix ? param.phonePrefix : '010'}">
		                        <option value="010" ${param.phonePrefix == '010' ? 'selected' : ''}>010</option>
		                        <option value="02" ${param.phonePrefix == '02' ? 'selected' : ''}>02</option>
		                        <option value="032" ${param.phonePrefix == '032' ? 'selected' : ''}>032</option>
		                        <option value="055" ${param.phonePrefix == '055' ? 'selected' : ''}>055</option>
		                    </select>
		                </div>
		                <div class="col">
		                    <input type="text" class="form-control" name="phoneMiddle" placeholder="0000" value="${not empty param.phoneMiddle ? param.phoneMiddle : ''}">
		                </div>
		                <div class="col">
		                    <input type="text" class="form-control" name="phoneEnd" placeholder="0000" value="${not empty param.phoneEnd ? param.phoneEnd : ''}">
		                </div>
		            </div>
		        </div>
		
		        <!-- 이메일 입력 -->
		        <div class="mb-3">
		            <label for="userEmail" class="form-label">이메일</label>
		            <div class="row g-2 align-items-center">
		                <div class="col-5">
		                    <input type="text" class="form-control" name="emailId" placeholder="이메일 아이디" value="${not empty param.emailId ? param.emailId : ''}">
		                </div>
		                <div class="col-1">
		                    <span>@</span>
		                </div>
		                <div class="col-6">
		                    <select class="form-select" name="emailDomain" aria-label="이메일 도메인" value="${not empty param.emailDomain ? param.emailDomain : ''}">
		                        <option value="naver.com" ${param.emailDomain == 'naver.com' ? 'selected' : ''}>naver.com</option>
		                        <option value="gmail.com" ${param.emailDomain == 'gmail.com' ? 'selected' : ''}>gmail.com</option>
		                        <option value="daum.net" ${param.emailDomain == 'daum.net' ? 'selected' : ''}>daum.net</option>
		                    </select>
		                </div>
		            </div>
		        </div>
		
		        <!-- 약관 동의 -->
		        <div class="form-check text-start my-3">
		            <input class="form-check-input" type="checkbox" value="agree" id="flexCheckDefault" name="agree">
		            <label class="form-check-label fw-medium" for="flexCheckDefault">약관에 동의합니다.</label>
		        </div>
		
		        <!-- 버튼들 -->
		        <div class="btn-group w-100">
		            <button class="btn btn-outline-primary" type="button" onclick="window.location.href='<c:url value='/front/index.do'/>'">이전</button>
		            <button class="btn btn-primary" type="submit">회원가입</button>
		        </div>
		    </form>
		</main>
        <!-- E : 회원가입 -->

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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>

</html>