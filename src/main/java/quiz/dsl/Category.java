package quiz.dsl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Category {
	@Id
	private String id ;
	private int choice;
	private String category;
	private List<Question> questions = new ArrayList<>();
	
 public  Category(CategoryBuilder cb){
	 cb.builder(this);
 }
 public Category(){
	 
 }
 protected void choice (int choice)
 {
	 this.choice = choice;
 }
 protected void category(String category){
	 this.category=category;
 }
 protected void questions(List<Question> questions){
	 this.questions=questions;
	 
 }
 

public String getCategory() {
	return category;
}
public int getChoice() {
	return choice;
}

public List<Question> getQuestions() {
	return questions;
}
public void addQuestion (Question q){
	questions.add(q);
}
 
}
