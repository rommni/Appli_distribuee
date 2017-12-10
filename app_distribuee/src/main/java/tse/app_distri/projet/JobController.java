package tse.app_distri.projet;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api(value="onlinestore", description="Operations pertaining to manage jobs")
public class JobController {
	@Autowired
	private JobRepository jobRepository;
	
	@ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	
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
