import React, { createContext, useState, useEffect } from 'react';
import axios from 'axios';

// UserContext 생성
export const UserContext = createContext();

// UserProvider 컴포넌트 생성
export const UserProvider = ({ children }) => {
    const [user, setUser] = useState(null);

    // 🔵 유저 정보 조회 함수
    useEffect(() => {

        const storedUser = localStorage.getItem('user');

        if (storedUser) {
            setUser(JSON.parse(storedUser));
        } else {

            const fetchUser = async () => {
                try {
                    const response = await axios.get('/api/employee', {
                        withCredentials: true,
                    });
                    if (response.status === 200) {
                        setUser(response.data);
                        localStorage.setItem('user', JSON.stringify(response.data));
                    } else {
                        console.error('유저 정보를 가져오는데 실패했습니다.');
                    }
                } catch (error) {
                    console.error('유저 정보를 가져오는 중 오류 발생:', error);
                }
            };

            fetchUser(); // 유저 정보가 없을 때만 서버에서 가져옴
        }
    }, []);

    return (
        <UserContext.Provider value={{ user, setUser }}>
            {children}
        </UserContext.Provider>
    );
};