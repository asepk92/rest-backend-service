package com.nostra.service;



import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

import com.nostra.util.Constants;

import java.util.*;

/**
 * Created by fani on 5/22/15.
 */
public abstract class AbstractBaseService{

    public static Sort getSortBy(String sortBy, String direction) {
        if (StringUtils.equalsIgnoreCase(direction, "asc")) {
            return new Sort(Sort.Direction.ASC, sortBy);
        } else {
            return new Sort(Sort.Direction.DESC, sortBy);
        }
    }


    public static Map<String, Object> constructMapReturn(Collection voList, long totalElements, int totalPages) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put(Constants.PageParameter.LIST_DATA, voList);
        map.put(Constants.PageParameter.TOTAL_ELEMENTS, totalElements);
        map.put(Constants.PageParameter.TOTAL_PAGES, totalPages);

        return map;
    }

}
