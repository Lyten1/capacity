package com.dao;

import com.models.Capacity;
import com.models.Subject;
import com.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//TODO перевірити юзабелльність всіх полів
// TODO максимально калічний клас  -- ПЕРЕПИСАТИ


@Component
public class TeacherDAO implements Dao<Teacher> {
    private Database db;
    public static final String DB_TEACHERS = "Teachers";
    public static final String DB_SUBJECTS = "Subjects";
    Teacher teacher = new Teacher();
    Subject subject = new Subject();
    private ArrayList<Teacher> data = new ArrayList<>();

    @Autowired
    public TeacherDAO(Database db) {
        this.db = db;
    }

    public TeacherDAO() {}

    @Override
    public void save(Teacher data) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO " + DB_TEACHERS +
                    " (name, surname, fathersname) " +
                    " VALUES ('" +
                    data.getName() + "','" +
                    data.getSurname() + "','" +
                    data.getFathersname()+ "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher get(String pattern) {
        
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        ArrayList<String> subjects = new ArrayList<>();

        
        try (Statement statement = db.getConnection().createStatement()){
            //TODO замутити все на сервіс
            ResultSet resultSet1 = statement.executeQuery("Select * from " + DB_SUBJECTS + " WHERE id_teacher=" + pattern + ";");
            while(resultSet1.next()){
                subjects.add(resultSet1.getString("name"));
            }


            ResultSet resultSet = statement.executeQuery("Select * from "+ DB_TEACHERS +" WHERE id="+ pattern + ";");

            while (resultSet.next()){
                teacher.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("fathersname"),
                        subjects
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacher;
    }

    @Override
    public ArrayList<Teacher> getAll() {
        try (Statement statement = db.getConnection().createStatement()){
            Subject subject = new Subject();
            SubjectDAO subjectDAO = new SubjectDAO();
            ArrayList<String> subjects = new ArrayList<>();

            data.clear();

            ResultSet resultSet = statement.executeQuery("Select * from " + DB_TEACHERS + ";");

            while (resultSet.next()){
                Teacher teacher = new Teacher();
                teacher.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("fathersname"),
                        subjects
                );
                data.add(teacher);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return data;
    }


    public ArrayList<Teacher> findBySubject(String pattern) {
        try (Statement statement = db.getConnection().createStatement()){
            Subject subject = new Subject();
            SubjectDAO subjectDAO = new SubjectDAO();
            ArrayList<String> subjects = new ArrayList<>();

            data.clear();

            ResultSet resultSet = statement.executeQuery("Select * from " + DB_TEACHERS + ", " + DB_SUBJECTS +
                    " where teachers.id = subjects.id_teacher and subjects.name='" + pattern+"';");

            subjects.add(pattern);

            while (resultSet.next()){
                Teacher teacher = new Teacher();
                teacher.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("fathersname"),
                        subjects
                );
                data.add(teacher);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public void delete(String pattern){
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("DELETE FROM "+ DB_TEACHERS +" WHERE id="+ pattern + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Teacher data, String pattern) {

        try(Statement statement = db.getConnection().createStatement()){
        statement.execute("UPDATE "+ DB_TEACHERS +
                " SET name='" +data.getName()+
                "', surname='" +data.getSurname()+
                "', fathersname='" +data.getFathersname()+
                "' WHERE id=" +pattern+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String makeShortName(Capacity data) {
        String shortname = null;
        try (Statement statement = db.getConnection().createStatement()){

            ResultSet resultSet = statement.executeQuery("Select * from "+ DB_TEACHERS +" WHERE id="+ data.getId_teacher() + ";");
            while (resultSet.next()){
                shortname = teacher.getShortName(resultSet.getString("name"),
                        resultSet.getString("surname"),resultSet.getString("fathersname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shortname;
    }



}
