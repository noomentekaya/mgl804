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
		Scanner scanner = new Scanner(System.in);
		int choice ;

		Category category = new Category(cc ->{
			cc.category("old progressive rock");
			cc.choice(1);
			cc.addQuestion(new Question(qq ->{
				qq.text("What Year was released in The court of the crimson king");
				qq.addAnswer(new Answer(aa->{
					aa.answer("1969");
					aa.correct(true);
					
				}));
				
				qq.addAnswer(new Answer(aa->{
					aa.answer("1970");
					aa.correct(false);
				}));
				qq.addAnswer(new Answer(aa->{
					aa.answer("1971");
					aa.correct(false);
				}));
				qq.category(cc.getCategory()); 

				
			}));
			
		});
		Category category2 = new Category(cc ->{
			cc.category("Progressive metal");
			cc.choice(2);
			cc.addQuestion(new Question(qq ->{
				qq.text("What Year was released Paradise lost of Symphony X");
				qq.addAnswer(new Answer(aa->{
					aa.text("2007");
					aa.correct(true);
				}));
				qq.addAnswer(new Answer(aa->{
					aa.text("2008");
					aa.correct(false);
				}));
				qq.addAnswer(new Answer(aa->{
					aa.text("2008");
					aa.correct(false);
				}));
				qq.category(cc.getCategory()); 

				
			}));
		});
		Category category3 = new Category(cc ->{
			cc.category("Modern Progressive rock");
			cc.choice(3);
			cc.addQuestion(new Question(qq ->{
				qq.text("Who is the former procupine tree drummer");
				qq.addAnswer(new Answer(aa->{
					aa.text("Gavin Harrison");
					aa.correct(true);
				}));
				qq.addAnswer(new Answer(aa->{
					aa.text("Mike Portnoy");
					aa.correct(false);
				}));
				qq.addAnswer(new Answer(aa->{
					aa.text("Martin Axenrot");
					aa.correct(false);
				}));
				qq.category(cc.getCategory()); 

				
			}));
		});
		

		List<Category> cat = new ArrayList<>();
		cat.add(category);
		cat.add(category2);
		cat.add(category3);
		DslQuizz dsl = new DslQuizz();
		System.out.println("Categories :");
		int ordre = 0;
		for (Category c : cat ){
			System.out.println(ordre+" - "+c.getCategory());
		}
		
		choice = scanner.nextInt();
		int i = 0 ;
		while (i<=cat.size()){
				dsl.runQuiz(cat.get(i));
				break;
			
			
			}
			
		}
		
				
		
	}


