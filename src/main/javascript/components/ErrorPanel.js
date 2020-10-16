'use strict'
import React, {useState, useEffect } from 'react';
import { css } from 'glamor';
import { xs, sm, md } from '../utils/mediaquery.js';

const ErrorPanel = function(props) {
    if (props.data == false )
        return false;

    const { code, error, data} = props.data;

    return (
        <div {...ruleError} >
            <div {...ruleCloseButton} onClick={props.resetErrorHandler}>⨉</div>
            <p>Error Found!</p>
            <p>Code: {code} </p>
            <p>Error: {error} </p>
            <p>Data: {JSON.stringify(data)}</p>
        </div>
    );
};


export default ErrorPanel;

const ruleError = css({
    background: 'red',
    padding: 5,
    color: '#fff',
    position: 'fixed',
    width: '80%',
    zIndex: 1,
});

const ruleCloseButton = css({
    position: 'absolute',
    top: 0,
    right: 0,
    padding: 5,
    color: '#000',
    fontWeight: 'bold',
    fontSize: '200%'
});
