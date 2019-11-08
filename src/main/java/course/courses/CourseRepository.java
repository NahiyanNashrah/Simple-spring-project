package course.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Courses,String>{
 
	/*If the property is string We have to declare the property name followed by 'findBy' according to
	 which we want to filter.Bt if its a class then we have to specify the property of that class*/
	
	public List<Courses>findByTopicId(String topicId);
	
}
