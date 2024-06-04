package cn.itsource.pojo.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 司机对象
 * </p>
 *
 * @author ywj
 * @since 2024-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_driver")
@Schema(name = "Driver对象", description = "司机对象")
public class Driver implements Serializable {

    private static final long serialVersionUID=1L;

    @Schema(name = "id", description = "同loginId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;//id=1728661876512002048

    @Schema(name = "phone", description = "电话")
    @TableField("phone")
    @NotEmpty(message = "手机号不能为空")//
    private String phone;

    @Schema(name = "homeAddress", description = "居住地址")
    @TableField("home_address")
    private String homeAddress;

    @Schema(name = "homeAddressLongitude", description = "居住地址精度")
    @TableField("home_address_longitude")
    private String homeAddressLongitude;

    @Schema(name = "homeAddressLatitude", description = "居住地址维度")
    @TableField("home_address_latitude")
    private String homeAddressLatitude;

    @Schema(name = "archive", description = "面部数据ID")
    @TableField("archive")
    private Boolean archive;

    @Schema(name = "createTime", description = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @Schema(name = "updateTime", description = "修改时间")
    @TableField("update_time")
    private Date updateTime;

    @Schema(name = "deleted", description = "逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;

    @Schema(name = "version", description = "乐观锁")
    @TableField("version")
    @Version
    private Integer version;

    @Schema(name = "openId", description = "微信ID")
    @TableField("open_id")
    private String openId;

    @Schema(name = "bitState", description = "位状态")
    @TableField("bit_state")
    @NotNull(message = "状态不能为空")
    private Long bitState;

}
