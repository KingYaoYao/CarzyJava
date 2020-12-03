import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GoBangGame {
    private static final int WIN_COUNT = 5;
    int posX = 0;
    int posY = 0;
    Chessboard chessboard = new Chessboard();

    /**
     * 验证字符串输入是否合法
     * @param inputStr
     * @return
     */
    public boolean isValid(String inputStr){
        //将用户输入的字符串以“,”分割得到x y的坐标
        String[] posStrArr = inputStr.split(",");
        try {
            posX = Integer.parseInt(posStrArr[0] ) ;
            posY = Integer.parseInt(posStrArr[1]) ;
        }catch (NumberFormatException e){
            chessboard.printBoard();
            System.out.println("请以(数字，数字)的格式输入：");
            return false;
        }
        //检查输入的数值是否在范围之内
        if (posX < 0 || posY < 0||posX >= Chessboard.BOARD_SIZE || posY >= Chessboard.BOARD_SIZE){
            chessboard.printBoard();
            System.out.println("x与y的坐标只能大于1小于等于" + Chessboard.BOARD_SIZE + "请重新输入");
            return false;
        }

        //验证玩家输入的棋子是否存在
        String[][] board = chessboard.getBoard();
        if (board[posX][posY] != "十"){
            chessboard.printBoard();
            System.out.println("已经存在棋子了，请重新输入");
            return false;
        }
        return  true;
    }

    /**
     * 开始游戏
     */
    public void start(){
        boolean isOver = false;
        chessboard.initBoard();
        chessboard.printBoard();
        //获取键盘的输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入棋子坐标");
        String inputStr = null;
        try {
            while ((inputStr = br.readLine()) != null) {

                isOver =false;
                if ( !isValid(inputStr)){
                        continue;
                    }
                    //把对应的数组元素赋值为黑色
                    String chessman = Chessman.BLACK.getChessman();
                    chessboard.setBoard(posX,posY,chessman);
                    chessboard.printBoard();
                    System.out.println(1);
                    //判断用户是否赢了
                    if (isWon(posX,posY,chessman)){
                        isOver = true;
                    }else {
                        System.out.println(2);
                        //计算机随机选择
                        int[] computerDo = computerDo();
                        for (int i = 0; i < computerDo.length; i++) {
                            System.out.println("电脑产生" + computerDo[i]);
                        }
                        //产生的坐标没有问题
                        String whiteChessman = Chessman.WHITE.getChessman();
                        chessboard.setBoard(computerDo[0],computerDo[1],whiteChessman);
                        chessboard.printBoard();
                        System.out.println("请输入棋子坐标");
                        // System.out.println(3);
                        if (isWon(computerDo[0],computerDo[1],whiteChessman)){
                            isOver = true;
                        }

                    }
                    if (isOver){
                        if (isReplay(chessman)){
                            chessboard.initBoard();
                            chessboard.printBoard();
                            continue;
                        }
                        break;
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        chessboard.printBoard();
        System.out.println("请输入棋子坐标");
        }



    /**
     * 是否重新玩
     * @param chessman
     * @return
     */
    public boolean isReplay(String chessman){
        chessboard.printBoard();
        String message = chessman.equals(Chessman.BLACK.getChessman())
                ?"恭喜您，您赢了" :"很遗憾，您输了";
        System.out.println(message + "再一下局？（y/n）");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            if (br.readLine().equals("y")){
                return true;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return false;
    }

    /**
     * 计算机随机落子
     * @return
     */
    public int[] computerDo(){
        String[][] board = chessboard.getBoard();
        int posA = 0;
        int posB = 0;
        do {
            //随机生成x坐标，即二维数组的一维的值
            posA = (int)(Math.random()*(Chessboard.BOARD_SIZE -1));
            //随机生成Y坐标，即生成二维数组的二维的值
            posB = (int)(Math.random()*(Chessboard.BOARD_SIZE -1));

        }while (board[posA][posB] != "十");
        //当棋盘中的位置不是"+"的时候（已经有棋子），再次生成新的坐标

        int [] computerArr= {posA,posB};
        return computerArr;
    }

    public boolean isWon(int posX,int posY,String ico){
        //直线起点的x坐标
        int startX = 0;
        //直线七点Y坐标
        int startY = 0;
        //直线结束X坐标
        int endX = Chessboard.BOARD_SIZE -1;
        int endY = endX;
        //同条直线上，相邻棋子累计数
        int sameCount = 0;
        int temp = 0;
        //计算起点的最小x坐标与Y坐标
        temp = posX - WIN_COUNT +1;
        startX = temp<0? 0 : temp;
        temp = posY - WIN_COUNT +1;
        startY = temp<0? 0 : temp;

        //计算重点的最大X坐标与Y坐标
        temp = posX+WIN_COUNT -1;
        endX = temp>Chessboard.BOARD_SIZE -1? Chessboard.BOARD_SIZE -1 :temp;
        temp = posY+WIN_COUNT -1;
        endY = temp>Chessboard.BOARD_SIZE -1? Chessboard.BOARD_SIZE -1 :temp;
        //从左到右方向计算相同相邻棋子的数目
        String[][] board = chessboard.getBoard();
        for (int i = startY; i < endY; i++) {
            if (board[posX][i] == ico && board[posX][i+1] == ico){
                sameCount++;
            }else if (sameCount != WIN_COUNT-1){
                sameCount = 0;
            }

        }
        return  sameCount >= WIN_COUNT-1;
    }


    public static void main(String[] args) {
        new GoBangGame().start();

    }


}
