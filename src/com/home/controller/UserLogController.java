package com.home.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.home.daoImpl.AdminDaoImpl;
import com.home.domain.ReUserlog;
import com.home.domain.Words;
import com.home.service.WordService;
import com.home.serviceImpl.WordServiceImpl;

public class UserLogController extends JFrame {

	private JPanel contentPane;
	// 默认表格模型
	private DefaultTableModel model = null;
	private JTable table = null;
	private JTable table_2;
	private JButton upBtn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogController frame = new UserLogController();
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
	public UserLogController() {
		//设置标题
				super("用户登录日志");
				this.setIconImage(new ImageIcon("image/2.jpg").getImage());
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				//WordService wordService = new WordServiceImpl();
				//List<Words> list = wordService.achieve(user.getId(),1);
				AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
				List<ReUserlog> list = adminDaoImpl.reUserlogList();
		        
		        String[][] datas = {};
		        String[] titles = { "id","ip", "用户名","登陆时间" };
		        model = new DefaultTableModel(datas, titles);
		        table = new JTable(model);
		        /*upBtn = new JButton("修改数据");
		        upBtn.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		Integer id = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
		        		String wordname = table.getValueAt(table.getSelectedRow(),1).toString();
		        		String quality = table.getValueAt(table.getSelectedRow(),2).toString();
		        		String chinese = table.getValueAt(table.getSelectedRow(),3).toString();
		        		//EditWordController editWordController = new EditWordController(user,id,wordname,quality,chinese);
		        		//editWordController.setVisible(true);
		        	}
		        });
		        upBtn.setBounds(0, 0, 146, 23);*/
		        
		        for (ReUserlog reUserlog : list) {
		        	System.out.println(reUserlog.getAddtime().toString());
		        	//SimpleDateFormat dataformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	//String datestr= dataformat.format(reUserlog.getAddtime());
		        	//System.out.println(words.getWordname()+":::"+words.getQuality()+":::"+words.getChinese());
		        	model.addRow(new String[] { reUserlog.getId().toString(),reUserlog.getIp(),reUserlog.getUsername(),reUserlog.getAddtime().toString()  });
		        	//model.addRow(new String[] { reUserlog.getId().toString(),reUserlog.getIp(),reUserlog.getUsername(),datestr  });
				}
		        getContentPane().setLayout(null);
		        
		        //getContentPane().add(upBtn);
		        JScrollPane scrollPane = new JScrollPane(table);
		        scrollPane.setBounds(0, 24, 392, 237);
		        getContentPane().add(scrollPane);
		        
		        /*JButton button = new JButton("删除数据");
		        button.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		WordService wordService = new WordServiceImpl();
		        		Boolean result = wordService.delWord(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()), user.getId());
		        		if (result) {
							JOptionPane.showMessageDialog(null, "删除成功！！！"); 
							 //删除这一行
						    model.removeRow(table.getSelectedRow()) ;
						    //刷新
						    model.fireTableDataChanged();
						}else {
							JOptionPane.showMessageDialog(null, "删除失败，请检查后重试！！！"); 
						}
		        	}
		        });
		        button.setBounds(246, 0, 146, 23);
		        getContentPane().add(button);*/

		        setSize(408, 303);
		        setLocationRelativeTo(null);
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		        setVisible(true);
			
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
