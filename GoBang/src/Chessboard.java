

/**
 * 棋盘类
 * 主要控制棋盘的初始化，输出及增加新的棋子。
 */
 class Chessboard {
    static final int BOARD_SIZE = 15;
    private String board[][] ;

    /**
     * 初始化棋盘。
     * 二维数组
     */
    public void initBoard(){
        board = new String[BOARD_SIZE][BOARD_SIZE];
        //把元素值设为“十”，用控制台输出棋盘
        for (int i = 0; i <BOARD_SIZE ; i++) {
            for (int j = 0; j <BOARD_SIZE ; j++) {
                board[i][j] = "十";
            }
        }
    }

    /**
     * 输出棋盘
     */
    public void printBoard(){
        //打印每个数组的元素
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE ; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }

    /**
     * 返回棋盘
     * @return
     */
    public String[][] getBoard() {
        return board;
    }

    public void setBoard(int posX ,int posY ,String chessman){
        board[posX-1][posY-1] = chessman;

    }

//    public static void main(String[] args) {
//        Chessboard chessboard = new Chessboard();
//        chessboard.initBoard();
//        chessboard.printBoard();
//
//    }
}
