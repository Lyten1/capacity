package com.dao;

import com.models.Specialities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class SpecialitiesDAO implements Dao<Specialities> {
    Database db;
    Specialities specialities = new Specialities();
    private static final String DB_TABLE_NAME = "specialities";
    ArrayList<Specialities> specialitiesArrayList = new ArrayList<>();

    @Autowired
    public SpecialitiesDAO(Database db) {
        this.db = db;
    }

    @Override
    public void save(Specialities data) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO " + DB_TABLE_NAME + " (id_faculty, speciality, specialty_abbreviation) VALUES ('"
                    + data.getId_faculty() + "', '"
                    + data.getSpeciality() + "', '"
                    + data.getSpecialty_abbreviation()
                    + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Specialities get(String id)  {
        try (Statement statement = db.getConnection().createStatement()){
            Specialities specialities = new Specialities();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id = " + id +";");

            while (resultSet.next()) {
                specialities.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_faculty"),
                        resultSet.getString("speciality"),
                        resultSet.getString("specialty_abbreviation")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialities;
    }

    @Override
    public ArrayList<Specialities> getAll() {

        try (Statement statement = db.getConnection().createStatement()){
            specialitiesArrayList.clear();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + ";");
            while (resultSet.next()) {
                Specialities specialities = new Specialities();
                specialities.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_faculty"),
                        resultSet.getString("speciality"),
                        resultSet.getString("specialty_abbreviation")
                );
                specialitiesArrayList.add(specialities);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialitiesArrayList;
    }

    @Override
    public void delete(String id)  {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("DELETE FROM " + DB_TABLE_NAME + " WHERE id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Specialities specialities, String id) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("UPDATE " + DB_TABLE_NAME +
                    " SET id_faculty ='" + specialities.getId_faculty() +
                    "', speciality ='" + specialities.getSpeciality() +
                    "', specialty_abbreviation ='" + specialities.getSpecialty_abbreviation() +
                    "' WHERE id=" + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public ArrayList<Specialities> getSpecialtiesByIdFaculty(String id_faculty) {
        try (Statement statement = db.getConnection().createStatement()){
            specialitiesArrayList.clear();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id_faculty = " + id_faculty +";");

            while (resultSet.next()) {
                Specialities specialities = new Specialities();
                specialities.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_faculty"),
                        resultSet.getString("speciality"),
                        resultSet.getString("specialty_abbreviation")
                );
                specialitiesArrayList.add(specialities);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialitiesArrayList;
    }
}
