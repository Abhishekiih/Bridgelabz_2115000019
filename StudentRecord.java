class Student{
	int rollNo;
	String name;
	int age;
	String grade;
	Student next;
	
	Student(int rollNo, String name, int age, String grade){
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}

class StudentRecord{
	private Student head;
	
	public void addStudent(int rollNo, String name, int age, String grade, int position){
		Student newStudent = new Student(rollNo, name, age, grade);
		
		if(position == 0 && head == null){
			newStudent.next = head;
			head = newStudent;
			return;
		}
		
		Student temp = head;
		int count = 0;
		while(temp.next != null && count < position-1){
			temp = temp.next;
			count++;
		}
		
		newStudent.next = temp.next;
		temp.next = newStudent;
	}
	
	public void deleteStudent(int rollNo){
		Student temp = head, prev = null;
		
		while(temp != null && temp.rollNo != rollNo ){
			prev = temp;
			temp = temp.next;
		}
		if(temp == null){
			System.out.println("Student with RollNo "+rollNo+" not found.");
			return;
		}
		
		if(prev != null ){
			prev.next = temp.next;
		}else{
			head = temp.next;
		}
		
		System.out.println("Student with RollNo "+rollNo+" deleted Successfully.");
	}

	public void searchStudent(int rollNo){
		Student temp = head;
		
		while(temp != null){
			if(temp.rollNo == rollNo){
				System.out.println("Student Found : RollNo : "+temp.rollNo+", Name : "+temp.name+", Age : "+temp.age+", Garde : "+temp.grade);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student with RollNo "+rollNo+" not found.");
	}
	
	public void displayStudents(){
		Student temp = head;
		
		while(temp == null){
			System.out.println("No Students record found.");
			return;
		}
		System.out.println("Students Records : ");
		while(temp != null){
			System.out.println("Student Found : RollNo : "+temp.rollNo+", Name : "+temp.name+", Age : "+temp.age+", Garde : "+temp.grade);
			temp = temp.next;
		}
	}
	
	public void updateGrade(int rollNo, String newGrade){
		Student temp = head;
		
		while(temp != null){
			if(temp.rollNo == rollNo){
				temp.grade = newGrade;
				System.out.println("Garde updated Successfully for RollNo : "+rollNo+".");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student with RollNo "+rollNo+" not found.");
	}
	
	public static void main(String []args){
		StudentRecord records = new StudentRecord();
		
		records.addStudent(101,"Alice",20,"A",0);
		records.addStudent(102,"Bob",19,"C",1);
		records.addStudent(103,"Ben",22,"B",0);
		
		records.displayStudents();
		
		records.updateGrade(102,"A+");
		records.searchStudent(102);
		
		records.deleteStudent(102);
		records.displayStudents();
	}
}