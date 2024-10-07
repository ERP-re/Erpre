import React, { useEffect, useState } from 'react';
import '../../resources/static/css/common/Header.css';
import { FaEnvelope, FaBell, FaCommentDots, FaWindowClose } from 'react-icons/fa'; // React Icons를 사용

function Header() {
    const [isMessengerOpen, setMessengerOpen] = useState(false);

    const toggleMessenger = () => {
        setMessengerOpen(!isMessengerOpen); // isMessengerOpen의 현재 값 반전
    };

    return (
        <header>
            <div className="header-container">
                <div className="logo">
                    <a href="/"><img src="/img/logo2.png" alt="IKEA Logo"/><span>Erpenterprise Resource  Planning</span></a>
                </div>
                <div className="header-icons">
                    <FaEnvelope className="header-icon mail" title="메일" />
                    <FaCommentDots className="header-icon messenger" title="메신저" onClick={toggleMessenger}/>
                    <FaBell className="header-icon alarm" title="알림" />
                </div>
            </div>
            <div className="bottom-border"></div>

            {/*메신저 슬라이드 패널*/}
            <div className={`messenger-panel ${isMessengerOpen ? 'open' : ''}`}>
                <div className="messenger-header">
                    <h2>IKEA TALK</h2>
                    <FaWindowClose className="messenger-close" title="닫기" onClick={toggleMessenger}></FaWindowClose>
                </div>
                <div className="messenger-content">
                    {/*메신저메신저*/}
                </div>
            </div>

        </header>
    );
}

export default Header;
