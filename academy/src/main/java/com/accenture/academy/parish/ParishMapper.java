package com.accenture.academy.parish;

import com.accenture.academy.priest.PriestDao;
import com.accenture.academy.priest.PriestDto;

public class ParishMapper {
//    public static PriestDao mapDtoToDao(PriestDto priestDto) {
//        return new PriestDao(
//                priestDto.getName(),
//                priestDto.getHeightInCm(),
//                priestDto.getAge()
//        );
//    }
//
//    static PriestDao mapDtoToDao(PriestDto priestDto, Long id){
//        PriestDao priestDao = new PriestDao();
//        priestDao.setId(id);
//        priestDao.setName(priestDto.getName());
//        priestDao.setHeightInCm(priestDto.getHeightInCm());
//        priestDao.setAge(priestDto.getAge());
//
//        return priestDao;
//    }
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
