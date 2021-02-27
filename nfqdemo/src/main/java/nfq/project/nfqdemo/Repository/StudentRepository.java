package nfq.project.nfqdemo.Repository;

import nfq.project.nfqdemo.Domain.Entities.Student;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface StudentRepository extends CrudRepository<Student, Integer> {

}