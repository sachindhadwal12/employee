package com.myBatis.EmployeeCrud.csv;

import com.myBatis.EmployeeCrud.model.Employees;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Employee {
    public  static  void writeObjectToCSV(PrintWriter writer, List<Employees> employees) throws IOException {
        try (
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Emp_id", "FirstName", "LastName","Gender",
                                "dob","pan_num",	"aadhaar_num",	"mobile_num"));
        ){
            for(Employees empl : employees){
              List<? extends Serializable> data =  Arrays.asList(
                      empl.getEmp_id(),
                      empl.getFirst_name(),
                      empl.getLast_name(),
                      empl.getGender(),
                      empl.getDob(),
                      empl.getPan_num(),
                      empl.getAadhaar_num(),
                      empl.getMobile_num()

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
