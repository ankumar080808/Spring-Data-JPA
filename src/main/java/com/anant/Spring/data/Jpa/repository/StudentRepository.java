package com.anant.Spring.data.Jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anant.Spring.data.Jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	
	List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName,
                                       String lastName);
    
    //JPQL---it is based on entity name  and its attributes names not on table name and its column names
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);
    
    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);
    
    //Native its based on table attributes and column names
    @Query(
    	value="SELECT * from Student_Table s where s.email_address=?1",
    	nativeQuery=true
    		
    		)
    Student getStudentByEmailAddressNative(String emailId);
    
    //Native named param
    @Query(
        	value="SELECT * from Student_Table s where s.email_address= :emailId",
        	nativeQuery=true
        		
        		)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
    
    @Modifying
    @Transactional
    @Query(
    		value="UPDATE Student_Table SET first_name=?1 where email_address=?2",
    		nativeQuery=true
    		)
    
    int updateStudentByEmailId(String firstName,String emailId);

}
