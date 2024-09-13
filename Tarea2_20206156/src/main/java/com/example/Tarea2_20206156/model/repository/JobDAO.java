/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Tarea2_20206156.model.repository;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.example.Tarea2_20206156.model.bean.Job;

public class  JobDAO  extends BaseDAO {
    
   public ArrayList<Job> findAll() {

        ArrayList<Job> listaJob = new ArrayList<>();

        String sql = "select "
                + "j.job_id, j.job_title "
                + "from jobs j ";

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                
                Job job = new Job();
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));

                listaJob.add(job);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaJob;
    }


}
