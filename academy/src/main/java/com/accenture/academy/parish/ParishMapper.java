package com.accenture.academy.parish;

public class ParishMapper {
    static ParishDao mapDtoToDao(ParishDto parishDto){
        return new ParishDao(
                parishDto.getName(),
                parishDto.getPriestDao(),
                parishDto.getChurchDao(),
                parishDto.getMembers(),
                parishDto.getCementaryDao()
        );
    }

    static ParishDao mapDtoToDao(ParishDto parishDto, Long id){
        ParishDao parishDao = new ParishDao();
        parishDao.setId(id);
        parishDao.setName(parishDto.getName());
        parishDao.setPriestDao(parishDto.getPriestDao());
        parishDao.setChurchDao(parishDto.getChurchDao());
        parishDao.setMembers(parishDto.getMembers());
        parishDao.setCementaryDao(parishDto.getCementaryDao());

        return parishDao;
    }
}
