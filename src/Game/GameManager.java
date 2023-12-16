public class GameManager {
    public static void Jalan(UlarTangga game, int posisiP1, int posisiP2, int giliran) {
        byte a1;
        int a2;
        byte s1;
        int s2;
        
        if (giliran == 1) {
            if (game.cekPlayer1 / 10 % 2 == 0) {
                s1 = 0;
                s2 = game.cekPlayer1 % 10 - 1;
            } else {
                s1 = 9;
                s2 = 10 - game.cekPlayer1 % 10;
            }

            if (game.cekPlayer1 == game.cekPlayer2) {
                if (game.cekPlayer1 <= 10) {
                    game.lArrPapan[9][game.cekPlayer1 - 1].setIcon(game.PapanP2[9][game.cekPlayer1 - 1]);
                } else if (game.cekPlayer1 % 10 == 0) {
                    game.lArrPapan[10 - game.cekPlayer1 / 10][s1].setIcon(game.PapanP2[10 - game.cekPlayer1 / 10][s1]);
                } else {
                    game.lArrPapan[9 - game.cekPlayer1 / 10][s2].setIcon(game.PapanP2[9 - game.cekPlayer1 / 10][s2]);
                }
            } else if (game.cekPlayer1 <= 10) {
                game.lArrPapan[9][game.cekPlayer1 - 1].setIcon(game.PapanKosong[9][game.cekPlayer1 - 1]);
            } else if (game.cekPlayer1 % 10 == 0) {
                game.lArrPapan[10 - game.cekPlayer1 / 10][s1].setIcon(game.PapanKosong[10 - game.cekPlayer1 / 10][s1]);
            } else {
                game.lArrPapan[9 - game.cekPlayer1 / 10][s2].setIcon(game.PapanKosong[9 - game.cekPlayer1 / 10][s2]);
            }

            if (posisiP1 / 10 % 2 == 0) {
                a1 = 0;
                a2 = posisiP1 % 10 - 1;
            } else {
                a1 = 9;
                a2 = 10 - posisiP1 % 10;
            }

            if (posisiP1 == posisiP2) {
                if (posisiP1 <= 10) {
                    game.lArrPapan[9][posisiP1 - 1].setIcon(game.PapanP1P2[9][posisiP1 - 1]);
                } else if (posisiP1 % 10 == 0) {
                    game.lArrPapan[10 - posisiP1 / 10][a1].setIcon(game.PapanP1P2[10 - posisiP1 / 10][a1]);
                } else {
                    game.lArrPapan[9 - posisiP1 / 10][a2].setIcon(game.PapanP1P2[9 - posisiP1 / 10][a2]);
                }
            } else if (posisiP1 <= 10) {
                game.lArrPapan[9][posisiP1 - 1].setIcon(game.PapanP1[9][posisiP1 - 1]);
            } else if (posisiP1 % 10 == 0) {
                game.lArrPapan[10 - posisiP1 / 10][a1].setIcon(game.PapanP1[10 - posisiP1 / 10][a1]);
            } else {
                game.lArrPapan[9 - posisiP1 / 10][a2].setIcon(game.PapanP1[9 - posisiP1 / 10][a2]);
            }
        }

        if (giliran == 2) {
            if (game.cekPlayer2 / 10 % 2 == 0) {
                s1 = 0;
                s2 = game.cekPlayer2 % 10 - 1;
            } else {
                s1 = 9;
                s2 = 10 - game.cekPlayer2 % 10;
            }

            if (game.cekPlayer1 == game.cekPlayer2) {
                if (game.cekPlayer2 <= 10) {
                    game.lArrPapan[9][game.cekPlayer2 - 1].setIcon(game.PapanP1[9][game.cekPlayer2 - 1]);
                } else if (game.cekPlayer2 % 10 == 0) {
                    game.lArrPapan[10 - game.cekPlayer2 / 10][s1].setIcon(game.PapanP1[10 - game.cekPlayer2 / 10][s1]);
                } else {
                    game.lArrPapan[9 - game.cekPlayer2 / 10][s2].setIcon(game.PapanP1[9 - game.cekPlayer2 / 10][s2]);
                }
            } else if (game.cekPlayer2 <= 10) {
                game.lArrPapan[9][game.cekPlayer2 - 1].setIcon(game.PapanKosong[9][game.cekPlayer2 - 1]);
            } else if (game.cekPlayer2 % 10 == 0) {
                game.lArrPapan[10 - game.cekPlayer2 / 10][s1].setIcon(game.PapanKosong[10 - game.cekPlayer2 / 10][s1]);
            } else {
                game.lArrPapan[9 - game.cekPlayer2 / 10][s2].setIcon(game.PapanKosong[9 - game.cekPlayer2 / 10][s2]);
            }

            if (posisiP2 / 10 % 2 == 0) {
                a1 = 0;
                a2 = posisiP2 % 10 - 1;
            } else {
                a1 = 9;
                a2 = 10 - posisiP2 % 10;
            }

            if (posisiP1 == posisiP2) {
                if (posisiP1 <= 10) {
                    game.lArrPapan[9][posisiP2 - 1].setIcon(game.PapanP1P2[9][posisiP2 - 1]);
                } else if (posisiP2 % 10 == 0) {
                    game.lArrPapan[10 - posisiP2 / 10][a1].setIcon(game.PapanP1P2[10 - posisiP2 / 10][a1]);
                } else {
                    game.lArrPapan[9 - posisiP2 / 10][a2].setIcon(game.PapanP1P2[9 - posisiP2 / 10][a2]);
                }
            } else if (posisiP2 <= 10) {
                game.lArrPapan[9][posisiP2 - 1].setIcon(game.PapanP2[9][posisiP2 - 1]);
            } else if (posisiP2 % 10 == 0) {
                game.lArrPapan[10 - posisiP2 / 10][a1].setIcon(game.PapanP2[10 - posisiP2 / 10][a1]);
            } else {
                game.lArrPapan[9 - posisiP2 / 10][a2].setIcon(game.PapanP2[9 - posisiP2 / 10][a2]);
            }
        }
    }
}