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
                res(r.data.pieces);
            })
            .catch((err) => {
                rej(err);
            });
        });
    });

    const handleCellClick = (cellPos) => {
        return loadingC.loadingDataHandler(() => {
            return new Promise((res, rej) => {
                if (movingPiece !== false) {
                    // @todo call to api post api/move
                    const params = new URLSearchParams();
                    params.append('rowFrom', movingPiece.row);
                    params.append('rowTo', cellPos.row);
                    params.append('colFrom', movingPiece.col);
                    params.append('colTo', cellPos.col);

                    axios.post('api/move-to', params)
                    .then((r) => {
                        setBoard(r.data.pieces);
                        setHighlightCells([]);
                        setMovingPiece(false);
                        res(true);
                    })
                    .catch((err) => {
                        console.log("moveto error");
                        console.log(err.response);
                        rej(err);
                    });

                } else {
                    setMovingPiece(cellPos);
                    setGrabbedPiecePos(cellPos);

                    axios.get('api/available-movements', {
                        params: cellPos
                    })
                    .then((r) => {
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

