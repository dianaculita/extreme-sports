package com.company.repository;

import com.company.details.Details;
import com.company.details.DetailsDto;
import com.company.model.ExtremeSport;
import com.company.model.SportByPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SportByPlaceRepository extends JpaRepository<SportByPlace, Long> {

    @Query(value = "SELECT  sbp.COUNTRY_ID AS countryId, sbp.REGION_ID AS regionId, sbp.PLACE_ID AS placeId, " +
            "es.SPORT_NAME AS extremeSport, sbp.PRICE_PER_DAY AS pricePerDay FROM EXTREME_SPORTS AS es, SPORTS_BY_PLACES AS sbp\n" +
            "WHERE (es.SPORT_NAME IN :sportNames) AND es.SPORT_ID=sbp.SPORT_ID AND es.START_PERIOD < :startPeriod " +
            "AND es.END_PERIOD > :endPeriod\n" +
            "GROUP BY sbp.PRICE_PER_DAY, sbp.COUNTRY_ID, sbp.REGION_ID, sbp.PLACE_ID, es.SPORT_NAME\n" +
            "ORDER BY sbp.PRICE_PER_DAY, sbp.COUNTRY_ID, sbp.REGION_ID, sbp.PLACE_ID, es.SPORT_NAME",
            nativeQuery = true)
    Optional<List<DetailsDto>> getFilteredExtremeSports(@Param("sportNames") List<String> sportNames,
                                                        @Param("startPeriod") Date startPeriod,
                                                        @Param("endPeriod") Date endPeriod);

    Optional<SportByPlace> findByExtremeSport(ExtremeSport extremeSport);

}
