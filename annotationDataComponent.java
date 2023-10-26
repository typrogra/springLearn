@Component /*해당 클래스가 스프링에서 객체로 만들어서 관리하는 대상임을 명
             root-context.xml 내 ComponentScan에 지정된 패키지에 있는 클래스를 조사하여 해당 어노테이션이 존재하는 클래스를 객체로 생성해서 빈으로 관리한다.*/
@Data //@ToString, @EqualsAndHashCode, @Getter/setter, @RequiredArgsConstructor를 결합한 형태
public class Restaurant {
  
  @Setter(onMethod_ = @Autowired) //스프링 의존성 주입은 크게 1)생성자 주입(Autowired)과 2)Setter 주입을 사용. @Setter로 setXXX() 메서드를 생성하고 @Autowired로 스프링으로부터 자신이 필요한 객체를 주입
  private Chef chef;

}
