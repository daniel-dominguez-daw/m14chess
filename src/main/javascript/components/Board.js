'use strict'
import React, {useEffect, useState} from 'react';
import { css } from 'glamor';
import pawnBlack from './img/pawn0.png';
import pawnWhite from './img/pawn1.png';

let boardRule = css({
    border: '2px solid black',
    display: 'flex',
    flexDirection: 'column',
    width: '50%'
});

let rowRule = css({
    background: 'green',
    height: 32,
    display: 'flex',
    flexDirection: 'row'
});

let backgroundWhite = css({
    background: '#fff'
});

let backgroundBlack = css({
    background: 'brown'
});

let ruleEmptyCell = css({
    width: 32,
    height: 32
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

const Board = function(props) {
    if (props.pieces.length == 0) return null;

    console.log(props);

    let boardGrid = props.pieces.map((row, index) => {
        let cells = row.map((column, iCol) => {

            let cellStyle;
            if (index % 2 == 0) {
                cellStyle = (iCol % 2 == 0 ? backgroundWhite : backgroundBlack);
            } else {
                cellStyle = (iCol % 2 == 0 ? backgroundBlack : backgroundWhite);
            }

            let pieceContent = (column == null ? <div {...ruleEmptyCell}></div> : pieceRenderer(column.color, column.codeName));

            return (
                <div key={iCol} {...cellStyle}>
                    {pieceContent}
                </div>
            );
        });

        return (
            <div {...rowRule} key={index}>
                {cells}
            </div>
        );
    });


    return (
        <div {...boardRule}>
        {boardGrid}
        </div>
    );
}

export default Board;
