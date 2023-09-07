package org.zerock.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
  
  private Long[] bnoArr = { 4194304L, 4194303L, 4194302L, 4194301L, 4194300L };
  
  @Setter(onMethod_ = @Autowired)
  private ReplyMapper mapper;
  
  @Test public void testList2() {
    Criteria cri = new Criteria(1, 10);
    List<ReplyVO> replies = mapper.getListWithPaging(cri, 4194301L);
    replies.forEach(reply -> log.info(reply));
  }
  
  /*
   * @Test public void testList() {
   * 
   * Criteria cri = new Criteria(); List<ReplyVO> replies =
   * mapper.getListWithPaging(cri, bnoArr[0]);
   * 
   * replies.forEach(reply -> log.info(reply)); }
   */
  
  /*
   * @Test public void testUpdate() { Long targetRno = 10L; ReplyVO vo =
   * mapper.read(targetRno); vo.setReply("Update Reply "); int count =
   * mapper.update(vo); log.info("UPDATE COUNT: " + count); }
   */
  
  /*
   * @Test public void testDelete() { Long targetRno = 1L;
   * mapper.delete(targetRno); }
   */
  
  /*
   * @Test public void testRead() { Long targetRno = 5L;
   * 
   * ReplyVO vo = mapper.read(targetRno);
   * 
   * log.info(vo); }
   */
  
  /*
   * @Test public void testCreate() { IntStream.rangeClosed(1,10).forEach(i -> {
   * 
   * ReplyVO vo = new ReplyVO();
   * 
   * vo.setBno(bnoArr[i % 5]); vo.setReply("reply test"+i);
   * vo.setReplyer("replyer"+i);
   * 
   * mapper.insert(vo); }); }
   */
  
  /*
   * @Test public void testMapper() { log.info(mapper); }
   */

}
