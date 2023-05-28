package org.atovio.pg.ui;

import javax.swing.*;

/**
 * @author Winter Yuan
 * @version 1.0
 */
public class WinJFrame extends JFrame {

    public WinJFrame(){
        initJFrame();
        initJButton();
        initText();
    }

    private void initText() {
        JLabel jLabel = new JLabel("游戏胜利！");
        jLabel.setBounds(115,60,80,30);

        getContentPane().add(jLabel);
    }

    private void initJButton() {
        JButton OKButton = new JButton("OK");
        OKButton.setBounds(115, 110, 56, 30);
        OKButton.addActionListener(e -> setVisible(false));
        getContentPane().add(OKButton);
    }

    private void initJFrame() {
        setSize(300, 250);
        // 设置标题
        setTitle("Win");
        // 设置居中
        setLocationRelativeTo(null);
        // 设置关闭模式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // 取消样式
        setLayout(null);

        setVisible(true);
    }
}
