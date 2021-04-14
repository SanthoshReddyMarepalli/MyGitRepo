package com.tyss.assignment.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.assignment.dto.QuizQuestions;
import com.tyss.assignment.dto.Register;
import com.tyss.assignment.dto.Results;

public class LoginDetails implements Quiz {

	EntityManagerFactory factory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public Register logIn(String username, String password) {
		try {

			Register login = null;
			factory = Persistence.createEntityManagerFactory("quiz");
			entityManager = factory.createEntityManager();
			login = entityManager.find(Register.class, username);
			return login;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return null;

	}

	@Override
	public Register register(Register register) {
		try {
			factory = Persistence.createEntityManagerFactory("quiz");
			entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(register);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();

			}

			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return register;

	}

	@Override
	public QuizQuestions questions(int id) {
		try {
			factory = Persistence.createEntityManagerFactory("quiz");
			entityManager = factory.createEntityManager();
			QuizQuestions questions = entityManager.find(QuizQuestions.class, id);
			return questions;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void results(Results results) {
		try {
			factory = Persistence.createEntityManagerFactory("quiz");
			entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(results);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}

	@Override
	public Results getResults(Date date) {
		Results results = null;
		try {
			factory = Persistence.createEntityManagerFactory("quiz");
			entityManager = factory.createEntityManager();
			results = entityManager.find(Results.class, date);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return results;
	}

}
