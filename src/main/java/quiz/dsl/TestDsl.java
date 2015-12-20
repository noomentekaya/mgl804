package quiz.dsl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class TestDsl {
	@Mock
	Question q ;
	@Mock
	Answer a;
	@Mock
	Quizz quizz;
	@Mock
	DslQuizz dsl;
	@Mock
	Category c;
	@Mock
	List<Question> questions ;
	@Mock
	List<Answer> answers ;
	
	
	
	
	@Before
	public void SetUp (){
		
	}
	
	@Test
	public void test_One_Question_should_Have_One_Right_Answer() {
		int i = 0 ;
		for (Answer a : q.getAnswers()){
			if (a.isCorrect()){
				i++;
			}
			assertTrue(i==1);
		}
	}
	
	@Test
	public void test_One_Category_should_Have_Atleast_One_Question() {
		c.questions(questions);
		assertTrue(c.getQuestions().size()>=1);
	}
	
	@Test
	public void test_One_question_should_have_more_than_one_answer(){
		q.answers(answers);
		
		assertTrue(q.getAnswers().size()>1);
	}
	
	
	
	
	

}
