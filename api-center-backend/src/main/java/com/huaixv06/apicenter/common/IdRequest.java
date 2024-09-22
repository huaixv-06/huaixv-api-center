package com.huaixv06.apicenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author huaixv06
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}