package org.atovio.pg.test;

import javax.swing.*;

/**
 * @author Winter Yuan
 * @version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(488,500);
        // 设置标题
        jFrame.setTitle("Register For Yami");
        // 设置居中
        jFrame.setLocationRelativeTo(null);
        // 设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消样式
        jFrame.setLayout(null);

        // 创建一个按钮
        JButton jButton = new JButton("Press Me!");
        jButton.setBounds(0, 0, 100, 50);
        // 添加监听,参数为实现了ActionListener的对象
        jButton.addActionListener(e -> System.out.println("The button has pressed."));

        // 添加按钮到窗体中
        jFrame.getContentPane().add(jButton);

        jFrame.setVisible(true);
    }
}
