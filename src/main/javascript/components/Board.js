'use strict'
import React, {useState, useEffect} from 'react';
import { css, select as $ } from 'glamor';
import { xs, sm, md } from '../utils/mediaquery.js';
import BoardRow from './BoardRow.js';
import axios from 'axios';

const Board = function(props) {
    var [board, setBoard] = useState([]);
    var [movingPiece, setMovingPiece] = useState(false);
    var [grabbedPiecePos, setGrabbedPiecePos] = useState({row: null, col: null});
    var [hightlightCells, setHighlightCells] = useState([]);

    const updateBoardHandler = () => {
        axios.get('api/board-state')
        .then((r) => {
            setBoard(r.data.pieces);
            console.log(r.data.pieces);
        });
    };

    const handleCellClick = (cellPos) => {
        return function() {
            if (movingPiece) {

            } else {
                console.log(cellPos);
                setMovingPiece(true);
                setGrabbedPiecePos(cellPos);

                axios.get('api/available-movements', {
                    params: cellPos
                })
                .then((r) => {
                    console.log(r.data);
                    setHighlightCells(r.data);
                });
            }
        }
    };

    useEffect(() => {
        updateBoardHandler();
    }, []);

    let boardGrid = board.map(
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

