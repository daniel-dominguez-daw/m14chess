'use strict'
import React from 'react';
import { css, select as $ } from 'glamor';
import { xs, sm, md } from '../utils/mediaquery.js';
import BoardRow from './BoardRow.js';

const Board = function(props) {
    const { pieces } = props;
    if (pieces.length == 0) return null;

    let boardGrid = pieces.map(
        (columns, rowIndex) => <BoardRow 
                        {...props}
                        key={rowIndex} 
                        rowIndex={rowIndex}
                        columns={columns} />);

    return (
        <div {...ruleBoard}>
        {boardGrid}
        </div>
    );
}

export default Board;

// CSS RULES
let ruleBoard = css({
    border: '8px solid #ad9807',
    borderRadius: 3,
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

