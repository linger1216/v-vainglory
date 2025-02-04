package com.vainglory.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lid
 * @since 2025-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PostField extends BaseEntity {

    /**
     * id
     */
    private String id;

    /**
     * 岗位ID
     */
    private String postId;

    /**
     * 对应实体表,无前缀
     */
    private String entity;

    /**
     * 对应实体表可见的字段
     */
    private String entityFields;
}
