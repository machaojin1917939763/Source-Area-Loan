package com.suke.czx.modules.apk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * APK版本管理
 *
 * @author czx
 * @email object_czx@163.com
 * @date 2023-01-26 20:32:33
 */
@Data
@TableName("tb_apk_version")
public class TbApkVersion implements Serializable {
    public static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @JsonProperty(value = "id")
    public Long id;

    @ApiModelProperty(value = "更新内容")
    @JsonProperty(value = "updateContent")
    public String updateContent;

    @ApiModelProperty(value = "版本码")
    @JsonProperty(value = "versionCode")
    public Integer versionCode;

    @ApiModelProperty(value = "版本号")
    @JsonProperty(value = "versionName")
    public String versionName;

    @ApiModelProperty(value = "包名")
    @JsonProperty(value = "packageName")
    public String packageName;

    @ApiModelProperty(value = "下载地址")
    @JsonProperty(value = "downloadUrl")
    public String downloadUrl;

    @ApiModelProperty(value = "APP名")
    @JsonProperty(value = "appName")
    public String appName;

    @ApiModelProperty(value = "MD5值")
    @JsonProperty(value = "md5Value")
    public String md5Value;

    @ApiModelProperty(value = "文件名")
    @JsonProperty(value = "fileName")
    public String fileName;

    @ApiModelProperty(value = "文件大小")
    @JsonProperty(value = "fileSize")
    public String fileSize;

    @ApiModelProperty(value = "是否强制安装")
    @JsonProperty(value = "isForce")
    public Integer isForce;

    @ApiModelProperty(value = "是否可忽略该版本")
    @JsonProperty(value = "isIgnorable")
    public Integer isIgnorable;

    @ApiModelProperty(value = "是否静默下载")
    @JsonProperty(value = "isSilent")
    public Integer isSilent;

    @ApiModelProperty(value = "上传人")
    @JsonProperty(value = "userId")
    public String userId;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "createTime")
    public Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "updateTime")
    public Date updateTime;

}
