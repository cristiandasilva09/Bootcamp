/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.mysql.conectmysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class TestService {
  
    public TestService() {
    }

    public void queryTest() throws SQLException, ClassNotFoundException {

        Connection conn;

        ConexionBD conexion = new ConexionBD();

        conn = conexion.Conection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from student");

        // ResultSet rs = pConsulta.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("FirstName"));
        }

        rs.close();
        conn.close();

    }

    public void queryExcersice5() throws SQLException, ClassNotFoundException {

        Connection conn;

        ConexionBD conexion = new ConexionBD();

        conn = conexion.Conection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(" select  t.FirstName,t.lasttName,\n" +
"ST.dayOfTheWeek, ST.initTime,ST.endTime,ST.nameCourse \n" +
" from Teacher T\n" +
" join course C on T.idTTeacher=C.assignedTeacher\n" +
" join scheduleTime ST on C.name=ST.nameCourse\n" +
"order by  ST.dayOfTheWeek, ST.initTime;");

        // ResultSet rs = pConsulta.executeQuery();
        
        while (rs.next()) {
            Date date=rs.getDate("ST.dayOfTheWeek");
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
          //  System.out.println( cal.get(Calendar.DAY_OF_WEEK));
            String day= null;
            if(cal.get(Calendar.DAY_OF_WEEK)==2)
                day="Monday";
            if(cal.get(Calendar.DAY_OF_WEEK)==3)
                day="Tuesday";
            if(cal.get(Calendar.DAY_OF_WEEK)==4)
                day="Wednseday";
            if(cal.get(Calendar.DAY_OF_WEEK)==6)
                day="Friday";
            
            System.out.println("Teacher:"+"<"+ rs.getString("T.lasttName")+">"+","+"<"+rs.getString("T.FirstName")+">");
            System.out.println("Schedule:");
            
            System.out.println((day )+rs.getString("St.initTime")+"-"+rs.getString("St.endTime")+":"+"<"+rs.getString("St.nameCourse")+">");
        }

        rs.close();
        conn.close();

    }
}
