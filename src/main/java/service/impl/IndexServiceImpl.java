package service.impl;

import dao.SensorMapper;
import entity.Sensor;
import entity.SensorExample;
import org.springframework.stereotype.Service;
import service.IndexService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Tneciv on 2-26-0026.
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    @Resource
    private SensorMapper sensorMapper;

    public List<Sensor> getSensorByName(String name) {
        SensorExample example = new SensorExample();
        example.createCriteria().andNameEqualTo(name);
        List<Sensor> sensors = sensorMapper.selectByExample(example);
        return sensors;
    }
}
