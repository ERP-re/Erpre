import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/EmailWrite.css'
import Layout from "../../layout/Layout";
import ReactQuill from "react-quill"; // 본문 글 편집기
import 'react-quill/dist/quill.snow.css'; // 편집기 기본 스타일

// 컴포넌트
function EmailWrite() {

  return (
    <Layout currentMenu="emailWrite">

      <div className="email-compose-container">
        <div className="email-compose-container">
          {/* 상단 메뉴 */}
          <div className="email-header">
            <div>
              <a href="#"><i className="bi bi-send"></i>보내기</a>
              <a href="#">저장하기</a>
            </div>
          </div>

          {/* 받는 사람, 제목 */}
          <div className="email-field">
            <label htmlFor="to">받는 사람</label>
            <button><i className="bi bi-person-plus"></i></button>
            <input
              type="text"
              id="to"
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

          {/* 파일 첨부 */}
          <label htmlFor="file-upload" className="file-label"> {/*htmlFor: file-upload라는 id의 input과 연결됨*/}
            <div className="file-attachment">
              파일 첨부
              <input type="file" id="file-upload" accept='image/png, image/jpeg' className='file-upload-input' />
              <div>여기로 파일을 끌어놓으세요</div>
            </div>
          </label>

          {/* 이메일 본문 + 편집기  */}
          <ReactQuill className='email-textBody' />

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