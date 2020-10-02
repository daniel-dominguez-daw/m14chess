'use strict'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Board from './Board.js';
import { css } from 'glamor';

const App = function() {
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

	return (
        <div {...ruleApp}>
            <Board pieces={board} updateBoardHandler={updateBoardHandler}/>
        </div>
	);
}

export default App;

// CSS RULES
let ruleApp = css({
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center'
});

