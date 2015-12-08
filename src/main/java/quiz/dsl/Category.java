package quiz.dsl;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Category {
	@Id
	private String id ;
	private String category;
	private List<Question> questions;
	
 public  Category(CategoryBuilder cb){
	 cb.builder(this);
 }
 public Category(){
	 
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

public List<Question> getQuestions() {
	return questions;
}
 
}
