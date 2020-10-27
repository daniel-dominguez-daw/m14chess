'use strict'
import React, {useState, useEffect, useContext} from 'react';
import { css, select as $ } from 'glamor';
import { xs, sm, md } from '../utils/mediaquery.js';
import BoardRow from './BoardRow.js';
import axios from 'axios';

import {ApiContext} from './App.js';

const Board = function(props) {
    var [board, setBoard] = useState([]);
    var [movingPiece, setMovingPiece] = useState(false);
    var [hightlightCells, setHighlightCells] = useState([]);

    const { registerApiCall } = useContext(ApiContext);

    useEffect(() => {
        if(hightlightCells.length > 0) {
            document.onkeypress = (e) => {
                if(e.key === " ") {
                    e.preventDefault();
                    setMovingPiece(false);
                    setHighlightCells([]);
                }
            };
        } else {
            document.onkeypress = (e) => {
                if(e.key === " ") {
                    e.preventDefault();
                }
            };
        }

    }, [hightlightCells]);

    // Safety effect, if board state changes, reset movingPiece state and piece highlighting
    useEffect(() => {
        setHighlightCells([]);
        setMovingPiece(false);
    }, [board]);

    const updateBoardHandler = registerApiCall(() => new Promise((res, rej) => {
        axios.get('api/board-state')
        .then((r) => {
            setBoard(r.data.pieces);
            res(r.data.pieces);
        })
        .catch((err) => {
            rej(err);
        });
    }));

    const handleCellClick = (cellPos) => {
        return registerApiCall(() => 
            new Promise((res, rej) => {
                if (movingPiece !== false) {
                    // When you click to the exact same piece you want to move, the movement mode reset
                    if(samePos(movingPiece, cellPos)) {
                        setMovingPiece(false);
                        setHighlightCells([]);
                        res(true);
                        return;
                    }

                    // Preparing API Post params
                    const params = new URLSearchParams();
                    params.append('rowFrom', movingPiece.row);
                    params.append('rowTo', cellPos.row);
                    params.append('colFrom', movingPiece.col);
                    params.append('colTo', cellPos.col);

                    axios.post('api/move-to', params)
                    .then((r) => {
                        setBoard(r.data.board.pieces);
                        setHighlightCells([]);
                        setMovingPiece(false);

                        // if servers responds with transform, then trigger UI
                        if (r.data.transformPiece !== false) {
                            alert("Transform!");
                        }
                        res(true);
                    })
                    .catch((err) => {
                        rej(err);
                    });

                } else {
                    // if no piece, don't do anything
                    if (cellIsEmpty(cellPos, board)) {
                        res(true);
                        return;
                    }

                    setMovingPiece(cellPos);

                    axios.get('api/available-movements', {
                        params: cellPos
                    })
                    .then((r) => {
                        // if there are no places to move, dont highlight and reset  movingPiece state
                        if(r.data.length == 0) {
                            setMovingPiece(false);
                        } else {
                            setHighlightCells(r.data);
                        }
                        res(true);
                    })
                    .catch((err) => {
                        rej(err);
                    });
                }
            })
        );
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

const cellIsEmpty = (cellPos, board) => {
    return (board[cellPos.row][cellPos.col] == null);
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
