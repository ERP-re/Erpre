import React, { useEffect, useState } from 'react';
import '../../resources/static/css/common/Header.css';
import { FaEnvelope, FaBell, FaCommentDots } from 'react-icons/fa'; // React Icons를 사용
import Messenger from '../components/messenger/Messenger';
import '../../resources/static/css/messenger/Messenger.css'; // 메신저 관련 스타일 파일


function Header() {
    const [isMessengerOpen, setMessengerOpen] = useState(false);

    const toggleMessenger = () => {
        setMessengerOpen(!isMessengerOpen); // isMessengerOpen의 현재 값 반전
    };

    const handleEmailClick = () => {
        window.location.href = '/receivedMail';
    }

    return (
        <header>
            <div className="header-container">
                <div className="logo">
                    <a href="/"><img src="/img/logo2.png" alt="IKEA Logo"/><span>Erpenterprise Resource  Planning</span></a>
                </div>
                <div className="header-icons">
                    <FaEnvelope className="header-icon mail" title="메일" onClick={handleEmailClick}/>
                    <FaCommentDots className="header-icon messenger" title="메신저" onClick={toggleMessenger}/>
                    <FaBell className="header-icon alarm" title="알림" />
                </div>
            </div>
            <div className="bottom-border"></div>

            {/* 메신저 컴포넌트 */}
            <Messenger isOpen={isMessengerOpen} toggleMessenger={toggleMessenger} />
        </header>
    );
}

export default Header;
