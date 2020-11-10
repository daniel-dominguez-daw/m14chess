'use strict'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { css } from 'glamor';

import PlayerInfo from './PlayerInfo.js';

const PlayerJoin = (props) => {
    var { color, player, joinGame } = props;

    const labelButton = (color == 'BLACK' ? 
                        'Join as black player' : 'Join as white player');
    const render = (player !== null ? 
                        <PlayerInfo name={player.name} playingAs={player.playingAs}/> :
                        (
                        <div>
                            <input type="button" value={labelButton} onClick={joinGame}/>
                        </div>
                        ));
    return render;
};

export default PlayerJoin;
