'use strict'
import pawnBlack from '../img/pawn0.png';
import pawnWhite from '../img/pawn1.png';
import kingBlack from '../img/king0.png';
import kingWhite from '../img/king1.png';
import queenBlack from '../img/queen0.png';
import queenWhite from '../img/queen1.png';
import rookBlack from '../img/rook0.png';
import rookWhite from '../img/rook1.png';
import knightBlack from '../img/knight0.png';
import knightWhite from '../img/knight1.png';
import bishopBlack from '../img/bishop0.png';
import bishopWhite from '../img/bishop1.png';

class Piece {
    constructor(color) {
        this.color = color;
        if (new.target == 'Piece')
            throw TypeError('Cannot construct Piece directly');
    }

    renderImage() {
        return null;
    }
}

class Pawn extends Piece {
    constructor(color) {
        super(color);
    }

    renderImage() {
        return (this.color == 'BLACK' ? pawnBlack : pawnWhite);
    }
}

class Rook extends Piece {
    constructor(color) {
        super(color);
    }

    renderImage() {
        return (this.color == 'BLACK' ? rookBlack : rookWhite);
    }
}

class Knight extends Piece {
    constructor(color) {
        super(color);
    }

    renderImage() {
        return (this.color == 'BLACK' ? knightBlack : knightWhite);
    }
}

class Bishop extends Piece {
    constructor(color) {
        super(color);
    }

    renderImage() {
        return (this.color == 'BLACK' ? bishopBlack : bishopWhite);
    }
}

class King extends Piece {
    constructor(color) {
        super(color);
    }

    renderImage() {
        return (this.color == 'BLACK' ? kingBlack : kingWhite);
    }
}

class Queen extends Piece {
    constructor(color) {
        super(color);
    }

    renderImage() {
        return (this.color == 'BLACK' ? queenBlack : queenWhite);
    }
}

const pieceRenderer = function(color, type) {
    let piece;
    switch(type) {
        case 'PAWN':
            piece = new Pawn(color);
            break;
        case 'ROOK':
            piece = new Rook(color);
            break;
        case 'KNIGHT':
            piece = new Knight(color);
            break;
        case 'BISHOP':
            piece = new Bishop(color);
            break;
        case 'KING':
            piece = new King(color);
            break;
        case 'QUEEN':
            piece = new Queen(color);
            break;
        default:
            piece = new Pawn(color);
            break;
    }

    return piece.renderImage();
}

export { Pawn, King, pieceRenderer };

