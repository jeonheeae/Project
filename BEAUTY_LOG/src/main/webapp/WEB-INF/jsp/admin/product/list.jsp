<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 				prefix="c" 			%>
<%@ taglib uri="http://egovframework.gov/ctl/ui" 				prefix="ui" 		%>
<head>
	<title>상품 관리</title>
	<script src="${pageContext.request.contextPath }/js/admin/product/list.js"></script>
</head>
<div class="page-heading">
    <div class="page-title">
        <div class="row">
            <div class="col-12 col-md-6 order-md-1 order-last">
                <h3>PRODUCT</h3>
                <p class="text-subtitle text-muted">상품 관리</p>
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

    <section class="section">
        <div class="row" id="basic-table">
            <div class="col-12 col-md-12">
                <div class="card">
                    <div class="card-header">
                    	<a href="post.do" class="btn btn-sm btn-primary float-end">등록</a>
                    </div>
                    <div class="card-content">
						<div class="col col-2 form-control-sm float-end">
							<form id="searchForm" name="searchForm" action="list.do">
								<input type="hidden" name="pageIndex" value="1" />
								<input type="text" name="keyword" class="form-control" placeholder="검색" value="${param.keyword }"/>
							</form>
						</div>
                        <div class="card-body mt-5">
                            <!-- Table with outer spacing -->
                            <div class="table-responsive">
                                <table class="table table-lg">
									<colgroup>
										<col width="30px" />
										<col width="100px" />
										<col width="120px" />
										<col width="120px" />
										<col width="100px" />
									</colgroup>                                
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>상품명</th>
                                            <th>상품 등록일</th>
                                            <th>상품 수정일</th>
                                            <th>설정</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      	<c:forEach var="list" items="${list }" varStatus="status">
 	                                       <tr>
	                                            <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index) }</td>
	                                            <td>${list.prdNm }</td>
	                                            <td>${list.regDt }</td>
	                                            <td>${list.updDt }</td>
	                                            <td>
	                                            	<a href="edit.do?prdSn=${list.prdSn }" class="btn btn-sm btn-secondary">수정</a>
	                                            	<button id="delBtn" class="btn btn-sm btn-danger" value="${list.prdSn }">삭제</button>
	                                            </td>
	                                       </tr>
                                        </c:forEach>
                                        <c:if test="${empty list }">
                                        <tr>
                                        	<td class="text-center" colspan="5">데이터가 없습니다.</td>
                                        </tr>
                                        </c:if>
                                    </tbody>
                                </table>
								<ul class="pagination pagination-sm paging justify-content-center align-items-center">
									<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="pageLink" />
								</ul>                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>