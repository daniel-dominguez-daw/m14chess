'use strict'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { css } from 'glamor';
// components
import Match from './Match.js';
import ErrorPanel from './ErrorPanel.js';
import Loading from './Loading.js';
// hooks
import useApi from '../hooks/useApi.js';

const ApiContext = React.createContext({
    registerApiCall: () => {}
});

const App = function() {
    // call to hook useApi and use his state and functions
    var [loading, errorData, registerApiCall, resetErrorHandler ] = useApi();

	return (
        <div {...ruleApp}>
            { errorData && <ErrorPanel data={errorData} resetErrorHandler={resetErrorHandler} /> }
            <Loading waitingRequest={loading}/>
            <p>Press SPACE or tap in place to cancel your move</p>
            <ApiContext.Provider value={{registerApiCall}}>
                <Match />
            </ApiContext.Provider>
        </div>
	);
};

export default App;

export {ApiContext};

// CSS RULES
let ruleApp = css({
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection: 'column'
});

