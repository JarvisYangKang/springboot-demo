package com.jarvis.demo.controller;

import com.jarvis.demo.model.qo.CityQO;
import com.jarvis.demo.model.qo.CountryQO;
import com.jarvis.demo.model.vo.CityVO;
import com.jarvis.demo.model.vo.CountryVO;
import com.jarvis.demo.service.QueryService;
import com.jarvis.demo.util.Response;
import com.jarvis.demo.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
@RestController
@RequestMapping("query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping(value = "city", produces = "application/json;charset=UTF-8")
    public Response<CityVO> city(@RequestBody CityQO qo){
        return ResponseFactory.success(queryService.getCity(qo.getCityId()));
    }

    @PostMapping(value = "country", produces = "application/json;charset=UTF-8")
    public Response<CountryVO> country(@RequestBody CountryQO qo){
        return ResponseFactory.success(queryService.getCountry(qo.getCode()));
    }

}
