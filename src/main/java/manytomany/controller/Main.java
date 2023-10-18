package manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import manytomany.dao.CoursesDao;
import manytomany.dao.StudentDao;
import manytomany.dto.Courses;
import manytomany.dto.Students;

public class Main {
	public static void main(String[] args) {
		Students students1 = new Students();
		students1.setId(1);
		students1.setName("manisha");

		Courses courses1 = new Courses();
		courses1.setId(101);
		courses1.setName("java");
		courses1.setFees(10000);
		
		Courses courses2 = new Courses();
		courses2.setId(102);
		courses2.setName("AdvanceJava");
		courses2.setFees(10000);
		
		
		Courses courses3 = new Courses();
		courses3.setId(103);
		courses3.setName("sql");
		courses3.setFees(10000);
		

		List<Courses> coursesOfManisha=new ArrayList<Courses>();
		coursesOfManisha.add(courses1);
		coursesOfManisha.add(courses3);
		
		students1.setCourses(coursesOfManisha);
		
		Students students2=new Students();
		students2.setId(2);
		students2.setName("Shreya");
		
		students2.setCourses(coursesOfManisha);
		Students students3=new Students();
		students3.setId(3);
		students3.setName("Kanchan");
		
		List<Courses> coursesOfKanchan=new ArrayList<Courses>();
		coursesOfKanchan.add(courses1);
		coursesOfKanchan.add(courses2);
		coursesOfKanchan.add(courses3);
		
		
		
		CoursesDao coursesDao=new CoursesDao();
		
		coursesDao.saveCourses(coursesOfKanchan);
		
		StudentDao studentDao=new  StudentDao();
		List<Students> students=new ArrayList<Students>();
		students.add(students1);
		students.add(students2);
		students.add(students3);
		studentDao.saveStudents(students);
		
		
		
		
		
		
		
		
		
		
		
	}
}
