'use strict'
import React from 'react';
import { css } from 'glamor';
import loadingImg from '../img/loading.gif';

const Loading = function(props) {
    const { waitingRequest } = props;

    return (
        <div {...ruleLoading}>
            {
                waitingRequest ?
                (
                    <>
                    <img src={loadingImg} alt="syncing"/> <span>&nbsp;syncing</span>
                    </>
                ) : null
            }
        </div>
    );
};

export default Loading;

const ruleLoading = css({
    height: 16,
    margin: '5px 0',
    display: 'flex',
    justifyContent: 'flex-end',
    '>img' : {
        height: 16,
        width: 16
    }
});
