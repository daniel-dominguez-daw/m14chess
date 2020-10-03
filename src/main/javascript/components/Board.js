'use strict'
import React, {useState, useEffect, useContext} from 'react';
import { css, select as $ } from 'glamor';
import { xs, sm, md } from '../utils/mediaquery.js';
import BoardRow from './BoardRow.js';
import axios from 'axios';

import {LoadingContext} from './App.js';

const Board = function(props) {
    var [board, setBoard] = useState([]);
    var [movingPiece, setMovingPiece] = useState(false);
    var [grabbedPiecePos, setGrabbedPiecePos] = useState({row: null, col: null});
    var [hightlightCells, setHighlightCells] = useState([]);

    const loadingC = useContext(LoadingContext);

    const updateBoardHandler = loadingC.loadingDataHandler(() => {
        return new Promise((res, rej) => {
            axios.get('api/board-state')
            .then((r) => {
                setBoard(r.data.pieces);
                console.log(r.data.pieces);
                res(true);
            });
        });
    });

    const handleCellClick = (cellPos) => {
        return loadingC.loadingDataHandler(() => {
            return new Promise((res, rej) => {
                if (movingPiece) {
                    // @todo call to api post api/move
                    res(true);
                    // on success piece movement
                    setHighlightCells([]);
                    updateBoardHandler();
                    // on error reject promise
                    // rej(err);
                    setMovingPiece(false);
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
                        res(true);
                    });
                }
            });
        });
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

