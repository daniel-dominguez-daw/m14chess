'use strict'
import React, {useEffect, useState} from 'react';
import { css, select as $ } from 'glamor';
import { xs, sm, md } from '../utils/mediaquery.js';
import Cell from './Cell.js';

let ruleBoard = css({
    border: '2px solid black',
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

let rowRule = css({
    background: 'green',
    display: 'flex',
    flexDirection: 'row'
});

const Board = function(props) {
    if (props.pieces.length == 0) return null;

    console.log(props);

    let boardGrid = props.pieces.map((row, index) => {
        let cells = row.map((column, iCol) => <Cell key={iCol}
                        cellColor={(index % 2 == 0 ? 
                            (iCol % 2 == 0 ? 'WHITE' : 'BLACK') : 
                            (iCol % 2 == 0 ? 'BLACK' : 'WHITE'))} 
                        codeName={(column == null ? null : column.codeName)} 
                        pieceColor={(column == null ? null : column.color)} />);

        return (
            <div {...rowRule} key={index}>
                {cells}
           </div>
        );
    });


    return (
        <div {...ruleBoard}>
        {boardGrid}
        </div>
    );
}

export default Board;
