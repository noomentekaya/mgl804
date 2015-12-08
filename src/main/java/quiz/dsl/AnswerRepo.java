package quiz.dsl;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import hello.Track;


public interface AnswerRepo extends MongoRepository<Answer, String> {
	public List<Answer> findByText(String Text);
}