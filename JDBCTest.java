@Log4j
public class JDBCTests {
  //static{..Class.forName()..}을 통해 DB 드라이버를 DriverManager에 등록한다.(https://brilliantdevelop.tistory.com/54)
  static {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testConnection() {
    
    try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-F70M1I8:1521:XE", "book_ex", "book_ex")){ //Connection: 데이터베이스와 연결해주는 객체
      
      log.info(con);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

}
