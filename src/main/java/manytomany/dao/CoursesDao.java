package manytomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany.dto.Courses;

public class CoursesDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void saveCourses(Courses courses) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(courses);
		entityTransaction.commit();
	}

	public void saveCourses(List<Courses> courses) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		for (Courses c : courses) {
			entityManager.persist(c);
		}
		entityTransaction.commit();
	}

	public void updateCourses(int id, Courses courses) {
		EntityManager entityManager = getEntityManager();
		Courses dbCourses = entityManager.find(Courses.class, id);
		if (dbCourses != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			courses.setId(id);
			entityManager.merge(courses);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry id is not pressent");
		}
	}

    public void deleteCourses(int id) {
    	EntityManager entityManager=getEntityManager();
    	Courses dbCourses=entityManager.find(Courses.class, id);
    	if(dbCourses!=null) {
    		EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbCourses);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry id is not pressent");
		}
    }

    public void findCourses(int id) {
    	EntityManager entityManager=getEntityManager();
    	Courses dbCourses=entityManager.find(Courses.class, id);
    	if(dbCourses!=null) {
    		System.out.println(dbCourses);
		} else {
			System.out.println("Sorry id is not pressent");
		}
    }
    
    
    
    
    
    
    
    
    
    
    
}
