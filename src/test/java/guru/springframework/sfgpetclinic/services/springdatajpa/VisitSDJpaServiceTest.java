package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {
  @Mock
  VisitRepository visitRepository;
  
  @InjectMocks
  VisitSDJpaService service;

  @Test
  void testFindAll() {
    Set<Visit> allVisit = new HashSet<>(Arrays.asList(
        new Visit(1L, LocalDate.now()),
        new Visit(2L, LocalDate.now()),
        new Visit(3L, LocalDate.now())));
    
    when(visitRepository.findAll()).thenReturn(allVisit);
    
    assertThat(service.findAll()).hasSize(allVisit.size());
    
    verify(visitRepository).findAll();
  }

  @Test
  void testFindById() {
    when(visitRepository.findById(anyLong())).thenReturn(Optional.of(new Visit(1L, LocalDate.now())));
    
    assertThat(service.findById(anyLong())).isNotNull();
    
    verify(visitRepository).findById(anyLong());
  }

  @Test
  void testSave() {
    Visit visit = new Visit(1L, LocalDate.now());
    
    when(visitRepository.save(visit)).thenReturn(visit);
    
    assertThat(service.save(visit)).isEqualTo(visit);
    
    verify(visitRepository).save(any(Visit.class));
  }

  @Test
  void testDelete() {
    Visit visit = new Visit(1L, LocalDate.now());
    
    service.delete(visit);
    
    verify(visitRepository).delete(any(Visit.class));
  }

  @Test
  void testDeleteById() {
    service.deleteById(1L);
    
    verify(visitRepository).deleteById(anyLong());
  }

}
