package course.topics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	
/*Autowired marks which needs dependency injection.It injected the created TopicService instance(this instance is created once
 by the spring when the program starts)  to this.
 */
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> showTopics() {
		return topicService.getAllTopics();
	}
	
	
	/* curly braces is used for declaring variable.
	 By using @PathVariable in the method parameter, we specify that the argument is received from url's variable part. 
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	/*map this method to any request that is post on this '/topics' url
	 spring requestmapping is by default GET method.To specify POST we need to declare in this way
	*/
	@RequestMapping(method = RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(id,topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
	}

}
