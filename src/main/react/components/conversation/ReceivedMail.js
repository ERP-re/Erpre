import React, { useState } from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/ReceivedMail.css'
import Layout from "../../layout/Layout";


function ReceivedMail() {

    // 🟢 검색 state
    const [searchTerm, setSearchTerm] = useState('');

  return (

    <Layout currentMenu="receivedMail">
      <div className='received-mail-page'>
        <h3>받은메일함 페이지 입니다</h3>

        {/* 검색창 */}
        <div className={`search_box ${searchTerm ? 'has_text' : ''}`}>
          <label className={`label_floating ${searchTerm ? 'active' : ''}`}>메일 검색</label>
          <i className="bi bi-search"></i>
          <input
            type="text"
            className="box search"
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
          {/* 검색어 삭제 버튼 */}
          {searchTerm && (
            <button
              className="btn-del"
              onClick={() => setSearchTerm('')} // 검색어 초기화
            >
              <i className="bi bi-x"></i>
            </button>
          )}
        </div>
      </div>
    </Layout>

  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <ReceivedMail />
  </BrowserRouter>
)