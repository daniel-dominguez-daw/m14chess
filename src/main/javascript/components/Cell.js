'use strict'
import React from 'react';
import { css } from 'glamor';
import { Pawn, pieceRenderer } from '../utils/pieces.js';

const Cell = function(props) {
    const { cellColor, pieceColor, codeName } = props;

    const cellStyle = (cellColor == 'BLACK' ? ruleBgBlack : ruleBgWhite);

    const pieceContent = (pieceColor == null && codeName == null ? 
        null : 
        <img src={pieceRenderer(pieceColor, codeName)} />);

    return (
        <div {...cellStyle} {...ruleCell}>
            {pieceContent}
        </div>
    );

}

export default Cell;

// CSS RULES
let ruleBgWhite = css({
    background: '#fff'
});

let ruleBgBlack = css({
    background: 'brown'
});

let ruleCell = css({
    position: 'relative',
    width: 'calc(100% / 8)',
    '>img': {
        position: 'absolute',
        top: 0,
        left: 0,
        width: '100%',
        height: '100%'
    },
    paddingBottom: 'calc(100% / 8)'
});

