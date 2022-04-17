package com.dao;
import com.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class GroupDAO implements Dao<Group>{
    Database db;
    Group group = new Group();
    private static final String DB_TABLE_NAME = "groupe";


    //TODO зробити всюди масиви з назвами класів замість data
    ArrayList<Group> groupArrayList = new ArrayList<>();

    @Autowired
    public GroupDAO(Database db) {
        this.db = db;
    }

    @Override
    public void save(Group data) {
        try (Statement statement = db.getConnection().createStatement()) {
            statement.executeUpdate("INSERT INTO " + DB_TABLE_NAME + "" +
                    " (id_speciality, group_name,  students_amount) VALUES " +
                    "('" + data.getId_speciality() + "', '" + data.getGroup_name() + "" +
                    "', '"+ data.getStudents_amount() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Group get(String id) {
        try (Statement statement = db.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id = " + id +";");
            while (resultSet.next()) {
                group.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_speciality"),
                        resultSet.getString("group_name"),
                        resultSet.getInt("students_amount")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public ArrayList<Group> getAll() {

        try (Statement statement = db.getConnection().createStatement()){
            groupArrayList.clear();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + ";");

            while (resultSet.next()) {
                Group group = new Group();
                group.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_speciality"),
                        resultSet.getString("group_name"),
                        resultSet.getInt("students_amount")
                );
                groupArrayList.add(group);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupArrayList;
    }

    public ArrayList<Group> getGroupByIdSpecialty(String id_speciality) {

        try (Statement statement = db.getConnection().createStatement()){
            groupArrayList.clear();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id_speciality = " + id_speciality +";");

            while (resultSet.next()) {
                Group group = new Group();
                group.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_speciality"),
                        resultSet.getString("group_name"),
                        resultSet.getInt("students_amount")
                );
                groupArrayList.add(group);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupArrayList;
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
    public void update(Group group, String id)  {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("UPDATE " + DB_TABLE_NAME +
                    " SET id_speciality ='" + group.getId_speciality() +
                    "', group_name ='" + group.getGroup_name() +
                    "', students_amount ='" + group.getStudents_amount() +
                    "' WHERE id=" + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

