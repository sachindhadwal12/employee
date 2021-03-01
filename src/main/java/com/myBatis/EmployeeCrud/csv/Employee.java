package com.myBatis.EmployeeCrud.csv;

import com.myBatis.EmployeeCrud.model.Employees;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class Employee {
    public  static  void writeObjectToCSV(PrintWriter writer, List<Employees> employees) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try (CSVPrinter csvPrinter =
        new CSVPrinter(
            writer,
            CSVFormat.DEFAULT.withHeader(
                "Emp_id",
                "Name",
                "doj",
                "Post_name",
                "Level",
                "Mobile_num",
                "Personal mail",
                "Office_mail",
                "Dob",
                "Blood_group",
                "mobile_num",
                "aadhaar_num")); ) {
            for(Employees empl : employees){

              List<? extends Serializable> data =  Arrays.asList(
                      empl.getEmp_id(),
                      empl.getFirst_name().concat(empl.getLast_name()),
                     df.format(empl.getDoj()),
                      empl.getPost_name(),
                      empl.getEmp_level(),
                      empl.getMobile_num(),
                      empl.getEmail_id(),
                      empl.getOffice_mail(),
                      df.format(empl.getDob()),
                      empl.getBlood_group(),
                      empl.getPan_num(),
                      empl.getAadhaar_num()


              );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
        }
        catch (Exception e){
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        }

    }
}
