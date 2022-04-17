package com.dao;


import com.models.EducationPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class EducationPlanDAO implements Dao<EducationPlan>{
    private Database db;
    EducationPlan educationPlan =  new EducationPlan();
    public static final String DB_EDUCATIONPLAN = "EducationPlan";
    private ArrayList<EducationPlan> data = new ArrayList<EducationPlan>();


    @Autowired
    public EducationPlanDAO(Database db) {
        this.db = db;
    }

    @Override
    public void save(EducationPlan data)  {
        try (Statement statement = db.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO " + DB_EDUCATIONPLAN +
                    " (id_speciality,week1,week2,week3,week4,week5,week6,week7,week8) " +
                    " VALUES ('" +
                    data.getId_speciality() + "','" +
                    data.getWeek1() + "','" +
                    data.getWeek2() + "','" +
                    data.getWeek3() + "','" +
                    data.getWeek4() + "','" +
                    data.getWeek5() + "','" +
                    data.getWeek6() + "','" +
                    data.getWeek7() + "','" +
                    data.getWeek8()+ "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EducationPlan get(String pattern){
        try (Statement statement = db.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("Select * from "+ DB_EDUCATIONPLAN +" WHERE id="+ pattern + ";");

            while (resultSet.next()){
                educationPlan.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_speciality"),
                        resultSet.getInt("week1"),
                        resultSet.getInt("week2"),
                        resultSet.getInt("week3"),
                        resultSet.getInt("week4"),
                        resultSet.getInt("week5"),
                        resultSet.getInt("week6"),
                        resultSet.getInt("week7"),
                        resultSet.getInt("week8")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationPlan;
    }

    @Override
    public ArrayList<EducationPlan> getAll(){
        try (Statement statement = db.getConnection().createStatement()){
            data.clear();

            ResultSet resultSet = statement.executeQuery("Select * from " + DB_EDUCATIONPLAN + ";");

            while (resultSet.next()){
                EducationPlan educationPlan = new EducationPlan();
                educationPlan.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_speciality"),
                        resultSet.getInt("week1"),
                        resultSet.getInt("week2"),
                        resultSet.getInt("week3"),
                        resultSet.getInt("week4"),
                        resultSet.getInt("week5"),
                        resultSet.getInt("week6"),
                        resultSet.getInt("week7"),
                        resultSet.getInt("week8")
                );
                data.add(educationPlan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }


    public ArrayList<EducationPlan> findBySpeciality(String pattern) {
        try (Statement statement = db.getConnection().createStatement()){
            data.clear();
            ResultSet resultSet = statement.executeQuery("Select * from " + DB_EDUCATIONPLAN + "" +
                    " where id_speciality="+ pattern +";");
            while (resultSet.next()){
                EducationPlan educationPlan = new EducationPlan();
                educationPlan.setData(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_speciality"),
                        resultSet.getInt("week1"),
                        resultSet.getInt("week2"),
                        resultSet.getInt("week3"),
                        resultSet.getInt("week4"),
                        resultSet.getInt("week5"),
                        resultSet.getInt("week6"),
                        resultSet.getInt("week7"),
                        resultSet.getInt("week8")
                );
                data.add(educationPlan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void delete(String pattern) {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("DELETE FROM "+ DB_EDUCATIONPLAN +" WHERE id="+ pattern + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(EducationPlan data, String pattern)  {
        try (Statement statement = db.getConnection().createStatement()){
            statement.execute("UPDATE "+ DB_EDUCATIONPLAN +
                    " SET id_speciality=" +data.getId_speciality()+
                    ", week1=" +data.getWeek1()+
                    ", week2=" +data.getWeek2()+
                    ", week3=" +data.getWeek3()+
                    ", week4=" +data.getWeek4()+
                    ", week5=" +data.getWeek5()+
                    ", week6=" +data.getWeek6()+
                    ", week7=" +data.getWeek7()+
                    ", week8=" +data.getWeek8()+
                    " WHERE id=" +pattern+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
