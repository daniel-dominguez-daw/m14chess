'use strict'
import React, {useState, useEffect, useContext} from 'react';
import { css, select as $ } from 'glamor';
import { xs, sm, md } from '../utils/mediaquery.js';
import axios from 'axios';

import PlayerJoin from './PlayerJoin.js';

import {ApiContext} from './App.js';

const EmptyMatch = function(props) {
    var { whitePlayer, blackPlayer, joinWhitePlayer, joinBlackPlayer } = props;

    if (whitePlayer == undefined) whitePlayer = null;
    if (blackPlayer == undefined) blackPlayer = null;

    return (
        <div>
            <div>
                <PlayerJoin 
                    color="WHITE"
                    player={whitePlayer}
                    joinGame={joinWhitePlayer} />
                <PlayerJoin 
                    color="BLACK"
                    player={blackPlayer}
                    joinGame={joinBlackPlayer} />
            </div>
            Preparing the game
        </div>
    );
};

export default EmptyMatch;
