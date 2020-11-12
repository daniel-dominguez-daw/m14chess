'use strict'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { css } from 'glamor';

import {King} from '../utils/pieces.js';


const PlayerInfo = (props) => {
    const { name, playingAs } = props;

    const king = new King(playingAs);

    return (
        <div {...rulePlayerInfo}>
            <div {...ruleHeading}>Player</div>
            <div {...ruleName}>{name}</div>
            <img src={king.renderImage()} width={48} height={48} />
        </div>
    );
};

const rulePlayerInfo = css({
    border: '4px solid #ad9807', 
    margin: 2,
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'column'
});

const ruleHeading = css({
    textTransform: 'uppercase',
    width: '100%',
    textAlign: 'center',
    padding: '4px 10px'
});

const ruleName = css({
    background: '#ad9807',
    width: '100%',
    color: '#FFF',
    textAlign: 'center',
    padding: 4
});

const ruleSubHeading = css({
});

const ruleColor = css({
});

export default PlayerInfo;

