package com.dao;

import com.models.Capacity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class CapacityDAO implements Dao<Capacity>{
    private Database db;
    Capacity capacity = new Capacity();
    public static final String DB_CAPASITY = "Capacity";
    private ArrayList<Capacity> data = new ArrayList<>();


    @Autowired
    public CapacityDAO(Database db) {
        this.db = db;
    }


    public void save(Capacity data, String shortname)  {
        try (Statement statement = db.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO " + DB_CAPASITY +
                    " ( id_teacher, teachers_name, subject, groupe, semester, year, all_hours, theory_hours, lab_hours, pract_hours," +
                    "  control_type) " +
                    " VALUES ('" +
                    data.getId_teacher() + "','" +
                    shortname + "','" +
                    data.getSubject() + "','" +
                    data.getGroupe() + "','" +
                    data.getSemester() + "','" +
                    data.getYear() + "','" +
                    data.getAll_hours() + "','" +
                    data.getTheory_hours() + "','" +
                    data.getLab_hours() + "','" +
                    data.getPract_hours() + "','" +
                    data.getControl_type()+ "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void save(Capacity data){

    }

    @Override
    public Capacity get(String pattern) {
        try (Statement statement = db.getConnection().createStatement()){
            Capacity capacity = new Capacity();
            ResultSet resultSet = statement.executeQuery("Select * from "+ DB_CAPASITY +" WHERE id="+ pattern + ";");

            while (resultSet.next()){
                capacity.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_teacher"),
                        resultSet.getString("teachers_name"),
                        resultSet.getString("subject"),
                        resultSet.getString("groupe"),
                        resultSet.getInt("semester"),
                        resultSet.getInt("year"),
                        resultSet.getInt("all_hours"),
                        resultSet.getInt("theory_hours"),
                        resultSet.getInt("lab_hours"),
                        resultSet.getInt("pract_hours"),
                        resultSet.getString("control_type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return capacity;
    }

    @Override
    public ArrayList<Capacity> getAll() {
        try (Statement statement = db.getConnection().createStatement()){
            data.clear();

            ResultSet resultSet = statement.executeQuery("Select * from "+DB_CAPASITY+";");

            while (resultSet.next()){
                Capacity capacity = new Capacity();
                capacity.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_teacher"),
                        resultSet.getString("teachers_name"),
                        resultSet.getString("subject"),
                        resultSet.getString("groupe"),
                        resultSet.getInt("semester"),
                        resultSet.getInt("year"),
                        resultSet.getInt("all_hours"),
                        resultSet.getInt("theory_hours"),
                        resultSet.getInt("lab_hours"),
                        resultSet.getInt("pract_hours"),
                        resultSet.getString("control_type")
                );
                data.add(capacity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void delete(String pattern) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("DELETE FROM "+ DB_CAPASITY +" WHERE id="+ pattern + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Capacity data, String pattern) {

    }


    public void update(Capacity data, String pattern, String shortname)  {
        try (Statement statement = db.getConnection().createStatement()){
            System.out.println("UPDATE "+ DB_CAPASITY +
                    " SET id_teacher='" +data.getId_teacher()+
                    "', teachers_name='" + shortname+
                    "', semester='" + data.getSemester()+
                    "', year ='" + data.getYear()+
                    "', all_hours='" + data.getAll_hours()+
                    "', theory_hours='" + data.getTheory_hours()+
                    "', lab_hours='" + data.getLab_hours()+
                    "', pract_hours='" + data.getPract_hours()+
                    "', teachers_name='" + data.getTeachers_name()+
                    "', subject='" + data.getSubject()+
                    "', groupe='" + data.getGroupe()+
                    "', control_type='" + data.getControl_type()+
                    "' WHERE id=" +pattern+";");
            statement.execute("UPDATE "+ DB_CAPASITY +
                    " SET id_teacher='" +data.getId_teacher()+
                    "', semester='" + data.getSemester()+
                    "', year ='" + data.getYear()+
                    "', all_hours='" + data.getAll_hours()+
                    "', theory_hours='" + data.getTheory_hours()+
                    "', lab_hours='" + data.getLab_hours()+
                    "', pract_hours='" + data.getPract_hours()+
                    "', teachers_name='" + shortname+
                    "', subject='" + data.getSubject()+
                    "', groupe='" + data.getGroupe()+
                    "', control_type='" + data.getControl_type()+
                    "' WHERE id=" +pattern+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
