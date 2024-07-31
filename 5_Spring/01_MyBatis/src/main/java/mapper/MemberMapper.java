package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.vo.Member;

@Mapper // 연결 도구 - (member.xml)과 1:1 연결
public interface MemberMapper {
	void register(Member member);
	// 받는 결과 값 없기 때문에 void로 받음
	
	List<Member> allMember();
	
	Member login(Member member);
	//1:1 매칭 - resultType: Member , id:login, parameterType: Member
	
	void update(Member member);
}
