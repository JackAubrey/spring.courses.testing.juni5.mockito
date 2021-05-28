/**
 * 
 */
package guru.springframework.sfgpetclinic;

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
 * This class show how to mock an interface and Inject a concrete class that use this interface
 */
@ExtendWith(MockitoExtension.class)
class MockServiceInterfaceAndInjectMockClassTest {
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
    
    verify(specialtyRepository).deleteById(1L);
  }

  @Test
  void testDelete() {
    Speciality spec = new Speciality();
    service.delete(spec);
    verify(specialtyRepository, times(1)).delete(spec);
  }

}
