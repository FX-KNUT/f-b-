//package fb.blind.comment;
//
//import fb.blind.domain.comment.Comment;
//import fb.blind.domain.comment.CommentRepository;
//import fb.blind.domain.comment.MemoryCommentRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class MemoryCommentRepositoryTest {
//
//    private CommentRepository commentRepository = new MemoryCommentRepository();
//    private Comment comm1, comm2, comm3, comm4, comm5, comm6;
//
//    @BeforeEach
//    public void beforeEach(){
//        comm1 = new Comment(1L, 1L, "comment1", "2023-01-06T11:19");
//        comm2 = new Comment(1L, 2L, "comment2", "2023-02-06T11:19");
//        comm3 = new Comment(2L, 2L, "comment3", "2023-03-06T11:19");
//        comm4 = new Comment(3L, 3L, "comment4", "2023-04-06T11:19");
//        comm5 = new Comment(3L, 4L, "comment5", "2023-05-06T11:19");
//        comm6 = new Comment(4L, 6L, "comment6", "2023-06-06T11:19");
//
//        comm1.setId(1L);
//        comm2.setId(2L);
//        comm3.setId(3L);
//        comm4.setId(4L);
//        comm5.setId(5L);
//        comm6.setId(6L);
//
//        commentRepository.save(comm1);
//        commentRepository.save(comm2);
//        commentRepository.save(comm3);
//        commentRepository.save(comm4);
//        commentRepository.save(comm5);
//        commentRepository.save(comm6);
//    }
//
//    @AfterEach
//    public void afterEach(){
//        commentRepository.clear();
//    }
//
//    @Test
//    void save() {
//        Comment comm7 = new Comment(1L, 7L, "comment7", "2023-07-06T11:19");
//        comm7.setId(7L);
//        Comment result = commentRepository.save(comm7);
//        assertThat(result.getId()).isEqualTo(comm7.getId());
//    }
//
//    @Test
//    void findByArticleId() {
//        List<Comment> result = commentRepository.findByArticleId(1L);
//        assertThat(result).contains(comm1, comm2);
//    }
//
//    @Test
//    void findByUserId() {
//        List<Comment> result = commentRepository.findByUserId(2L);
//        assertThat(result).contains(comm2, comm3);
//    }
//
//    @Test
//    void delete() {
//        commentRepository.delete(1L);
//        Optional<Comment> byCommentId = commentRepository.findByCommentId(1L);
//        assertThat(byCommentId).isEmpty();
//    }
//}