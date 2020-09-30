'use strict'
import React from 'react';
import { css } from 'glamor';
import pawnBlack from './img/pawn0.png';
import pawnWhite from './img/pawn1.png';
import kingBlack from './img/king0.png';
import kingWhite from './img/king1.png';
import queenBlack from './img/queen0.png';
import queenWhite from './img/queen1.png';
import rookBlack from './img/rook0.png';
import rookWhite from './img/rook1.png';
import knightBlack from './img/knight0.png';
import knightWhite from './img/knight1.png';
import bishopBlack from './img/bishop0.png';
import bishopWhite from './img/bishop1.png';

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

const pieceRenderer = function(color, type) {
    let piece;
    if (color == 'BLACK') {
        switch(type) {
            case 'PAWN':
                piece = pawnBlack;
                break;
        }
    } else if(color == 'WHITE') {
        switch(type) {
            case 'PAWN':
                piece = pawnWhite;
                break;
        }
    }

    return (
        <img src={piece} />
    )
}

const Cell = function(props) {
    const { cellColor, pieceColor, codeName } = props;

    const cellStyle = (cellColor == 'BLACK' ? ruleBgBlack : ruleBgWhite);

    const pieceContent = (pieceColor == null && codeName == null ? 
        null : 
        pieceRenderer(pieceColor, codeName));

    return (
        <div {...cellStyle} {...ruleCell}>
            {pieceContent}
        </div>
    );

}

export default Cell;
