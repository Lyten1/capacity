package com.dao;
import com.models.Deanery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class DeaneryDAO implements Dao<Deanery> {
    private Database db;
    private Deanery deanery = new Deanery();
    private static final String DB_TABLE_NAME = "deanery";
    ArrayList<Deanery> deaneryArrayList = new ArrayList<>();

    @Autowired
    public DeaneryDAO(Database db) {
        this.db = db;
    }

    @Override
    public void save(Deanery data) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO " + DB_TABLE_NAME + " " +
                    "(faculty, dean) VALUES ('" + data.getFaculty() + "', '" + data.getDean() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Deanery get(String id){
        try (Statement statement = db.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id = " + id +";");
            while (resultSet.next()) {
                deanery.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("faculty"),
                        resultSet.getString("dean")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deanery;
    }

    @Override
    public ArrayList<Deanery> getAll(){
        try (Statement statement = db.getConnection().createStatement()){
            deaneryArrayList.clear();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + ";");
            while (resultSet.next()) {
                Deanery deanery = new Deanery();
                deanery.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("faculty"),
                        resultSet.getString("dean")
                );
                deaneryArrayList.add(deanery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deaneryArrayList;
    }

    public Deanery getFaculty(String faculty)  {

        try (Statement statement = db.getConnection().createStatement()){
            Deanery deanery = new Deanery();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE faculty = " + faculty +";");

            while (resultSet.next()) {
                deanery.setData(
                        resultSet.getInt("id"),
                        resultSet.getString("faculty"),
                        resultSet.getString("dean")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return deanery;
    }




    @Override
    public void delete(String id) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("DELETE FROM " + DB_TABLE_NAME + " WHERE id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Deanery deanery, String id) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("UPDATE " + DB_TABLE_NAME +
                    " SET faculty ='" + deanery.getFaculty() +
                    "', dean ='" + deanery.getDean() +
                    "' WHERE id=" + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}