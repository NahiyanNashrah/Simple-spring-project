package course.courses;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Courses> getAllCourses(String topicId){
		List<Courses> course = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(course::add);
		return course;
	}
	
	
	public Courses getCourse(String id) {
		Courses course =  courseRepository.findById(id).get();
		return course;
	}


	public void addCourse(Courses course) {
		courseRepository.save(course);
	}


	public void updateCourse(Courses course) {
		courseRepository.save(course);
	}


	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
