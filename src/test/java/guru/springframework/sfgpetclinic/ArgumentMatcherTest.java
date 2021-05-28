/**
 * 
 */
package guru.springframework.sfgpetclinic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

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
 * This class shows how to mock values expected to be returned.
 * In this case we use the static method "any"
 */
@ExtendWith(MockitoExtension.class)
class ArgumentMatcherTest {
  @Mock
  SpecialtyRepository specialtyRepository;
  
  @InjectMocks
  SpecialitySDJpaService service;
  
  @Test
  void testDeleteByIdAt() {
    service.delete(new Speciality());
    
    // verifica che il deleteById con valore 1L sia stato invocato almeno una volta
    verify(specialtyRepository).delete(any(Speciality.class));
  }
  
  @Test
  void testFindById() {
    Speciality speciality = new Speciality();
    
    when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));
    
    Speciality found = service.findById(1L);
    
    assertThat(found).isNotNull();
    verify(specialtyRepository).findById(anyLong());
  }
}
