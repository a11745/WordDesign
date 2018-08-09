package com.home.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.home.domain.User;
import com.home.domain.Words;
import com.home.service.WordService;
import com.home.serviceImpl.WordServiceImpl;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudyWordsController extends JFrame {

	private JPanel contentPane;
	private JTextField wordnametext;
	private static Integer current = 0;
	private Words currWord = null;
	private JLabel qualitytext;
	private JLabel chinesetext;
	private JLabel label_4;
	private List<Words> list=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyWordsController frame = new StudyWordsController(null);
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
	public StudyWordsController(User user) {
		//设置标题
		super("背诵单词");
		this.setIconImage(new ImageIcon("image/2.jpg").getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		WordService wordService = new WordServiceImpl();
		list = wordService.achieve(user.getId(),0);
		
		
		
		JButton button = new JButton("上一个");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (current>0) {
					current--;
					currWord = list.get(current);
					qualitytext.setText(currWord.getQuality());
					chinesetext.setText(currWord.getChinese());
					label_4.setText((current+1)+"/"+list.size());
				}else {
					JOptionPane.showMessageDialog(null, "已经到头啦！！！");
				}
			}
		});
		button.setBounds(21, 207, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("下一个");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (current<list.size()-1) {
					current++;
					System.out.println("list.size()::::"+list.size());
					System.out.println("current::::"+current);
					currWord = list.get(current);
					qualitytext.setText(currWord.getQuality());
					chinesetext.setText(currWord.getChinese());
					label_4.setText((current+1)+"/"+list.size());
				}else {
					JOptionPane.showMessageDialog(null, "已经到底啦！！！");
				}
			}
		});
		button_1.setBounds(277, 207, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("掌握");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("current::::::"+current);
				System.out.println("list.size()-1:::::"+(list.size()-1));
				WordService wordService = new WordServiceImpl();
				Boolean result = wordService.okWord(currWord.getId(), user.getId());
				if (result) {
					JOptionPane.showMessageDialog(null, "恭喜你掌握次单词！！！"); 
					list = wordService.achieve(user.getId(),0);
					
					System.out.println("current::::::"+current);
					System.out.println("list.size()-1:::::"+(list.size()-1));
					label_4.setText((current+1)+"/"+list.size());
					if (current<list.size()) {
						//current++;						
						currWord = list.get(current);
						qualitytext.setText(currWord.getQuality());
						chinesetext.setText(currWord.getChinese());
					}else {
						JOptionPane.showMessageDialog(null, "已经到底啦！！！");						
						if (current>0) {
							current--;
							currWord = list.get(current);
							qualitytext.setText(currWord.getQuality());
							chinesetext.setText(currWord.getChinese());
							label_4.setText((current+1)+"/"+list.size());
						}else {
							JOptionPane.showMessageDialog(null, "已经到头啦！！！");
							JOptionPane.showMessageDialog(null, "恭喜你全部掌握！！！");
							label_4.setText("0/0");
						}
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "操作失败，请检查后重试！！！"); 
				}
				
			}
		});
		button_2.setBounds(316, 10, 93, 23);
		contentPane.add(button_2);
		
		JLabel label = new JLabel("英文：");
		label.setBounds(84, 48, 54, 15);
		contentPane.add(label);
		
		wordnametext = new JTextField();
		wordnametext.setBounds(148, 45, 122, 21);
		contentPane.add(wordnametext);
		wordnametext.setColumns(10);
		
		JLabel label_1 = new JLabel("词性：");
		label_1.setBounds(84, 92, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("中文：");
		label_2.setBounds(84, 143, 54, 15);
		contentPane.add(label_2);
		
		qualitytext = new JLabel("n");
		qualitytext.setBounds(146, 92, 54, 15);
		contentPane.add(qualitytext);
		
		chinesetext = new JLabel("中文");
		chinesetext.setBounds(146, 143, 54, 15);
		contentPane.add(chinesetext);
		
		JLabel label_3 = new JLabel("当前单词：");
		label_3.setBounds(95, 240, 66, 15);
		contentPane.add(label_3);
		
		label_4 = new JLabel("0/0");
		label_4.setBounds(173, 240, 54, 15);
		contentPane.add(label_4);
		
		label_4.setText((current+1)+"/"+list.size());
		
		JButton button_3 = new JButton("检验");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (wordnametext.getText().toString().equals(currWord.getWordname())) {
					JOptionPane.showMessageDialog(null, "恭喜你答对了！！！");
				}else {
					JOptionPane.showMessageDialog(null, "很遗憾，答错了！！！");
				}
				
			}
		});
		button_3.setBounds(150, 207, 93, 23);
		contentPane.add(button_3);
		
		if (list!=null&&list.size()>0) {
			currWord = list.get(0);
			qualitytext.setText(currWord.getQuality());
			chinesetext.setText(currWord.getChinese());
			
		}
		
		
		
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
