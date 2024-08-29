package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.api.model.vo.User;

@Mapper
public interface UserMapper {
	
	void register(User user);
	User login(User user);
	User kakaoLogin(String email);
}
