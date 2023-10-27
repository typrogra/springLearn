// https://yangtaeyoung.github.io/docs/spring/di/ 내용

// 1. 의존관계
// A(student)는 B(korean)에 의존적이다.(포함관계)
// Korean.java
class Korean{
    int score; // 과목 점수
    string content; // 과목 내용
}

// Student.java
class Student{
    private Korean korean;
    public Student(){
        korean = new Korean();
    }
}

// 2. 1:N 의존 관계
// 의존관계를 만들기 위해 각각의 생성자 필요
// Korean.java
class Korean{
int score; // 과목 점수
string content; // 과목 내용
}

// Math.java
class Math {
    int score;
    string content;
}

// Student.java
class Student{
    // private Korean korean;
    private Math math;
    public Student(){
        //korean = new Korean();
        math = new Math();
    }
}

//3. 인터페이스로 추상화
// Subject.java
public interface Subject {
  // 개별의 클래스를 하나의 공통 주제로 추상화
}

// Korean.java
class Korean implements Subject{
int score; // 과목 점수
string content; // 과목 내용
}

// Math.java
class Math implements Subject{
int score;
string content;
}


// Student.java 
// 멤버 변수 선언만으로 여러 객체를 사용 가능
class Student{
    private Subject subject;
    public Student(){
        subject = new Korean();
        // subject = new Math()
    }
}

// 4. 의존성 주입
// Student클래스를 사용하는 객체는 멤버변수 선언만으로 subject, korean, math 의 객체를 모두 주입받게 된다.
// Subject.java(Interface)
// Korean.java
// Math.java
// Student.java
class Student{
    private Subject subject;
    
    public Student(Subject subject){
        subject = subject;
    }
}

// Student클래스를 사용하는 곳.java
Student student = new Student(new Korean());

// 5. @Autowired
// 스프링은 @Autowired 어노테이션을 통해 생성자 키워드를 사용하는 번거로움 없이 주입시켜주며 스프링 4.3 이후 부터는 @Autowired 어노테이션 없이도 묵시적 자동 주입한다.
class StudentService{
  @Autowired
  private StudentRepository studentRepository;
  
  // 이름으로 학생을 찾는 메서드
  public Student findByStdName(string name){
    return studentRepository.findByName(name); // new 생성자 없이 멤버변수의 메서드를 호출한다.
  }
}
