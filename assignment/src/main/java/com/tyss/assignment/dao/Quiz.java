package com.tyss.assignment.dao;

import java.util.Date;

import com.tyss.assignment.dto.QuizQuestions;
import com.tyss.assignment.dto.Register;
import com.tyss.assignment.dto.Results;

public interface Quiz {

	abstract Register logIn(String username, String password);

	abstract Register register(Register register);

	abstract QuizQuestions questions(int id);

	abstract void results(Results results);

	abstract Results getResults(Date date);

}
