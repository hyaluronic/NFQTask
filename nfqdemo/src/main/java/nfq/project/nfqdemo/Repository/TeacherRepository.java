package nfq.project.nfqdemo.Repository;

import nfq.project.nfqdemo.Domain.Entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
