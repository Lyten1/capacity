package com.dao;

import com.models.Disciplines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class DisciplinesDAO implements Dao<Disciplines>{
    Database db;
    Disciplines disciplines = new Disciplines();
    private static final String DB_TABLE_NAME = "Disciplines";
    ArrayList<Disciplines> data = new ArrayList<>();

    @Autowired
    public DisciplinesDAO(Database db) {
        this.db = db;
    }


    @Override
    public void save(Disciplines data) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO " + DB_TABLE_NAME + " (" +
                    "id_education, id_speciality, discipline, sem_exam, sem_zal, sem_kp, " +
                    "all_hours, theory_hours, lab_hours, pract_hours, hours_first, hours_second, " +
                    "hours_third, hours_forth, hours_fifth, hours_sixth, hours_seventh, hours_eighth) VALUES ('"
                    + data.getId_education() + "', '"
                    + data.getId_speciality() + "', '"
                    + data.getDiscipline() + "', '"
                    + data.getSem_exam() + "', '"
                    + data.getSem_zal() + "', '"
                    + data.getSem_kp() + "', '"
                    + data.getAll_hours() + "', '"
                    + data.getTheory_hours() + "', '"
                    + data.getLab_hours() + "', '"
                    + data.getPract_hours() + "', '"
                    + data.getHours_first() + "', '"
                    + data.getHours_second() + "', '"
                    + data.getHours_third() + "', '"
                    + data.getHours_forth() + "', '"
                    + data.getHours_fifth() + "', '"
                    + data.getHours_sixth() + "', '"
                    + data.getHours_seventh() + "', '"
                    + data.getHours_eighth() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Disciplines get(String id) {
        try (Statement statement = db.getConnection().createStatement()){


            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id = " + id +";");

            while (resultSet.next()) {
                disciplines.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_education"),
                        resultSet.getInt("id_speciality"),
                        resultSet.getString("discipline"),
                        resultSet.getInt("sem_exam"),
                        resultSet.getInt("sem_zal"),
                        resultSet.getInt("sem_kp"),
                        resultSet.getInt("all_hours"),
                        resultSet.getInt("theory_hours"),
                        resultSet.getInt("lab_hours"),
                        resultSet.getInt("pract_hours"),
                        resultSet.getInt("hours_first"),
                        resultSet.getInt("hours_second"),
                        resultSet.getInt("hours_third"),
                        resultSet.getInt("hours_forth"),
                        resultSet.getInt("hours_fifth"),
                        resultSet.getInt("hours_sixth"),
                        resultSet.getInt("hours_seventh"),
                        resultSet.getInt("hours_eighth")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disciplines;
    }

    @Override
    public ArrayList<Disciplines> getAll()  {

        try (Statement statement = db.getConnection().createStatement()){
            data.clear();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + ";");

            while (resultSet.next()) {
                Disciplines disciplines  = new Disciplines();
                disciplines.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_education"),
                        resultSet.getInt("id_speciality"),
                        resultSet.getString("discipline"),
                        resultSet.getInt("sem_exam"),
                        resultSet.getInt("sem_zal"),
                        resultSet.getInt("sem_kp"),
                        resultSet.getInt("all_hours"),
                        resultSet.getInt("theory_hours"),
                        resultSet.getInt("lab_hours"),
                        resultSet.getInt("pract_hours"),
                        resultSet.getInt("hours_first"),
                        resultSet.getInt("hours_second"),
                        resultSet.getInt("hours_third"),
                        resultSet.getInt("hours_forth"),
                        resultSet.getInt("hours_fifth"),
                        resultSet.getInt("hours_sixth"),
                        resultSet.getInt("hours_seventh"),
                        resultSet.getInt("hours_eighth")
                );
                data.add(disciplines);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;

    }

    public ArrayList<Disciplines> getDisciplinesByIDSpecialty(String speciality_number) {
        try (Statement statement = db.getConnection().createStatement()){
            data.clear();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id_speciality = " + speciality_number +";");

            while (resultSet.next()) {
                Disciplines disciplines  = new Disciplines();
                disciplines.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_education"),
                        resultSet.getInt("id_speciality"),
                        resultSet.getString("discipline"),
                        resultSet.getInt("sem_exam"),
                        resultSet.getInt("sem_zal"),
                        resultSet.getInt("sem_kp"),
                        resultSet.getInt("all_hours"),
                        resultSet.getInt("theory_hours"),
                        resultSet.getInt("lab_hours"),
                        resultSet.getInt("pract_hours"),
                        resultSet.getInt("hours_first"),
                        resultSet.getInt("hours_second"),
                        resultSet.getInt("hours_third"),
                        resultSet.getInt("hours_forth"),
                        resultSet.getInt("hours_fifth"),
                        resultSet.getInt("hours_sixth"),
                        resultSet.getInt("hours_seventh"),
                        resultSet.getInt("hours_eighth")
                );
                data.add(disciplines);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
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
    public void update(Disciplines disciplines, String id) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("UPDATE " + DB_TABLE_NAME + " SET " +
                    "id_education ='" + disciplines.getId_education() + "', " +
                    "id_speciality ='" + disciplines.getId_speciality() + "', " +
                    "discipline ='" + disciplines.getDiscipline() + "', " +
                    "sem_exam ='" + disciplines.getSem_exam() + "', " +
                    "sem_zal ='" + disciplines.getSem_zal() + "', " +
                    "sem_kp ='" + disciplines.getSem_kp() + "', " +
                    "all_hours ='" + disciplines.getAll_hours() + "', " +
                    "theory_hours ='" + disciplines.getTheory_hours() + "', " +
                    "lab_hours ='" + disciplines.getLab_hours() + "', " +
                    "pract_hours ='" + disciplines.getPract_hours() + "', " +
                    "hours_first ='" + disciplines.getHours_first() + "', " +
                    "hours_second ='" + disciplines.getHours_second() + "', " +
                    "hours_third ='" + disciplines.getHours_third() + "', " +
                    "hours_forth ='" + disciplines.getHours_forth() + "', " +
                    "hours_fifth ='" + disciplines.getHours_fifth() + "', " +
                    "hours_sixth ='" + disciplines.getHours_sixth() + "', " +
                    "hours_seventh ='" + disciplines.getHours_seventh() + "', " +
                    "hours_eighth ='" + disciplines.getHours_eighth() +
                    "' WHERE id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
