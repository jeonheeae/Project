<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <meta property="og:image" content="<c:url value='/WEB-INF/images/front/main/thumbnail.svg' />">
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
            <!-- E : header -->

            <!-- S : qna-detail -->
            <main class="main qna-detail w-100">
                <div class="container pt-5">
                    <h3 class="fw-bold">Q&A 상세보기</h3>

                    <!-- 게시판 -->
                    <div class="row">
                        <div class="table-wrap">
                            <table class="table border-top mb-0">
                                <thead>
                                    <tr>
                                        <td class="px-5 py-4">
                                            <h4 class="fw-semibold">
                                                ${qnaDetail.title}
                                            </h4>
                                        </td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="px-5 py-2">
                                            <span class="me-3 fw-semibold">작성자</span> 
                                            ${qnaDetail.userId}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="px-5 py-2">
                                            <span class="me-3 fw-semibold">작성일</span> 
                                            <fmt:formatDate value="${qnaDetail.createdAt}" pattern="yyyy-MM-dd" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="px-5 py-2">
                                            <span class="me-3 fw-semibold">조회수</span> 
                                              ${qnaDetail.viewCount}
                                        </td>
                                    </tr>
								    <tr>
								    <tr>
									    <td class="px-5 py-2">
									        <span class="me-3 fw-semibold">첨부파일</span>
									        <c:choose>
									            <c:when test="${not empty qnaDetail.fileName}">
									                ${qnaDetail.fileName}
									                <c:choose>               
									                    <c:when test="${qnaDetail.fileName.endsWith('.jpg') || qnaDetail.fileName.endsWith('.png') || qnaDetail.fileName.endsWith('.gif')}">
									                        <br>
									                        <img src="${pageContext.request.contextPath}/front/qnaDownload.do?fileName=${qnaDetail.fileName}" alt="첨부 이미지" class="img-fluid mt-2" style="max-width: 200px;">
									                    </c:when>           
									                    <c:when test="${qnaDetail.fileName.endsWith('.pdf')}">
									                        <br>
									                        <embed src="${pageContext.request.contextPath}/front/qnaDownload.do?fileName=${qnaDetail.fileName}" type="application/pdf" width="100%" height="400px">
									                    </c:when>
									                </c:choose>
									                <a href="${pageContext.request.contextPath}/front/qnaDownload.do?fileName=${qnaDetail.fileName}"
									                   class="btn btn-outline-primary btn-sm ms-3">
									                    <i class="bi bi-download"></i> 다운로드
									                </a>
									            </c:when>
									            <c:otherwise>
									                첨부파일 없음
									            </c:otherwise>
									        </c:choose>
									    </td>
									</tr>
                                    <tr>
                                        <td class="px-5 py-5">
                                            <pre>
                                                ${qnaDetail.content}
                                            </pre>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

<!-- 댓글 작성 form -->
<div class="row">
    <div class="table-wrap">
        <form action="<c:url value='/front/writeComment.do'/>" method="post" onsubmit="return checkCommentLogin('${sessionScope.userId}')">
            <input type="hidden" name="qnaId" value="${qnaDetail.qnaId}">

            <table class="table">
                <thead>
                    <tr>
                        <td class="px-5 py-4">
                            <label for="exampleFormControlTextarea1" class="form-label">댓글 작성</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" name="content" rows="3" required></textarea>
                            <button class="btn btn-primary mt-3" type="submit">작성하기</button>
                        </td>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="comment" items="${comments}">
                        <tr>
                            <td class="p-5">
                                <div class="d-flex align-items-center mb-3">
                                    <p class="name m-0 me-4 fw-semibold">${comment.userId}</p>
                                </div>
                                <p class="review m-0">${comment.content}</p>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</div>



<div class="btn-group justify-content-center w-100 mt-5">
   <button class="btn btn-outline-primary w-100" type="button" onclick="location.replace('<c:url value='/front/qna.do'/>')">목록으로</button>
</div>
                </div>
            </main>
            <!-- E : qna-detail -->

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
    		<script src="<c:url value='/js/front/check.js'/>"></script>
    </body>
</html>
