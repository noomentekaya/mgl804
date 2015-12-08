package quiz.dsl;

public class DslQuizz {
	
	 public DslQuizz(QuizzDslBuilder dsl) {
		// TODO Auto-generated constructor stub
		dsl.builder(this);
	}
	 public DslQuizz() {
			
		}
		
	
	Quizz quizz = new Quizz();
	protected void category (Category category){
		quizz.category(category);
	}
	
	protected void question (Question question){
		quizz.addQuestion(question);
		
	}
	public void Right(Answer a ){
		quizz.lastQuestion().addAnswer(a);
	}
	public void Wrong(Answer a ){
		quizz.lastQuestion().addAnswer(a);
	}
	public void runQuiz(){
		quizz.runQuiz();
	}

	
}
