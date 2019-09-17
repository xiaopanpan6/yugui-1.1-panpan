package src.yugui.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.yugui.common.ResponseMsg;
import src.yugui.common.TimeTool;
import src.yugui.entity.NotifyInfo;
import src.yugui.entity.Record;
import src.yugui.entity.ValveHistoryNotify;
import src.yugui.service.RecordService;
import src.yugui.service.ValveHistoryService;
import src.yugui.util.Constant;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 处理消息通知
 * @Author: XiaoPanPan
 * @Date: 2019/9/11 16:55
 */
@RestController
@Api(tags = "消息通知控制层", description = "NotifyController")
@RequestMapping("/report")
public class NotifyController extends BaseController {
    private static final Logger logger = Logger.getLogger(ValveReportController.class);

    @Resource(name = "valveHistory")
    private ValveHistoryService valveHistoryService;

    @Autowired
    private RecordService recordService;

    @ApiOperation(value = "获取今日不同状态下各有多少份报告数量接口", response = ResponseMsg.class)
    @GetMapping("/getTodayNotify")
    public ResponseMsg getNotify() {
        String startTime = TimeTool.getTodayStartTime();//今日的开始时间
        String endTime = TimeTool.getTodayEndTime();//今日的结束时间
        logger.info(startTime + "-------------" + endTime);

        NotifyInfo notifyInfo = new NotifyInfo();//总通知消息封装
        List<Integer> modiflyFlag = new ArrayList<>();
        List<ValveHistoryNotify> valveHistoryNotifies;
        //今日新建报告数量
        modiflyFlag.add(Constant.REPORT_STATE_NEW);
        valveHistoryNotifies = valveHistoryService.getReportNumByModiflyFlagAndTime(modiflyFlag, startTime, endTime);
        int newReportNum = valveHistoryNotifies.size();
        notifyInfo.setNewReportNum(newReportNum);

        //今日已审核报告数量
        modiflyFlag = new ArrayList<>();
        modiflyFlag.add(Constant.REPORT_STATE_CHECK);
        modiflyFlag.add(Constant.REPORT_STATE_UNCHECK);
        valveHistoryNotifies = valveHistoryService.getReportNumByModiflyFlagAndTime(modiflyFlag, startTime, endTime);
        int checkNum = valveHistoryNotifies.size();
        notifyInfo.setCheckReportNum(checkNum);

        //今日已审批报告数量
        modiflyFlag = new ArrayList<>();
        modiflyFlag.add(Constant.REPORT_STATE_APPROVE);
        modiflyFlag.add(Constant.REPORT_STATE_UNAPPROVE);
        valveHistoryNotifies = valveHistoryService.getReportNumByModiflyFlagAndTime(modiflyFlag, startTime, endTime);
        int approveNum = valveHistoryNotifies.size();
        notifyInfo.setAprroveReportNum(approveNum);

        //今日归档报告数量
        modiflyFlag = new ArrayList<>();
        modiflyFlag.add(Constant.REPORT_STATE_FILE);
        valveHistoryNotifies = valveHistoryService.getReportNumByModiflyFlagAndTime(modiflyFlag, startTime, endTime);
        int fileNum = valveHistoryNotifies.size();
        notifyInfo.setFileReportNum(fileNum);
        return ResponseMsg.ok(notifyInfo);
    }

    @ApiOperation(value = "消息动态接口", response = ResponseMsg.class)
    @GetMapping("/getReportNotify")
    public ResponseMsg getReportNotify() {
        List<Record> records = recordService.getRecordList();
        return ResponseMsg.ok(records);
    }
}