package com.dilmen.view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import com.dilmen.controller.PersonController;
import com.dilmen.entity.EGender;
import com.dilmen.entity.Person;

import java.awt.Font;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;

public class PersonGui {

	private JFrame frame;
	private JTextField tFId;
	private JTextField tFEmail;
	private JTextField tFFirstName;
	private JTextField tFLastName;
	private JTextField tFTelCI1;
	private JTextField tFTelCI2;
	private JTextField tFAddressCI1;
	private JTextField tFAddressCI2;
	private JTextField tFPhotoUrl;
	private JComboBox<String> comboBoxLanguage;
	private JComboBox<String> comboBoxGender;
	private JLabel lblId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JButton btnGetAll;
	private JButton btnEmailQuery;
	private JButton btnFirstNameQuery;
	private JButton btnLastNameQuery;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblPhotoTag;
	private JLabel lblGender;
	private JLabel lblPhone;
	private JLabel lblAddress;
	private JLabel lblContactInfo1;
	private JLabel lblContactInfo2;
	private JLabel lblLanguage;
	private JLabel lblEmail;
	private JTable table;
	private JScrollPane scrollPane;
	private String firstName;
	private String lastName;
	private String[] columns;
	private String url;
	private PersonController personController;
	private JLabel lblIcon;
	private JLabel lblBG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonGui window = new PersonGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonGui() {
		personController = new PersonController();
		initialize();

		String lang = comboBoxLanguage.getSelectedItem().toString();
		i18n(lang);

	}

	private void i18n(String lang) {
		if (lang.trim().equalsIgnoreCase("turkish")) {
			Locale.setDefault(new Locale("tr", "TR"));
		} else if (lang.equalsIgnoreCase("français")) {
			Locale.setDefault(new Locale("fr", "FR"));
		} else
			Locale.setDefault(new Locale("en", "EN"));
		ResourceBundle resourceBundle = ResourceBundle.getBundle("com/dilmen/config/resource_bundle");
		frame.setTitle(resourceBundle.getString("wTitle"));
		lblId.setText(resourceBundle.getString("wID"));
		lblFirstName.setText(resourceBundle.getString("wFirstName"));
		lblLastName.setText(resourceBundle.getString("wLastName"));
		lblGender.setText(resourceBundle.getString("wGender"));
		btnEmailQuery.setText(resourceBundle.getString("wSearch"));
		btnFirstNameQuery.setText(resourceBundle.getString("wSearch"));
		btnLastNameQuery.setText(resourceBundle.getString("wSearch"));
		lblPhone.setText(resourceBundle.getString("wPhone"));
		lblAddress.setText(resourceBundle.getString("wAddress"));
		lblContactInfo1.setText(resourceBundle.getString("wContactInfo1"));
		lblContactInfo2.setText(resourceBundle.getString("wContactInfo2"));
		btnGetAll.setText(resourceBundle.getString("wGetAll"));
		btnSave.setText(resourceBundle.getString("wSave"));
		btnUpdate.setText(resourceBundle.getString("wUpdate"));
		btnDelete.setText(resourceBundle.getString("wDelete"));
		comboBoxGender.removeAllItems();
		comboBoxGender.addItem((String) resourceBundle.getObject("wMale"));
		comboBoxGender.addItem((String) resourceBundle.getObject("wFemale"));

		firstName = resourceBundle.getString("wFirstName").toString();
		lastName = resourceBundle.getString("wLastName");
		columns = new String[4];
		columns[0] = "ID";
		columns[1] = "Email";
		columns[2] = firstName;
		columns[3] = lastName;

		table.setModel(new DefaultTableModel(new Object[][] {}, columns));

		url = "nophoto";
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBackground(new Color(255, 255, 204));
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\abdul\\Desktop\\project1_images\\megumi.jpg"));
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);
				
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Dialog", Font.BOLD, 8));
		lblId.setBounds(62, 35, 70, 13);
		frame.getContentPane().add(lblId);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 8));
		lblEmail.setBounds(62, 68, 70, 13);
		frame.getContentPane().add(lblEmail);

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 8));
		lblFirstName.setBounds(62, 94, 70, 13);
		frame.getContentPane().add(lblFirstName);

		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 8));
		lblLastName.setBounds(62, 124, 70, 13);
		frame.getContentPane().add(lblLastName);

		lblGender = new JLabel("Cinsiyet:");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 8));
		lblGender.setBounds(62, 150, 70, 13);
		frame.getContentPane().add(lblGender);

		lblPhone = new JLabel("Tel:");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 8));
		lblPhone.setBounds(351, 68, 45, 13);
		frame.getContentPane().add(lblPhone);

		lblAddress = new JLabel("Adres:");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 8));
		lblAddress.setBounds(351, 104, 45, 13);
		frame.getContentPane().add(lblAddress);

		lblContactInfo1 = new JLabel("Contact Info 1");
		lblContactInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactInfo1.setFont(new Font("Dialog", Font.BOLD, 8));
		lblContactInfo1.setBounds(401, 35, 96, 13);
		frame.getContentPane().add(lblContactInfo1);

		lblContactInfo2 = new JLabel("Contact Info 2");
		lblContactInfo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactInfo2.setFont(new Font("Dialog", Font.BOLD, 8));
		lblContactInfo2.setBounds(527, 35, 96, 13);
		frame.getContentPane().add(lblContactInfo2);

		lblIcon = new JLabel("New label");
		setPicture(url);
		lblIcon.setFont(new Font("Dialog", Font.BOLD, 8));
		lblIcon.setBounds(664, 35, 90, 90);
		frame.getContentPane().add(lblIcon);



		tFId = new JTextField();
		tFId.setEditable(false);
		tFId.setBounds(131, 32, 96, 19);
		frame.getContentPane().add(tFId);
		tFId.setColumns(10);

		tFEmail = new JTextField();
		tFEmail.setColumns(10);
		tFEmail.setBounds(131, 65, 96, 19);
		frame.getContentPane().add(tFEmail);

		tFFirstName = new JTextField();
		tFFirstName.setColumns(10);
		tFFirstName.setBounds(131, 91, 96, 19);
		frame.getContentPane().add(tFFirstName);

		tFLastName = new JTextField();
		tFLastName.setColumns(10);
		tFLastName.setBounds(131, 121, 96, 19);
		frame.getContentPane().add(tFLastName);

		tFTelCI1 = new JTextField();
		tFTelCI1.setColumns(10);
		tFTelCI1.setBounds(401, 65, 96, 19);
		frame.getContentPane().add(tFTelCI1);

		tFTelCI2 = new JTextField();
		tFTelCI2.setColumns(10);
		tFTelCI2.setBounds(527, 65, 96, 19);
		frame.getContentPane().add(tFTelCI2);

		tFAddressCI1 = new JTextField();
		tFAddressCI1.setColumns(10);
		tFAddressCI1.setBounds(401, 101, 96, 19);
		frame.getContentPane().add(tFAddressCI1);

		tFAddressCI2 = new JTextField();
		tFAddressCI2.setColumns(10);
		tFAddressCI2.setBounds(527, 101, 96, 19);
		frame.getContentPane().add(tFAddressCI2);

		comboBoxGender = new JComboBox<String>();
		comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBoxGender.setBounds(131, 146, 85, 21);
		frame.getContentPane().add(comboBoxGender);

		comboBoxLanguage = new JComboBox<String>();
		comboBoxLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i18n(comboBoxLanguage.getSelectedItem().toString());
			}
		});
		comboBoxLanguage.setModel(new DefaultComboBoxModel<String>(new String[] { "English", "Français", "Turkish" }));
		comboBoxLanguage.setBounds(664, 337, 88, 21);
		frame.getContentPane().add(comboBoxLanguage);

		lblLanguage = new JLabel("Language:");
		lblLanguage.setFont(new Font("Dialog", Font.BOLD, 8));
		lblLanguage.setBounds(664, 314, 88, 13);
		frame.getContentPane().add(lblLanguage);

		btnGetAll = new JButton("Get All");
		btnGetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTable();

			}
		});
		btnGetAll.setFont(new Font("Dialog", Font.BOLD, 8));
		btnGetAll.setBounds(237, 180, 85, 21);
		frame.getContentPane().add(btnGetAll);

		btnEmailQuery = new JButton("Sorgula");
		btnEmailQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person person =personController.finbByEmail(tFEmail.getText().toString().toLowerCase());
				getTable(person);
			}
		});
		btnEmailQuery.setFont(new Font("Dialog", Font.BOLD, 8));
		btnEmailQuery.setBounds(237, 64, 104, 21);
		frame.getContentPane().add(btnEmailQuery);

		btnFirstNameQuery = new JButton("Sorgula");
		btnFirstNameQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Person> people = personController.finbByName(tFFirstName.getText().toString().toLowerCase());
				fillTextFields(getTable(people));
			}
		});
		btnFirstNameQuery.setFont(new Font("Dialog", Font.BOLD, 8));
		btnFirstNameQuery.setBounds(237, 90, 104, 21);
		frame.getContentPane().add(btnFirstNameQuery);

		btnLastNameQuery = new JButton("Sorgula");
		btnLastNameQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Person> people = personController.findByLastName(tFLastName.getText().toString().toLowerCase());
				fillTextFields(getTable(people));
			}
		});
		btnLastNameQuery.setFont(new Font("Dialog", Font.BOLD, 8));
		btnLastNameQuery.setBounds(237, 120, 104, 21);
		frame.getContentPane().add(btnLastNameQuery);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personController.create(fieldsToPerson());
				getTable();
			}
		});
		btnSave.setFont(new Font("Dialog", Font.BOLD, 8));
		btnSave.setBounds(341, 180, 85, 21);
		frame.getContentPane().add(btnSave);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personController.update(fieldsToPerson(), Integer.parseInt(tFId.getText()));
				getTable();
			}
		});
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 8));
		btnUpdate.setBounds(445, 180, 85, 21);
		frame.getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personController.delete(Integer.parseInt(tFId.getText()));
				getTable();
			}
		});
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 8));
		btnDelete.setBounds(540, 180, 85, 21);
		frame.getContentPane().add(btnDelete);

		tFPhotoUrl = new JTextField();
		tFPhotoUrl.setBounds(664, 181, 96, 19);
		frame.getContentPane().add(tFPhotoUrl);
		tFPhotoUrl.setColumns(10);

		lblPhotoTag = new JLabel("Photo TAG: ");
		lblPhotoTag.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhotoTag.setFont(new Font("Dialog", Font.BOLD, 8));
		lblPhotoTag.setBounds(664, 161, 96, 13);
		frame.getContentPane().add(lblPhotoTag);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 228, 572, 163);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				table.getSelectedRow();
				Person person = personController.finbByID(Integer.parseInt(table.getValueAt(i, 0).toString()));
				fillTextFields(person);
			}
		});
		scrollPane.setViewportView(table);
	}

	public void getTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] column = new Object[4];
		model.setRowCount(0);
		List<Person> people = personController.getAll();

		for (int i = 0; i < people.size(); i++) {
			column[0] = people.get(i).getId();
			column[1] = people.get(i).getEmail();
			column[2] = people.get(i).getName();
			column[3] = people.get(i).getSurname();
			model.addRow(column);
		}
	}
	public Person getTable(List<Person> people) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] column = new Object[4];
		model.setRowCount(0);
		for (int i = 0; i < people.size(); i++) {
			column[0] = people.get(i).getId();
			column[1] = people.get(i).getEmail();
			column[2] = people.get(i).getName();
			column[3] = people.get(i).getSurname();
			model.addRow(column);
		}
		return people.get(0);
	}

	public void getTable(Person person) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] column = new Object[4];
		model.setRowCount(0);
		column[0] = person.getId();
		column[1] = person.getEmail();
		column[2] = person.getName();
		column[3] = person.getSurname();
		model.addRow(column);

	}

	public void fillTextFields(Person person) {
		tFId.setText(String.valueOf(person.getId()));
		tFEmail.setText(person.getEmail());
		tFFirstName.setText(person.getName());
		tFLastName.setText(person.getSurname());
		comboBoxGender.setSelectedIndex(person.getGender() == EGender.MAN ? 0 : 1);
		tFTelCI1.setText(person.getPhone1());
		tFTelCI2.setText(person.getPhone2());
		tFAddressCI1.setText(person.getAddress1());
		tFAddressCI2.setText(person.getAddress2());
		tFPhotoUrl.setText(person.getUrl());
		url = tFPhotoUrl.getText().toString().trim();
		setPicture(url);
	}

	public Person fieldsToPerson() {
		Person person = new Person();
		person.setEmail(tFEmail.getText().toString());
		person.setName(tFFirstName.getText().toString());
		person.setSurname(tFLastName.getText().toString());
		person.setGender(comboBoxGender.getSelectedIndex() == 0 ? EGender.MAN : EGender.WOMAN);
		person.setPhone1(tFTelCI1.getText().toString());
		person.setPhone2(tFTelCI2.getText().toString());
		person.setAddress1(tFAddressCI1.getText().toString());
		person.setAddress2(tFAddressCI2.getText().toString());
		person.setUrl(tFPhotoUrl.getText().toString());
		return person;
	}

	public void setPicture(String tag) {
		String path = "C:\\Users\\abdul\\Desktop\\project1_images\\" + url + ".jpg";
		File f = new File(path);
		if (f.exists() && !f.isDirectory()) {
			lblIcon.setIcon(new ImageIcon("C:\\Users\\abdul\\Desktop\\project1_images\\" + url + ".jpg"));
		} else {
			lblIcon.setIcon(new ImageIcon("C:\\Users\\abdul\\Desktop\\project1_images\\nophoto.jpg"));
		}

	}
}
