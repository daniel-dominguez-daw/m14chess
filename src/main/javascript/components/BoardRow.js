'use strict'
import React from 'react';
import { css } from 'glamor';
import Cell from './Cell.js';

const BoardRow = function(props) {
    const { columns, rowIndex, hightlightCells, handleCellClick } = props;

    let cells = columns.map((column, iCol) => <Cell key={iCol}
                    highlight={shouldBeHightlighted(hightlightCells, rowIndex, iCol)}
                    cellColor={(rowIndex % 2 == 0 ? 
                        (iCol % 2 == 0 ? 'WHITE' : 'BLACK') : 
                        (iCol % 2 == 0 ? 'BLACK' : 'WHITE'))} 
                    codeName={(column == null ? null : column.codeName)} 
                    pieceColor={(column == null ? null : column.color)} 
                    position={{row: rowIndex, col: iCol}}
                    handleCellClick={handleCellClick}
                    />);

    return (
        <div {...ruleBoardRow} >
            {cells}
       </div>
    );
}

const shouldBeHightlighted = (positionList, cellRow, cellCol) => {
    for ( let pos of positionList) {
        if (cellRow == pos.row && cellCol == pos.col) {
            return true;
        }
    }
    return false;
};

// CSS RULES
let ruleBoardRow = css({
    background: 'green',
    display: 'flex',
    flexDirection: 'row'
});

export default BoardRow;
