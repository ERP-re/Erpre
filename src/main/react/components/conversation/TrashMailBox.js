import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/TrashMailBox.css'
import Layout from "../../layout/Layout";

function TrashMailBox() {

  return (

    <Layout currentMenu="trashMailBox">
      <div className='trash-mail-page'>
        <h3>휴지통 페이지 입니다</h3>
      </div>
    </Layout>

  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <TrashMailBox />
  </BrowserRouter>
)