import React, { useRef, useState } from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/EmailWrite.css'
import Layout from "../../layout/Layout";
import ReactQuill from "react-quill"; // 본문 글 편집기
import 'react-quill/dist/quill.snow.css'; // 편집기 기본 스타일


// 컴포넌트
function EmailWrite() {

  // 수신자
  const [to, setTo] = useState('');
  // 제목
  const [title, setTitle] = useState('');
  // 본문
  const [content, setContent] = useState('');
  // 파일 첨부
  const [files, setFiles] = useState([]);
  // 전송 중 로딩 상태 default 값 필요
  const [loading, setLoading] = useState(false);
  // reactQuill은 ref로 
  const quillRef = useRef(null);

  //파일 리스트 업데이트 함수 e 사용 / 파일 첨부 state 사용
  const handleFileList = (e) => {
    setFiles(e.target.files);
  }
  //보내기 함수 어싱크 사용 /
  // 로딩 상태 활성화 / 
  //이메일 데이터를 multipart 형식으로 서버에 전송하기 위해 사용 폼데이타를 새로은 변수 선언
  // 폼데이타에 수신자 이메일 주소 추가 / 
  // 폼데이타에 이메일 제목 추가 / 
  // 폼데이타에 이메일 본문 추가 / 
  const handleSendEmail = async () => {
    setLoading(true);
    const formData = new FormData(); // formData는 파일 업로드 폼데이터 저장하기 위한 객체
    formData.append('to', to); // append : 폼데이터에 ('to'라는 키 추가, to라는 현재의 상태값)
    formData.append('title', title);
    formData.append('content', content);
  }


  return (
    <Layout currentMenu="emailWrite">

      <div className="email-compose-container">
        <div className="email-compose-container">
          {/* 상단 메뉴 */}
          <div className="email-header">
            <div>
              {/* 1. 버튼 안에 로딩창 */}
              <button
                onClick={handleSendEmail}
                disabled={loading}
              >
                <i className="bi bi-send"></i>
                {loading ? '메일 전송중 ..' : '보내기'}
              </button>
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
              value={to}
              onChange={(e) => setTo(e.target.value)}
              placeholder='받는 사람 이메일'
              required // 필수
            />
          </div>

          <div className="email-field">
            <label htmlFor="title">제목</label>
            <input
              type="text"
              id="title"
              placeholder="제목을 입력하세요"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              required
            />
          </div>

          {/* 파일 첨부 */}
          <label htmlFor="file-upload" className="file-label"> {/*htmlFor: file-upload라는 id의 input과 연결됨*/}
            <div className="file-attachment">
              파일 첨부
              <input
                type="file"
                id="file-upload"
                accept='image/png, image/jpeg, application/pdf'
                className='file-upload-input'
                multiple //여러파일 선택
                onChange={handleFileList}
              />
              <div>여기로 파일을 끌어놓으세요</div>
            </div>
          </label>

          {/* 이메일 본문 + 편집기  */}
          <ReactQuill
            ref={quillRef} //ReactQuill에 ref 추가
            className='email-textBody'
            value={content}
            onChange={(value) => setContent(value)} // reactQuill 같은 서드파티 편집기는 html 구조를 반환함 바로 value로 받음
          />

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