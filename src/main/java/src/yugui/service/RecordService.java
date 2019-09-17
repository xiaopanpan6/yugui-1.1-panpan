package src.yugui.service;

import src.yugui.entity.Record;

import java.util.List;
import java.util.Map;

/**
 * @Description: RecordService接口
 * @Author: XiaoPanPan
 * @Date: 2019/9/17 12:45
 */
public interface RecordService {


    List<Record> getRecordList();

    Boolean addRecord(Map<String, Object> recordMap);
}
