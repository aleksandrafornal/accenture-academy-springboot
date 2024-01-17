package com.accenture.academy.priest;

public class PriestMapper {
    static PriestDao mapDtoToDao(PriestDto priestDto) {
        return new PriestDao(
                priestDto.getName(),
                priestDto.getHeightInCm(),
                priestDto.getAge()
        );
    }

    static PriestDao mapDtoToDao(PriestDto priestDto, Long id){
        PriestDao priestDao = new PriestDao();
        priestDao.setId(id);
        priestDao.setName(priestDto.getName());
        priestDao.setHeightInCm(priestDto.getHeightInCm());
        priestDao.setAge(priestDto.getAge());

        return priestDao;
    }
}
