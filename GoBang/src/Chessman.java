/**
 * 棋子类
 */
public enum Chessman {
    BLACK("●"),WHITE("○");
    private String chessman;

    /**
     * 私有构造方法，只允许本类内创建
     * @param chessman
     */
    private Chessman(String chessman){
        this.chessman = chessman;
    }

    /**
     *
     * @return
     */
    public String getChessman() {
        return chessman;
    }
}
