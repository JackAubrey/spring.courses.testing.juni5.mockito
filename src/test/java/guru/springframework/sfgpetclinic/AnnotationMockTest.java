/**
 * 
 */
package guru.springframework.sfgpetclinic;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author dcividin
 *
 * This class shows how to initialize Mockito hands-on.
 * This method do same what the Mockito Extension done inside
 */
class AnnotationMockTest {
  @Mock
  Map<String, String> mapMock;
  
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }
  
  @Test
  void test() {
    mapMock.put("key", "value");
  }

}
