package com.CarSaleApi.app.controllers.api;

import com.CarSaleApi.app.dto.RevenueDto;
import com.CarSaleApi.app.services.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/car-showrooms/{idCarshowroom}/revenues")
@RequiredArgsConstructor
public class RevenueController {

    private final RevenueService revenueService;

    @GetMapping("/day/{date}")
    public RevenueDto getRevenueByDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                      @PathVariable Long idCarshowroom) {
        return revenueService.getRevenueByDay(date,idCarshowroom);
    }

    @GetMapping("/week/{startDate}/{endDate}")
    public RevenueDto getRevenueByWeek(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                      @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                                      @PathVariable Long idCarshowroom) {
        return revenueService.getRevenueByWeek(startDate,endDate,idCarshowroom);
    }

    @GetMapping("/years/month/{year}/{month}")
    public RevenueDto getRevenueByMonth(@PathVariable String month, @PathVariable String year,
                                        @PathVariable Long idCarshowroom){
        return revenueService.getRevenueByMonth(month,year,idCarshowroom);
    }
}
