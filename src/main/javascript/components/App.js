'use strict'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import './App.css';

const App = function() {
    var [jscontent, setJsContent] = useState("");

	var b = 0;

    useEffect(() => {
        axios.get('js/app.js')
        .then((r) => {
            setJsContent(r.data);
        });
    }, []);

	return (
        <div id="app">
            <div>Hello world {b}</div>
            <div style={{background: "orange"}}>{jscontent}</div>
        </div>
	);
}

export default App;
