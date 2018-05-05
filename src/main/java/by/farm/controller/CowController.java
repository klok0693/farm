package by.farm.controller;

import by.farm.service.CowService;
import by.farm.NotNullByDefault;
import by.farm.service.ServiceException;
import by.farm.entity.Cow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by klok on 4.5.18.
 */
@NotNullByDefault
@RestController
@RequestMapping(value = "/farm", produces = "application/json")
public class CowController {
    @Autowired
    CowService service;

    @RequestMapping(method = GET)
    public @ResponseBody Iterable<Cow> FindAll() {
        try {
            return service.FindAll();
        }
        catch (ServiceException e) {
            return null;
        }
    }

    @RequestMapping(method = POST)
    public @ResponseBody boolean GiveBirth(Integer parentId, Integer childId, String childNickName) {
        try {
            service.GiveBirth(childId, childNickName);
            return true;
        }
        catch (ServiceException e) {
            return false;
        }
    }

    @RequestMapping(method = DELETE)
    public @ResponseBody boolean EndLifeSpan(Integer cowId) {
        try {
            service.EndLifeSpan(cowId);
            return true;
        }
        catch (ServiceException e) {
            return false;
        }
    }
}
