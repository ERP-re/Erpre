import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/EmailViewer.css'
import Layout from "../../layout/Layout";

function EmailViewer() {

  return (

    <Layout currentMenu="emailViewer">
      <div class="email-viewer-container">

        <div class="email-actions">
          <a href="#" class="action-link">답장</a>
          <a href="#" class="action-link">전달</a>
          <a href="#" class="action-link delete">삭제</a>
        </div>

        <h1 class="email-title">안녕하세요</h1>

        <div class="email-meta">
          <span>2019-08-28 13:44:25</span>
        </div>

        <div class="email-info">
          <p>보낸 사람: 홍길동 <span class="email-address"><a href="#">abc1@abc1.com</a></span> <a href="#" class="add-contact">주소추가</a></p>
          <p>받는 사람: 이순신 <span class="email-address"><a href="#">abc2@abc2.com</a></span> <a href="#" class="add-contact">주소추가</a></p>
        </div>

        <div class="email-content">
          <p>안녕하세요. 홍길동입니다.</p>
          <p>어제 회의 때 요청 드린 엑셀 파일 공유 받을 수 있을까요?</p>
          <p>감사합니다.</p>      
        </div>
      </div>

    </Layout>

  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <EmailViewer />
  </BrowserRouter>
)