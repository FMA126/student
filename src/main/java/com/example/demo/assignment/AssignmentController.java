package com.example.demo.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping
    public List<Assignment> getAssignments() {
        return assignmentService.getAssignments();
    }

    @PostMapping
    public void registerNewAssignment(@RequestBody Assignment assignment) {
        assignmentService.addNewAssignment(assignment);
    }

    @DeleteMapping(path = "{assignmentId}")
    public void deleteAssignment(@PathVariable("assignmentId") Long assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
    }

    @PutMapping(path = "{assignmentId}")
    public void updateAssignment(
            @PathVariable("assignmentId") Long assignmentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        assignmentService.updateAssignment(assignmentId, name);
    }
}
