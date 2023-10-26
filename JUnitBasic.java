@RunWith(SpringJUnit4ClassRunner.class) //하기 코드가 스프링을 실행하는 역할을 할 것이라는 것을 표시. 이 어노테이션 선언으로 main함수 없이 테스트 코드를 실행할 수 있게 된다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //속성값을 이용해서 명시된 객체들을 스프링 내 객체(bean)으로 등록
@Log4j //Logger 변수 생성.
public class SampleTests {
  
  @Setter(onMethod_ = { @Autowired}) //@Setter(Lombok lib) 어노테이션을 선언하여 setter 객체를 생성한다. onMethod 속성에 @Autowired 어노테이션은 선언하여 별도의 생성자(new Restaurant) 선언 없이 객체를 생성한다.
  private Restaurant restaurant;
  
  @Test //테스트 대상을 표시. 이 어노테이션이 해당 메서드가 main 메서드 없이 실행할 수 있게 해준다.
  public void testExist() {
    assertNotNull(restaurant); //속성값으로 지정된 변수가 null이 아니어야 테스트가 성공한다는 것을 의미
    
    log.info(restaurant);//@Log4j 어노테이션 선언으로 별도의 Logger 객체 선언없이 바로 사용할 수 있다.
    log.info("---------------------------");
    log.info(restaurant.getChef());
  }
  
}
