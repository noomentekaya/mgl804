package quiz.dsl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private QuestionRepo questionrepository;
	@Autowired
	private AnswerRepo answerrepo;
	@Autowired
	private CategoryRepo catrepo ;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		//Answer a = new Answer("Opeth", true);
		
		//Answer a1 = new Answer("Katatonia", false);
		//Answer a2 = new Answer("In flames", false);
		
		
		Answer a = new Answer (aa -> {
			aa.answer("Opeth");
			aa.correct(true);
		});
		Answer a1 = new Answer (aa -> {
			aa.answer("Katatonia");
			aa.correct(false);
		});
		Answer a2 = new Answer (aa -> {
			aa.answer("inflames");
			aa.correct(false);
		});
	
		//Question q = new Question(answers, "Band who release Still Life in 1999");
		List<Answer> answers = new ArrayList<>();
		
		
		
		answers.add(a);
		answers.add(a1);
		answers.add(a2);
	
	//	Question qq = new Question(new ArrayList<>(), "ss");
		Question q = new Question(qs -> {
			qs.text("Who released Still life in 1999");
			qs.answers(answers);
		});
		questionrepository.save(q);
		
		a.text(q.text);
		a1.text(q.text);
		a2.text(q.text);
		answerrepo.save(a);
		answerrepo.save(a1);
		answerrepo.save(a2);
		List<Question> questions = new ArrayList<>();
		questions.add(q);
		Category c = new Category(cat->{
		cat.category("Metal");
		cat.questions(questions);
		});
		catrepo.save(c);
		DslQuizz dsl = new DslQuizz();
		
		for(Question question : catrepo.findByCategory("Metal")){
		for(Answer answer: answerrepo.findByText(question.text)){
			System.out.println(answer);
			if (answer.isCorrect()){
				dsl = new DslQuizz(dslq ->{
					dslq.question(question);

					dslq.Right(answer);});
				
			}else
			{
				dsl = new DslQuizz(dslq ->{
					dslq.question(question);

					dslq.Wrong(answer);});
				
			}
//			dsl = new DslQuizz(dslq ->{
//				dslq.question(question);
//				if(answer.isCorrect()){
//
//				dslq.rightAnswer(answer);}
//				else{
//					dslq.wrongAnswer(answer);}
//						
//			});
				
			

			
		}

		}
		dsl.runQuiz();
		
	}

}
