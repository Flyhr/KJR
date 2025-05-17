package com.ruoyi.DocSys.controller;

import com.ruoyi.DocSys.domain.DoctorPatientRelation;
import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.domain.UserBasicInfo;
import com.ruoyi.DocSys.service.impl.IntegratedHealthDataService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("/api/healthData")
public class IntegratedHealthDataController {

    @Autowired
    private IntegratedHealthDataService healthDataService;

/**
 * 医生：根据姓名和手机号查询患者是否有账号
 *
 */

    @GetMapping("/selectPat")
    public AjaxResult selectPatientInfo(@RequestParam("name") String name,
                                        @RequestParam("phone") String phone){
        SysUser data = healthDataService.selectPatientInfo(name,phone);

        if(data != null){

            return AjaxResult.success(data);
        }
        return AjaxResult.error("暂无数据");
    };
    /**
     * 医生：添加与患者的关系
     * 使用 POST 方法接收设备数据，根据 userId 执行更新或插入操作
     */
    @PostMapping("/addPatientRelationle")
    public AjaxResult upsertSensorData(@RequestBody DoctorPatientRelation Data) {
//        System.out.println(Data);
        int rows = healthDataService.insertRelation(Data);
        System.out.println("8888888888"+rows);
        if (rows > 0) {
            return AjaxResult.success("操作成功");
        }
        return AjaxResult.error("操作失败");
    };
    /**
     * 患者查询自己医生信息
     */
    @GetMapping("/getDoctorInfo")
    public AjaxResult getDoctorInfoData(@RequestParam("user_id") Long user_id) {
        DoctorPatientRelation data = healthDataService.getDoctorRelationByUserId(user_id);

        if(data != null){
            Long doc_id = data.getDocId();
            SysUser DocInfo = healthDataService.getDoctorInfoByUserId(doc_id);
            return AjaxResult.success(DocInfo);
        }
        return AjaxResult.error("暂无数据");
    };
    /**
     * 医生查询自己患者信息
     */
    @GetMapping("/getPatientInfo")
    public AjaxResult getPatientInfoData(@RequestParam("user_id") Long user_id) {
        DoctorPatientRelation data = healthDataService.getPatientRelationByUserId(user_id);
//        System.out.println("医生id"+user_id);
//        System.out.println("医患关系"+data);
        if(data != null)
        {
            Long pat_id = data.getPatId();
//            System.out.println("患者id"+pat_id);

            SysUser PatInfo = healthDataService.getPatientInfoByUserId(pat_id);
            System.out.println("患者信息"+PatInfo);

            return AjaxResult.success(PatInfo);
        }
        return AjaxResult.error("暂无数据");
    };
    /**
     * 查询设备数据
     */
    @GetMapping("/getData")
    public AjaxResult getLatestHealthData(@RequestParam("user_id") Long user_id) {
        IntegratedHealthData data = healthDataService.selectLatestByUserId(user_id);
        if(data != null){
            return AjaxResult.success(data);
        }
        return AjaxResult.error("暂无数据");
    };

    /**
     * 存储设备数据
     * 使用 POST 方法接收设备数据，根据 userId 执行更新或插入操作
     */
    @PostMapping("/setData")
    public AjaxResult upsertSensorData(@RequestBody IntegratedHealthData sensorData) {
        System.out.println(sensorData);
        int rows = healthDataService.upsertSensorData(sensorData);
        if (rows > 0) {
            return AjaxResult.success("操作成功");
        }
        return AjaxResult.error("操作失败");
    };
    /**
     * 删除设备数据
     */
    @GetMapping("/deleteData")
    public AjaxResult deleteHealthData(@RequestParam("user_id") Long user_id) {
        // 存在设备信息，则调用删除方法
        int rows = healthDataService.deleteHealthDataByUserId(user_id);
        if (rows > 0) {
            return AjaxResult.success("设备信息删除成功");
        } else {
            return AjaxResult.error("设备信息删除失败");
        }
    };
    /**
     * 查询用户用于预测的基础信息
     */
    @GetMapping("/getBasicUserInfo")
    public AjaxResult getBasicUserInfo(@RequestParam("user_id") Long user_id) {
        UserBasicInfo data = healthDataService.selectUserBasicInfoByUserId(user_id);
        if(data != null){
            return AjaxResult.success(data);
        }
        return AjaxResult.error("暂无数据");
    };
    /**
     * 插入或更新用户基础数据
     * 使用 POST 方法接收设备数据，根据 userId 执行更新或插入操作
     */
    @PostMapping("/setBasicInfo")
    public AjaxResult upsertSensorData(@RequestBody UserBasicInfo userBasicInfo) {
        int rows = healthDataService.setUserBasicInfo(userBasicInfo);
        if (rows > 0) {
            return AjaxResult.success("操作成功");
        }
        return AjaxResult.error("操作失败");
    };
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 预测康复情况
     * 1. 先从数据库获取 `user_id` 对应的 `integrated_health_data` 信息
     * 2. 发送数据到 Python 机器学习服务进行预测
     * 3. 返回预测结果给前端
     */
    @GetMapping("/predict")
    public AjaxResult predictRecovery(@RequestParam("user_id") Long userId) {
//        Long  id = 109L;
        // 1. 查询数据库，获取用户数据
        UserBasicInfo userData = healthDataService.selectUserBasicInfoByUserId(userId);
//        System.out.println("99999999999"+userData);
        if (userData == null) {
            return AjaxResult.error("未找到用户数据");
        }

        // 2. 构造请求参数，转换为 Python 服务所需的格式
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("weight", String.valueOf(userData.getWeight()));
        params.add("height", String.valueOf(userData.getHeight()));
        params.add("gender", String.valueOf(userData.getGender().equals("男") ? 1 : 0));
        params.add("age", String.valueOf(userData.getAge()));
        params.add("smoking", String.valueOf(userData.getSmoking().equals("是") ? 1 : 0));
        params.add("temp", String.valueOf(userData.getTemp()));
        params.add("temp_cut", String.valueOf(userData.getTempCut()));
        params.add("pulse", String.valueOf(userData.getPulse()));
        params.add("sbp", String.valueOf(userData.getSbp()));
        params.add("dbp", String.valueOf(userData.getDbp()));
        params.add("swelling", String.valueOf(userData.getSwelling().equals("是") ? 1 : 0));
        params.add("knee", String.valueOf(userData.getKnee()));
        params.add("step", String.valueOf(userData.getStep()));
        params.add("decri", userData.getDecri());

        // 3. 构造新的目标 URL
        String baseUrl = "http://47.97.76.102:4672/api/healthData/predict";
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParams(params)
                .build()
                .toUriString();

        // 4. 调用 Python 机器学习服务，并获取响应
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        // 5. 解析返回的预测结果
        if (response.getBody() != null && (int) response.getBody().get("code") == 200) {
            return AjaxResult.success(response.getBody().get("data"));
        } else {
            return AjaxResult.error("预测失败：" + response.getBody().get("msg"));
        }
    };
}
