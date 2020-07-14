package com.example.myapplication.helper;

import android.database.Observable;

import com.example.myapplication.data.model.User;

import java.util.List;

public interface DbHelper {
//    Observable<List<Question>> getAllQuestions();

//    Observable<List<User>> getAllUsers();

//    Observable<List<Option>> getOptionsForQuestionId(Long questionId);

    Observable<Boolean> insertUser(final User user);

//    Observable<Boolean> isOptionEmpty();
//
//    Observable<Boolean> isQuestionEmpty();

//    Observable<Boolean> saveOption(Option option);
//
//    Observable<Boolean> saveOptionList(List<Option> optionList);
//
//    Observable<Boolean> saveQuestion(Question question);
//
//    Observable<Boolean> saveQuestionList(List<Question> questionList);
}
