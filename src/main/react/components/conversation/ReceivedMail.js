import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/ReceivedMail.css'
import Layout from "../../layout/Layout";

function ReceivedMail() {

  return (

    <Layout currentMenu="receivedMail">
      <div className='received-mail-page'>
        <h3>받은메일함 페이지 입니다</h3>
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