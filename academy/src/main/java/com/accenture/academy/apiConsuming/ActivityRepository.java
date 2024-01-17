package com.accenture.academy.apiConsuming;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ActivityRepository {
    private final IActivityRepository iActivityRepository;

    public void saveActivity(Activity activity){
        iActivityRepository.save(activity);
    }

}
