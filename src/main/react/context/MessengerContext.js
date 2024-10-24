import React, { createContext, useState } from 'react';

export const MessengerContext = createContext();

export const MessengerProvider = ({ children }) => {
    const [isMessengerOpen, setMessengerOpen] = useState(false);

    return (
        <MessengerContext.Provider value={{ isMessengerOpen, setMessengerOpen }}>
            {children}
        </MessengerContext.Provider>
    );
};
