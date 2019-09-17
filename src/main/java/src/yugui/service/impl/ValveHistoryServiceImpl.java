package src.yugui.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.yugui.entity.ValveHistoryNotify;
import src.yugui.mapper.ValveHistoryMapper;
import src.yugui.service.ValveHistoryService;
import src.yugui.entity.ValveHistoryInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description: 实现类
 * @Author: XiaoPanPan
 * @Date: 2019/8/6 11:20
 */
@Service(value = "valveHistory")
public class ValveHistoryServiceImpl implements ValveHistoryService {

    @Resource(name = "valveHistoryMapper")
    private ValveHistoryMapper valveHistoryMapper;


    @Override
    public List<ValveHistoryInfo> getValveHistoryList(Map<String, String> valveHistoryMap) {
        return valveHistoryMapper.getValHistoryList(valveHistoryMap);
    }

    @Override
    public List<ValveHistoryInfo> getValveHistoryInfoByCreateNameAndModifyFlag(String createName, List<Integer> modiflyFlags) {
        return valveHistoryMapper.getValveHistoryInfoByCreateNameAndModifyFlags(createName, modiflyFlags);
    }

    @Override
    public Integer getValveHistoryCount() {
        return valveHistoryMapper.getValHistoryCount();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addValvehistory(Map<String, Object> valveMap) {
        return valveHistoryMapper.insertValvehistory(valveMap);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateValvehistory(String reportNo, Integer flag) {
        return valveHistoryMapper.updateValvehistory(reportNo, flag);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateValvehistory(Map<String, String> infoMap) {
        return valveHistoryMapper.updateValvehistoryByReport(infoMap);
    }

    @Override
    public ValveHistoryInfo getValveHistoryInfoByReportNo(String reportNo) {
        return valveHistoryMapper.getValveHistoryInfoByReportNo(reportNo);
    }

    @Override
    public List<ValveHistoryInfo> getValveHistoryListByModiflyFlag(List<Integer> modiflyFlags) {
        return valveHistoryMapper.getValveHistoryListByModiflyFlag(modiflyFlags);
    }

    @Override
    public String getReportNo() {
        return valveHistoryMapper.getReportNo();
    }

    @Override
    public List<ValveHistoryNotify> getReportNumByModiflyFlagAndTime(List<Integer> modiflyFlags, String startTime, String nowTime) {
        return valveHistoryMapper.getReportNumByModiflyFlagAndTime(modiflyFlags,startTime,nowTime);
    }
}


