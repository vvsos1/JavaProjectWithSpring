package user.vo;

import org.dimigo.exception.InvalidArguementException;
import org.dimigo.util.CommonUtil;

/**
 * <pre>
 * org.dimigo.vo |_ UserVo
 *
 * 1. 개요 : 2. 작성일 : 2017. 9. 27.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class UserVo {

	private String id;
	private String pwd;
	private String grade;
	private String classroom;
	private String number;
	private String name;

	public UserVo() {
		super();
	}

	public UserVo(String id) {
		super();
		this.id = id;
	}

	public UserVo(String id, String grade, String classroom, String number, String name) {
		super();
		this.id = id;
		this.grade = grade;
		this.classroom = classroom;
		this.number = number;
		this.name = name;
	}

	public UserVo(String id, String pwd, String grade, String classroom, String number, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.grade = grade;
		this.classroom = classroom;
		this.number = number;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "UserVo [id=" + id + ", pwd=" + pwd + ", grade=" + grade + ", classroom=" + classroom + ", number="
				+ number + ", name=" + name + "]";
	}

	public void validate() throws InvalidArguementException {
		if (CommonUtil.isEmpty(id))
			throw new InvalidArguementException("아이디를 입력하세요");
		if (CommonUtil.isEmpty(pwd))
			throw new InvalidArguementException("비밀번호를 입력하세요");
		if (CommonUtil.isEmpty(name))
			throw new InvalidArguementException("이름를 입력하세요");
		if (CommonUtil.isEmpty(grade))
			throw new InvalidArguementException("학년을 입력하세요");
		if (CommonUtil.isEmpty(classroom))
			throw new InvalidArguementException("반을 입력하세요");
		if (CommonUtil.isEmpty(number))
			throw new InvalidArguementException("번호를 입력하세요");

	}
}
