//package com.sanjanaDemoProject.demoProject;
//
//import java.io.Serializable;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
//public class StudentSeqGenerator implements IdentifierGenerator {
//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//        String prefix = "Customer";
//        String suffix = "";
//        try {
//            CustomerRepository customer = session.customer();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select count(id) from student");
//            if(resultSet.next()) {
//                Integer id = resultSet.getInt(1) + 1;
//                suffix = id.toString();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return prefix + suffix;
//    }
//}