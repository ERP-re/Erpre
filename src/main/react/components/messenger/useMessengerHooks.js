import React, {useContext, useEffect, useState} from "react";
import { UserContext } from '../../context/UserContext';
import {FaUserAlt, FaUserAltSlash, FaUtensils} from "react-icons/fa";
import {MdMeetingRoom, MdWork} from "react-icons/md";
import {PiOfficeChairFill} from "react-icons/pi";

export const useMessengerHooks = () => {

    /////////////////////////////////////////////////////////////////////////
    // ⭐ 동적 뷰
    // 🔵 유저
    /////////////////////////////////////////////////////////////////////////

    // ⭐ 활성화된 뷰 관리
    const [activeView, setActiveView] = useState('home');

    // ⭐ 로딩 관리 state
    const [isLoading, setIsLoading] = useState(true);

    // 🔵 유저 관리 state (online, offline, eating, meeting, working, absent)
    const [status, setStatus] = useState('offline')

    // 🔵 유저 상태 변경 함수
    const handleStatusChange = (selectedOption) => {
        if (selectedOption) {
            setStatus(selectedOption.value);
            console.log(selectedOption);
        }
    };

    // 🔵 유저 상태 아이콘
    const userIcon = [
        {value: 'online', label: '온라인', icon: <FaUserAlt/>},
        {value: 'offline', label: '오프라인', icon: <FaUserAltSlash/>},
        {value: 'eating', label: '식사중', icon: <FaUtensils/>},
        {value: 'working', label: '업무중', icon: <MdWork/>},
        {value: 'meeting', label: '회의중', icon: <MdMeetingRoom/>},
        {value: 'absent', label: '부재중', icon: <PiOfficeChairFill/>}
    ];

    // 🔵 유저 상태 React-Select 커스텀
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
            fontSize: '16px',
            height: '40px',
        }),
        singleValue: (provided, state) => ({
            ...provided,
            alignItems: 'center',
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

    // 🔵 유저 상태메세지 state
    const [statusMessage, setStatusMessage] = useState('');

    // 🔵 유저 상태메세지 변경 함수
    const handleStatusMessageChange = (event) => {
        setStatusMessage(event.target.value);
    }

    // 🔵 유저 정보 조회 Context
    const { user } = useContext(UserContext);

    // 🔵 유저 상태 & 로딩 useEffect
    useEffect(() => {
        if (user) {
            setStatus('online');
            console.log('로그인 유저', user);

            setIsLoading(false);
        }
    }, [user]);





    /////////////////////////////////////////////////////////////////////////
    return {

        // ⭐ 동적 뷰
        activeView,
        setActiveView,
        isLoading,

        // 🔵 유저
        user,
        status,
        setStatus,
        handleStatusChange,
        userIcon,
        customStyles,
        statusMessage,
        setStatusMessage,
        handleStatusMessageChange,
    };

};