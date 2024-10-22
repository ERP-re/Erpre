import React, {useState} from 'react';
import {FaComments, FaInfoCircle, FaSearch, FaUserAlt, FaUserAltSlash, FaUtensils, FaWindowClose} from 'react-icons/fa';
import {MdMeetingRoom, MdWork} from "react-icons/md";
import {PiOfficeChairFill} from "react-icons/pi";
import {BsEnvelope} from "react-icons/bs";
import Select from 'react-select';
import {SlOrganization} from "react-icons/sl";
import { HTML5Backend } from 'react-dnd-html5-backend';
import { Tree, NodeModel } from '@minoru/react-dnd-treeview';
import { Menu, Item, useContextMenu } from 'react-contexify';
import { DndProvider } from 'react-dnd';


function Messenger({isOpen, toggleMessenger}) {

    const [isStatusMessageOpen, setStatusMessageOpen] = useState(false); // 대화명 모달
    const [statusMessage, setStatusMessage] = useState('대화명을 입력해주세요.');
    // 유저 상태 (online, offline, eating(식사중), meeting(회의중), working(바쁨), absent(부재중))
    const [userStatus, setUserStatus] = useState('offline');
    // 활성화된 뷰를 관리
    const [activeView, setActiveView] = useState('home');
    // 직원 목록
    const [treeData, setTreeData] = useState([
        { id: 1, parent: 0, droppable: true, text: 'CEO' },
        { id: 2, parent: 1, droppable: true, text: '개발팀' },
        { id: 3, parent: 2, droppable: false, text: '장원영' },
    ]);

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
    const SingleValue = ({ children, ...props }) => (
        <div className="single-value" {...props.innerProps}>
            {props.data.icon}
            <span style={{ marginLeft: '8px' }}>{children}</span>
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

    const { show } = useContextMenu({
        id: 'employee_menu',
    });

    const handleContextMenu = (data) => {
        alert(`직원 정보: ${data.text}`);
    };

    return (
        <div>
        <DndProvider backend={HTML5Backend} >
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
                                <div className="status-icon">
                                    {/* 현재 상태에 맞는 아이콘 표시 */}
                                    {getStatusIcon()}
                                </div>
                                <div className="status-select-wrapper">
                                    <Select
                                        value={options.find((option) => option.value === userStatus)}
                                        onChange={handleStatusChange}
                                        options={options}
                                        styles={customStyles}
                                        components={{ Option, SingleValue }}
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

                {/* 직원 목록 트리 */}
                <div className="messenger-content">
                    <Tree
                        tree={treeData}
                        rootId={0}
                        render={(node, { depth, isOpen, onToggle }) => (
                            <div style={{ marginInlineStart: depth * 20 }}>
                                    <span onContextMenu={(event) => show(event, { props: node })}>
                                        {node.droppable ? (isOpen ? '📂' : '📁') : '📄'} {node.text}
                                    </span>
                            </div>
                        )}
                        dragPreviewRender={(monitorProps) => <div>{monitorProps.item.text}</div>}
                        onDrop={(newTree) => setTreeData(newTree)}
                    />
                </div>

                {/* Context 메뉴 */}
                <Menu id="employee_menu">
                    <Item onClick={({ props }) => handleContextMenu(props)}>
                        직원 정보 보기
                    </Item>
                </Menu>
            </div>
        </div>
        </DndProvider>
        </div>
);
}

export default Messenger;
