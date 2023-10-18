package manytomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany.dto.Students;

public class StudentDao {

	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void saveStudents(Students students) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(students);
		entityTransaction.commit();
	}
	
	public void saveStudents(List<Students> students) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		for(Students student:students) {
			entityManager.persist(student);
		}
		entityTransaction.commit();
	}
	
	public void updateStudent(int id,Students students) {
		EntityManager entityManager=getEntityManager();
		Students dbStudents=entityManager.find(Students.class, id);
		if(dbStudents!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			students.setId(id);
//			keep eye on this everybody
			students.setCourses(dbStudents.getCourses());
			entityManager.merge(students);
			entityTransaction.commit();
		}else {
			System.out.println("sorry id is not present");
		}
	}
	
	public void findStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Students dbStudents=entityManager.find(Students.class, id);
		if(dbStudents!=null) {
			System.out.println(dbStudents);
		}else {
			System.out.println("sorry id is not present");
		}
	}
	public void deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Students dbStudents=entityManager.find(Students.class, id);
		if(dbStudents!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbStudents);
			entityTransaction.commit();
		}else {
			System.out.println("sorry id is not present");
		}
	}
	
	
}
