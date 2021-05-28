/**
 * 
 */
package guru.springframework.sfgpetclinic;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.services.springdatajpa.SpecialitySDJpaService;

/**
 * @author dcividin
 *
 * This class shows how to verify the mocked calls
 */
@ExtendWith(MockitoExtension.class)
class VerifyMockCallsTest {
  @Mock
  SpecialtyRepository specialtyRepository;
  
  @InjectMocks
  SpecialitySDJpaService service;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
  }
  
  @Test
  void testDeleteById() {
    service.deleteById(1L);
    verify(specialtyRepository, times(1)).deleteById(1L);
  }
  
  @Test
  void testDeleteByIdTimes() {
    service.deleteById(1L);
    service.deleteById(1L);
    
    // verifica che il deleteById con valore 1L sia stato invocato 2 volte
    verify(specialtyRepository, times(2)).deleteById(1L);
  }
  
  @Test
  void testDeleteByIdAtLeast() {
    service.deleteById(1L);
    service.deleteById(1L);
    service.deleteById(1L);
    
    // verifica che il deleteById con valore 1L sia stato invocato almeno 3 volte
    verify(specialtyRepository, atLeast(3)).deleteById(1L);
  }
  
  @Test
  void testDeleteByIdAtLeastOnce() {
    service.deleteById(1L);
    service.deleteById(1L);
    
    // verifica che il deleteById con valore 1L sia stato invocato almeno una volta
    verify(specialtyRepository, atLeastOnce()).deleteById(1L);
  }
  
  @Test
  void testDeleteByIdAtMost() {
    service.deleteById(1L);
    service.deleteById(1L);
    
    // verifica che il deleteById con valore 1L sia stato invocato al massimo 2 volte
    verify(specialtyRepository, atMost(2)).deleteById(1L);
  }
  
  @Test
  void testDeleteByIdAtMostOnce() {
    service.deleteById(1L);
    
    // verifica che il deleteById con valore 1L sia stato invocato al massimo una volta
    verify(specialtyRepository, atMostOnce()).deleteById(1L);
  }
  
  @Test
  void testDeleteByIdNever() {
    // verifica che il deleteById con valore 1L NON sia mai stato invocato
    verify(specialtyRepository, never()).deleteById(1L);
  }

  @Test
  void testDelete() {
    Speciality spec = new Speciality();
    service.delete(spec);
    verify(specialtyRepository, times(1)).delete(spec);
  }

}
