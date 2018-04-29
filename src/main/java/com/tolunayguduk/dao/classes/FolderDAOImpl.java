package com.tolunayguduk.dao.classes;

import com.tolunayguduk.dao.interfaces.FolderDAO;
import com.tolunayguduk.model.Folder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FolderDAOImpl implements FolderDAO {

    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insertFolder(Folder folder) {
        Session session = getCurrentSession();

        session.saveOrUpdate(folder);
        session.flush();
    }

    @Override
    public List<Folder> isExistFolder(String folderName) {
        Session session = getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Folder.class);
        Root<Folder> root = criteriaQuery.from(Folder.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get("name"), folderName)
        );
        Query query = session.createQuery(criteriaQuery);
        List<Folder> folderList = query.getResultList();

        return folderList;
    }

    @Override
    public List<Folder> isExistFolderByOwner(Long ownerID) {
        Session session = getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Folder.class);
        Root<Folder> root = criteriaQuery.from(Folder.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get("ownerID"), ownerID)
        );
        Query query = session.createQuery(criteriaQuery);
        List<Folder> folderList = query.getResultList();

        return folderList;
    }
}
