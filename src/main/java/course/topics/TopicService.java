package course.topics;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*Business Services in Spring are singleton's.When application starts up spring creates instance of these services & keep in its memory.
 When other class depend on these services it declares dependency & spring inject the created instance to that class from its registry 
 or memory
*/

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	
	//lambda expression is used to find the specified id
	
	public Topic getTopic(String id) {
		Topic topic =  topicRepository.findById(id).get();
		return topic;
	}


	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}


	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}


	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
