package nfq.project.nfqdemo.Repository;

import nfq.project.nfqdemo.Domain.Entities.Project;
import org.springframework.data.repository.CrudRepository;


public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
