package tse.app_distri.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tse.app_distri.projet.Job;

@Controller
@RequestMapping(path="/jobs")
public class JobController {
	@Autowired
	private JobRepository jobRepository;
	
	@GetMapping(path="/list")
	public @ResponseBody Iterable<Job> getAllJobs(){
		return jobRepository.findAll();
	}
	
	@PostMapping(path="/update")
	public @ResponseBody String updateJob(@RequestParam String id, 
			@RequestParam String title){
		Job job = jobRepository.findOne(id);
		job.setJobTitle(title);
		jobRepository.save(job);
		return "Updated";
	}
}
