package ns.org.app.ud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ns.org.app.ud.entity.UserAccountEntity;
import ns.org.app.ud.entity.UserEntity;
import ns.org.app.ud.repo.UserRepo;

@RestController
public class UserController {
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/user")
	public UserEntity create(@RequestBody UserEntity user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		List<UserAccountEntity> accounts = new ArrayList<>();
		user.getUserAccount().forEach(account -> {
			account.setUser(userEntity);
			accounts.add(account);
		});
		userEntity.setUserAccount(accounts);
		return userRepo.save(userEntity);
	}

	@PostMapping("/user/{id}/account")
	public UserEntity create(@PathVariable("id") Long id, @RequestBody UserAccountEntity userAccount) {
		Optional<UserEntity> user = userRepo.findById(id);
		if (user.isPresent()) {
			UserEntity userEntity = user.get();
			userAccount.setUser(userEntity);
			userEntity.getUserAccount().add(userAccount);
			return userRepo.save(userEntity);
		} else {
			return null;
		}
	}

	@GetMapping("/user/{id}")
	public Optional<UserEntity> get(@PathVariable("id") Long id) {
		return userRepo.findById(id);
	}

	@GetMapping("/user/{id}/account-type/{type}")
	public UserEntity get(@PathVariable("id") Long id, @PathVariable("type") String type) {
		return userRepo.findByIdAndUserAccountType(id, type);
	}

}
