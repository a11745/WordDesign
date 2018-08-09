package com.home.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.home.domain.User;
import com.home.service.WordService;
import com.home.serviceImpl.WordServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddWordController extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWordController frame = new AddWordController(null);
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
	public AddWordController(User user) {
		//设置标题
		super("添加单词");
		this.setIconImage(new ImageIcon("image/2.jpg").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("单词：");
		label.setBounds(29, 29, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(69, 26, 101, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("词性：");
		label_1.setBounds(29, 57, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(69, 57, 101, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("中文：");
		label_2.setBounds(29, 88, 54, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(69, 88, 101, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		JButton button = new JButton("添加");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WordService wordService = new WordServiceImpl();
				Boolean result = wordService.addWord(textField.getText(), textField_1.getText(),user.getId(),textField_2.getText());
				if (result) {
					JOptionPane.showMessageDialog(null, "添加成功！！！"); 
				}else {
					JOptionPane.showMessageDialog(null, "添加失败，请检查后重试！！！"); 
				}
			}
		});
		button.setBounds(65, 136, 93, 23);
		contentPane.add(button);
		
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
