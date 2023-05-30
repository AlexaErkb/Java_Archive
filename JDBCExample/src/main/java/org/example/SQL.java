package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SQL {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        ArrayList<String> al= new ArrayList<>();
        al.add("Не женат/Не замужем");
        al.add("Женат/Замужем");

        try{
            //Scanner scanner = new Scanner(System.in);

            //Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            //String name = scanner.nextLine();
            //int price = scanner.nextInt();

            try (Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)){
                Scanner in = new Scanner(System.in);
                int choice = -1;
                while (choice!=0) {
                    System.out.println("""
                            Введите 1, если хотите вывести информацию обо всех сотрудниках
                            Введите 2, если хотите добавить сотрудника
                            Введите 3, если хотите найти сотрудника по id
                            Введите 4, если хотите найти сотрудника по имени
                            Введите 5, если хотите найти сотрудника по дате рождения
                            Введите 6, если хотите изменить любую информацию о сотруднике
                            Введите 7, если хотите удалить сотрудника
                            Введите 8, если хотите получить общую сумму зарплат всех сотрудников
                            Введите 0, если хотите выйти""");
                    choice = in.nextInt();
                    PreparedStatement preparedStatement = null;
                    switch (choice) {
                        case 1 -> {
                            String sql = "SELECT *  FROM people";
                            preparedStatement = conn.prepareStatement(sql);
                        }
                        case 2 -> {
                            Boolean flag = true;
                            while (flag) {
                                String sql = "INSERT INTO People(firstname,surname,address,birthday,place_of_birth,salary,family) VALUES(?,?,?,?,?,?,?)";
                                preparedStatement = conn.prepareStatement(sql);
                                System.out.println("Введите имя нового пользователя ");
                                preparedStatement.setString(1, in.next());
                                System.out.println("Введите фамилию нового пользователя ");
                                preparedStatement.setString(2, in.next());
                                System.out.println("Введите страну проживания нового пользователя ");
                                preparedStatement.setString(3, in.next());
                                System.out.println("Введите дату рождения нового пользователя ");
                                preparedStatement.setDate(4, java.sql.Date.valueOf(in.next()));
                                System.out.println("Введите страну рождения нового пользователя ");
                                preparedStatement.setString(5, in.next());
                                System.out.println("Введите зарплату нового пользователя ");
                                preparedStatement.setInt(6, in.nextInt());
                                System.out.println("Введите семейное положение нового пользователя ");
                                preparedStatement.setBoolean(7, in.nextBoolean());
                                preparedStatement.executeUpdate();
                                System.out.println("Введите 1, если хотите продолжить вводить данные новых пользователей ");
                                int ch = in.nextInt();
                                if (ch != 1) {
                                    flag = false;
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("Введите id человека которого хотите найти ");
                            int id_s = in.nextInt();
                            String sql = "SELECT *  FROM people WHERE id = ?";
                            preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setInt(1, id_s);
                        }
                        case 4 -> {
                            System.out.println("Введите имя человека которого хотите найти ");
                            String fs = in.next();
                            String sql = "SELECT *  FROM people WHERE firstname = ?";
                            preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setString(1, fs);
                        }
                        case 5 -> {
                            System.out.println("Введите дату рождения человека которого хотите найти в формате год-месяц-день ");
                            String dt = in.next();
                            String sql = "SELECT *  FROM people WHERE birthday = ?";
                            preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setDate(1, java.sql.Date.valueOf(dt));
                        }
                        case 6 -> {
                            System.out.println("Введите id сотрудника, которому хотите поменять данные");
                            int id_s = in.nextInt();
                            System.out.println("""
                            Введите 1, если хотите поменять имя
                            Введите 2, если хотите поменять фамилию
                            Введите 3, если хотите поменять адрес
                            Введите 4, если хотите поменять дату рождения
                            Введите 5, если хотите поменять место рождения
                            Введите 6, если хотите поменять зарплату
                            Введите 7, если хотите поменять семейное положение
                            Введите 0, если уже ничего не хотите""");
                            int ch = in.nextInt();
                            System.out.println("Введите новое значение ");
                            switch (ch) {
                                case 1 -> {
                                    String sql = "UPDATE people SET firstname = ? WHERE id = ?";
                                    preparedStatement = conn.prepareStatement(sql);
                                    String new_val = in.next();
                                    preparedStatement.setString(1, new_val);
                                }
                                case 2 -> {
                                    String sql = "UPDATE people SET surname = ? WHERE id = ?";
                                    preparedStatement = conn.prepareStatement(sql);
                                    String new_val = in.next();
                                    preparedStatement.setString(1, new_val);
                                }
                                case 3 -> {
                                    String sql = "UPDATE people SET address = ? WHERE id = ?";
                                    preparedStatement = conn.prepareStatement(sql);
                                    String new_val = in.next();
                                    preparedStatement.setString(1, new_val);
                                }
                                case 4 -> {
                                    String sql = "UPDATE people SET birthday = ? WHERE id = ?";
                                    preparedStatement = conn.prepareStatement(sql);
                                    String new_val = in.next();
                                    preparedStatement.setDate(1, java.sql.Date.valueOf(new_val));
                                }
                                case 5 -> {
                                    String sql = "UPDATE people SET place_of_birth = ? WHERE id = ?";
                                    preparedStatement = conn.prepareStatement(sql);
                                    String new_val = in.next();
                                    preparedStatement.setString(1, new_val);
                                }
                                case 6 -> {
                                    String sql = "UPDATE people SET salary = ? WHERE id = ?";
                                    preparedStatement = conn.prepareStatement(sql);
                                    int new_val = in.nextInt();
                                    preparedStatement.setInt(1, new_val);
                                }
                                case 7 -> {
                                    String sql = "UPDATE people SET family = ? WHERE id = ?";
                                    preparedStatement = conn.prepareStatement(sql);
                                    Boolean new_val = in.nextBoolean();
                                    preparedStatement.setBoolean(1, new_val);
                                }
                                case 0 -> {
                                    break;
                                }
                                default -> {
                                    System.out.println("Попробуйте ввести другое значение");
                                }
                            }
                            preparedStatement.setInt(2, id_s);
                            preparedStatement.executeUpdate();


                        }
                        case  7 -> {
                            System.out.println("Введите id сотрудника, которого хотите удалить ");
                            int id_s = in.nextInt();
                            String sql = "DELETE FROM people WHERE id = ?";
                            preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setInt(1, id_s);
                            preparedStatement.executeUpdate();
                            sql = "ALTER TABLE people AUTO_INCREMENT = 1";
                            preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.executeUpdate();
                        }
                        case 8 -> {
                            String sql = "SELECT SUM(salary) as sss FROM people";
                            preparedStatement = conn.prepareStatement(sql);
                            ResultSet rs = preparedStatement.executeQuery();
                            rs.next();
                            System.out.println("Общая сумма: " + rs.getInt("sss"));
                        }
                        case 0 -> {
                            break;
                        }
                        default -> {
                            System.out.println("Попробуйте ввести другое значение");
                        }
                    }
                    if (choice!=2 & choice!=6 & choice!=7 & choice!=0 & choice!=8) {
                        ResultSet rs = preparedStatement.executeQuery();
                        while (rs.next()) {
                            System.out.println("=========================== ID: " + rs.getInt("id") + " ==========================");
                            System.out.println("First Name: " + rs.getString("firstname"));
                            System.out.println("Surname: " + rs.getString("surname"));
                            System.out.println("Address: " + rs.getString("address"));
                            System.out.println("Birthday: " + rs.getDate("birthday"));
                            System.out.println("Place of birth: " + rs.getString("place_of_birth"));
                            System.out.println("Salary: " + rs.getInt("salary"));
                            System.out.println("Family: " + al.get(rs.getBoolean("family") ? 1 : 0));
                            System.out.println("************************************************************");
                        }
                    }
                }

                //String sql = "INSERT INTO Products (ProductName, Price) Values (?, ?)";
                //preparedStatement.setString(1, name);
                //preparedStatement.setInt(2, price);

                /*ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){

                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("firstname");

                    System.out.printf(id + name);
                }

                 */
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}