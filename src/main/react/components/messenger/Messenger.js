import React, {Component, useState} from 'react';
import {FaComments, FaInfoCircle, FaSearch, FaUserAlt, FaUserAltSlash, FaUtensils, FaWindowClose} from 'react-icons/fa';
import {MdMeetingRoom, MdWork} from "react-icons/md";
import {PiOfficeChairFill} from "react-icons/pi";
import {BsEnvelope} from "react-icons/bs";
import {SlOrganization} from "react-icons/sl"; // react icon 사용
import Select from 'react-select'; // react-select 라이브러리
import Tree, {TreeNode} from "rc-tree"; // react-tree 라이브러리
import "rc-tree/assets/index.css"


function Messenger({isOpen, toggleMessenger}) {

    // 🟣 상태(프로필) 관리
    // 🔴

    const [isStatusMessageOpen, setStatusMessageOpen] = useState(false); // 대화명 모달
    const [statusMessage, setStatusMessage] = useState('대화명을 입력해주세요.');
    // 🟣 유저 상태 (online, offline, eating(식사중), meeting(회의중), working(바쁨), absent(부재중))
    const [userStatus, setUserStatus] = useState('offline');
    // 활성화된 뷰를 관리
    const [activeView, setActiveView] = useState('home');
    // 🔴 수신자 목록을 관리하는 state
    const [selectedRecipients, setSelectedRecipients] = useState([]);

    // 트리 데이터
    const treeData = [
        {
            key: "1",
            title: "Erpre",
            icon: <span className="parent-icon">🍎</span>, // 아이콘 뒤에 띄어쓰기
            children: [
                {
                    key: "1-1",
                    title: "영업부",
                    icon: <span>🤝</span>,
                    children: [
                        {key: "1-1-1", title: "안유진"},
                        {key: "1-1-2", title: "김민주"}
                    ]
                },
                {
                    key: "1-2",
                    title: "개발부",
                    icon: <span>🖥️</span>,
                    children: [
                        {key: "1-2-1", title: "장원영"},
                        {key: "1-2-2", title: "최예나"},
                        {key: "1-2-3", title: "조유리"}
                    ]
                },
                {
                    key: "1-3",
                    title: "인사부",
                    icon: <span>📓</span>,
                    isLeaf: false,
                    children: []
                }
            ]
        }
    ];

    // 상태 정의
    const options = [
        {value: 'online', label: '온라인', icon: <FaUserAlt/>},
        {value: 'offline', label: '오프라인', icon: <FaUserAltSlash/>},
        {value: 'eating', label: '식사중', icon: <FaUtensils/>},
        {value: 'working', label: '업무중', icon: <MdWork/>},
        {value: 'meeting', label: '회의중', icon: <MdMeetingRoom/>},
        {value: 'absent', label: '부재중', icon: <PiOfficeChairFill/>}
    ];

    // 현재 상태 아이콘 가져오는 함수
    const getStatusIcon = () => {
        const selectedOption = options.find(option => option.value === userStatus);
        return selectedOption ? selectedOption.icon : <FaUserAltSlash/>;
    };

    // 상태명 변경함수
    const handleStatusMessageChange = (event) => {
        setUserStatus(event.target.value);
    }

    // 커스텀 옵션 컴포넌트
    const Option = (props) => {
        return (
            <div {...props.innerProps} className="custom-option">
                {props.data.icon}
                <span style={{marginLeft: '8px'}}>{props.label}</span>
            </div>
        );

    }

    // react-select 커스텀
    const customStyles = {
        control: (provided) => ({
            ...provided,
            minHeight: '30px',
            height: '30px',
            fontSize: '16px',
            display: 'flex',
            width: '140px',
            border: 'none',
            boxShadow: 'none',
        }),
        indicatorsContainer: (provided) => ({
            ...provided,
            height: '28px',
            display: 'flex',
        }),
        indicatorSeparator: () => ({
            display: 'none',
        }),
        valueContainer: (provided) => ({
            ...provided,
            height: '30px',
            display: 'flex',
            alignItems: 'center',
        }),
        dropdownIndicator: (provided) => ({
            ...provided,
            transition: 'none',
        }),
        option: (provided, state) => ({
            ...provided,
            display: 'flex',
            alignItems: 'center',
            color: '#333',
            fontSize: '16px',
            height: '40px',
        }),
        singleValue: (provided, state) => ({
            ...provided,
            alignItems: 'center',
            color: '#333',
            fontSize: '16px',
        }),
        menu: (provided) => ({
            ...provided,
            position: 'absolute',
            top: '100%',
            marginTop: '0',
            width: 'calc(100% - 20px)',
            left: '18px',
        }),
    };

    // 선택된 옵션에 아이콘 표시
    const SingleValue = ({children, ...props}) => (
        <div className="single-value" {...props.innerProps}>
            {props.data.icon}
            <span style={{marginLeft: '8px'}}>{children}</span>
        </div>
    );

    // 상태명 변경창 열림/닫힘 반전
    const openStatusMessage = () => {
        setStatusMessageOpen(true)
    }

    // 상태명 저장 (update)
    const handleSaveStatusMessage = () => {
        setStatusMessageOpen(false)
    }

    // 상태 변경 함수
    const handleStatusChange = (selectedOption) => {
        if (selectedOption) {
            setUserStatus(selectedOption.value);
            console.log(selectedOption);
        }
    };

    // 🔴 수신자 목록 업데이트 함수
    const handleCheck = (checkedKeys, { checkedNodes }) => {
        const recipientNames = checkedNodes
            .filter(node =>  !node.children) // 자식 노드만 필터링
            .map(node => node.title); // 직원 이름 가져옴

        console.log(recipientNames);

        setSelectedRecipients(recipientNames);
    }

    return (
        <div>
            {/* 슬라이드 패널*/}
            <div className={`messenger-panel ${isOpen ? 'open' : ''}`}>
                {/* 왼쪽 사이드바 */}
                <div className={`messenger-panel ${isOpen ? 'open' : ''} sidebar`}>
                    <div className="messenger-btn top">
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
                    <h3>ERPRE</h3>
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
                        <img src="/img/erpre.png" alt="회사 로고"/>
                    </div>
                    <div className="info">
                        <div className="info-wrapper">
                            <div className="user-name">홍길동</div>

                            {/* 상태 아이콘 및 변경 */}
                            <div className="profile status">
                                <div className="status-select-wrapper">
                                    <Select
                                        value={options.find((option) => option.value === userStatus)}
                                        onChange={handleStatusChange}
                                        options={options}
                                        styles={customStyles}
                                        components={{Option, SingleValue}}
                                        isSearchable={false}
                                    />
                                </div>
                            </div>
                        </div>
                        <div className="status-message" onClick={() => setStatusMessageOpen(true)}>
                            {statusMessage}
                        </div>
                    </div>
                </div>

                {/* 메신저 조직도*/}
                <div className="messenger-content">
                    <Tree
                        treeData={treeData}
                        defaultExpandAll={true}  // 모든 노드를 기본적으로 확장
                        checkable                // 체크박스 설정
                        onCheck={handleCheck}    // 체크 시 이벤트
                    />
                </div>
                
            </div>
        </div>
    );
}

export default Messenger;
