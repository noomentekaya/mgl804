package quiz.dsl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.annotation.Id;

public class Question {
	@Id
	private String id ;
	List<Answer> answers = new ArrayList<>();
	String text;
	String category;
	public Question (QuestionBuilder qb){
		qb.buildQuestion(this);
	}
	public Question(){
		
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	private void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public String getText() {
		return text;
	}
	private void setText(String text) {
		this.text = text;
	}
	
	protected void answers(List<Answer> answers) {
		this.answers = answers;
	}
	
	protected void text(String text) {
		this.text = text;
	}
	public Question(List<Answer> answers, String text) {
		super();
		this.answers = answers;
		this.text = text;
	}
	protected void addAnswer(Answer answer){
		answers.add(answer);
	}
	public void category(String category){
		this.category= category;
	}
	
	//public List<Question> question()
	protected int ask(){
		System.out.println(text);
		int i =1;
		for(Answer a : answers){
			System.out.println(i++ +" - "+a.getAnswer());
		}
		System.out.println("enter answer :");
		Scanner scanner = new Scanner(System.in);
		int ans =scanner.nextInt();
		int correct=0 ;
		for(Answer a : answers){
			if (a.isCorrect()){
				System.out.println(a);
				correct++;
			}
		}
		return correct;

		
	}
}
