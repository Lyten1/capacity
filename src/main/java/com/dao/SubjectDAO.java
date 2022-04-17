package com.dao;

import com.models.Subject;
import com.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class SubjectDAO implements Dao<Subject>{
    private Database db;
    public static final String DB_SUBJECT = "Subjects";
    Subject subject = new Subject();
    private ArrayList<Subject> data = new ArrayList<>();

    @Autowired
    public SubjectDAO(Database db) {
        this.db = db;
    }

    public SubjectDAO() {}

    @Override
    public void save(Subject data){
        try (Statement statement = db.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO " + DB_SUBJECT +
                    " (name, id_teacher) " +
                    " VALUES ('" +
                    data.getName() + "','" +
                    data.getId_teacher()+ "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Subject get(String pattern)  {
        Statement statement = null;
        try {
            Subject subject = new Subject();
            ResultSet resultSet = statement.executeQuery("Select * from "+ DB_SUBJECT +" WHERE id="+ pattern + ";");
            while (resultSet.next()){
                subject.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("id_teacher")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    @Override
    public ArrayList<Subject> getAll()  {
        try (Statement statement = db.getConnection().createStatement()){
            data.clear();
            ResultSet resultSet = statement.executeQuery("Select * from " + DB_SUBJECT + ";");

            while (resultSet.next()){
                Subject subject = new Subject();
                subject.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("id_teacher")
                );
                data.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public void delete(String pattern){
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("DELETE FROM "+ DB_SUBJECT +" WHERE id="+ pattern + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Subject data, String pattern) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("UPDATE "+ DB_SUBJECT +
                    " SET name='" +data.getName()+
                    "', id_teacher='" +data.getId_teacher()+
                    "' WHERE id=" +pattern+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
