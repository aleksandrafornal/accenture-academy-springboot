package com.accenture.academy.church;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChurchDataInitializer {
    private final ChurchService churchService;

    @PostConstruct
    void initChurches(){
        ChurchDao churchDao = new ChurchDao(
                "Kościół św. Krzyża",
                "Warszawa",
                150,
                50000,
                20000.00
        );
        ChurchDao churchDao1 = new ChurchDao(
                "Kościół św. Stanisława",
                "Łódź",
                250,
                10000,
                10000.00
        );
        ChurchDao churchDao2 = new ChurchDao(
                "Kościół św. Rodzina",
                "Radom",
                50,
                100000,
                5000.00
        );
        churchService.addChurch(churchDao);
        churchService.addChurch(churchDao1);
        churchService.addChurch(churchDao2);
    }
}
