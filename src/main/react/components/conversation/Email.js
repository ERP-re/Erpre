import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/Email.css'
import Layout from "../../layout/Layout";

// 컴포넌트
function Email() {

  return (
    <Layout currentMenu= "email">
      <div className="email-page">
        <h3>이메일 페이지입니다</h3>

      </div>
    </Layout>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root')); // 루트 DOM 요소에 리액트 컴포넌트를 랜더링
root.render(
  <BrowserRouter> {/*리액트 라우터를 사용하여 클라이언트 사이드 라우팅 지원*/}
    <Email /> {/*컴포넌트 랜더링*/}
  </BrowserRouter>
)