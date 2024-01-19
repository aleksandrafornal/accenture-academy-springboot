package com.accenture.academy.church;

public class ChurchMapper {
    public static ChurchDao mapDtoToDao(ChurchDto churchDto) {
        return new ChurchDao(
                churchDto.getName(),
                churchDto.getNameOfCity(),
                churchDto.getNumberOfSeats(),
                churchDto.getNumberOfMembers(),
                churchDto.getBudget()
        );
    }

    static ChurchDao mapDtoToDao(ChurchDto churchDto, Long id) {
        ChurchDao churchDao = new ChurchDao();
        churchDao.setId(id);
        churchDao.setName(churchDto.getName());
        churchDao.setNameOfCity(churchDto.getNameOfCity());
        churchDao.setNumberOfSeats(churchDto.getNumberOfSeats());
        churchDao.setNumberOfMembers(churchDto.getNumberOfMembers());
        churchDao.setBudget(churchDto.getBudget());

        return churchDao;
    }
}
