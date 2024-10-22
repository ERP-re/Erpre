import React, {useState} from 'react';
import {FaComments, FaInfoCircle, FaSearch, FaUserAlt, FaUserAltSlash, FaUtensils, FaWindowClose} from 'react-icons/fa';
import {MdMeetingRoom, MdWork} from "react-icons/md";
import {PiOfficeChairFill} from "react-icons/pi";
import {BsEnvelope} from "react-icons/bs";
import {SlOrganization} from "react-icons/sl"; // React Icons를 사용

function Messenger({ isOpen, toggleMessenger }) {

    const [isStatusMessageOpen, setStatusMessageOpen] = useState(false); // 대화명 모달
    const [statusMessage, setStatusMessage] = useState('대화명을 입력해주세요.');

    // 상태명 변경창 열림/닫힘 반전
    const openStatusMessage = () => {
        setStatusMessageOpen(true)
    }

    // 상태명 변경함수
    const handleStatusMessageChange = (event) => {
        setStatusMessage(event.target.value);
    }

    // 상태명 저장 (update)
    const handleSaveStatusMessage = () => {
        setStatusMessageOpen(false)
    }

    // 활성화된 뷰를 관리
    const [activeView, setActiveView] = useState('home');

    // 유저 상태 (online, offline, eating(식사중), meeting(회의중), working(바쁨), absent(부재중))
    const [userStatus, setUserStatus] = useState({value: 'online', label: <><FaUserAlt/> 온라인</>});

    // 상태 변경 함수
    const handleStatusChange = (selectedOption) => {
        setUserStatus(selectedOption);
    }

    // 상태
    const options = [
        {value: 'online', label: <><FaUserAlt/> 온라인</>},
        {value: 'offline', label: <><FaUserAltSlash/> 오프라인</>},
        {value: 'eating', label: <><FaUtensils/> 식사중</>},
        {value: 'working', label: <><MdWork/> 업무중</>},
        {value: 'meeting', label: <><MdMeetingRoom/> 회의중</>},
        {value: 'absent', label: <><PiOfficeChairFill/> 부재중</>}
    ];

    // 상태에 따른 아이콘 상태
    const statusIcon = () => {
        switch (userStatus) {
            case 'online':
                return <FaUserAlt/>;
            case 'offline':
                return <FaUserAltSlash/>;
            case 'eating':
                return <FaUtensils/>
            case 'meeting':
                return <MdMeetingRoom/>;
            case 'working':
                return <MdWork/>;
            case 'absent':
                return <PiOfficeChairFill/>;
            default:
                return <FaUserAlt/>;
        }
    }


    return (
        <div>
            <div className={`messenger-panel ${isOpen ? 'open' : ''}`}>
                {/* 왼쪽 사이드바 */}
                <div className="messenger-sidebar">
                    <div className="button top">
                        <button className="btn1"><SlOrganization/></button>
                        <button className="btn2"><FaInfoCircle/></button>
                        <button className="btn3"><BsEnvelope/></button>
                        <button className="btn4"><FaComments/></button>
                    </div>
                    <div className="button bottom">

                    </div>
                </div>

                {/* 메신저 헤더 */}
                <div className="messenger-header">
                    <h2>ERPRE</h2>
                    <FaWindowClose className="messenger-close" title="닫기" onClick={toggleMessenger}/>
                </div>

                {/* 검색창 */}
                <div className="search-bar">
                    <div className="search-input-container">
                        <FaSearch className="search-icon"/>
                        <input type="text" placeholder="이름, 부서를 입력해주세요"/>
                    </div>
                </div>
                {/* 유저 프로필*/}
                <div className="messenger-user">
                    <div className="erpre-logo">
                        <img src="./erpre.jpg" alt="회사 로고"/>
                    </div>
                    <div className="info">
                        <div className="info-wrapper">
                            <div className="user-name">홍길동</div>

                            {/* 상태변경*/}
                            <div className={`profile status ${userStatus.value}`}>
                                <div className="status-select-wrapper">
                                    <Select
                                        options={options}
                                        value={userStatus}
                                        onChange={handleStatusChange}>
                                    </Select>
                                </div>
                            </div>
                        </div>
                        <div className="status-message" onClick={isStatusMessageOpen}>
                            {statusMessage}
                        </div>
                    </div>
                </div>


                {/* 메신저 내용 */}
                <div className="messenger-content">
                </div>

            </div>
        </div>

    );

}

export default Messenger;
