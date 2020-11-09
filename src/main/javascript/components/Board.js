'use strict'
import React, {useState, useEffect, useContext} from 'react';
import { css, select as $ } from 'glamor';
import { xs, sm, md } from '../utils/mediaquery.js';
import BoardRow from './BoardRow.js';
import axios from 'axios';

import {ApiContext} from './App.js';

const Board = function(props ) {
    var { board, hightlightCells, handleCellClick } = props;

    if (board == undefined) return null;

    let boardGrid = board.pieces.map(
        (columns, rowIndex) => <BoardRow 
                        handleCellClick={handleCellClick}
                        {...props}
                        key={rowIndex} 
                        rowIndex={rowIndex}
                        columns={columns} 
                        hightlightCells={hightlightCells}
        />);

    return (
        <div {...ruleBoard}>
            <div {...css(ruleLettersNumbersShared, ruleVerticalNumbers)}>
                <span>8</span>
                <span>7</span>
                <span>6</span>
                <span>5</span>
                <span>4</span>
                <span>3</span>
                <span>2</span>
                <span>1</span>
            </div>
            <div {...css(ruleLettersNumbersShared, ruleHorizontalLetters)}>
                <span>a</span>
                <span>b</span>
                <span>c</span>
                <span>d</span>
                <span>e</span>
                <span>f</span>
                <span>g</span>
                <span>h</span>
            </div>
            {boardGrid}
        </div>
    );
}

const cellIsEmpty = (cellPos, boardPieces) => {
    return (boardPieces[cellPos.row][cellPos.col] == null);
};

const samePos = (posA, posB) => {
    return (posA.row == posB.row && posA.col == posB.col);
};

export default Board;

// CSS RULES
const borderColor = '#ad9807';
let ruleBoard = css({
    borderStyle: 'solid',
    borderWidth: '24px 16px 24px 16px',
    borderColor: borderColor,
    position: 'relative',
    borderRadius: 20,
    display: 'flex',
    flexDirection: 'column',
    width: '60%'
    },
    $(xs, {
        width: '90%'
    }),
    $(sm, {
        width: '80%'
    }),
    $(md, {
        width: '70%'
    }),
    $(md, {
        width: '50%'
    })
);

let ruleLettersNumbersShared = css({
    background: borderColor,
    color: '#605300',
    display: 'flex',
    position: 'absolute',
    fontWeight: 'bold'
});

let ruleHorizontalLetters = css({
    padding: '2px 0',
    flexDirection: 'row',
    width: '100%',
    top: '-22px',
    '>span' : {
        width: 'calc(100%/8)',
        textAlign: 'center'
    }
});


let ruleVerticalNumbers = css({
    padding: '0 2px',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    left: -13,
    height: '100%',
    '>span' : {
        height: 'calc(100% / 8)',
        display: 'flex',
        textAlign: 'center',
        alignItems: 'center'
    }
});
