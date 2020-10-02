'use strict'
import React from 'react';
import { css } from 'glamor';
import { Pawn, pieceRenderer } from '../utils/pieces.js';

const Cell = function(props) {
    const { cellColor, pieceColor, codeName, highlight } = props;

    const cellStyle = (cellColor == 'BLACK' ? ruleBgBlack : ruleBgWhite);

    const pieceContent = (pieceColor == null && codeName == null ? 
        null : 
        <img src={pieceRenderer(pieceColor, codeName)} />);

    let incomingCellCss = ruleCell;
    if (highlight) {
        incomingCellCss = css(incomingCellCss, ruleCellSucessPosition);
    }

    if (null !== pieceContent) {
        incomingCellCss = css(incomingCellCss, ruleCellGrab);
    }

    return (
        <div {...cellStyle} {...incomingCellCss} >
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
    paddingBottom: 'calc(100% / 8)',
    border: '1px solid #000'
});

let hightlightPulse = css.keyframes('hpulse', {
    '0%': {
        background: '#24ca21'
    },
    '50%': {
        background: '#5ee45c'
    },
    '100%': {
        background: '#24ca21'
    },
});

let ruleCellSucessPosition = css({
    animation: `${hightlightPulse} 1s infinite`,
    background: '#24ca21'
});

let ruleCellGrab = css({
    ':hover' : {
        cursor: 'grabbing'
    }
});
