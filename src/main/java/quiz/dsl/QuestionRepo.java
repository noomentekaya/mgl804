package quiz.dsl;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface QuestionRepo extends MongoRepository<Question, String> {

}