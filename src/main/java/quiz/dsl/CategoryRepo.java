package quiz.dsl;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface CategoryRepo extends MongoRepository<Category, String> {
	public List<Question> findByCategory(String category);
}