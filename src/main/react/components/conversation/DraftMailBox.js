import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/DraftMailBox.css'
import Layout from "../../layout/Layout";
import Pagination from '../common/Pagination';

function DraftMailBox() {

  return (
    <Layout currentMenu="draftMailBox">

<main className="main-content menu_mail">

<div className="menu_title">
  <div className="sub_title">임시 보관함</div>
</div>

{/* 검색어 입력 */}
<div className="mail-search search_box">
  <label className="label_floating">메일 검색</label>
  <i className="bi bi-search"></i>
  <input type="text" className="mail-search-box box search" />
  <button className="btn-del">
    <i className="bi bi-x"></i>
  </button>
</div>
<div className="menu_content">
  <div className="search_wrap">
    <div className="left">
      <div className="checkbox_box">
        <input type="checkbox" id="currentMail" name="status" />
      </div>
    </div>
  </div>
  <div className="table_wrap">
    <table>
      <thead>
        <tr>
          <th>
            <label className="chkbox_label">
              <input type="checkbox" className="chkbox" />
              <i className="chkbox_icon">
                <i className="bi bi-check-lg"></i>
              </i>
            </label>
          </th>
          <th>
            <div className="order_wrap">
              <span>이름</span>
              <button className="btn_order">
                <i className="bi bi-arrow-up"></i>
              </button>
            </div>
          </th>
          <th>
            <div className="order_wrap">
              <span>제목 + 내용</span>
              <button className="btn_order">
                <i className="bi bi-arrow-up"></i>
              </button>
            </div>
          </th>
          <th>
            <div className="order_wrap">
              <span>일자</span>
              <button className="btn_order">
                <i className="bi bi-arrow-up"></i>
              </button>
            </div>
          </th>

        </tr>
      </thead>
      {/* 표 내용 */}
      <tbody>
        {/* 로딩 중일 때 로딩 이미지 표시 + 화면 구성하고 주석제거 */}
        {/* <tr className="tr_empty">
            <td colSpan="10">
              <div className="loading">
                <span></span>
                <span></span>
                <span></span>
              </div>
            </td>
          </tr>
          <tr className="tr_empty">
            <td colSpan="10">
              <div className="no_data">
                <i className="bi bi-exclamation-triangle"></i> 조회된 결과가 없습니다.
              </div>
            </td>
          </tr> */}

        <tr>
          <td><input type="checkbox" /></td>
          <td>이름 / 이메일</td>

          <td>제목 + 내용</td>
          <td>일자</td>
        </tr>

        <tr>
          <td><input type="checkbox" /></td>
          <td>이름 / 이메일</td>

          <td>제목 + 내용</td>
          <td>일자</td>
        </tr>

      </tbody>
    </table>
  </div>

  {/* 페이지 네이션 컴포넌트 임포트 */}
  <Pagination />

</div>
</main>

    </Layout>
  );

}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <DraftMailBox />
  </BrowserRouter>
)
