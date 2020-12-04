import javax.swing.*;
import java.awt.*;

/**
 * 容器类
 */
public class CalFrame {
    private static final int PRE_HEIGHT = 10;
    private static final int PRE_WIDTH = 10;
    private JFrame jFrame;      //窗口
    private TextField textField;

    private String[] nOp = {"","","","","","","","","","","","","","","","","","","",""};

    private JButton[];


    public CalFrame() {
    }

    public JFrame getjFrame() {
        return jFrame = new JFrame();
    }

    public java.awt.TextField getTextField() {
        return textField = new TextField();
    }
    /**
     * 初始化计算机窗口
     * @param
     */
    private void initialize(){
    jFrame = getjFrame();
    jFrame.setTitle("计算器");
    jFrame.setSize(500,600);
    jFrame.setResizable(false);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setVisible(true);
    //增加容器
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(20,1));
    //增加上部文本框
    panel.add(getTextField(),BorderLayout.NORTH);
    panel.setPreferredSize(new Dimension(PRE_WIDTH,PRE_HEIGHT));
    panel.setVisible(true);
    //增加左边的操作存储件


    jFrame.add(panel);
    }

    public static void main(String[] args) {
        new CalFrame().initialize();
    }

}
