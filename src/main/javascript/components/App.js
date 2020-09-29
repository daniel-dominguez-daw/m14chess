'use strict'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Board from './Board.js';
import { css } from 'glamor';

let ruleApp = css({
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center'
});

const App = function() {
    var [board, setBoard] = useState([]);

    useEffect(() => {
        axios.get('api/board-state')
        .then((r) => {
            setBoard(r.data.pieces);
            console.log(r.data.pieces);
        });
    }, []);

	return (
        <div {...ruleApp}>
            <Board pieces={board}/>
        </div>
	);
}

export default App;
