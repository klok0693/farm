package by.farm.service;

import by.farm.NotNullByDefault;
import by.farm.entity.Cow;
import by.farm.repository.CowRepository;
import lombok.Synchronized;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by klok on 4.5.18.
 */
@Log4j
@Component
@Transactional(isolation = Isolation.REPEATABLE_READ, timeout = 60)
@NotNullByDefault
public class CowService {
    @Autowired
    private CowRepository repository;


    @Synchronized
    public void GiveBirth (Integer childCowId, String nickName) throws ServiceException {
        try {
            repository.GiveBirth(childCowId, nickName);
        }
        catch (HibernateException e) {
            log.error("can't add new cow", e);
            throw new ServiceException(e);
        }
    }

    @Synchronized
    public void EndLifeSpan(Integer cowId) throws ServiceException {
        try {
            repository.deleteById(cowId);
        }
        catch (HibernateException e) {
            log.error("can't delete cow", e);
            throw new ServiceException(e);
        }
    }


    public Iterable<Cow> FindAll() throws ServiceException {
        try {
            return repository.findAll();
        }
        catch (HibernateException e) {
            log.error("can't find all cows", e);
            throw new ServiceException(e);
        }
    }
}
