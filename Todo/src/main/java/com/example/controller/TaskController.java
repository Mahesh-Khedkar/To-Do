package com.example.controller;

import com.example.daos.TaskDao;
import com.example.daos.UserDao;
import com.example.entity.Task;
import com.example.service.Helper;
import com.example.service.TaskAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/todo")
public class TaskController {

    @Autowired
    private TaskAction Taskaction;

    @Autowired
    private UserDao userdao;
    @Autowired
    private TaskDao taskdao;

    Task task=new Task();
    @Autowired
    Helper helper = new Helper();

    @PostMapping("/registerList")
    public ResponseEntity<?> getTask(@RequestBody Task task){
        System.out.println(" details"+task);

        task.setDate(helper.currentDateAndTime());

        Task saved = Taskaction.register(task);

        if(saved!=null)
        {
            return ResponseEntity.ok("Task registered successful");
        }
        else
            return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping("/viewTasks")
    public ResponseEntity<?> viewTask(@RequestBody String userId){
        String str = userId.substring(0,userId.length()-1);
        try {
            System.out.println(str);
            List<Task> getTask = taskdao.findByUserId(str);
            System.out.println("Its returning" +getTask);
            return ResponseEntity.ok(getTask);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @PostMapping("/DeleteTask")
    public ResponseEntity<?> cancelTask(@RequestBody String Id){
        System.out.println(Id);
        String s=Id.substring(0,Id.length()-1);
        try {
            taskdao.deleteById(Integer.parseInt(s));
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

	@GetMapping("/ViewAllTasks")
	public ResponseEntity<?> viewAllTasks(){
		try {
			List<Task> gettasks = taskdao.findAll();
			System.out.println(gettasks);
			return ResponseEntity.ok(gettasks);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	@PostMapping("/CompletedTask")
	public ResponseEntity<?> Completed(@RequestBody String Id){
		System.out.println(Id);
		System.out.println("In  completed");
		String s=Id.substring(0,Id.length()-1);
		try {
			taskdao.findById(Integer.parseInt(s));

			return ResponseEntity.ok("Completed successfully");
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}


