/**
 * 
 */
package guru.springframework.sfgpetclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * @author dcividin
 * 
 * This class shows how to use Mockito in-line
 */
class InlineMockTest {
  @Test
  void testInlineMock() {
    Map<String, Object> map = mock(Map.class);
    
    assertEquals(0, map.size());
  }
}
