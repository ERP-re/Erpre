import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/DraftMailBox.css'
import Layout from "../../layout/Layout";

function DraftMailBox() {

  return (
    <Layout currentMenu="draftMailBox">

      <div className="email-draft-page">
        <h3>임시 보관함 페이지입니다</h3>
      </div>

    </Layout>
  );

}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <DraftMailBox />
  </BrowserRouter>
)
