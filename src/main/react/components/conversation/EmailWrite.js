import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/EmailWrite.css'
import Layout from "../../layout/Layout";

// 컴포넌트
function EmailWrite() {

  return (
    <Layout currentMenu="emailWrite">

<div className="email-compose-container">
      <div className="email-compose-container">
        {/* 상단 메뉴 */}
        <div className="email-header">
          <div>
            <a href="#">보내기</a>
            <a href="#">미리보기</a>
            <a href="#">저장하기</a>
          </div>
          <div>
            <a href="#">옵션</a>
          </div>
        </div>

        {/* 받는 사람, 참조, 제목 입력 필드 */}
        <div className="email-field">
          <label htmlFor="to">받는 사람</label>
          <input
            type="text"
            id="to"
            placeholder="메일 주소 사이에 ,(콤마) 또는 ;(세미콜론)으로 구분하여 입력하세요"
          />
        </div>

        <div className="email-field">
          <label htmlFor="cc">참조</label>
          <input
            type="text"
            id="cc"
            placeholder=""
          />
        </div>

        <div className="email-field">
          <label htmlFor="subject">제목</label>
          <input
            type="text"
            id="subject"
            placeholder=""
          />
        </div>

        {/* 파일 첨부 영역 */}
        <div className="file-attachment">
          <label htmlFor="file-upload" className="file-label">
            파일 첨부
          </label>
          <input type="file" id="file-upload" style={{ display: 'none' }} />
          <div>여기로 파일을 끌어놓으세요</div>
        </div>

        {/* 이메일 본문 편집기 */}
        <div className="toolbar">
          <button><i className="bi bi-type-bold"></i></button>
          <button><i className="bi bi-type-italic"></i></button>
          <button><i className="bi bi-text-paragraph"></i></button>
          <button><i className="bi bi-align-left"></i></button>
          <button><i className="bi bi-align-center"></i></button>
          <button><i className="bi bi-align-right"></i></button>
        </div>

        <div className="email-editor" contentEditable="true">
          <p>여기에 이메일 본문을 입력하세요...</p>
        </div>

        {/* 하단 메뉴 */}
        <div className="email-footer">
          <button>보내기</button>
          <button>저장하기</button>
        </div>
      </div>

      </div>
    </Layout>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root')); // 루트 DOM 요소에 리액트 컴포넌트를 랜더링
root.render(
  <BrowserRouter> {/*리액트 라우터를 사용하여 클라이언트 사이드 라우팅 지원*/}
    <EmailWrite /> {/*컴포넌트 랜더링*/}
  </BrowserRouter>
)