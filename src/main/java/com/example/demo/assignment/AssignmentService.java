package com.example.demo.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> getAssignments() {
        return assignmentRepository.findAll();
    }

    public void addNewAssignment(Assignment assignment) {
        Optional<Assignment> assignmentOptional = assignmentRepository
                .findAssignmentByName(assignment.getName());
        if(assignmentOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        assignmentRepository.save(assignment);
    }

    public void deleteAssignment(Long assignmentId) {
        boolean exists = assignmentRepository.existsById(assignmentId);
        if (!exists) {
            throw new IllegalStateException("assignment with id " + assignmentId + " does not exist");
        }
        assignmentRepository.deleteById(assignmentId);
    }

    @Transactional
    public void updateAssignment(Long assignmentId, String name) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new IllegalStateException(
                        "assignment with id " + assignmentId + " does not exist"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(assignment.getName(), name)) {
            assignment.setName(name);
        }

        if (name != null && name.length() > 0 && !Objects.equals(assignment.getName(), name)) {
            Optional<Assignment> assignmentOptional = assignmentRepository
                    .findAssignmentByName(name);
            if (assignmentOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }

            assignment.setName(name);
        }
    }
}
