package quiz.dsl;

import java.util.ArrayList;
import java.util.List;

public class Quizz {

	List<Question> questions =  new ArrayList<>() ;
	
	public Quizz(QuizzBuilder qb){
		qb.build(this);
	}
	
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	protected void questions(List<Question> questions) {
		this.questions = questions;
	}
	
	
	public Quizz(List<Question> questions) {
		super();
		this.questions = questions;
	}
	public Quizz() {
		// TODO Auto-generated constructor stub
	}
	public void category(Category c){
		c.questions(questions);
	}

	public void addQuestion (Question q){
		questions.add(q);
	}
	
	public Question lastQuestion(){
		return questions.get(questions.size()-1);
			
	}
	public void runQuiz (){
		int count = 0;
		
		for (Question q : questions){
			count = count+q.ask();
		}
		System.out.println("you have got "+count+" out of "+ questions.size()+" questions");
	}
}
