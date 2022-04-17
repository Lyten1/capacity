package com.dao;

import com.models.Teacher;
import com.models.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class UserTypesDAO implements Dao<UserTypes>{
    private Database db;
    UserTypes userTypes = new UserTypes();
    public static final String DB_USERTYPES = "usertypes";
    private ArrayList<UserTypes> data = new ArrayList<>();


    @Autowired
    public UserTypesDAO(Database db) {
        this.db = db;
    }

    @Override
    public void save(UserTypes data) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO " + DB_USERTYPES +
                    " (name, permit1,permit2,permit3,permit4,permit5,permit6,permit7,permit8) " +
                    " VALUES ('" +
                    data.getName() + "','" +
                    data.isPermit1() + "','" +
                    data.isPermit2() + "','" +
                    data.isPermit3() + "','" +
                    data.isPermit4() + "','" +
                    data.isPermit5() + "','" +
                    data.isPermit6() + "','" +
                    data.isPermit7() + "','" +
                    data.isPermit8()+ "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserTypes get(String pattern){
        try (Statement statement = db.getConnection().createStatement()){
            UserTypes userTypes = new UserTypes();
            ResultSet resultSet = statement.executeQuery("Select * from "+ DB_USERTYPES +" WHERE id="+ pattern + ";");
            while (resultSet.next()){
                userTypes.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("permit1"),
                        resultSet.getBoolean("permit2"),
                        resultSet.getBoolean("permit3"),
                        resultSet.getBoolean("permit4"),
                        resultSet.getBoolean("permit5"),
                        resultSet.getBoolean("permit6"),
                        resultSet.getBoolean("permit7"),
                        resultSet.getBoolean("permit8")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userTypes;
    }

    @Override
    public ArrayList<UserTypes> getAll() {

        try (Statement statement = db.getConnection().createStatement()){
            data.clear();

            ResultSet resultSet = statement.executeQuery("Select * from " + DB_USERTYPES + ";");

            while (resultSet.next()){
                UserTypes userTypes = new UserTypes();
                userTypes.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("permit1"),
                        resultSet.getBoolean("permit2"),
                        resultSet.getBoolean("permit3"),
                        resultSet.getBoolean("permit4"),
                        resultSet.getBoolean("permit5"),
                        resultSet.getBoolean("permit6"),
                        resultSet.getBoolean("permit7"),
                        resultSet.getBoolean("permit8")
                );
                data.add(userTypes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<UserTypes> findByPermit(String pattern) {
        try (Statement statement = db.getConnection().createStatement()){
            data.clear();
            ResultSet resultSet = statement.executeQuery("Select * from " + DB_USERTYPES + " WHERE permit"+ pattern +"='true';");

            while (resultSet.next()){
                UserTypes userTypes = new UserTypes();
                userTypes.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("permit1"),
                        resultSet.getBoolean("permit2"),
                        resultSet.getBoolean("permit3"),
                        resultSet.getBoolean("permit4"),
                        resultSet.getBoolean("permit5"),
                        resultSet.getBoolean("permit6"),
                        resultSet.getBoolean("permit7"),
                        resultSet.getBoolean("permit8")
                );
                data.add(userTypes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void delete(String pattern){

        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("DELETE FROM "+ DB_USERTYPES +" WHERE id="+ pattern + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(UserTypes data, String pattern) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("UPDATE "+ DB_USERTYPES +
                    " SET name='" +data.getName()+
                    "', permit1='" +data.isPermit1()+
                    "', permit2='" +data.isPermit2()+
                    "', permit3='" +data.isPermit3()+
                    "', permit4='" +data.isPermit4()+
                    "', permit5='" +data.isPermit5()+
                    "', permit6='" +data.isPermit6()+
                    "', permit7='" +data.isPermit7()+
                    "', permit8='" +data.isPermit8()+
                    "' WHERE id=" +pattern+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
