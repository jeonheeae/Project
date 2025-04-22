<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0">
    <title>Beauty Log - 리뷰 수정</title>

    <!-- Bootstrap & CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/front/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/front/sub.css">
</head>

<body>
<div id="wrap">
     <!-- S : header -->
        <header data-bs-theme="light">
            <nav class="navbar navbar-expand-md fixed-top bg-white shadow-sm">
                <div class="container-fluid">
                    <a class="navbar-brand" href="<c:url value='/index.do' />">
                        <img src="${pageContext.request.contextPath}/images/front/common/logo_b.svg" alt="로고">
                    </a>
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav me-auto mb-2 mb-md-0">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/front/rank.do' />">Rank</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/front/review.do' />">Review</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/front/qna.do' />">Q&A</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/front/event.do' />">Event</a>
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

    <div id="wrap">
    <main class="main w-100">
        <div class="container pt-5">
            <h3 class="fw-bold mb-4">리뷰 수정</h3>

            <form action="<c:url value='/front/review/update.do'/>" method="post" enctype="multipart/form-data">
                <!-- 리뷰 ID 및 제품 ID -->
                <input type="hidden" name="reviewSn" value="${review.reviewSn}">
                <input type="hidden" name="prdSn" value="${review.prdSn}">

                <table class="table border-top">
                    <tbody>
                        <tr>
                            <th class="px-3 py-3">작성자</th>
                            <td class="px-3 py-3">${sessionScope.userName}</td>
                        </tr>
                        <tr>
                            <th class="px-3 py-3">평점</th>
                            <td class="px-3 py-3">
                                <select name="rating" class="form-select" required>
                                    <option value="5" ${review.rating == 5 ? "selected" : ""}>★★★★★ (5점)</option>
                                    <option value="4" ${review.rating == 4 ? "selected" : ""}>★★★★☆ (4점)</option>
                                    <option value="3" ${review.rating == 3 ? "selected" : ""}>★★★☆☆ (3점)</option>
                                    <option value="2" ${review.rating == 2 ? "selected" : ""}>★★☆☆☆ (2점)</option>
                                    <option value="1" ${review.rating == 1 ? "selected" : ""}>★☆☆☆☆ (1점)</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th class="px-3 py-3">내용</th>
                            <td class="px-3 py-3">
                                <textarea name="reviewContent" rows="10" class="form-control" required>${review.reviewContent}</textarea>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-primary me-2">수정</button>
                    <button type="button" class="btn btn-outline-secondary" onclick="history.back();">취소</button>
                </div>
            </form>
        </div>
    </main>
</div>

    
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
