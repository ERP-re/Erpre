import React, { useState, useEffect } from 'react';
import '../../resources/static/css/common/Sidebar.css';
import { useLocation } from 'react-router-dom';

function EmailSidebar({ currentMenu }) {
    const [activeSubMenu, setActiveSubMenu] = useState(() => {
        const path = window.location.pathname;
        return path.split('/').pop();
    });
    const [loginTime, setLoginTime] = useState('시간 정보 없음');
    const [employee, setEmployee] = useState(null);
    const [role, setRole] = useState('');
    const location = useLocation();

    useEffect(() => {
        const storedLoginTime = localStorage.getItem('loginTime');
        setLoginTime(storedLoginTime || '시간 정보 없음');
    }, []);


    useEffect(() => {
        const fetchEmployee = async () => {
            try {
                const response = await fetch('/api/employee', { credentials: 'include' });
                if (response.ok) {
                    const data = await response.json();
                    setEmployee(data);
                    setRole(data.employeeRole);
                } else {
                    console.error('사용자 정보를 가져오는 데 실패했습니다.');
                }
            } catch (error) {
                console.error('사용자 정보를 가져오는 중 오류 발생:', error);
            }
        };
        fetchEmployee();
    }, []);

    useEffect(() => {
        if (location.pathname === '/main') {
            setActiveSubMenu(null);
        }
    }, [location.pathname]);

    const handleMenuClick = (menu) => {
        setActiveSubMenu(null);
    };

    const handleSubMenuClick = (subMenu, path) => {
        setActiveSubMenu(subMenu);
        window.location.href = path;
    };

    const handleLogout = async () => {
        try {
            const response = await fetch('/api/logout', {
                method: 'POST',
                credentials: 'include',
            });
            if (response.ok) {
                window.location.href = '/login';
            } else {
                console.error('로그아웃 실패');
            }
        } catch (error) {
            console.error('로그아웃 에러 발생:', error);
        }
    };

    return (
        <aside className="sidebar">
            <div className="sidebar-top">
                <div className="user-info">
                    <div className="user-name">
                        {employee ? (
                            <>
                                {employee.employeeName} ({employee.employeeRole.toUpperCase()})
                            </>
                        ) : (
                            'LOADING'
                        )}
                    </div>
                    <div className="login-time">{loginTime}</div>
                    <button onClick={handleLogout} className="box small">로그아웃</button>
                </div>
            </div>
            <ul className={`menu ${currentMenu}`}>
                <li>

                    <span className={`mail-write-span ${currentMenu.startsWith('emailWrite') ? 'active' : ''}`} onClick={() => handleSubMenuClick('emailWrite', '/email')}>
                        <a className="mail-write" href="#" ><i className="bi bi-pencil-square"></i>메일 작성</a>
                    </span>

                    <hr className='mail-line' />

                    <span className={currentMenu.startsWith('order') ? 'active' : ''}>
                        <i className="bi bi-mailbox2-flag"></i>메일함
                    </span>
                    <ul className="submenu">
                        <li className={currentMenu === 'receivedMail' ? 'active' : ''}>
                            <a href="#" onClick={() => handleSubMenuClick('receivedMail', '/receivedMail')}>받은 메일함</a>
                        </li>
                        <li className={currentMenu === 'sentMail' ? 'active' : ''}>
                            <a href="#"
                                onClick={() => handleSubMenuClick('orderList', role === 'admin' ? 'sentMail' : '/sentMail')}>
                                보낸 메일함
                            </a>
                        </li>

                    </ul>
                </li>
                <li>
                    <span className={currentMenu.startsWith('product') ? 'active' : ''}>
                        <i className="bi bi-inboxes-fill"></i>메일 관리
                    </span>
                    <ul className="submenu">
                        <li className={currentMenu === 'draftMailBox' ? 'active' : ''}>
                            <a href="#" onClick={() => handleSubMenuClick('draftMailBox', '/draftMailBox')}>임시 보관함</a>
                        </li>
                        <li className={currentMenu === 'trashMailBox' ? 'active' : ''}>
                            <a href="#" onClick={() => handleSubMenuClick('trashMailBox', '/trashMailBox')}>휴지통</a>
                        </li>
                    </ul>
                </li>

                <hr className='mail-line' />

                <li>
                    <ul className="submenu one">
                        <span className='menu-back'  onClick={() => handleSubMenuClick('productCategory', '/productCategory')}>
                            <i className="bi bi-box-arrow-in-left"></i>메인메뉴 이동
                        </span>
                    </ul>
                </li>
            </ul>
        </aside>
    );
}

export default EmailSidebar;