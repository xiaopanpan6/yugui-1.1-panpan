package src.yugui.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import src.yugui.common.BaseMapper;
import src.yugui.entity.Record;

import java.util.List;
import java.util.Map;

/**
 * @Description: mapper接口
 * @Author: XiaoPanPan
 * @Date: 2019/8/6 11:12
 */
@Mapper
@Repository(value = "recordMapper")
public interface RecordMapper extends BaseMapper<Record> {

    List<Record> getRecordList();

    Boolean addRecord(Map<String, Object> recordMap);

}
