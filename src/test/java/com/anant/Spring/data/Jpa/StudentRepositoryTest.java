package com.anant.Spring.data.Jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anant.Spring.data.Jpa.entity.Guardian;
import com.anant.Spring.data.Jpa.entity.Student;
import com.anant.Spring.data.Jpa.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student.builder().emailId("anant@gmail.com").firstName("Anant").lastName("Kumar")
				//.guardianEmail("Vinod@gmail.com")
				//.guardianName("Vinod")
				//.guardianMobile("1234")
				.build();

		studentRepository.save(student);

	}
	
	@Test
	public void saveStudentWithGuardian()
	{
		
		Guardian guardian=Guardian.builder()
				.name("jitendra")
				.email("jitendra@gmail.com")
				.mobile("1111")
				.build();
		Student student = Student.builder()
				.firstName("Agastay")
				.lastName("Chauhan")
				.emailId("agastay@gmail.com")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
		
	}
    
	@Test
	public void printAllStudent() {

		List<Student> studentList = studentRepository.findAll();

		System.out.print("Students_List = " + studentList);
	}
	
	  @Test
	    public void printStudentByFirstName() {
	        
	        List<Student> students =
	                studentRepository.findByFirstName("Anant");

	        System.out.println("students = " + students);
	    }
	  
	  @Test
	    public void printStudentByFirstNameContaining() {

	        List<Student> students =
	                studentRepository.findByFirstNameContaining("an");

	        System.out.println("students = " + students);
	    }
	  
	  @Test
	    public void printStudentByLastNameNotNull() {

	        List<Student> students =
	                studentRepository.findByLastNameNotNull();

	        System.out.println("students = " + students);
	    }
   
	  @Test
	    public void printStudentBasedOnGuardianName(){
	        List<Student> students =
	                studentRepository.findByGuardianName("Vipin");
	        System.out.println("students = " + students);
	    }
	  
	  @Test
	    public void printStudentBasedOnFirstNameAndLastName(){
	        Student student =
	                studentRepository.findByFirstNameAndLastName("Anant","Kumar");
	        System.out.println("students = " + student);
	    }
	  
	  @Test
	    public void printgetStudentByEmailAddressJPQL() {
	        Student student =
	                studentRepository.getStudentByEmailAddress(
	                        "vinita@gmail.com"
	                );

	        System.out.println("student = " + student);
	    }
	  
	  @Test
	    public void printgetStudentFirstNameByEmailAddress() {
	        String firstName =
	                studentRepository.getStudentFirstNameByEmailAddress(
	                        "vinita@gmail.com"
	                );
	        System.out.println("firstName = " + firstName);
	    }
	  
	  
	    @Test
	    public void printgetStudentByEmailAddressNative(){
	        Student student =
	                studentRepository.getStudentByEmailAddressNative(
	                        "vinita@gmail.com"
	                );

	        System.out.println("student = " + student);
	    }
	    
	    @Test
	    public void printgetStudentByEmailAddressNativeNamedParam() {
	        Student student =
	                studentRepository.getStudentByEmailAddressNativeNamedParam(
	                        "vinita@gmail.com"
	                );

	        System.out.println("student = " + student);
	    }
	    
	    @Test
	    public void updateStudentNameByEmailId()
	    {
	    	studentRepository.updateStudentByEmailId("Anant Singh","anant@gmail.com");
	    }
}
