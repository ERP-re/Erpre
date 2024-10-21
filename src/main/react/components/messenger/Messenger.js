import React from 'react';
import { FaWindowClose } from 'react-icons/fa'; // React Icons를 사용

function Messenger({ isOpen, toggleMessenger }) {
    return (
        <div className={`messenger-panel ${isOpen ? 'open' : ''}`}>
            <div className="messenger-header">
                <h2>IKEA TALK</h2>
                <FaWindowClose className="messenger-close" title="닫기" onClick={toggleMessenger} />
            </div>
            <div className="messenger-content">
                {/* 메신저 내용 */}
            </div>
        </div>
    );
}

export default Messenger;
