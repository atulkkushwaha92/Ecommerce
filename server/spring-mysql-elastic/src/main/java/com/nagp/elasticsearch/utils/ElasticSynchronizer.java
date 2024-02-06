package com.nagp.elasticsearch.utils;

import com.nagp.elasticsearch.mapper.ProductMapper;
import com.nagp.elasticsearch.model.Product;
import com.nagp.elasticsearch.repo.IProductDAO;
import com.nagp.elasticsearch.repo.elastic.IProductESRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ElasticSynchronizer {

    private IProductDAO productDAO;
    private IProductESRepo productESRepo;

    private static final Logger LOG = LoggerFactory.getLogger(ElasticSynchronizer.class);

    @Autowired
    public ElasticSynchronizer(IProductDAO productDAO, IProductESRepo productESRepo) {
        this.productDAO = productDAO;
        this.productESRepo = productESRepo;
    }

    @Scheduled(cron = "0 */1 * * * *")
    @Transactional
    public void sync() {
        LOG.info("Start Syncing - {}", LocalDateTime.now());
        this.syncProducts();
        LOG.info(" End Syncing - {}", LocalDateTime.now());
    }

    private void syncProducts() {

        Specification<Product> userSpecification = (root, criteriaQuery, criteriaBuilder) ->
                getModificationDatePredicate(criteriaBuilder, root);
        List<Product> productList;
        if (productESRepo.count() == 0) {
        	productList = productDAO.findAll();
        } else {
        	productList = productDAO.findAll(userSpecification);
        }
        for(Product product: productList) {
            LOG.info("Syncing Product - {}", product.getId());
            productESRepo.save(new ProductMapper().toProductModel(product));
        }
    }

    private static Predicate getModificationDatePredicate(CriteriaBuilder cb, Root<?> root) {
        Expression<Timestamp> currentTime;
        currentTime = cb.currentTimestamp();
        Expression<Timestamp> currentTimeMinus = cb.literal(new Timestamp(System.currentTimeMillis() -
                (Constants.INTERVAL_IN_MILLISECONDE)));
        return cb.between(root.<Date>get(Constants.MODIFICATION_DATE),
                currentTimeMinus,
                currentTime
        );
    }
}
