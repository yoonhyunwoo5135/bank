package money;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankManger {
	private JTable table;
	static JTextField t1;
	static JTextField t2;
	static JTextField t3;
	static JTextField tId;
	static JTextField tName;
	static JTextField tAge;
	static JTextField tTel;
	static JTextField t4;
	static String id;
	
	private int tableRow;
	static DefaultTableModel tmodel;
	static BankDAO dao;
	BankDTO dto;
	ArrayList list =  new ArrayList();
	ArrayList id1 = new ArrayList();
	
	public BankManger(){
		BankDAO dao = new BankDAO();
		
		dto = dao.count();
		list = dao.selectAll();
		
		JFrame f = new JFrame();
		f.setSize(800, 600);
		f.getContentPane().setLayout(null);
		
		String[] header = { "No", "아이디", "이름", "나이", "전화번호"};
		Object[][] contents = new Object[dto.getCount()][5];
		tableRow = 0;
		for (int i = 0; i < contents.length; i++) {
			BankDTO dto = (BankDTO)list.get(i);
			contents[i][0] = ++tableRow;
			contents[i][1] = dto.getId();
			contents[i][2] = dto.getName();
			contents[i][3] = dto.getAge();
			contents[i][4] = dto.getTel();
		}
		tmodel = new DefaultTableModel(header, 0);
		for (int j = 0; j < contents.length; j++) {
			tmodel.addRow(contents[j]);
		}
		
		table = new JTable(tmodel);
		DefaultTableCellRenderer dcr = new DefaultTableCellRenderer();
		dcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dcr); // table에서 컬럼을 불러온 뒤 셀의 속성을 설정
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 92, 513, 279);
		f.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		String[] search = { "전체", "아이디"};
		
		JComboBox comboBox = new JComboBox(search);
		comboBox.setBounds(30, 55, 64, 27);
		f.getContentPane().add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(555, 92, 217, 150);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton buttonDelete = new JButton("삭제");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankDAO dao = new BankDAO();
				dao.delete();
				JOptionPane.showMessageDialog(null, "삭제되었습니다");
			}
		});
		buttonDelete.setBounds(139, 68, 74, 23);
		panel.add(buttonDelete);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(37, 68, 90, 23);
		panel.add(t1);
		
		JLabel label = new JLabel("ID:");
		label.setBounds(12, 72, 38, 15);
		panel.add(label);
		
		JLabel label2 = new JLabel("회원 삭제");
		label2.setFont(new Font("굴림", Font.BOLD, 16));
		label2.setBounds(12, 10, 90, 36);
		panel.add(label2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(555, 252, 217, 224);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		t2 = new JTextField();
		t2.setBounds(41, 65, 87, 21);
		t2.setColumns(10);
		panel_1.add(t2);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setBounds(12, 68, 38, 15);
		panel_1.add(label_1);
		
		t3 = new JTextField();
		t3.setBounds(41, 96, 87, 21);
		panel_1.add(t3);
		t3.setColumns(10);
		
		JButton buttonUpdate = new JButton("수정");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankDAO dao = new BankDAO();
				dao.update();
				JOptionPane.showMessageDialog(null, "수정되었습니다");
			}
		});
		buttonUpdate.setBounds(143, 95, 74, 23);
		panel_1.add(buttonUpdate);
		
		JLabel label3 = new JLabel("회원 수정");
		label3.setBounds(12, 26, 57, 15);
		panel_1.add(label3);
		
		JLabel label4 = new JLabel("tel");
		label4.setBounds(12, 99, 57, 15);
		panel_1.add(label4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 381, 513, 95);
		f.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		tId = new JTextField();
		tId.setBounds(52, 10, 116, 21);
		panel_2.add(tId);
		tId.setColumns(10);
		
		tName = new JTextField();
		tName.setColumns(10);
		tName.setBounds(223, 10, 116, 21);
		panel_2.add(tName);
		
		tAge = new JTextField();
		tAge.setColumns(10);
		tAge.setBounds(52, 61, 116, 21);
		panel_2.add(tAge);
		
		tTel = new JTextField();
		tTel.setColumns(10);
		tTel.setBounds(223, 61, 116, 21);
		panel_2.add(tTel);
		
		JLabel la1 = new JLabel("ID");
		la1.setBounds(12, 13, 57, 15);
		panel_2.add(la1);
		
		JLabel la3 = new JLabel("Age");
		la3.setBounds(12, 64, 57, 15);
		panel_2.add(la3);
		
		JLabel la2 = new JLabel("Name");
		la2.setBounds(180, 13, 57, 15);
		panel_2.add(la2);
		
		JLabel la4 = new JLabel("Tel");
		la4.setBounds(180, 64, 57, 15);
		panel_2.add(la4);
		
		JButton buttonInsert = new JButton("가입");
		buttonInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankDAO dao = new BankDAO();
				dao.insert();
				JOptionPane.showMessageDialog(null, "가입되었습니다");
			}
		});
		buttonInsert.setFont(new Font("굴림", Font.BOLD, 20));
		buttonInsert.setBounds(385, 10, 103, 73);
		panel_2.add(buttonInsert);
		
		JLabel lblNewLabel = new JLabel("은행 고객 관리 프로그램");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(422, 22, 362, 60);
		f.getContentPane().add(lblNewLabel);
		
		t4 = new JTextField();
		t4.setBounds(106, 55, 176, 27);
		f.getContentPane().add(t4);
		t4.setColumns(10);
		
		JButton buttonSearch = new JButton("검색");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = comboBox.getSelectedItem().toString();
				if (selected == "전체") {
					for (int i = tableRow - 1; i >= 0; i--) {
						tmodel.removeRow(--tableRow);
					}
					for (int i = 0; i < dto.getCount(); i++) {
						BankDTO dto = (BankDTO) list.get(i);
						contents[i][0] = ++tableRow;
						contents[i][1] = dto.getId();
						contents[i][2] = dto.getName();
						contents[i][3] = dto.getAge();
						contents[i][4] = dto.getTel();
					}
					tmodel = (DefaultTableModel) table.getModel();
					for (int j = 0; j < dto.getCount(); j++) {
						tmodel.addRow(contents[j]);
					}
				}
				else if (selected == "아이디") {
					id = t4.getText();
					for (int i = tableRow - 1; i >= 0; i--) {
						tmodel.removeRow(--tableRow);
					}
					tableRow = 0;
					BankDTO dto = dao.idcount();
					id1 = dao.select(t4.getText());
					for (int i = 0; i < dto.getIdcount(); i++) {
						BankDTO dto2 = (BankDTO) id1.get(i);
						contents[i][0] = ++tableRow;
						contents[i][1] = dto2.getId();
						contents[i][2] = dto2.getName();
						contents[i][3] = dto2.getAge();
						contents[i][4] = dto2.getTel();
					}
					tmodel = (DefaultTableModel) table.getModel();
					for (int j = 0; j < dto.getIdcount(); j++) {
						tmodel.addRow(contents[j]);
					}
				}
				
			}
		});
		buttonSearch.setBounds(294, 57, 81, 23);
		f.getContentPane().add(buttonSearch);
		
		
		
		
		
		
		
		
		
		
		
		
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		BankManger bank = new BankManger();
		
	}
}
