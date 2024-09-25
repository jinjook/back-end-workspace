package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

@Mapper
public interface BoardMapper {
	void insert(Board bo);
	List<Board> allList(Paging paging);
	int total();
	Board detail(int no);
	void update(Board vo);
	void delete(int no);
}
