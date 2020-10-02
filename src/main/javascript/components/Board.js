'use strict'
import React, {useState, useEffect} from 'react';
import { css, select as $ } from 'glamor';
import { xs, sm, md } from '../utils/mediaquery.js';
import BoardRow from './BoardRow.js';
import axios from 'axios';

const Board = function(props) {
    var [board, setBoard] = useState([]);

    const updateBoardHandler = () => {
        axios.get('api/board-state')
        .then((r) => {
            setBoard(r.data.pieces);
            console.log(r.data.pieces);
        });
    };

    useEffect(() => {
        updateBoardHandler();
    }, []);

    let boardGrid = board.map(
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

