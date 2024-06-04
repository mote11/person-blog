package com.edu.cqie.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    @NotNull(groups = {Edit.class,Delete.class})
    private Integer categoryId;

    /**
     * 类别
     */
//    @NotEmpty(groups = {Add.class,Edit.class})
    @NotEmpty
    private String categoryName;

    /**
     * 外键
     */
    private Integer userId;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //某个校验项没有指定分组，默认属于Default分组
    //分组之间可以继承，A extends B 那么A中拥有B中所有的校验项

    public interface Add extends Default {

    }

    public interface Edit extends Default{

    }
    public interface Delete{

    }
}
