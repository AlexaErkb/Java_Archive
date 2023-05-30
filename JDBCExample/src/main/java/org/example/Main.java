package org.example;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

class LoginFrame extends JFrame implements ActionListener {
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
    public static long time;
    JLabel icon = new JLabel(new ImageIcon(new ImageIcon("cat.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
    LoginFrame(long time) {
        this.time = time;
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
                if (e.getSource() == loginButton) {
                    String userText;
                    String pwdText;
                    userText = userTextField.getText();
                    pwdText = passwordField.getText();
                    String sql = "SELECT * FROM people WHERE firstname = ?";
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, userText);
                    ResultSet rs = preparedStatement.executeQuery();
                    if (userText.equals("") | pwdText.equals("")) {
                        JOptionPane.showMessageDialog(this, "Пустое поле логина или пароля");
                    }
                    if (!rs.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(this, "Такой пользователь не зарегистрирован в сети");
                    }
                    while (rs.next()) {;
                        if (userText.equals(rs.getString("firstname")) && pwdText.equals(rs.getString("pass"))) {
                            userTextField.setText("");
                            passwordField.setText("");
                            setVisible(false);
                            if (rs.getInt("permission_level") == 1) {
                                ActFrameAdmin frame = new ActFrameAdmin(this, time);
                                frame.setTitle("Act Frame");
                                frame.setVisible(true);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setResizable(false);
                            } else if (rs.getInt("permission_level") == 2) {
                                ActFrameEditor frame = new ActFrameEditor(this, time);
                                frame.setTitle("Act Frame");
                                frame.setVisible(true);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setResizable(false);
                            } else {
                                ActFrameUser frame = new ActFrameUser(this, time);
                                frame.setTitle("Act Frame");
                                frame.setVisible(true);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setResizable(false);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                        }
                    }
                }
            }
            if (e.getSource() == resetButton) {
                userTextField.setText("");
                passwordField.setText("");
            }
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

class ActFrameAdmin extends JFrame implements ActionListener {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    Thread th;
    JFrame jFrame;
    JPanel container = new JPanel();
    JButton act1 = new JButton("Добавить сотрудников");
    JButton act2 = new JButton("Удалить сотрудника");
    JButton act3 = new JButton("Поиск сотрудника по id");
    JButton act4 = new JButton("Поиск сотрудника по имени");
    JButton act5 = new JButton("Поиск сотрудника по дате рождения");
    JButton act6 = new JButton("Изменить информацию о пользователе");
    JButton act7 = new JButton("Рассчитать общую сумму зарплат");
    JButton act8 = new JButton("Удалить пользователя");
    JButton act9 = new JButton("Добавить пользователя");
    JButton act10 = new JButton("Вывести всех пользователей");
    JButton act11 = new JButton("Вывести всех сотрудников");
    JButton act12 = new JButton("Установить время");
    JButton act13 = new JButton("Выйти");
    public long time;
    ActFrameAdmin (JFrame jFrame, long time) {
        this.time = time;
        this.jFrame = jFrame;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setSize(new Dimension(800,700));
        setContentPane(container);
        timer();
    }

    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(new Color(255,226,226));

    }

    public void setLocationAndSize() {
        act1.setBounds(200, 20, 400, 30);
        act2.setBounds(200, 70, 400, 30);
        act3.setBounds(200, 120, 400, 30);
        act4.setBounds(200, 170, 400, 30);
        act5.setBounds(200, 220, 400, 30);
        act6.setBounds(200, 270, 400, 30);
        act7.setBounds(200, 320, 400, 30);
        act8.setBounds(200, 370, 400, 30);
        act9.setBounds(200, 420, 400, 30);
        act10.setBounds(200, 470, 400, 30);
        act11.setBounds(200, 520, 400, 30);
        act12.setBounds(200, 570, 400, 30);
        act13.setBounds(200, 620, 400, 30);
    }

    public void addComponentsToContainer() {
        container.add(act1);
        container.add(act2);
        container.add(act3);
        container.add(act4);
        container.add(act5);
        container.add(act6);
        container.add(act7);
        container.add(act8);
        container.add(act9);
        container.add(act10);
        container.add(act11);
        container.add(act12);
        container.add(act13);
    }

    public void addActionEvent() {
        act1.addActionListener(this);
        act2.addActionListener(this);
        act3.addActionListener(this);
        act4.addActionListener(this);
        act5.addActionListener(this);
        act6.addActionListener(this);
        act7.addActionListener(this);
        act8.addActionListener(this);
        act9.addActionListener(this);
        act10.addActionListener(this);
        act11.addActionListener(this);
        act12.addActionListener(this);
        act13.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            try (Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
                PreparedStatement preparedStatement = null;
                if (e.getSource() == act11) {
                    Data frame = new Data(11, jFrame, 1, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act10) {
                    Data frame = new Data(10, jFrame, 1, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act7) {
                    String sql = "SELECT * FROM people";
                    preparedStatement = conn.prepareStatement(sql);
                    int sum = 0;
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        sum = sum + rs.getInt("salary");
                    }
                    JOptionPane.showMessageDialog(jFrame, "Общая сумма зарплат: " + sum);
                    th.interrupt();
                    timer();
                } else if (e.getSource() == act1) {
                    AddFrame frame = new AddFrame(0, jFrame, 1, time);
                    frame.setTitle("Add Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act9) {
                    AddFrame frame = new AddFrame(1, jFrame, 1, time);
                    frame.setTitle("Add Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act2 | e.getSource() == act8) {
                    th.interrupt();
                    timer();
                    String getMessage = JOptionPane.showInputDialog(this, "Введите id");
                    String sql;
                    if (e.getSource() == act2) {
                        sql = "DELETE FROM people WHERE id = ?";
                    } else {
                        sql = "DELETE FROM people WHERE id = ? and pass IS NOT NULL";
                    }
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1, Integer.parseInt(getMessage));
                    preparedStatement.executeUpdate();
                    sql = "ALTER TABLE people AUTO_INCREMENT = 1";
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                } else if (e.getSource() == act3) {
                    FindFrame frame = new FindFrame(1, jFrame, 1, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act4) {
                    FindFrame frame = new FindFrame(2, jFrame, 1, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act5) {
                    FindFrame frame = new FindFrame(3, jFrame, 1, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act13) {
                    th.interrupt();
                    dispose();
                    jFrame.setVisible(true);
                } else if (e.getSource() == act6) {
                    th.interrupt();
                    timer();
                    String getMessage = JOptionPane.showInputDialog(this, "Введите id");
                    String sql = "";
                    th.interrupt();
                    timer();
                    Object[] possibilities = {"firstname", "surname", "address", "birthday", "place_of_birth",
                    "salary", "family", "permission_level", "pass"};
                    Icon icon = null;
                    String s = (String)JOptionPane.showInputDialog(
                            this,
                            "Выберите что хотите изменить у пользователя",
                            "Изменение данных",
                            JOptionPane.PLAIN_MESSAGE,
                            icon,
                            possibilities,
                            "firstname");
                    th.interrupt();
                    timer();
                    String getMessage2 = JOptionPane.showInputDialog(this, "Введите новое значение");
                    th.interrupt();
                    timer();
                    if ((s != null) && (s.length() > 0)) {
                        sql = "UPDATE people SET " + s + " = ? WHERE id = ?";
                        preparedStatement = conn.prepareStatement(sql);
                        if (s == "birthday") {
                            preparedStatement.setDate(1, java.sql.Date.valueOf(getMessage2));
                        } else if (s == "family") {
                            preparedStatement.setBoolean(1, Boolean.parseBoolean(getMessage2));
                        } else if (s == "salary") {
                            preparedStatement.setInt(1, Integer.parseInt(getMessage2));
                        } else {
                            preparedStatement.setString(1, getMessage2);
                        }
                        preparedStatement.setInt(2, Integer.parseInt(getMessage));
                        preparedStatement.executeUpdate();
                    }
                } else if (e.getSource() == act12) {
                    th.interrupt();
                    String getMessage2 = JOptionPane.showInputDialog(this, "Введите новое значение");
                    time = Long.parseLong(getMessage2)*1000;
                    LoginFrame.time = Long.parseLong(getMessage2)*1000;
                    timer();
                }
            }
        } catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public void timer() {
        final Boolean[] flag = {true};
        th = new Thread(new Thread() {
            public void run() {
                while(flag[0]) {
                    try {
                        Thread.sleep(time);
                        dispose();
                        th.interrupt();
                        jFrame.setVisible(true);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        flag[0] = false;
                    }
                }
            }
        });
        th.start();
    }
}
class Data extends JFrame implements ActionListener {
    private final int code;
    int level;
    JFrame jFrame;
    Thread th;
    JButton act = new JButton("Выйти");
    JPanel container = new JPanel();
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    JTable jtable = new JTable();
    public long time;
    Data(int code, JFrame jFrame, int level, long time) {
        this.code = code;
        this.jFrame = jFrame;
        this.level = level;
        this.time = time;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setSize(new Dimension(800,700));
        table();
        setContentPane(container);
        timer();
    }

    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(new Color(255,226,226));
    }
    public void table() {
        try {
            try (Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
                ArrayList<String> al= new ArrayList<>();
                al.add("Не женат/Не замужем");
                al.add("Женат/Замужем");
                PreparedStatement preparedStatement = null;
                String sql = "";
                switch (code) {
                    case 11 -> {
                        sql = "SELECT * FROM people";
                    }
                    case 10 -> {
                        sql = "SELECT * FROM people WHERE pass IS NOT NULL";
                    }
                }
                String[] columnNames = {"id", "firstname", "surname", "address", "birthday",
                        "place_of_birth", "salary", "family", "permission_level", "pass"};
                preparedStatement = conn.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                while (rs.next()) {
                    String[] data;
                    data = new String[]{String.valueOf(rs.getInt("id")),
                                rs.getString("firstname"),
                                rs.getString("surname"),
                                rs.getString("address"),
                                String.valueOf(rs.getDate("birthday")),
                                rs.getString("place_of_birth"),
                                String.valueOf(rs.getInt("salary")),
                                al.get(rs.getBoolean("family") ? 1 : 0),
                                String.valueOf(rs.getInt("permission_level")),
                                rs.getString("pass")};
                    tableModel.addRow(data);
                }
                jtable.setModel(tableModel);
                JScrollPane scroll = new JScrollPane(jtable);
                scroll.setBounds(100, 100, 600, 400);
                scroll.setBackground(new Color(255,226,226));
                container.add(scroll);

            }
        } catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public void setLocationAndSize() {
        act.setBounds(200, 20, 400, 30);
    }

    public void addComponentsToContainer() {
        container.add(act);
    }

    public void addActionEvent() {
        act.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == act) {
            th.interrupt();
            dispose();
            if (level == 1) {
                ActFrameAdmin frame = new ActFrameAdmin(jFrame, time);
                frame.setTitle("Act Frame");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            } else if (level == 2) {
                ActFrameEditor frame = new ActFrameEditor(jFrame, time);
                frame.setTitle("Act Frame");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            } else {
                ActFrameUser frame = new ActFrameUser(jFrame, time);
                frame.setTitle("Act Frame");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            }
        }
    }
    public void timer() {
        System.out.println(time);
        final Boolean[] flag = {true};
        th = new Thread(new Thread() {
            public void run() {
                while(flag[0]) {
                    try {
                        Thread.sleep(time);
                        dispose();
                        th.interrupt();
                        jFrame.setVisible(true);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        flag[0] = false;
                    }
                }
            }
        });
        th.start();
    }
}

class ActFrameEditor extends JFrame implements ActionListener {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    Thread th;
    JFrame jFrame;
    JPanel container = new JPanel();
    JButton act3 = new JButton("Поиск сотрудника по id");
    JButton act4 = new JButton("Поиск сотрудника по имени");
    JButton act5 = new JButton("Поиск сотрудника по дате рождения");
    JButton act6 = new JButton("Изменить информацию о пользователе");
    JButton act7 = new JButton("Рассчитать общую сумму зарплат");
    JButton act10 = new JButton("Вывести всех пользователей");
    JButton act11 = new JButton("Вывести всех сотрудников");
    JButton act13 = new JButton("Выйти");
    ActFrameEditor (JFrame jFrame, long time) {
        this.time = time;
        this.jFrame = jFrame;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setSize(new Dimension(800,700));
        setContentPane(container);
        timer();
    }

    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(new Color(255,226,226));

    }

    public void setLocationAndSize() {
        act3.setBounds(200, 20, 400, 30);
        act4.setBounds(200, 70, 400, 30);
        act5.setBounds(200, 120, 400, 30);
        act6.setBounds(200, 170, 400, 30);
        act7.setBounds(200, 220, 400, 30);
        act10.setBounds(200, 270, 400, 30);
        act11.setBounds(200, 320, 400, 30);
        act13.setBounds(200, 370, 400, 30);
    }

    public void addComponentsToContainer() {
        container.add(act3);
        container.add(act4);
        container.add(act5);
        container.add(act6);
        container.add(act7);
        container.add(act10);
        container.add(act11);
        container.add(act13);
    }

    public void addActionEvent() {
        act3.addActionListener(this);
        act4.addActionListener(this);
        act5.addActionListener(this);
        act6.addActionListener(this);
        act7.addActionListener(this);
        act10.addActionListener(this);
        act11.addActionListener(this);
        act13.addActionListener(this);
    }
    public long time;
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            try (Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
                PreparedStatement preparedStatement = null;
                if (e.getSource() == act11) {
                    Data frame = new Data(11, jFrame, 2, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act10) {
                    Data frame = new Data(10, jFrame, 2, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act7) {
                    String sql = "SELECT * FROM people";
                    preparedStatement = conn.prepareStatement(sql);
                    int sum = 0;
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        sum = sum + rs.getInt("salary");
                    }
                    JOptionPane.showMessageDialog(jFrame, "Общая сумма зарплат: " + sum);
                    th.interrupt();
                    timer();
                } else if (e.getSource() == act3) {
                    FindFrame frame = new FindFrame(1, jFrame, 2, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act4) {
                    FindFrame frame = new FindFrame(2, jFrame, 2, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act5) {
                    FindFrame frame = new FindFrame(3, jFrame, 2, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act13) {
                    th.interrupt();
                    dispose();
                    jFrame.setVisible(true);
                } else if (e.getSource() == act6) {
                    th.interrupt();
                    timer();
                    String getMessage = JOptionPane.showInputDialog(this, "Введите id");
                    String sql = "";
                    th.interrupt();
                    timer();
                    Object[] possibilities = {"firstname", "surname", "address", "birthday", "place_of_birth",
                            "salary", "family", "permission_level", "pass"};
                    Icon icon = null;
                    String s = (String) JOptionPane.showInputDialog(
                            this,
                            "Выберите что хотите изменить у пользователя",
                            "Изменение данных",
                            JOptionPane.PLAIN_MESSAGE,
                            icon,
                            possibilities,
                            "firstname");
                    th.interrupt();
                    timer();
                    String getMessage2 = JOptionPane.showInputDialog(this, "Введите новое значение");
                    th.interrupt();
                    timer();
                    if ((s != null) && (s.length() > 0)) {
                        sql = "UPDATE people SET " + s + " = ? WHERE id = ?";
                        preparedStatement = conn.prepareStatement(sql);
                        if (s == "birthday") {
                            preparedStatement.setDate(1, java.sql.Date.valueOf(getMessage2));
                        } else if (s == "family") {
                            preparedStatement.setBoolean(1, Boolean.parseBoolean(getMessage2));
                        } else if (s == "salary") {
                            preparedStatement.setInt(1, Integer.parseInt(getMessage2));
                        } else {
                            preparedStatement.setString(1, getMessage2);
                        }
                        preparedStatement.setInt(2, Integer.parseInt(getMessage));
                        preparedStatement.executeUpdate();
                    }
                }
            }
        } catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public void timer() {
        System.out.println(time);
        final Boolean[] flag = {true};
        th = new Thread(new Thread() {
            public void run() {
                while(flag[0]) {
                    try {
                        Thread.sleep(time);
                        dispose();
                        th.interrupt();
                        jFrame.setVisible(true);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        flag[0] = false;
                    }
                }
            }
        });
        th.start();
    }
}

class ActFrameUser extends JFrame implements ActionListener {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    Thread th;
    JFrame jFrame;
    JPanel container = new JPanel();
    JButton act3 = new JButton("Поиск сотрудника по id");
    JButton act4 = new JButton("Поиск сотрудника по имени");
    JButton act5 = new JButton("Поиск сотрудника по дате рождения");
    JButton act13 = new JButton("Выйти");
    ActFrameUser (JFrame jFrame, long time) {
        this.time = time;
        this.jFrame = jFrame;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setSize(new Dimension(800,700));
        setContentPane(container);
        timer();
    }

    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(new Color(255,226,226));

    }

    public void setLocationAndSize() {
        act3.setBounds(200, 20, 400, 30);
        act4.setBounds(200, 70, 400, 30);
        act5.setBounds(200, 120, 400, 30);
        act13.setBounds(200, 170, 400, 30);
    }

    public void addComponentsToContainer() {
        container.add(act3);
        container.add(act4);
        container.add(act5);
        container.add(act13);
    }

    public void addActionEvent() {
        act3.addActionListener(this);
        act4.addActionListener(this);
        act5.addActionListener(this);
        act13.addActionListener(this);
    }
    public long time;
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            try (Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
                PreparedStatement preparedStatement = null;
                if (e.getSource() == act3) {
                    FindFrame frame = new FindFrame(1, jFrame, 3, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act4) {
                    FindFrame frame = new FindFrame(2, jFrame, 3, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act5) {
                    FindFrame frame = new FindFrame(3, jFrame, 3, time);
                    frame.setTitle("Data Frame");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    th.interrupt();
                    dispose();
                } else if (e.getSource() == act13) {
                    th.interrupt();
                    dispose();
                    jFrame.setVisible(true);
                }
            }
        } catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public void timer() {
        System.out.println(time);
        final Boolean[] flag = {true};
        th = new Thread(new Thread() {
            public void run() {
                while(flag[0]) {
                    try {
                        Thread.sleep(time);
                        dispose();
                        th.interrupt();
                        jFrame.setVisible(true);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        flag[0] = false;
                    }
                }
            }
        });
        th.start();
    }
}
class AddFrame extends JFrame implements ActionListener {
    public long time;
    JFrame jFrame;
    int type;
    Thread th;
    JButton act = new JButton("Выйти");
    JButton add = new JButton("Добавить");
    JLabel nameLabel = new JLabel("Имя: ", SwingConstants.RIGHT);
    JLabel surnameLabel = new JLabel("Фамилия: ", SwingConstants.RIGHT);
    JLabel addressLabel = new JLabel("Адрес: ", SwingConstants.RIGHT);
    JLabel birthLabel = new JLabel("Дата рождения: ", SwingConstants.RIGHT);
    JLabel placeLabel = new JLabel("Место рождения: ", SwingConstants.RIGHT);
    JLabel salaryLabel = new JLabel("Зарплата: ", SwingConstants.RIGHT);
    JLabel familyLabel = new JLabel("Семейное положение: ", SwingConstants.RIGHT);
    JLabel permissionLabel = new JLabel("Статус: ", SwingConstants.RIGHT);
    JLabel passLabel = new JLabel("Пароль: ", SwingConstants.RIGHT);
    JTextField nameField = new JTextField();
    JTextField surnameField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField birthField = new JTextField();
    JTextField placeField = new JTextField();
    JTextField salaryField = new JTextField();
    JTextField familyField = new JTextField();
    JTextField permissionField = new JTextField();
    JTextField passField = new JTextField();
    JPanel container = new JPanel();
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    int level;
    AddFrame(int type, JFrame jFrame, int level, long time) {
        this.type = type;
        this.jFrame = jFrame;
        this.level = level;
        this.time = time;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setSize(new Dimension(800,700));
        setContentPane(container);
        timer();
    }

    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(new Color(255,226,226));

    }

    public void setLocationAndSize() {
        act.setBounds(200, 20, 400, 30);
        nameLabel.setBounds(100, 70, 250, 30);
        nameField.setBounds(380, 70, 250, 30);
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        surnameLabel.setBounds(100, 120, 250, 30);
        surnameField.setBounds(380, 120, 250, 30);
        surnameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        addressLabel.setBounds(100, 170, 250, 30);
        addressField.setBounds(380, 170, 250, 30);
        addressLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        birthLabel.setBounds(100, 220, 250, 30);
        birthField.setBounds(380, 220, 250, 30);
        birthLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        placeLabel.setBounds(100, 270, 250, 30);
        placeField.setBounds(380, 270, 250, 30);
        placeLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        salaryLabel.setBounds(100, 320, 250, 30);
        salaryField.setBounds(380, 320, 250, 30);
        salaryLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        familyLabel.setBounds(100, 370, 250, 30);
        familyField.setBounds(380, 370, 250, 30);
        familyLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        permissionLabel.setBounds(100, 420, 250, 30);
        permissionField.setBounds(380, 420, 250, 30);
        permissionLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        passLabel.setBounds(100, 470, 250, 30);
        passField.setBounds(380, 470, 250, 30);
        passLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add.setBounds(200, 520, 400, 30);
    }

    public void addComponentsToContainer() {
        container.add(act);
        container.add(nameLabel);
        container.add(nameField);
        container.add(surnameLabel);
        container.add(surnameField);
        container.add(addressLabel);
        container.add(addressField);
        container.add(birthLabel);
        container.add(birthField);
        container.add(placeLabel);
        container.add(placeField);
        container.add(salaryLabel);
        container.add(salaryField);
        container.add(familyLabel);
        container.add(familyField);
        if (this.type == 1) {
            container.add(permissionLabel);
            container.add(permissionField);
            container.add(passLabel);
            container.add(passField);
        }
        container.add(add);
    }
    public void addActionEvent() {
        act.addActionListener(this);
        add.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == act) {
            th.interrupt();
            dispose();
            if (level == 1) {
                ActFrameAdmin frame = new ActFrameAdmin(jFrame, time);
                frame.setTitle("Act Frame");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            } else if (level == 2) {
                ActFrameEditor frame = new ActFrameEditor(jFrame, time);
                frame.setTitle("Act Frame");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            } else {
                ActFrameUser frame = new ActFrameUser(jFrame, time);
                frame.setTitle("Act Frame");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            }
        }

        if (e.getSource() == add) {
            try {
                try (Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
                    PreparedStatement preparedStatement = null;
                    String sql = "";
                    if (type == 1) {
                        if (nameField.getText().equals("") | surnameField.getText().equals("") |
                                addressField.getText().equals("") | birthField.getText().equals("") |
                                placeField.getText().equals("") | salaryField.getText().equals("") |
                                familyField.getText().equals("") | permissionField.getText().equals("") |
                                passField.getText().equals("")) {
                            JOptionPane.showMessageDialog(this, "Не все поля заполнены");
                        } else {
                            sql = "INSERT INTO People(firstname,surname,address,birthday,place_of_birth,salary,family,permission_level,pass) VALUES(?,?,?,?,?,?,?,?,?)";
                            preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setString(1, nameField.getText());
                            preparedStatement.setString(2, surnameField.getText());
                            preparedStatement.setString(3, addressField.getText());
                            preparedStatement.setDate(4, java.sql.Date.valueOf(birthField.getText()));
                            preparedStatement.setString(5, placeField.getText());
                            preparedStatement.setInt(6, Integer.parseInt(salaryField.getText()));
                            preparedStatement.setBoolean(7, Boolean.parseBoolean(familyField.getText()));
                            preparedStatement.setInt(8, Integer.parseInt(permissionField.getText()));
                            preparedStatement.setString(9, passField.getText());
                            preparedStatement.executeUpdate();
                            reset();
                        }
                    } else {
                        if (nameField.getText().equals("") | surnameField.getText().equals("") |
                                addressField.getText().equals("") | birthField.getText().equals("") |
                                placeField.getText().equals("") | salaryField.getText().equals("") |
                                familyField.getText().equals("")) {
                            JOptionPane.showMessageDialog(this, "Не все поля заполнены");
                        } else {
                            sql = "INSERT INTO People(firstname,surname,address,birthday,place_of_birth,salary,family) VALUES(?,?,?,?,?,?,?)";
                            preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setString(1, nameField.getText());
                            preparedStatement.setString(2, surnameField.getText());
                            preparedStatement.setString(3, addressField.getText());
                            preparedStatement.setDate(4, java.sql.Date.valueOf(birthField.getText()));
                            preparedStatement.setString(5, placeField.getText());
                            preparedStatement.setInt(6, Integer.parseInt(salaryField.getText()));
                            preparedStatement.setBoolean(7, Boolean.parseBoolean(familyField.getText()));
                            preparedStatement.executeUpdate();
                            reset();
                        }
                    }
                }
            } catch(Exception ex){
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
            th.interrupt();
            timer();
        }
    }
    public void reset() {
        nameField.setText("");
        surnameField.setText("");
        addressField.setText("");
        birthField.setText("");
        placeField.setText("");
        salaryField.setText("");
        familyField.setText("");
        if (type==1) {
            permissionField.setText("");
            passField.setText("");
        }
    }
    public void timer() {
        System.out.println(time);
        final Boolean[] flag = {true};
        th = new Thread(new Thread() {
            public void run() {
                while(flag[0]) {
                    try {
                        Thread.sleep(time);
                        dispose();
                        th.interrupt();
                        jFrame.setVisible(true);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        flag[0] = false;
                    }
                }
            }
        });
        th.start();
    }
}
class FindFrame extends JFrame implements ActionListener {
    JFrame jFrame;
    int type;
    Thread th;
    JPanel container = new JPanel();
    JButton act = new JButton("Выйти");
    JButton find = new JButton("Найти");
    JLabel nameLabel = new JLabel("Имя: ", SwingConstants.RIGHT);
    JLabel birthLabel = new JLabel("Дата рождения: ", SwingConstants.RIGHT);
    JLabel idLabel = new JLabel("Id: ", SwingConstants.RIGHT);
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    JTable jtable = new JTable();
    JTextField findField = new JTextField();
    int level;
    public long time;

    FindFrame(int type, JFrame jFrame, int level, long time) {
        this.type = type;
        this.jFrame = jFrame;
        this.level = level;
        this.time = time;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setSize(new Dimension(800,700));
        setContentPane(container);
        timer();
    }
    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(new Color(255,226,226));

    }

    public void setLocationAndSize() {
        act.setBounds(200, 20, 400, 30);
        nameLabel.setBounds(200, 70, 150, 30);
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        birthLabel.setBounds(200, 70, 150, 30);
        birthLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        idLabel.setBounds(200, 70, 150, 30);
        idLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        findField.setBounds(380, 70, 120, 30);
        find.setBounds(200, 120, 400, 30);
    }

    public void addComponentsToContainer() {
        container.add(act);
        switch (type) {
            case 1 -> {
                container.add(idLabel);
            }
            case 2 -> {
                container.add(nameLabel);
            }
            case 3 -> {
                container.add(birthLabel);
            }
        }
        container.add(findField);
        container.add(find);
    }
    public void addActionEvent() {
        act.addActionListener(this);
        find.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == act) {
            th.interrupt();
            dispose();
            if (level == 1) {
                ActFrameAdmin frame = new ActFrameAdmin(jFrame, time);
                frame.setTitle("Act Frame");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            } else if (level == 2) {
                ActFrameEditor frame = new ActFrameEditor(jFrame, time);
                frame.setTitle("Act Frame");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            } else {
                ActFrameUser frame = new ActFrameUser(jFrame, time);
                frame.setTitle("Act Frame");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            }
        }
        if (e.getSource() == find) {
            try {
                try (Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
                    if (findField.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Не все поля заполнены");
                    } else {
                        ArrayList<String> al = new ArrayList<>();
                        al.add("Не женат/Не замужем");
                        al.add("Женат/Замужем");
                        PreparedStatement preparedStatement = null;
                        String sql = "";
                        switch (type) {
                            case 1 -> {
                                sql = "SELECT *  FROM people WHERE id = ?";
                                preparedStatement = conn.prepareStatement(sql);
                                preparedStatement.setInt(1, Integer.parseInt(findField.getText()));
                            }
                            case 2 -> {
                                sql = "SELECT *  FROM people WHERE firstname = ?";
                                preparedStatement = conn.prepareStatement(sql);
                                preparedStatement.setString(1, findField.getText());
                            }
                            case 3 -> {
                                sql = "SELECT *  FROM people WHERE birthday = ?";
                                preparedStatement = conn.prepareStatement(sql);
                                preparedStatement.setString(1, findField.getText());
                            }
                        }
                        String[] columnNames;
                        if (level!=3) {
                            columnNames = new String[]{"id", "firstname", "surname", "address", "birthday",
                                    "place_of_birth", "salary", "family", "permission_level", "pass"};
                        } else {
                            columnNames = new String[]{"id", "firstname", "surname", "address", "birthday",
                                    "place_of_birth", "salary", "family"};
                        }
                        ResultSet rs = preparedStatement.executeQuery();
                        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                        if (level != 3) {
                            while (rs.next()) {
                                String[] data;
                                data = new String[]{String.valueOf(rs.getInt("id")),
                                        rs.getString("firstname"),
                                        rs.getString("surname"),
                                        rs.getString("address"),
                                        String.valueOf(rs.getDate("birthday")),
                                        rs.getString("place_of_birth"),
                                        String.valueOf(rs.getInt("salary")),
                                        al.get(rs.getBoolean("family") ? 1 : 0),
                                        String.valueOf(rs.getInt("permission_level")),
                                        rs.getString("pass")};
                                tableModel.addRow(data);
                            }
                        } else {
                            while (rs.next()) {
                                String[] data;
                                data = new String[]{String.valueOf(rs.getInt("id")),
                                        rs.getString("firstname"),
                                        rs.getString("surname"),
                                        rs.getString("address"),
                                        String.valueOf(rs.getDate("birthday")),
                                        rs.getString("place_of_birth"),
                                        String.valueOf(rs.getInt("salary")),
                                        al.get(rs.getBoolean("family") ? 1 : 0),
                                        String.valueOf(rs.getInt("permission_level")),
                                        rs.getString("pass")};
                                tableModel.addRow(data);
                            }
                        }
                        jtable.setModel(tableModel);
                        JScrollPane scroll = new JScrollPane(jtable);
                        scroll.setBounds(100, 170, 600, 400);
                        scroll.setBackground(new Color(255, 226, 226));
                        container.add(scroll);
                        th.interrupt();
                        timer();
                    }
                }
            } catch(Exception ex){
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
        }
    }
    public void timer() {
        System.out.println(time);
        final Boolean[] flag = {true};
        th = new Thread(new Thread() {
            public void run() {
                while(flag[0]) {
                    try {
                        Thread.sleep(time);
                        dispose();
                        th.interrupt();
                        jFrame.setVisible(true);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        flag[0] = false;
                    }
                }
            }
        });
        th.start();
    }
}
class Login {
    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame(40000);
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}