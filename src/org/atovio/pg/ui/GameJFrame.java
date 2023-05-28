package org.atovio.pg.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * 游戏界面
 * @author Winter Yuan
 * @version 1.0
 */
public class GameJFrame extends JFrame implements KeyListener , ActionListener {

    // 加载图片，打乱要用到
    int[][] data = new int[3][5];

    // 记录空白块在二维数组的位置。移动图片时用到。
    int row;
    int column;
    // 通关数组
    int[][] win = new int[][]{
            {0,1,2,3,4},
            {5,6,7,8,9},
            {10,11,12,13,14}
    };

    // 条目对象
    JMenuItem replayItem = new JMenuItem("Replay");
    JMenuItem closeItem = new JMenuItem("Close Game");
    JMenuItem aboutItem = new JMenuItem("We Star");

    public GameJFrame(){
        // 初始化界面
        initJFrame();

        // 初始化菜单栏
        initJMenu();

        // 获取图片数据
        initData();

        // 展示图片
        intiImage();

        // 展示界面
        setVisible(true);
    }

    /**
     * 添加标题
     */
    private void intiTitle() {
        JLabel jLabel = new JLabel("Puzzle Game");
        jLabel.setBounds(260,10,100,50);
        getContentPane().add(jLabel);
    }

    /**
     * 打乱数据
     */
    private void initData() {
        // 打乱图片
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            // 获取随机索引
            int index = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        // 添加数据
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = arr[index];
                index++;
                // 记录0的坐标
                if (data[i][j] == 0) {
                    row = i;
                    column = j;
                }
            }
        }
    }

    /**
     * 初始化图片
     */
    private void intiImage() {
        // 清空所有图片
        getContentPane().removeAll();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int number = data[i][j];
                // 创建图片对象，创建图片管理容器
                JLabel jLabel = new JLabel(new ImageIcon("images/2girls/"+number+".jpg"));
                // 指定位置
                jLabel.setBounds(105 * j + 33,105 * i + 80,105,105);
                // 图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                // 添加到窗体中
                getContentPane().add(jLabel);
            }
        }
        if (victory())
            new WinJFrame();

        intiTitle();

        // 刷新界面
        getContentPane().repaint();
    }

    /**
     * 初始化菜单栏
     */
    private void initJMenu() {
        // 初始化菜单
        // 菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        // 选项对象
        JMenu functionJMenu = new JMenu("Function");
        JMenu aboutJMenu = new JMenu("About Us");

        // 添加菜单选项
        functionJMenu.add(replayItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(aboutItem);

        // 添加菜单条目
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        // 添加监听
        replayItem.addActionListener(this);
        closeItem.addActionListener(this);
        aboutItem.addActionListener(this);

        // 添加菜单栏
        setJMenuBar(jMenuBar);
    }

    /**
     * 初始化界面
     */
    private void initJFrame() {
        // 设置界面大小
        setSize(603, 580);
        // 设置标题
        setTitle("Yami v1.0");
        // 设置置顶
        //setAlwaysOnTop(true);
        // 设置居中
        setLocationRelativeTo(null);
        // 设置关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消样式
        setLayout(null);

        // 添加监听
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按下不松时调用这个
    @Override
    public void keyPressed(KeyEvent e) {
        if (victory())
            return;
        int code = e.getKeyCode();
        if (code == 65){
            getContentPane().removeAll();
            // 加载完整图片
            JLabel all = new JLabel(new ImageIcon("images/2girls/all.jpg"));
            all.setBounds(33,80,525,315);
            getContentPane().add(all);
            intiTitle();

            getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory())
            return;
        // 设置按键监听效果。左：37,上：38，右：39，下：40
        int code = e.getKeyCode();
        switch (code){
            // 向左
            case 37 ->{
                if (column == 4)
                    return;
                data[row][column] = data[row][column+1];
                data[row][column+1] = 0;
                column++;
                intiImage();
            }
            // 向上
            case 38 ->{
                if (row == 2)
                    return;
                data[row][column] = data[row+1][column];
                data[row+1][column] = 0;
                row++;
                intiImage();
            }
            // 向右
            case 39 ->{
                if (column == 0)
                    return;
                data[row][column] = data[row][column-1];
                data[row][column-1] = 0;
                column--;
                intiImage();
            }
            // 向下
            case 40 ->{
                if (row == 0)
                    return;
                data[row][column] = data[row-1][column];
                data[row-1][column] = 0;
                row--;
                intiImage();
            }
            // A键
            case 65 -> intiImage();
            // W键
            case 87 -> {
                data = new int[][]{
                    {0,1,2,3,4},
                    {5,6,7,8,9},
                    {10,11,12,13,14}
                };
                intiImage();
            }
        }
    }

    public boolean victory(){
        for (int i= 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j])
                    return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取被点击的条目对象
        Object obj = e.getSource();
        if (replayItem.equals(obj)) {
            initData();
            intiImage();
        } else if (closeItem.equals(obj)) {
            System.exit(0);
        } else if (aboutItem.equals(obj)) {
            Desktop desktop = Desktop.getDesktop();
            try {
                URI uri = new URI("https://space.bilibili.com/200569093?spm_id_from=333.1007.0.0");
                desktop.browse(uri);
            } catch (URISyntaxException | IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
