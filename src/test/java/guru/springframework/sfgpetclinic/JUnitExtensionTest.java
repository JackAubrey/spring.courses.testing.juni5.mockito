package guru.springframework.sfgpetclinic;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * 
 * @author dcividin
 * 
 * This class show the most used way to initialize Mockito
 */
@ExtendWith(MockitoExtension.class)
class JUnitExtensionTest {
  @Mock
  Map<String, String> mapMock;

  @Test
  void test() {
    mapMock.put("key", "value");
    
  }
}
