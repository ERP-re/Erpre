import React, { useState, useEffect } from 'react';
import ReactDOM from 'react-dom/client'; // ReactDOM을 사용하여 React 컴포넌트를 DOM에 렌더링
import '../../../resources/static/css/common/Main.css'; // 공통 CSS 파일
import Layout from "../../layout/Layout"; // 공통 레이아웃 컴포넌트를 임포트 (헤더, 푸터 등)
import { BrowserRouter } from "react-router-dom";
import '../../../resources/static/css/sales/OrderDispatch.css';


function OrderDispatch() {

    return (
        <Layout currentMenu="orderDispatch">
            <main className="main-content menu_orderDispatch">
                 <div className="menu_title">
                    <div className="sub_title">영업 관리</div>
                    <div className="main_title">주문 출고</div>
                 </div>
                <div className="menu_content">
                    <div className="left">
                        {/* 검색어 입력 */}
                            <div className={`search_box ${filter ? 'has_text' : ''}`}>
                                <label className={`label_floating ${filter ? 'active' : ''}`}>고객사, 상품명, 출고창고명 입력</label>
                                <i className="bi bi-search"></i>
                                <input
                                    type="text"
                                    className="box search"
                                    value={filter}
                                    onChange={(e) => setFilter(e.target.value)}
                                />
                                {/* 검색어 삭제 버튼 */}
                                {filter && (
                                    <button
                                        className="btn-del"
                                        onClick={() => setFilter('')}
                                    >
                                        <i className="bi bi-x"></i>
                                    </button>
                                )}
                            </div>
                            <div className="radio_box">
                                    <span>상태</span>
                                    <input
                                        type="radio"
                                        id="pending"
                                        name="filterType"
                                        value="pending"
                                        checked={filterType === 'pending'}
                                        
                                    />
                                    <label htmlFor="pending">출고대기</label>
                                    <input
                                        type="radio"
                                        id="in progress"
                                        name="filterType"
                                        value="in progress"
                                        checked={filterType === 'in progress'}

                                    />
                                    <label htmlFor="in progress">출고요청</label>
                                    <input
                                        type="radio"
                                        id="complete"
                                        name="filterType"
                                        value="complete"
                                        checked={filterType === 'complete'}

                                    />
                                    <label htmlFor="complete">출고완료</label>
                                </div>
                            </div>
                            <div className="right">
                                <button className="box color" >
                                  <i className="bi bi-plus-circle"></i> 출고지시
                                </button>
                            </div>
                            <div className="table_wrap">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>
                                                <label className="chkbox_label">
                                                    <input
                                                        type="checkbox"
                                                        className="chkbox"

                                                    />
                                                    <i className="chkbox_icon">
                                                        <i className="bi bi-check-lg"></i>
                                                    </i>
                                                </label>
                                            </th>
                                            <th>출고번호</th>
                                            <th>
                                                <div className={`order_wrap ${sortColumn === 'customerName' ? 'pending' : ''}`}>
                                                    <span>고객사</span>
                                                    <button className="btn_order" onClick={() => sortCustomers('customerName')}>
                                                        <i className={`bi ${sortColumn === 'customerName' ? (sortOrder === 'desc' ? 'bi-arrow-down' : 'bi-arrow-up') : 'bi-arrow-up'}`}></i>
                                                    </button>
                                                </div>
                                            </th>
                                            <th>
                                                <div className={`order_wrap ${sortColumn === 'productName' ? 'pending' : ''}`}>
                                                    <span>상품명</span>
                                                    <button className="btn_order" onClick={() => sortCustomers('productName')}>
                                                        <i className={`bi ${sortColumn === 'productName' ? (sortOrder === 'desc' ? 'bi-arrow-down' : 'bi-arrow-up') : 'bi-arrow-up'}`}></i>
                                                    </button>
                                                </div>
                                            </th>
                                            <th>
                                                <div className={`order_wrap ${sortColumn === 'deliveryRequestDate' ? 'pending' : ''}`}>
                                                    <span>납품 요청일</span>
                                                    <button className="btn_order" onClick={() => sortCustomers('deliveryRequestDate')}>
                                                        <i className={`bi ${sortColumn === 'deliveryRequestDate' ? (sortOrder === 'desc' ? 'bi-arrow-down' : 'bi-arrow-up') : 'bi-arrow-up'}`}></i>
                                                    </button>
                                                </div>
                                            </th>
                                            <th>
                                                <div className={`order_wrap ${sortColumn === 'dispatchStatus' ? 'pending' : ''}`}>
                                                    <span>출고상태</span>
                                                    <button className="btn_order" onClick={() => sortCustomers('dispatchStatus')}>
                                                        <i className={`bi ${sortColumn === 'dispatchStatus' ? (sortOrder === 'desc' ? 'bi-arrow-down' : 'bi-arrow-up') : 'bi-arrow-up'}`}></i>
                                                    </button>
                                                </div>
                                            </th>
                                            <th>
                                                <div className={`order_wrap ${sortColumn === 'dispatchStartDate' ? 'pending' : ''}`}>
                                                    <span>출고 시작일시</span>
                                                    <button className="btn_order" onClick={() => sortCustomers('dispatchStartDate')}>
                                                        <i className={`bi ${sortColumn === 'dispatchStartDate' ? (sortOrder === 'desc' ? 'bi-arrow-down' : 'bi-arrow-up') : 'bi-arrow-up'}`}></i>
                                                    </button>
                                                </div>
                                            </th>
                                            <th>
                                                <div className={`order_wrap ${sortColumn === 'dispatchEndDate' ? 'pending' : ''}`}>
                                                    <span>출고 완료일시</span>
                                                    <button className="btn_order" onClick={() => sortCustomers('dispatchEndDate')}>
                                                        <i className={`bi ${sortColumn === 'dispatchEndDate' ? (sortOrder === 'desc' ? 'bi-arrow-down' : 'bi-arrow-up') : 'bi-arrow-up'}`}></i>
                                                    </button>
                                                </div>
                                            </th>
                                            <th>
                                                <div className={`order_wrap ${sortColumn === 'warehouseName' ? 'pending' : ''}`}>
                                                    <span>출고창고명</span>
                                                    <button className="btn_order" onClick={() => sortCustomers('warehouseName')}>
                                                        <i className={`bi ${sortColumn === 'warehouseName' ? (sortOrder === 'desc' ? 'bi-arrow-down' : 'bi-arrow-up') : 'bi-arrow-up'}`}></i>
                                                    </button>
                                                </div>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    {/* 페이지네이션 추가*/}
                                    <td>
                                        <div className="btn_group">
                                            <button className="box small" >qr코드</button>
                                        </div>
                                    </td>
                                       <td>
                                            <div className="btn_group">
                                                <button className="box small" >상세보기</button>
                                            </div>
                                        </td>
                                    </tbody>
                                </table>
                             </div>
                        </div>
                    <div className="pagination-container">
                        <div>
                            <button className="box" >
                                <i className="bi bi-trash3"></i> 선택 삭제
                            </button>
                        </div>
                        {/* 가운데: 페이지네이션 */}
                        <div className="pagination">
                            {/* '처음' 버튼 */}
                            {currentPage > 1 && (
                                <button className="box icon first" >
                                    <i className="bi bi-chevron-double-left"></i>
                                </button>
                            )}

                            {/* '이전' 버튼 */}
                            {currentPage > 1 && (
                                <button className="box icon left" >
                                    <i className="bi bi-chevron-left"></i>
                                </button>
                            )}

                            {/* 페이지 번호 블록 */}
                            {Array.from({ length: Math.min(5, totalPages) }, (_, index) => {
                                const startPage = Math.floor((currentPage - 1) / 5) * 5 + 1;
                                const page = startPage + index;
                                return (
                                    page <= totalPages && (
                                        <button
                                            key={page}
                                            onClick={() => setCurrentPage(page)}
                                            className={currentPage === page ? 'box active' : 'box'}
                                        >
                                            {page}
                                        </button>
                                    )
                                );
                            })}

                            {/* '다음' 버튼 */}
                            {currentPage < totalPages && (
                                <button className="box icon right" >
                                    <i className="bi bi-chevron-right"></i>
                                </button>
                            )}

                            {/* '끝' 버튼 */}
                            {currentPage < totalPages && (
                                <button className="box icon last" >
                                    <i className="bi bi-chevron-double-right"></i>
                                </button>
                            )}
                        </div>

                    </div>

            </main>
        </Layout>

    );
}


//최종 렌더링
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
        <OrderDispatch />
    </BrowserRouter>
);
