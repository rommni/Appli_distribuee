package tse.app_distri.projet;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import tse.app_distri.projet.Job;

@RestController
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
	@PostMapping(path="/above")
	public @ResponseBody Iterable<Job> POSTgetJobsAbove(@RequestParam String amount){
		List<Job> jobs = (List<Job>) jobRepository.findAll();
		Iterator<Job> it = jobs.iterator();
		while(it.hasNext())
		{
			Job current = it.next();
			if(current.getMinSalary().doubleValue() <= Double.parseDouble(amount)) it.remove();
		}
		Collections.sort(jobs, new Comparator<Job>() {
	        @Override
	        public int compare(Job job2, Job job1)
	        {

	            return  job2.getMinSalary().compareTo(job1.getMinSalary());
	        }
	    });
		return jobs;
	}
 

}
