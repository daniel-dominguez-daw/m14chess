'use strict'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Board from './Board.js';
import { css } from 'glamor';

const App = function() {

	return (
        <div {...ruleApp}>
            <Board />
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

