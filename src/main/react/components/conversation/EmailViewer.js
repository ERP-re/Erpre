import React from 'react';
import { BrowserRouter } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import '../../../resources/static/css/conversation/EmailViewer.css'
import Layout from "../../layout/Layout";

function EmailViewer() {

  return (

    <Layout currentMenu="emailViewer">
      <div className='email-viewer-page'>
        <h3>메일뷰어 페이지 입니다</h3>

        


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