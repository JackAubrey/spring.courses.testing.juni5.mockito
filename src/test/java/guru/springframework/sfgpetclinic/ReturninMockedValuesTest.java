/**
 * 
 */
package guru.springframework.sfgpetclinic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
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
 * We can looking two types of test, one using a Map and one using a mocked service interface
 */
@ExtendWith(MockitoExtension.class)
class ReturninMockedValuesTest {
  @Mock
  SpecialtyRepository specialtyRepository;
  
  @InjectMocks
  SpecialitySDJpaService service;
  
  @Mock
  Map<String, String> mapMock;
  
  @Test
  void testMapMethod() {
    when(mapMock.put("key", "value")).thenReturn("key");
    when(mapMock.size()).thenReturn(1);
    
    assertEquals("key", mapMock.put("key", "value"));
    assertEquals(1, mapMock.size());
    
    verify(mapMock).put("key", "value");
    verify(mapMock).size();
  }

  @Test
  void testFindById() {
    Speciality speciality = new Speciality();
    
    when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));
    
    Speciality found = service.findById(1L);
    
    assertThat(found).isNotNull();
    verify(specialtyRepository).findById(1L);
  }
}
