package quiz.dsl;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface AnswerRepo extends MongoRepository<Answer, String> {
	public List<Answer> findByText(String Text);
}