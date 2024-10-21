// src/main/react/layout/Layout.js
import React from 'react';
import Header from './Header';
import Sidebar from './Sidebar';
import '../../resources/static/css/common/Layout.css';
import Toast from '../components/common/Toast'; // 토스트 컴포넌트
import ConfirmCustom from '../components/common/ConfirmCustom'; // confirm 모달 컴포넌트
import { useLocation } from 'react-router-dom';
import EmailSidebar from './EmailSidebar';

function Layout({ currentMenu, children }) {

    const location = useLocation();

    return (
        <div className="container">
            <Header />
            <div className="main-container">
                {location.pathname === "/email" ||
                    location.pathname === "/receivedMail" ||
                    location.pathname === "/sentMail" ||
                    location.pathname === "/draftMailBox" ||
                    location.pathname === "/trashMailBox" ?
                    <EmailSidebar currentMenu={currentMenu} /> :
                    <Sidebar currentMenu={currentMenu} />}

                {children}
                <Toast /> {/* Toast 메세지 */}
                <ConfirmCustom /> {/* confirm 모달 */}
            </div>
        </div>
    );
}

export default Layout;
