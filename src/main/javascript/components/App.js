'use strict'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Board from './Board.js';
import ErrorPanel from './ErrorPanel.js';
import { css } from 'glamor';

import Loading from './Loading.js';

const LoadingContext = React.createContext({
    loadingState: false,
    loadingDataHandler: () =>{}
});

const App = function() {
    var [loading, setLoading] = useState(false);
    var [errorData, setErrorData] = useState(false);

    const loadingDataHandler = function(apiHandlerFn) {
        return function() {
            if(!loading) {
                setLoading(true);
                setTimeout(() => {
                    apiHandlerFn()
                    .then(() => {
                        setLoading(false);
                    })
                    .catch((err) => {
                        if(err.response.data !== undefined) {
                            setErrorData(err.response.data);
                        }
                        setLoading(false);
                    });
                }, 300);
            }
        }
    };

    const resetErrorHandler = () => {
        setErrorData(false);
        console.log("run resetErrorHandler");
    };

	return (
        <div {...ruleApp}>
            { errorData && <ErrorPanel data={errorData} resetErrorHandler={resetErrorHandler} /> }
            <Loading waitingRequest={loading}/>
            <LoadingContext.Provider value={{loadingState: loading, loadingDataHandler: loadingDataHandler}}>
                <Board />
            </LoadingContext.Provider>
        </div>
	);
}

export default App;

export {LoadingContext};

// CSS RULES
let ruleApp = css({
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection: 'column'
});

