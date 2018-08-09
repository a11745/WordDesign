package com.home.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.home.domain.User;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WordMainController extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordMainController frame = new WordMainController(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WordMainController(User user) {
		//设置标题
		super("单词系统");
		this.setIconImage(new ImageIcon("image/2.jpg").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("添加单词");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddWordController addWord = new AddWordController(user);
				addWord.setVisible(true);
			}
		});
		button.setBounds(24, 27, 144, 89);
		contentPane.add(button);
		
		JButton button_1 = new JButton("背诵单词");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudyWordsController studyWordsController = new StudyWordsController(user);
				studyWordsController.setVisible(true);
			}
		});
		button_1.setBounds(223, 27, 150, 89);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("学会单词");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AchieveController achieveController = new AchieveController(user);
				achieveController.setVisible(true);
			}
		});
		button_2.setBounds(24, 146, 144, 89);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("待学单词");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WaitStudyController waitStudyController = new WaitStudyController(user);
				waitStudyController.setVisible(true);
			}
		});
		button_3.setBounds(223, 146, 150, 89);
		contentPane.add(button_3);
		//背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
		String path = "image/2.jpg";
		// 背景图片
		ImageIcon background = new ImageIcon(path);
		// 把背景图片显示在一个标签里面
		JLabel label2 = new JLabel(background);
		// 把标签的大小位置设置为图片刚好填充整个面板
		label2.setBounds(0, 0, this.getWidth(), this.getHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
		//设置可见
		setVisible(true);
	}

}
