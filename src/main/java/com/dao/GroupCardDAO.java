package com.dao;
import com.models.GroupCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class GroupCardDAO implements Dao<GroupCard>{
    Database db;
    GroupCard groupCard = new GroupCard();
    private static final String DB_TABLE_NAME = "groupcard";
    ArrayList<GroupCard> groupCardsArrayList = new ArrayList<>();

    @Autowired
    public GroupCardDAO(Database db) {
        this.db = db;
    }

    @Override
    public void save(GroupCard data) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO " + DB_TABLE_NAME + " (" +
                    "id_group, " +
                    "discipline, " +
                    "gradebook_hours, " +
                    "theory_hours1, " +
                    "lab_hours1, " +
                    "pract_hours1, " +
                    "coursework1, " +
                    "all_hours1, " +
                    "theory_hours2, " +
                    "lab_hours2, " +
                    "pract_hours2, " +
                    "coursework2, " +
                    "all_hours2, " +
                    "all_hours_in_year, " +
                    "id_teacher) VALUES ('"
                    + data.getId_group() + "', '"
                    + data.getDiscipline() + "', '"
                    + data.getGradebook_hours() + "', '"
                    + data.getTheory_hours1() + "', '"
                    + data.getLab_hours1() + "', '"
                    + data.getPract_hours1() + "', '"
                    + data.getCoursework1() + "', '"
                    + data.getAll_hours1() + "', '"
                    + data.getTheory_hours2() + "', '"
                    + data.getLab_hours2() + "', '"
                    + data.getPract_hours2() + "', '"
                    + data.getCoursework2() + "', '"
                    + data.getAll_hours2() + "', '"
                    + data.getAll_hours_in_year() + "', '"
                    + data.getId_teacher() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public GroupCard get(String id)  {
        try (Statement statement = db.getConnection().createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id = " + id +";");

            while (resultSet.next()) {
                groupCard.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_group"),
                        resultSet.getInt("discipline"),
                        resultSet.getInt("gradebook_hours"),
                        resultSet.getInt("theory_hours1"),
                        resultSet.getInt("lab_hours1"),
                        resultSet.getInt("pract_hours1"),
                        resultSet.getInt("coursework1"),
                        resultSet.getInt("all_hours1"),
                        resultSet.getInt("theory_hours2"),
                        resultSet.getInt("lab_hours2"),
                        resultSet.getInt("pract_hours2"),
                        resultSet.getInt("coursework2"),
                        resultSet.getInt("all_hours2"),
                        resultSet.getInt("all_hours_in_year"),
                        resultSet.getInt("id_teacher")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupCard;
    }

    @Override
    public ArrayList<GroupCard> getAll() {
        try (Statement statement = db.getConnection().createStatement()){
            groupCardsArrayList.clear();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + ";");
            while (resultSet.next()) {
                GroupCard groupCard = new GroupCard();
                groupCard.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_group"),
                        resultSet.getInt("discipline"),
                        resultSet.getInt("gradebook_hours"),
                        resultSet.getInt("theory_hours1"),
                        resultSet.getInt("lab_hours1"),
                        resultSet.getInt("pract_hours1"),
                        resultSet.getInt("coursework1"),
                        resultSet.getInt("all_hours1"),
                        resultSet.getInt("theory_hours2"),
                        resultSet.getInt("lab_hours2"),
                        resultSet.getInt("pract_hours2"),
                        resultSet.getInt("coursework2"),
                        resultSet.getInt("all_hours2"),
                        resultSet.getInt("all_hours_in_year"),
                        resultSet.getInt("id_teacher")
                );
                groupCardsArrayList.add(groupCard);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupCardsArrayList;
    }


    public ArrayList<GroupCard> getByTeacher(String teacher)  {
        try (Statement statement = db.getConnection().createStatement()){
            groupCardsArrayList.clear();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id_teacher = " + teacher +";");

            while (resultSet.next()) {
                GroupCard groupCard = new GroupCard();
                groupCard.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_group"),
                        resultSet.getInt("discipline"),
                        resultSet.getInt("gradebook_hours"),
                        resultSet.getInt("theory_hours1"),
                        resultSet.getInt("lab_hours1"),
                        resultSet.getInt("pract_hours1"),
                        resultSet.getInt("coursework1"),
                        resultSet.getInt("all_hours1"),
                        resultSet.getInt("theory_hours2"),
                        resultSet.getInt("lab_hours2"),
                        resultSet.getInt("pract_hours2"),
                        resultSet.getInt("coursework2"),
                        resultSet.getInt("all_hours2"),
                        resultSet.getInt("all_hours_in_year"),
                        resultSet.getInt("id_teacher")
                );
                groupCardsArrayList.add(groupCard);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupCardsArrayList;
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
    public void update(GroupCard groupCard, String id) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("UPDATE " + DB_TABLE_NAME + " SET " +
                    "id_group ='" + groupCard.getId_group() + "', " +
                    "discipline ='" + groupCard.getDiscipline() + "', " +
                    "gradebook_hours ='" + groupCard.getGradebook_hours() + "', " +
                    "theory_hours1 ='" + groupCard.getTheory_hours1() + "', " +
                    "lab_hours1 ='" + groupCard.getLab_hours1() + "', " +
                    "pract_hours1 ='" + groupCard.getPract_hours1() + "', " +
                    "coursework1 ='" + groupCard.getCoursework1() + "', " +
                    "all_hours1 ='" + groupCard.getAll_hours1() + "', " +
                    "theory_hours2 ='" + groupCard.getTheory_hours2() + "', " +
                    "lab_hours2 ='" + groupCard.getLab_hours2() + "', " +
                    "pract_hours2 ='" + groupCard.getPract_hours2() + "', " +
                    "coursework2 ='" + groupCard.getCoursework2() + "', " +
                    "all_hours2 ='" + groupCard.getAll_hours2() + "', " +
                    "all_hours_in_year ='" + groupCard.getAll_hours_in_year() + "', " +
                    "id_teacher ='" + groupCard.getId_teacher() +
                    "' WHERE id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
