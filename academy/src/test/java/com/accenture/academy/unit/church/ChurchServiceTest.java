package com.accenture.academy.unit.church;

import com.accenture.academy.church.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ChurchServiceTest {

    @Mock
    ChurchRepository churchRepository;

    //ChurchRepository churchRepository = Mockito.mock(ChurchRepository.class);

    @InjectMocks
    ChurchService churchService;

    @Test
    void shouldReturnAllChurches(){
        //Given
        ChurchDao churchDao = new ChurchDao(
                "Kościół św. Krzyża",
                "Warszawa",
                150,
                50000,
                20000.00
        );
        ChurchDao churchDao1 = new ChurchDao(
                "Kościół św. Marka",
                "Warszawa",
                150,
                50000,
                20000.00
        );

        Mockito.when(churchRepository.findAll()).thenReturn(List.of(churchDao, churchDao1));

        //When

        //Then
        Assertions.assertEquals(List.of(churchDao, churchDao1), churchService.getAllChurches());
    }

    @Test
    void shouldAddChurch(){
        //Given
        ChurchDao churchDao = new ChurchDao(
                "Kościół św. Krzyża",
                "Warszawa",
                150,
                50000,
                20000.00
        );


        //When
        churchService.addChurch(churchDao);

        //Then
        Mockito.verify(churchRepository, Mockito.times(1)).save(churchDao);

    }

    @Test
    void shouldGetChurchById(){
        //Given
        ChurchDao churchDao = new ChurchDao(
                "Kościół św. Krzyża",
                "Warszawa",
                150,
                50000,
                20000.00
        );

        //When
        Mockito.when(churchRepository.findById(churchDao.getId())).thenReturn(Optional.of(churchDao));

        //Then
        Assertions.assertEquals(churchDao, churchService.getChurchById(churchDao.getId()));

    }

    @Test
    void shouldReturnExceptionWhenChurchDoesNotExists(){
        Mockito.when(churchRepository.findById(any())).thenReturn(Optional.empty());
        Assertions.assertThrows(ChurchNotFoundException.class, () -> churchService.getChurchById(any()));
    }

    @Test
    void shouldDeleteChurch(){
        //Given

        //When
        churchService.deleteById(any());

        //Then
        Mockito.verify(churchRepository, Mockito.times(1)).deleteById(any());

    }

    @Test
    void shouldUpdateChurch(){
        //Given
        ChurchDto churchDto = new ChurchDto(
                "test",
                "test",
                2,
                2,
                2.0
        );

        //When
        churchService.update(churchDto, any());

        //Then
        Mockito.verify(churchRepository, Mockito.times(1)).save(any());

    }

}