package ns.org.app.ud.repo;

import org.springframework.data.repository.CrudRepository;

import ns.org.app.ud.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

	UserEntity findByIdAndUserAccountType(Long id, String type);
}
