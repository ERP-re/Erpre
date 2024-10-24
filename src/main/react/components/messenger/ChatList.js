import React from 'react';
import { FaUserCircle } from 'react-icons/fa';

const ChatList = ({ chatList, formatDate }) => {
    return (
        <div className="chat-list-container">

            {/* 채팅 목록 */}
            <ul className="chat-list">
                {chatList.map((chat, index) => (
                    <li className="chat-item" key={chat?.id || index}>
                        <FaUserCircle className="chat-icon" />
                        <div className="chat-info">
                            <div className="chat-name">
                                {chat.chatTitle}
                                <span className="chat-time">
                                    {formatDate(chat.chatSendDate)}
                                </span>
                            </div>
                            <div className="last-message">
                                {chat.chatMessageContent}
                            </div>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    )
};

export default ChatList;