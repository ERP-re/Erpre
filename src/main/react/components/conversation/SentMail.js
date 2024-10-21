import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/SentMail.css'
import Layout from "../../layout/Layout";

function SentMail() {

  return (

    <Layout currentMenu="sentMail">
      <div className='sent-mail-page'>
        <h3>보낸메일함 페이지 입니다</h3>
      </div>
    </Layout>

  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <SentMail />
  </BrowserRouter>
)