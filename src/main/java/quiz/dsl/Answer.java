package quiz.dsl;

import org.springframework.data.annotation.Id;

public class Answer {
	@Id
private String id ;
 public String answer ;
 public boolean correct ;
 public String text;
 
 
 public Answer(AnswerBuilder ab){
	 ab.build(this);
 }
 public Answer(){
	 
 }
public String getAnswer() {
	return answer;
}
protected void answer(String answer) {
	this.answer = answer;
}
public boolean isCorrect() {
	return correct;
}
protected void answer(){
	
}
protected void correct(boolean correct) {
	this.correct = correct;
}
public Answer(String answer, boolean correct) {
	super();
	this.answer = answer;
	this.correct = correct;
}
protected void text (String text){
	this.text= text;
}

 
}
