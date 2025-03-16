<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 				prefix="c" 			%>
<head>
	<title>상품 등록</title>
	<script src="${pageContext.request.contextPath }/js/admin/product/edit.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
</head>

<div class="page-heading">
    <div class="page-title">
        <div class="row">
            <div class="col-12 col-md-6 order-md-1 order-last">
                <h3>PRODUCT</h3>
                <p class="text-subtitle text-muted">상품 수정</p>
            </div>
            <div class="col-12 col-md-6 order-md-2 order-first">
                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Product</a></li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
    
    <section id="basic-vertical-layouts">
        <div class="row match-height">
            <div class="col-md-12 col-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">상품 수정</h4>
                    </div>
                    <div class="card-content">
                        <div class="card-body">
                            <form class="form form-vertical" id="postForm" name="postForm" method="post">
                                <div class="form-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="form-group">
                                                <label for="first-name-vertical">상품명</label>
                                                <input type="text" id="prdNm" class="form-control" name="prdNm" placeholder="상품명을 입력하세요" value="${rs.prdNm }">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <label for="email-id-vertical">상품설명</label>
                                                <input type="text" id="prdDesc" class="form-control" name="prdDesc" placeholder="상품설명을 입력하세요" value="${rs.prdDesc }">
                                            </div>
                                        </div>

                                        <div class="col-12 d-flex justify-content-end mt-3">
                                            <button type="submit" class="btn btn-sm btn-primary me-1 mb-1">등록</button>
                                            <button type="button" class="btn btn-sm btn-light-secondary me-1 mb-1" onclick="history.back(-1)">뒤로</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>    

</div>