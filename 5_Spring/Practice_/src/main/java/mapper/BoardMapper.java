package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;

@Mapper
public interface BoardMapper {
	List<Board> allList();
	void insertBoard(Board board);
	Board selectList(int no);
	void updateContent(Board board);
	void deleteContent(int no);
}
