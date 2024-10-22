import React, { useState, useEffect } from 'react';
import ReactDOM from 'react-dom/client'; // ReactDOM을 사용하여 React 컴포넌트를 DOM에 렌더링
import '../../../resources/static/css/common/Main.css'; // 공통 CSS 파일
import Layout from "../../layout/Layout"; // 공통 레이아웃 컴포넌트를 임포트 (헤더, 푸터 등)
import { BrowserRouter } from "react-router-dom";
import '../../../resources/static/css/sales/OrderDispatch.css';


function OrderDispatch() {

    return (

        <Layout currentMenu="orderDispatch">
            <div className="order-dispatch-container">
                <h3>Order Dispatch 페이지</h3>
                
            </div>
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
