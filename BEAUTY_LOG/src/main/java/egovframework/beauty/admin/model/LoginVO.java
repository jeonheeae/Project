package egovframework.beauty.admin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO extends DefaultVO{

	private static final long serialVersionUID = 1L;
	
	private int admSn;				// 관리자 일련번호
	private String admId;			// 관리자 아아디
	private String admPwd;			// 관리자 비밀번호
	
	

}
