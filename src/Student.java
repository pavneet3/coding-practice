import java.util.Date;
		
		
public final class Student {

	private Integer id;
	private Date dob;

	public Student(Integer id, Date dob) {
		super();
		this.id = id;
		this.dob = (Date) dob.clone();
	}

	public Integer getId() {
		return id;
	}

	public Date getDob() {
		return (Date) dob.clone();
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	static void updateStudent(Student s) {
		s.setId(2);
		s = new Student(3, new Date());
	}

	public static void main(String[] args) {
		Student s = new Student(1, new Date());
		System.out.println(s.getId()); // 1
		updateStudent(s);
		System.out.println(s.getId()); // 2
	}
	
}
