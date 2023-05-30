package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    JPanel container = new JPanel();
    JLabel userLabel = new JLabel("ЛОГИН");
    JLabel passwordLabel = new JLabel("ПАРОЛЬ");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("ВОЙТИ");
    JButton resetButton = new JButton("СКИНУТЬ");
    JCheckBox showPassword = new JCheckBox("Показать пароль");
    JLabel icon = new JLabel(new ImageIcon(new ImageIcon("cat.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setSize(new Dimension(400,500));
        setContentPane(container);
    }

    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(new Color(255,226,226));

    }

    public void setLocationAndSize() {
        userLabel.setBounds(75, 150, 100, 30);
        passwordLabel.setBounds(75, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        showPassword.setBackground(new Color(255,226,226));
        loginButton.setBounds(75, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        icon.setBounds(150, 20, 100, 100);
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(icon);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            try (Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
                PreparedStatement preparedStatement = null;
                //Coding Part of LOGIN button
                if (e.getSource() == loginButton) {
                    String userText;
                    String pwdText;
                    userText = userTextField.getText();
                    pwdText = passwordField.getText();
                    String sql = "SELECT * FROM people WHERE firstname = ?";
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, userText);
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        if (userText.equals(rs.getString("firstname")) && pwdText.equals(rs.getString("pass"))) {
                            JOptionPane.showMessageDialog(this, "Login Successful");
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                        }
                    }
                }
            }
                //Coding Part of RESET button
                if (e.getSource() == resetButton) {
                    userTextField.setText("");
                    passwordField.setText("");
                }
                //Coding Part of showPassword JCheckBox
                if (e.getSource() == showPassword) {
                    if (showPassword.isSelected()) {
                        passwordField.setEchoChar((char) 0);
                    } else {
                        passwordField.setEchoChar('*');
                    }
                }
        } catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

}

class Login {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    public static void main(String[] a) {
        try {
            LoginFrame frame = new LoginFrame();
            frame.setTitle("Login Form");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        } catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

}