package controller;

import common.ApplicationException;
import common.ResEnv;
import entity.Sensor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IndexService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tneciv on 2-26-0026.
 */
@Controller
public class IndexController {

    @Resource
    private IndexService indexService;

    @RequestMapping("/index")
    public String index() {
        return "/index/index";
    }

    @RequestMapping("/fetchSensorsByName")
    @ResponseBody
    public ResEnv<List<Sensor>> fetchSensorsByName(String name) {
        List<Sensor> sensorList = new ArrayList<>();

        try {
            sensorList = this.indexService.getSensorByName(name);
        } catch (ApplicationException e) {
//            logger.error(e.getMessage(), e);
            return ResEnv.fail(e.getMessage());
        } catch (Exception e) {
//            logger.error("获取数据异常", e);
            return ResEnv.fail("获取数据异常");
        }
        return ResEnv.success(sensorList);

    }

}
