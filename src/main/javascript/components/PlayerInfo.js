'use strict'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { css } from 'glamor';


const PlayerInfo = (props) => {
    const { name, playingAs } = props;

    return (
        <div {...css({border: '4px solid red', padding: 10, margin: 2})}>
            <p>Playername: {name}</p>
            <p>PlayingAs: {playingAs}</p>
        </div>
    );
};


export default PlayerInfo;

