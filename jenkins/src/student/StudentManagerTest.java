package student;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {

    private static StudentManager manager;

    @BeforeAll
    static void setUp() {
        manager = new StudentManager();
    }

    @Test
    @Order(1)
    @DisplayName("학생 추가 - 추가 후 조회 시 true 반환")
    void addStudent_success() {
        manager.addStudent("홍길동");
        assertTrue(manager.hasStudent("홍길동"));
    }

    @Test
    @Order(2)
    @DisplayName("중복 추가 예외 처리 - 1번에서 추가된 홍길동 재추가 시 예외 발생")
    void addStudent_duplicate_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> manager.addStudent("홍길동"));
    }

    @Test
    @Order(3)
    @DisplayName("학생 제거 - 홍길동 제거 후 조회 시 false 반환")
    void removeStudent_success() {
        manager.removeStudent("홍길동");
        assertFalse(manager.hasStudent("홍길동"));
    }

    @Test
    @Order(4)
    @DisplayName("존재하지 않는 학생 제거 예외 처리 - 3번에서 제거된 홍길동 재제거 시 예외 발생")
    void removeStudent_notExist_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> manager.removeStudent("홍길동"));
    }
}