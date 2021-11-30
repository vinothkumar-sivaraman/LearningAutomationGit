package org.learning.com;

import org.learningselenium.com.StudentForm;

public class GetStudentDetails extends StudentForm {

    public static void main(String[] args) {
        GetStudentDetails obj = new GetStudentDetails();
        obj.setSsn(23432432);
        System.out.println(obj.getSsn());
        obj.setSsn(2332);
        System.out.println(obj.getSsn());
    }
}
