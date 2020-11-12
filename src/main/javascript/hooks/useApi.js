'use strict'
import React, {useState} from 'react';

const useApi = function() {
    var [loading, setLoading] = useState(false);
    var [errorData, setErrorData] = useState(false);

    const registerApiCall = function(onSuccessPromise) {
        return function() {
            if(!loading) {
                setLoading(true);
                setTimeout(() => {
                    onSuccessPromise()
                    .then(() => {
                        setLoading(false);
                    })
                    .catch((err) => {
                        if(err.response.data !== undefined) {
                            setErrorData(err.response.data);
                        }
                        setLoading(false);
                    });
                }, 80);
            }
        }
    };

    const resetErrorHandler = () => {
        setErrorData(false);
    };

    return [ loading, errorData, registerApiCall, resetErrorHandler ];
};

export default useApi;
