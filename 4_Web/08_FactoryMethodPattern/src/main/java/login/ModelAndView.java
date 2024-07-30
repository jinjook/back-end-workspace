package login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ModelAndView {
	
	private String path; // 마지막에 어디서 응답할건지 경로
	private boolean isRedirect; // forward or sendRedirect 
	
	// path만 가지는 생성자도 필요 (boolean 기본값 false)
	public ModelAndView(String path) {
		this.path = path;
		this.isRedirect = false;
	}
	
}
