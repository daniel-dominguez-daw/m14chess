'use strict'
import React from 'react';
import { css } from 'glamor';
import Cell from './Cell.js';

const BoardRow = function(props) {
    const { columns, rowIndex } = props;

    let cells = columns.map((column, iCol) => <Cell key={iCol}
                    highlight={iCol % 4 == 0 ? true : false}
                    cellColor={(rowIndex % 2 == 0 ? 
                        (iCol % 2 == 0 ? 'WHITE' : 'BLACK') : 
                        (iCol % 2 == 0 ? 'BLACK' : 'WHITE'))} 
                    codeName={(column == null ? null : column.codeName)} 
                    pieceColor={(column == null ? null : column.color)} 
                    position={{row: rowIndex, col: iCol}}
                    />);

    return (
        <div {...ruleBoardRow} >
            {cells}
       </div>
    );
}

// CSS RULES
let ruleBoardRow = css({
    background: 'green',
    display: 'flex',
    flexDirection: 'row'
});

export default BoardRow;
